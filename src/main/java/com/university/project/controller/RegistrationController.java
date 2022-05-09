package com.university.project.controller;

import com.university.project.domain.Role;
import com.university.project.domain.User;
import com.university.project.repos.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.Map;

@Controller
public class RegistrationController {

    @Autowired
    private UserRepository userRepository;


    @GetMapping("/registration")
    public  String registration(){
        return "registration";
    }

    @PostMapping("/registration")
    public  String addUser( User user, Map<String, Object> model){
        User userFromDB =  userRepository.findByUsername(user.getUsername());

        if (userFromDB != null){
            model.put("message", "User exists!");
            return "registration";
        }

        user.setActive(true);
        user.setRoles(Collections.singleton(Role.USER));//сет с одним значением
        userRepository.save(user);
        return  "redirect:/login";
    }
}
