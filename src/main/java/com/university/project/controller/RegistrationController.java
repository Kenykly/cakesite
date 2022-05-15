package com.university.project.controller;

import com.university.project.domain.User;
import com.university.project.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Map;

@Controller
public class RegistrationController {

    @Autowired
    private UserService userService;


    @GetMapping("/registration")
    public  String registration(){
        return "registration";
    }

    @PostMapping("/registration")
    public  String addUser( User user, Map<String, Object> model){
        /*User userFromDB =  userRepository.findByUsername(user.getUsername());*/
        if (!userService.addUser(user)){
            model.put("message", "User exists!");
            return "registration";
        }

        /*user.setActive(true);
        user.setRoles(Collections.singleton(Role.USER));//сет с одним значением
        userRepository.save(user);*/
        return  "redirect:/login";
    }

    @GetMapping("/activate/{code}")
    public  String activate(Model model, @PathVariable String code){

        boolean isActivated = userService.activateUser(code);

        if (isActivated){
            model.addAttribute("message", "Учетная запись успешно подтверждена");
        } else {
            model.addAttribute("message", "Код активации не найден");
        }
        return  "login";
    }
}
