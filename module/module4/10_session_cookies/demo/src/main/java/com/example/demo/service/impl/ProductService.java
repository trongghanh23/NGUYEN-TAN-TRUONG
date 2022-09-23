package com.example.demo.service.impl;

import com.example.demo.model.Product;
import com.example.demo.repository.ProductRepository;
import com.example.demo.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class ProductService implements IProductService {
    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();

    }

    @Override
    public Optional<Product> finById(Long id) {
        return productRepository.findById(Math.toIntExact(id));

    }

    @Override
    public void save(Product product) {
        productRepository.save(product);

    }
}
