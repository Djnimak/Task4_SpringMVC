package com.nikita.task3spring.controllers;

import com.nikita.task3spring.constants.Constants;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class WelcomeController {


    @RequestMapping({"/", "", "/index"})
    public String welcome() {
        return "index";
    }

    @GetMapping(value = "/")
    public ModelAndView welcomePage() {
        return new ModelAndView(Constants.INDEX_JSP);
    }
}
