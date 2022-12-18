package com.example.snackbars.modules.products.entity;

import javax.persistence.*;

@Entity
@Table(name = "Products")
public class Product {

    @Id
    @GeneratedValue
    private long id;

    @Column(name = "name_product")
    private String name_product;

    @Lob
    @Column(name = "ingredients_product", columnDefinition = "CLOB", nullable = true)
    private String ingredients_product;

    @Column(name = "kind_product")
    private String kind_product;

    @Column(name = "flavor_product", nullable = true)
    private String flavor_product;

    @Column(name = "value_product")
    private String value_product;
}
