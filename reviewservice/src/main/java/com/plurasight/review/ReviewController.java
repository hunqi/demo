package com.plurasight.review;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Optional;

@RestController
public class ReviewController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ReviewController.class);

    @Autowired
    private ReviewService service;

    @GetMapping("/review/{id}")
    public ResponseEntity<?> getReview(@PathVariable String id) {
        return service.findById(id)
                .map(review -> {
                    try {
                        return ResponseEntity
                                .ok()
                                .eTag(Integer.toString(review.getVersion()))
                                .location(new URI("/review/" + review.getId()))
                                .body(review);
                    } catch (URISyntaxException e) {
                        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
                    }
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/reviews")
    public Iterable<Review> getReviews(@RequestParam(value = "productId", required = false) Optional<String> productId) {
        return productId.map(pid -> service.findByProductId(Integer.valueOf(pid))
                .map(Arrays::asList)
                .orElseGet(ArrayList::new))
                .orElse(service.findAll());
    }

    @PostMapping("/review")
    public ResponseEntity<Review> createReview(@RequestBody Review review) {
        LOGGER.info("Creating new review of product id: {}, {}", review.getProductId(), review);

        review.getEntries().forEach(entry -> entry.setDate(new Date()));

        Review newReview = service.save(review);
        LOGGER.info("Saved review: {}", newReview);

        try {
            return ResponseEntity
                    .created(new URI("/review/" + newReview.getId()))
                    .eTag(Integer.toString(newReview.getVersion()))
                    .body(newReview);
        } catch (URISyntaxException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PostMapping("/review/{productId}/entry")
    public ResponseEntity<Review> addEntryToReview(@PathVariable Integer productId, @RequestBody ReviewEntry entry) {
        LOGGER.info("Add review entry for product id: {}, {}", productId, entry);

        Review review = service.findByProductId(productId).orElseGet(() -> new Review(productId));

        entry.setDate(new Date());
        review.getEntries().add(entry);

        Review updatedReview = service.save(review);
        LOGGER.info("Updated review: {}", review);

        try {
            return ResponseEntity
                    .ok()
                    .location(new URI("/review/" + updatedReview.getId()))
                    .eTag(Integer.toString(updatedReview.getVersion()))
                    .body(updatedReview);
        } catch (URISyntaxException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @DeleteMapping("/review/{id}")
    public ResponseEntity<?> deleteReview(@PathVariable String id) {
        LOGGER.info("Delete review with ID: {}", id);

        Optional<Review> existingReview = service.findById(id);

        return existingReview.map(review -> {
            service.delete(review.getId());
            return ResponseEntity.ok().build();
        }).orElse(ResponseEntity.notFound().build());
    }

}
