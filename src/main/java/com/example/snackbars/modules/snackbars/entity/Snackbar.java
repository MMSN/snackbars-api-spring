package com.example.snackbars.modules.snackbars.entity;

import javax.persistence.*;

@Entity
@Table(name = "Snackbars")
public class Snackbar {

    @Id
    @GeneratedValue
    private long id;

    @Column(name = "name_snackbar")
    private String name_snackbar;

    @Column(name = "logo_url_snackbar", nullable = true)
    public String logo_url_snackbar;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName_snackbar() {
        return name_snackbar;
    }

    public void setName_snackbar(String name_snackbar) {
        this.name_snackbar = name_snackbar;
    }

    public String getLogo_url_snackbar() {
        return logo_url_snackbar;
    }

    public void setLogo_url_snackbar(String logo_url_snackbar) {
        this.logo_url_snackbar = logo_url_snackbar;
    }
}
