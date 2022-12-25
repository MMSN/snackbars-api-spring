package com.example.snackbars.modules.products.service;

import com.example.snackbars.modules.addresses.entity.Address;
import com.example.snackbars.modules.products.entity.Product;
import com.example.snackbars.modules.products.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> findAllProducts() {
        return productRepository.findAll();
    }

    public Optional<Product> findProductById(long id) {
        return productRepository.findById(id);
    }




}
