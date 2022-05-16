package com.university.project.controller;

import com.university.project.domain.Order;
import com.university.project.domain.OrderStatus;
import com.university.project.domain.Role;
import com.university.project.domain.User;
import com.university.project.repos.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/adminorders")
@PreAuthorize("hasAuthority('ADMIN')")//чтобы была только админу доступна
public class OrderAdminController {


    @Autowired
    private OrderRepository orderRepository;

    @GetMapping
    public String orderList(Model model) {
        model.addAttribute("orders", orderRepository.findAll());
        return "adminorders";
    }


    @GetMapping("{order}") //ожидаем помимо /user через слеш id
    public String adminOrderEditForm(@PathVariable int order, Model model) {
        model.addAttribute("order", orderRepository.findById(order));
        return "adminOrderEdit";
    }


    @PostMapping
    public String orderStatusChange(
            Model model,
            @RequestParam("orderId") int orderid,
            @RequestParam String orderStatus
    ) {
        Order order1 = orderRepository.findById(orderid);

        //Ожидает_Подтверждения, Подтвержден, Ждет_Оплаты, Оплачен, Готовится, В_доставке, Завершен;

        switch (orderStatus) {
            case ("Ожидает_Подтверждения"):
                order1.setOrderStatus(OrderStatus.Ожидает_Подтверждения);
                break;
            case ("Подтвержден"):
                order1.setOrderStatus(OrderStatus.Подтвержден);
                break;
            case ("Ждет_Оплаты"):
                order1.setOrderStatus(OrderStatus.Ждет_Оплаты);
                break;
            case ("Оплачен"):
                order1.setOrderStatus(OrderStatus.Оплачен);
                break;
            case ("Готовится"):
                order1.setOrderStatus(OrderStatus.Готовится);
                break;
            case ("В_доставке"):
                order1.setOrderStatus(OrderStatus.В_доставке);
                break;
            case ("Завершен"):
                order1.setOrderStatus(OrderStatus.Завершен);
                break;
            default:
                order1.setOrderStatus(OrderStatus.Завершен);
                break;
        }


        //order1.setOrderStatus(OrderStatus.Подтвержден);
        orderRepository.save(order1);
        return "redirect:/adminorders";
    }


}