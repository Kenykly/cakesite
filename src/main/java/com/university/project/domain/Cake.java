package com.university.project.domain;

import javax.persistence.*;
import java.util.List;

@Entity
public class Cake {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;


    public Cake(User user, boolean isInBasket, int stageCount, String cakeForm, int personCount, double cakePrice, String decorDescription, String decorfilename, List<Ingredient> ingredients, /*Ingredient biscuit, Ingredient cream, Ingredient filling, */String cakeComment) {

        this.user = user;
        this.isInBasket = isInBasket;
        this.stageCount = stageCount;
        this.cakeForm = cakeForm;
        this.personCount = personCount;
        this.cakePrice = cakePrice;
        this.decorDescription = decorDescription;
        this.decorfilename = decorfilename;

        this.ingredients = ingredients;
        this.fillingName = ingredients.get(0).getTastename();
        this.biscuitPrice = ingredients.get(0).getPrice();
        this.biscuitName = ingredients.get(1).getTastename();
        this.biscuitPrice = ingredients.get(1).getPrice();
        this.creamName = ingredients.get(2).getTastename();
        this.creamPrice = ingredients.get(2).getPrice();

        /*this.filling = ingredients.get(0);;
        this.biscuit = ingredients.get(1);
        this.cream = ingredients.get(2);*/
        this.cakeComment = cakeComment;
    }

    public Cake() {

    }
    private  String biscuitName;
    private  int biscuitPrice;

    private  String creamName;
    private  int  creamPrice;

    private  String fillingName;
    private  int  fillingPrice;


    private  String cakeComment;
    private String cakeForm;
    private int personCount;
    private double cakePrice;
    private  int stageCount;

    private String decorDescription;
    private  String decorfilename;

    private  boolean isInBasket;

/*    @OneToOne
    private  Ingredient biscuit;
    @OneToOne
    private  Ingredient filling;
    @OneToOne
    private  Ingredient cream;*/


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

    @OneToMany
    @JoinColumn(name = "ingredient_id")
    private List<Ingredient> ingredients;



   /* @OneToOne
    @JoinColumn(name = "cream_id")
    private Cream cream;

    @OneToOne
    @JoinColumn(name = "filling_id")
    private Filling filling;*/


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

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    public String getBiscuitName() {
        return biscuitName;
    }

    public void setBiscuitName(String biscuitName) {
        this.biscuitName = biscuitName;
    }

    public int getBiscuitPrice() {
        return biscuitPrice;
    }

    public void setBiscuitPrice(int biscuitPrice) {
        this.biscuitPrice = biscuitPrice;
    }

    public String getCreamName() {
        return creamName;
    }

    public void setCreamName(String creamName) {
        this.creamName = creamName;
    }

    public int getCreamPrice() {
        return creamPrice;
    }

    public void setCreamPrice(int creamPrice) {
        this.creamPrice = creamPrice;
    }

    public String getFillingName() {
        return fillingName;
    }

    public void setFillingName(String fillingName) {
        this.fillingName = fillingName;
    }

    public int getFillingPrice() {
        return fillingPrice;
    }

    public void setFillingPrice(int fillingPrice) {
        this.fillingPrice = fillingPrice;
    }


    /*  public Ingredient getBiscuit() {
        return biscuit;
    }

    public void setBiscuit(Ingredient biscuit) {
        this.biscuit = biscuit;
    }

    public Ingredient getCream() {
        return cream;
    }

    public void setCream(Ingredient cream) {
        this.cream = cream;
    }

    public Ingredient getFilling() {
        return filling;
    }

    public void setFilling(Ingredient filling) {
        this.filling = filling;
    }*/
}
