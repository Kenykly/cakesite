package com.university.project.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Ingredient {


    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private  Integer id;

    private String tastename;

    private String ingtype;

    private int price;

    public Ingredient(String tastename, String type, int price) {
        this.tastename = tastename;
        this.ingtype = type;
        this.price = price;
    }

    public Ingredient() {

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

    public String getType() {
        return ingtype;
    }

    public void setType(String type) {
        this.ingtype = type;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
