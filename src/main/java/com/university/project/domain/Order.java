package com.university.project.domain;

import javax.persistence.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity
@Table(name="ordr")
public class Order {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO) //доверяем спрингу в настройке айди
    private  Integer id;

    //одному пользователю соотв множество заказов
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User user;

    private  double orderSum;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "cake_id")
    private List<Cake> cakes;

    @Column(name = "ordr_status")
    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus;


    private String orderDate;
    private String orderReadyDate;
    private String userAdress;
    //0-доставляем, 1 - самовывоз
    private boolean pickup;
    String orderReadyTime;
    private String phone;
    private  String orderComment;


    public Order(User user, double orderSum, String orderReadyDate, String orderReadyTime, String userAdress, boolean pickup, List<Cake> cakes, String phone, String orderComment) {

        this.cakes = cakes;
        this.user = user;
        this.orderComment = orderComment;
        this.phone = phone;
        this.orderSum = orderSum;
        this.orderStatus = OrderStatus.Ожидает_Подтверждения;
        SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date(System.currentTimeMillis());
        this.orderDate =formatter.format(date);
        this.orderReadyDate = orderReadyDate;  //дату заказа автоматически делать  сегодняшней, статус - создан
        this.userAdress = userAdress;
        this.pickup = pickup;
        this.orderReadyTime = orderReadyTime;
    }

    public Order(User user) {
        this.user = user;
    }
    public Order() {

    }


    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    public List<Cake> getCakes() {
        return cakes;
    }

    public void setCakes(List<Cake> cakes) {
        this.cakes = cakes;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getOrderComment() {
        return orderComment;
    }

    public void setOrderComment(String orderComment) {
        this.orderComment = orderComment;
    }

    public String getOrderReadyTime() {
        return orderReadyTime;
    }

    public void setOrderReadyTime(String orderReadyTime) {
        this.orderReadyTime = orderReadyTime;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public double getOrderSum() {
        return orderSum;
    }

    public void setOrderSum(double orderSum) {
        this.orderSum = orderSum;
    }


    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public String getOrderReadyDate() {
        return orderReadyDate;
    }

    public void setOrderReadyDate(String orderReadyDate) {
        this.orderReadyDate = orderReadyDate;
    }

    public String getUserAdress() {
        return userAdress;
    }

    public void setUserAdress(String userAdress) {
        this.userAdress = userAdress;
    }

    public boolean isPickup() {
        return pickup;
    }

    public void setPickup(boolean pickup) {
        this.pickup = pickup;
    }
}
