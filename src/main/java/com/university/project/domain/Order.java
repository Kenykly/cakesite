package com.university.project.domain;

import javax.persistence.*;
import java.util.Calendar;
import java.util.Date;
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

    @ElementCollection(targetClass = OrderStatus.class, fetch  = FetchType.EAGER )
    @CollectionTable(name = "order_status", joinColumns = @JoinColumn(name = "ordr_id") )
    @Enumerated(EnumType.STRING)
    private Set<OrderStatus>  status;

    private Date orderDate;
    private Date orderReadyDate;
    private String userAdress;
    //0-доставляем, 1 - самовывоз
    private boolean pickup;
    String orderReadyTime;

    public Order(User user,  double orderSum,   Date orderReadyDate, String orderReadyTime, String userAdress, boolean pickup) {
        this.user = user;
        this.orderSum = orderSum;
        //this.status = OrderStatus.Ожидает_Подтверждения;
        Calendar calendar = Calendar.getInstance();
        this.orderDate = calendar.getTime();
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

    public Set<OrderStatus> getStatus() {
        return status;
    }

    public void setStatus(Set<OrderStatus> status) {
        this.status = status;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public Date getOrderReadyDate() {
        return orderReadyDate;
    }

    public void setOrderReadyDate(Date orderReadyDate) {
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
