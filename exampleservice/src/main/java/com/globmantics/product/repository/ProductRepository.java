package com.globmantics.product.repository;

import com.globmantics.product.service.Product;

import java.util.List;
import java.util.Optional;

public interface ProductRepository {

    Optional<Product> findById(Integer id);

    List<Product> findAll();

    boolean update(Product product);

    Product save(Product product);

    boolean delete(Integer id);

}
