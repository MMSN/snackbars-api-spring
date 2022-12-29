package com.example.snackbars.modules.products.controller;

import com.example.snackbars.modules.products.entity.Product;
import com.example.snackbars.modules.products.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping("/api")
@RestController
@ResponseBody
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/product")
    public ResponseEntity<List<Product>> getAllProducts() {
        List<Product> listProduct = productService.findAllProducts();
        if (listProduct.isEmpty()) return new ResponseEntity<>(HttpStatus.NO_CONTENT);

        return new ResponseEntity<>(listProduct, HttpStatus.OK);
    }

    @GetMapping(path = "/product/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable("id") Long id) {
        Optional<Product> product = productService.findProductById(id);
        if (product.isPresent()) return new ResponseEntity(product, HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    /*@GetMapping(path = "/address/{id}/products")
    public ResponseEntity<List<Product>> getAllProductsByAddressId(@PathVariable("id") Long id) {
        Optional<List<Product>> listProducts = Optional.ofNullable(productService.findAllProductsBySnackBarId(id));
        if (listProducts.isPresent()) return new ResponseEntity(listProducts, HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }*/

    @PostMapping("/{id}/product")
    public ResponseEntity<Product> addProduct(
            @PathVariable("id") Long id,
            @NonNull @RequestBody Product product) {
        Optional<Product> savedProduct = Optional.ofNullable(productService.saveProduct(id, product));
        if (savedProduct.isPresent()) return new ResponseEntity<>(HttpStatus.CREATED);
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
}
