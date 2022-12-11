package com.example.snackbars.modules.address.entity;

import com.example.snackbars.modules.snackbars.entity.Snackbar;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Entity
@Table(name = "Addresses")
public class Address {

    @Id
    @GeneratedValue
    private long id;

    @Column(name = "street_address")
    private String street_address;

    @Column(name = "number_address")
    private String number_address;

    @Column(name = "zipcode_address")
    private String zipcode_address;

    @Column(name = "city_address")
    private String city_address;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "snackbar_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Snackbar snackbar;

    // getters and setters

    public long getId() {
        return id;
    }

    public String getStreet_address() {
        return street_address;
    }

    public String getNumber_address() {
        return number_address;
    }

    public String getZipcode_address() {
        return zipcode_address;
    }

    public String getCity_address() {
        return city_address;
    }

    public Snackbar getSnackbar() {
        return snackbar;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setStreet_address(String street_address) {
        this.street_address = street_address;
    }

    public void setNumber_address(String number_address) {
        this.number_address = number_address;
    }

    public void setZipcode_address(String zipcode_address) {
        this.zipcode_address = zipcode_address;
    }

    public void setCity_address(String city_address) {
        this.city_address = city_address;
    }

    public void setSnackbar(Snackbar snackbar) {
        this.snackbar = snackbar;
    }
}