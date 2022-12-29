package com.example.snackbars.modules.products.entity;

import com.example.snackbars.modules.addresses.entity.Address;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Entity
@Table(name = "Products")
public class Product {

    @Id
    @GeneratedValue
    private long id;

    @Column(name = "catalog_id_product", nullable = true)
    private int catalog_id_product;

    @Column(name = "name_product")
    private String name_product;

    @Lob
    @Column(name = "ingredients_product", columnDefinition="TEXT", nullable = true)
    private String ingredients_product;

    @Column(name = "kind_product")
    private String kind_product;

    @Column(name = "flavor_product", nullable = true)
    private String flavor_product;

    @Column(name = "value_product")
    private String value_product;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "address_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Address address;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getCatalog_id_product() {
        return catalog_id_product;
    }

    public void setCatalog_id_product(int catalog_id_product) {
        this.catalog_id_product = catalog_id_product;
    }

    public String getName_product() {
        return name_product;
    }

    public void setName_product(String name_product) {
        this.name_product = name_product;
    }

    public String getIngredients_product() {
        return ingredients_product;
    }

    public void setIngredients_product(String ingredients_product) {
        this.ingredients_product = ingredients_product;
    }

    public String getKind_product() {
        return kind_product;
    }

    public void setKind_product(String kind_product) {
        this.kind_product = kind_product;
    }

    public String getFlavor_product() {
        return flavor_product;
    }

    public void setFlavor_product(String flavor_product) {
        this.flavor_product = flavor_product;
    }

    public String getValue_product() {
        return value_product;
    }

    public void setValue_product(String value_product) {
        this.value_product = value_product;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
