package com.plurasight.review;

import java.util.List;
import java.util.Optional;

public interface ReviewService {

    Optional<Review> findById(String id);

    List<Review> findAll();

    Optional<Review> findByProductId(Integer productId);

    Review save(Review review);

    void delete(String id);
}
