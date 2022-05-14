package com.university.project.controller;

import com.university.project.domain.User;
import com.university.project.repos.CakeRepository;
import com.university.project.repos.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserOrdersController {

    @Autowired
    private OrderRepository orderRepository;

    @GetMapping("/userorders")
    public String cakeList(Model model, @AuthenticationPrincipal User user) {
        model.addAttribute("orders", orderRepository.findById(user.getId()));
        return "userorders";
    }
}
