package com.university.project.controller;

import com.university.project.domain.User;
import com.university.project.repos.CakeRepository;
import com.university.project.repos.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
        return "basket";
    }


}
