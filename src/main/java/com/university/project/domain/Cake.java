package com.university.project.domain;

import javax.persistence.*;

@Entity
public class Cake {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;


    public Cake(User user, boolean isInBasket, int stageCount, String cakeForm, int personCount, double cakePrice, String decorDescription, String decorfilename, Biscuit biscuit, Cream cream, Filling filling, String cakeComment) {

        this.user = user;
        this.isInBasket = isInBasket;
        this.stageCount = stageCount;
        this.cakeForm = cakeForm;
        this.personCount = personCount;
        this.cakePrice = cakePrice;
        this.decorDescription = decorDescription;
        this.decorfilename = decorfilename;
        this.biscuit = biscuit;
        this.cream = cream;
        this.filling = filling;
        this.cakeComment = cakeComment;
    }

    public Cake() {

    }

    private  String cakeComment;
    private String cakeForm;
    private int personCount;
    private double cakePrice;
    private  int stageCount;

    private String decorDescription;
    private  String decorfilename;

    private  boolean isInBasket;

    //одному пользователю соотв множество созданных тортиков
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private  User user;

    public boolean isInBasket() {
        return isInBasket;
    }

    public void setInBasket(boolean inBasket) {
        isInBasket = inBasket;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @OneToOne
    @JoinColumn(name = "biscuit_id")
    private Biscuit biscuit;

    @OneToOne
    @JoinColumn(name = "cream_id")
    private Cream cream;

    @OneToOne
    @JoinColumn(name = "filling_id")
    private Filling filling;


    public int getStageCount() {
        return stageCount;
    }

    public void setStageCount(int stageCount) {
        this.stageCount = stageCount;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCakeForm() {
        return cakeForm;
    }

    public String getCakeComment() {
        return cakeComment;
    }

    public void setCakeComment(String cakeComment) {
        this.cakeComment = cakeComment;
    }

    public void setCakeForm(String cakeForm) {
        this.cakeForm = cakeForm;
    }

    public int getPersonCount() {
        return personCount;
    }

    public void setPersonCount(int personCount) {
        this.personCount = personCount;
    }

    public double getCakePrice() {
        return cakePrice;
    }

    public void setCakePrice(double cakePrice) {
        this.cakePrice = cakePrice;
    }

    public String getDecorDescription() {
        return decorDescription;
    }

    public void setDecorDescription(String decorDescription) {
        this.decorDescription = decorDescription;
    }

    public String getDecorfilename() {
        return decorfilename;
    }

    public void setDecorfilename(String decorfilename) {
        this.decorfilename = decorfilename;
    }

    public Biscuit getBiscuit() {
        return biscuit;
    }

    public void setBiscuit(Biscuit biscuit) {
        this.biscuit = biscuit;
    }

    public Cream getCream() {
        return cream;
    }

    public void setCream(Cream cream) {
        this.cream = cream;
    }

    public Filling getFilling() {
        return filling;
    }

    public void setFilling(Filling filling) {
        this.filling = filling;
    }
}
