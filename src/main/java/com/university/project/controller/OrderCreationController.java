package com.university.project.controller;

import com.university.project.domain.*;
import com.university.project.repos.CakeRepository;
import com.university.project.repos.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Controller
public class OrderCreationController {


    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private CakeRepository cakeRepository;

    @GetMapping("/basket")
    public String cakeList(Model model, @AuthenticationPrincipal User user) {
        model.addAttribute("cakes", cakeRepository.findByUserIdAndisInBasket(user.getId()));
        model.addAttribute("ordersum", orderSumCount(cakeRepository.findByUserIdAndisInBasket(user.getId())));
        return "basket";
    }


    @GetMapping("basket/{cake}") //ожидаем помимо /user через слеш id
    public  String cakeDelete(@PathVariable Cake cake, Model model,  @AuthenticationPrincipal User user){
        cakeRepository.delete(cake);
        List<Cake> cakes = cakeRepository.findByUserIdAndisInBasket(user.getId());
        model.addAttribute("cakes", cakes);
        model.addAttribute("ordersum", orderSumCount(cakes));
        /* model.addAttribute("ссфлу", user);


        model.addAttribute("roles", Role.values());*/
        return "basket";
    }

    @PostMapping("basket/{cake}") //ожидаем помимо /user через слеш id
    public  String cakeDelete2(@PathVariable Cake cake, Model model,  @AuthenticationPrincipal User user){
        cakeRepository.delete(cake);
        List<Cake> cakes = cakeRepository.findByUserIdAndisInBasket(user.getId());
        model.addAttribute("ordersum", orderSumCount(cakes));
       /* model.addAttribute("ссфлу", user);
        model.addAttribute("roles", Role.values());*/
        return "basket";
    }


    @PostMapping("/basket")
    public String createOrder(@AuthenticationPrincipal User user,
                              Model model,
                              @RequestParam String orderComment,
                              @RequestParam String orderReadyDate,
                              @RequestParam String orderReadyTime,
                              @RequestParam String userAdress,
                              @RequestParam String deliveryway,
                              @RequestParam String phone

    ) {

        boolean isPickup = true;
        if (deliveryway == "delivery") {
            isPickup = false;
        }
        List<Cake> cakes= cakeRepository.findByUserIdAndisInBasket(user.getId());
        double orderSum = orderSumCount(cakes);
        Order order = new Order(user, orderSum, orderReadyDate, orderReadyTime, userAdress, isPickup, cakes, phone, orderComment);
        for (Cake cake : cakes)
        {
            cake.setInBasket(false);
        }
        orderRepository.save(order);
        model.addAttribute("orders", orderRepository.findAll()); //искать по id
        return "userorders";
    }

    private double orderSumCount(List<Cake> cakes) {
        double orderSum = 0;
        for (Cake c : cakes)
            orderSum += c.getCakePrice();
        return orderSum;

    }


}
