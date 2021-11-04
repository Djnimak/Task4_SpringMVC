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
public class DeleteUserController {

    private final UserService service;
    private final User user;

    public DeleteUserController(UserService service, User user) {
        this.service = service;
        this.user = user;
    }

    @GetMapping(value = "delete")
    public ModelAndView printCreateUserPage() {
        return new ModelAndView(Constants.DELETE_JSP);
    }

    @PostMapping("/deleted")
    public String deleteUser(@RequestParam Map<String, String> allParams, Model model) {
        user.setEmail(allParams.get(Constants.EMAIL));
        user.setPassword(allParams.get(Constants.PASSWORD));
        String adminPassword = allParams.get(Constants.ADMIN_PASSWORD);

        if (adminPassword == null) {
            int result = service.deleteUser(user);
            if (result > 0) {
                model.addAttribute(Constants.USER_DELETED, Constants.USER_DELETED_MESSAGE);
                return Constants.INDEX_JSP;
            } else {
                model.addAttribute(Constants.USER_NOT_DELETED, Constants.USER_NOT_DELETED_MESSAGE);
                return Constants.DELETE_JSP;
            }
        } else if (adminPassword.equals(Constants.ADMIN_PASSWORD_VALUE)){
            int result = service.deleteAllUsers();
            if (result > 0) {
                model.addAttribute(Constants.ALL_USERS_DELETED, Constants.ALL_USERS_DELETED_MESSAGE);
                return Constants.INDEX_JSP;
            } else {
                model.addAttribute(Constants.USERS_NOT_DELETED, Constants.USERS_NOT_DELETED_MESSAGE);
                return Constants.DELETE_JSP;
            }
        } else {
            model.addAttribute(Constants.USERS_NOT_DELETED, Constants.USERS_NOT_DELETED_MESSAGE);
            return Constants.DELETE_JSP;
        }
    }
}
