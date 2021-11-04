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
        List<User> listUser;
        if(allParams.get(Constants.SHOW_ALL_USERS) == null) {
            listUser = service.findUserByEmail(allParams.get(Constants.EMAIL));
            model.addAttribute(Constants.USER, service.findUserByEmail(allParams.get(Constants.EMAIL)));
            if (listUser.isEmpty()) {
                model.addAttribute(Constants.NO_SUCH_USER, Constants.NO_SUCH_USER_MESSAGE);
                return Constants.SHOW_JSP;
            }
        } else {
            model.addAttribute(Constants.USER, service.findAllUsers());
        }
        return Constants.USER_BY_EMAIL_JSP;
    }
}
