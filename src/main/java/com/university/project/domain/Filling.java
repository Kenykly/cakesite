package com.university.project.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Filling {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private  Integer id;

    private String tastename;

    private int price;

    public Filling(String tastename, int price) {
        this.tastename = tastename;
        this.price = price;
    }

    public Filling(String tastename) {
        this.tastename = tastename;

    }

    public Filling() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTastename() {
        return tastename;
    }

    public void setTastename(String tastename) {
        this.tastename = tastename;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
