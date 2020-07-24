package com.globmantics.product.service;

import com.globmantics.product.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public Optional<Product> findById(Integer id) {
        return productRepository.findById(id);
    }

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Product save(Product product) {
        product.setVersion(1);
        return productRepository.save(product);
    }

    @Override
    public boolean update(Product p) {
        return productRepository.update(p);
    }

    @Override
    public boolean delete(Integer id) {
        return productRepository.delete(id);
    }
}
