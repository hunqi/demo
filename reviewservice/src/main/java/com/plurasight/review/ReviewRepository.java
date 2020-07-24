package com.plurasight.review;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface ReviewRepository extends MongoRepository<Review, String> {

    Optional<Review> findById(String id);

    Optional<Review> findByProductId(Integer productId);

    List<Review> findAll();

    Review save(Review review);

    void deleteById(String id);
}
