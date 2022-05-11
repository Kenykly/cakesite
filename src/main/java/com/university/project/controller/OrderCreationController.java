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
    //basket

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private CakeRepository cakeRepository;

    @GetMapping("/basket")
    public String cakeList(Model model, @AuthenticationPrincipal User user){
        model.addAttribute("cakes", cakeRepository.findByUserIdAndisInBasket(user.getId()));
        model.addAttribute("ordersum", orderSumCount(cakeRepository.findByUserIdAndisInBasket(user.getId())));
        return "basket";
    }

   /* @GetMapping("{cakeid}") //ожидаем помимо /basket через слеш id
    public  String cakeDelete(*//*@PathVariable Cake cake,*//*   @PathVariable("cakeid") long cakeId ,Model model){
        Cake cake = cakeRepository.findById(cakeId);
        cakeRepository.delete(cake);
        //model.addAttribute("cakes", cakeRepository.findByUserIdAndisInBasket(user.getId()));
        //model.addAttribute("user", user);
        //model.addAttribute("roles", Role.values());
        return "basket";
    }*/

    @PostMapping("/basket")
    public String createOrder(@AuthenticationPrincipal User user,
                             @RequestParam String decorDescription,
                             @RequestParam int personCount,
                             @RequestParam int stageCount,
                             @RequestParam String cakeComment,
                             @RequestParam String cakeform,
                             @RequestParam String biscuitname,
                             @RequestParam String creamname,
                             @RequestParam String  fillingname
    ){

        double orderSum = orderSumCount(cakeRepository.findByUserIdAndisInBasket(user.getId()));
        //Order order = new Order(user,  orderSum, "Создан", Date orderReadyDate, String orderReadyTime, String userAdress, boolean pickup)
        //boolean isInBasket = true;
        //double orderPrice = countOrderPrice(biscuit, cream, filling, stageCount, personCount);
        //Cake cake = new Cake(user, isInBasket, stageCount, cakeform, personCount, cakePrice, decorDescription, resultFileName,  biscuit, cream, filling, cakeComment);
        //cakeRepository.save(cake);

        return "userorders";
    }

    private double orderSumCount(List<Cake> cakes) {
        double orderSum = 0;
        for(Cake c : cakes)
            orderSum += c.getCakePrice();
        return orderSum;

    }


}
