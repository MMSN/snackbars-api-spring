package com.example.snackbars.modules.products.repository;

import com.example.snackbars.modules.products.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
