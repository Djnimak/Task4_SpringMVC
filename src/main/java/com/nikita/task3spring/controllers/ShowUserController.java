package com.nikita.task3spring.controllers;

import com.nikita.task3spring.constants.Constants;
import com.nikita.task3spring.model.entity.User;
import com.nikita.task3spring.model.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

@Controller
public class ShowUserController {

    private final UserService service;

    public ShowUserController(UserService service) {
        this.service = service;
    }

    @GetMapping(value = "show")
    public ModelAndView printShowUserPage() {
        return new ModelAndView(Constants.SHOW_JSP);
    }

    @PostMapping("/shown")
    public String showUser(@RequestParam Map<String, String> allParams, Model model) {
        String email = allParams.get(Constants.EMAIL);
        String command = allParams.get(Constants.SHOW_ALL_USERS);
        List<User> listUser;
        List<User> listUsers;
        if(command == null) {
            listUser = service.findUserByEmail(email);
            model.addAttribute(Constants.USER, listUser);
            if (listUser.isEmpty()) {
                model.addAttribute(Constants.NO_SUCH_USER, Constants.NO_SUCH_USER_MESSAGE);
                return Constants.SHOW_JSP;
            }
        } else {
            listUsers = service.findAllUsers();
            model.addAttribute(Constants.USER, listUsers);
        }
        return Constants.USER_BY_EMAIL_JSP;
    }
}
