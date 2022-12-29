package com.example.snackbars.modules.products.service;

import com.example.snackbars.modules.addresses.entity.Address;
import com.example.snackbars.modules.addresses.repository.AddressRepository;
import com.example.snackbars.modules.products.entity.Product;
import com.example.snackbars.modules.products.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private AddressRepository addressRepository;

    public List<Product> findAllProducts() {
        return productRepository.findAll();
    }

    public Optional<Product> findProductById(long id) {
        return productRepository.findById(id);
    }

    /*public Optional<List<Product>> findAllProductsByAddressId(long id) {

    }*/

    public Product saveProduct(long id, Product product) {
        Optional<Address> address = addressRepository.findById(id);
        if (address.isPresent()) {
            product.setAddress(address.get());
            productRepository.save(product);
            return product;
        }
        return null;
    }


}
