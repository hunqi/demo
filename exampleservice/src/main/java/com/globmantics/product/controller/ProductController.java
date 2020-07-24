package com.globmantics.product.controller;

import com.globmantics.product.service.Product;
import com.globmantics.product.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Optional;

@RestController
public class ProductController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ProductController.class);

    @Autowired
    private ProductService productService;

    @GetMapping("/product/{id}")
    public ResponseEntity<?> getProduct(@PathVariable Integer id) {
        return productService.findById(id)
                .map(product -> {
                    try {
                        return ResponseEntity
                                .ok()
                                .eTag(Integer.toString(product.getVersion()))
                                .location(new URI("/product/" + product.getId()))
                                .body(product);
                    } catch (URISyntaxException e) {
                        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
                    }
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/products")
    public Iterable<Product> getProducts() {
        return productService.findAll();
    }

    @PostMapping("/product")
    public ResponseEntity<Product> createProduct(@RequestBody Product product) {
        LOGGER.info("Creating new service with name: {}, quantity: {}", product.getName(), product.getQuantity());

        Product newProduct = productService.save(product);

        try {
            return ResponseEntity
                    .created(new URI("/product/" + newProduct.getId()))
                    .eTag(Integer.toString(newProduct.getVersion()))
                    .body(newProduct);
        } catch (URISyntaxException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PutMapping("/product/{id}")
    public ResponseEntity<?> updateProduct(@RequestBody Product product,
                                           @PathVariable Integer id,
                                           @RequestHeader("If-Match") Integer ifMatch) {
        LOGGER.info("Updating service with id: {}, name: {}, quantity: {}",
                id, product.getName(), product.getQuantity());

        Optional<Product> existingProduct = productService.findById(id);

        return existingProduct.map(p -> {
            LOGGER.info("Product with id: {} has a version of {}. Update is for If-Match: {}",
                    id, p.getVersion(), ifMatch);

            if (!p.getVersion().equals(ifMatch)) {
                return ResponseEntity.status(HttpStatus.CONFLICT).build();
            }

            p.setName(product.getName());
            p.setQuantity(product.getQuantity());
            p.setVersion(p.getVersion() + 1);

            LOGGER.info("Updating service with id: {} -> name={}, quantity={}, version={}",
                    p.getId(), p.getName(), p.getQuantity(), p.getVersion());

            try {
                if (productService.update(p)) {
                    return ResponseEntity.ok()
                            .location(new URI("/product/" + p.getId()))
                            .eTag(Integer.toString(p.getVersion()))
                            .body(p);
                } else {
                    return ResponseEntity.notFound().build();
                }
            } catch (URISyntaxException e) {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
            }
        }).orElse(ResponseEntity.notFound().build());
    }


    @DeleteMapping("/product/{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable Integer id) {
        LOGGER.info("Deleting product with ID {}", id);

        Optional<Product> existingProduct = productService.findById(id);

        return existingProduct.map(p -> {
            if (productService.delete(id))
                return ResponseEntity.ok().build();
            else
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }).orElse(ResponseEntity.notFound().build());
    }
}
