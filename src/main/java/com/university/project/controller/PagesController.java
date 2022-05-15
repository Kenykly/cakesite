package com.university.project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Map;

@Controller
public class PagesController {

    @GetMapping("/")
    public String getMainPage( Map<String, Object> model) {
        return "greeting";
    }

    @GetMapping("/aboutus")
    public String getAboutUsPage( Map<String, Object> model) {
        return "aboutus";
    }

    @GetMapping("/howtoorder")
    public String getGowToOrderPage( Map<String, Object> model) {
        return "howtoorder";
    }

}
