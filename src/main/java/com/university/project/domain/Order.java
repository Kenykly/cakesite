package com.university.project.domain;

import javax.persistence.*;
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

    private  int orderSum;

    @ElementCollection(targetClass = OrderStatus.class, fetch  = FetchType.EAGER )
    @CollectionTable(name = "order_status", joinColumns = @JoinColumn(name = "ordr_id") )
    @Enumerated(EnumType.STRING)
    private Set<OrderStatus>  status;

    private Date orderDate;
    private Date orderReadyDate;
    private String userAdress;
    //0-доставляем, 1 - самовывоз
    private boolean pickup;

    public Order(User user, int orderSum, Set<OrderStatus> status, Date orderDate, Date orderReadyDate, String userAdress, boolean pickup) {
        this.user = user;
        this.orderSum = orderSum;
        this.status = status;
        this.orderDate = orderDate;
        this.orderReadyDate = orderReadyDate;
        this.userAdress = userAdress;
        this.pickup = pickup;
    }

    public Order(User user) {
        this.user = user;
    }
    public Order() {

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

    public int getOrderSum() {
        return orderSum;
    }

    public void setOrderSum(int orderSum) {
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
