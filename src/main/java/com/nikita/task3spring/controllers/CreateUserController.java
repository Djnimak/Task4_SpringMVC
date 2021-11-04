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
public class CreateUserController {

    private final UserService service;
    private final User user;

    public CreateUserController(UserService service, User user) {
        this.service = service;
        this.user = user;
    }

    @GetMapping(value = "create")
    public ModelAndView printCreateUserPage() {
        return new ModelAndView(Constants.CREATE_JSP);
    }

    @PostMapping("/created")
    public String createUser(@RequestParam Map<String, String> allParams, Model model) {
        user.setFirstName(allParams.get(Constants.FIRST_NAME));
        user.setLastName(allParams.get(Constants.LAST_NAME));
        user.setEmail(allParams.get(Constants.EMAIL));
        user.setPassword(allParams.get(Constants.PASSWORD));
        user.setGender(allParams.get(Constants.GENDER));
        user.setAge(Integer.parseInt(allParams.get(Constants.AGE)));

        int result = service.createUser(user);
        if (result > 0) {
            model.addAttribute(Constants.USER_CREATED, Constants.USER_CREATED_MESSAGE);
            return Constants.INDEX_JSP;
        } else {
            model.addAttribute(Constants.USER_NOT_CREATED, Constants.USER_NOT_CREATED_MESSAGE);
            return Constants.CREATE_JSP;
        }
    }


}
