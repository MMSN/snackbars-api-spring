package com.example.snackbars.modules.snackbars.entity;

import javax.persistence.*;

@Entity
@Table(name = "snackbars")
public class Snackbar {

    @Id
    @GeneratedValue
    private long id;

    @Column(name = "snackbar_name")
    public String snackbar_name;

    //Getters
    public long getId() {
        return id;
    }

    public String getSnackbar_name() {
        return snackbar_name;
    }

    //Setters
    public void setId(long id) {
        this.id = id;
    }

    public void setSnackbar_name(String snackbar_name) {
        this.snackbar_name = snackbar_name;
    }
}
