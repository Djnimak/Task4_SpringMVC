package com.nikita.task3spring.controllers;

import com.nikita.task3spring.constants.Constants;
import com.nikita.task3spring.model.entity.User;
import com.nikita.task3spring.model.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

@Controller
public class UpdateUserController {

    private final UserService service;
    private final User user;

    public UpdateUserController(UserService service, User user) {
        this.service = service;
        this.user = user;
    }

    @GetMapping(value = "update")
    public ModelAndView printCreateUserPage() {
        return new ModelAndView(Constants.UPDATE_JSP);
    }

    @PostMapping("/updated")
    public String updateUser(@RequestParam Map<String, String> allParams, Model model) {
        user.setEmail(allParams.get(Constants.EMAIL));
        user.setPassword(allParams.get(Constants.PASSWORD));
        String newEmail = allParams.get(Constants.NEW_EMAIL);
        String newPassword = allParams.get(Constants.NEW_PASSWORD);

        if (service.updateUser(user, newEmail, newPassword) > 0) {
            model.addAttribute(Constants.USER_UPDATED, Constants.USER_UPDATED_MESSAGE);
            return Constants.INDEX_JSP;
        } else {
            model.addAttribute(Constants.USER_NOT_UPDATED, Constants.USER_NOT_UPDATED_MESSAGE);
            return Constants.UPDATE_JSP;
        }
    }
}
