package com.globmantics.product.service;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    Optional<Product> findById(Integer id);

    List<Product> findAll();

    Product save(Product product);

    boolean update(Product p);

    boolean delete(Integer id);
}
