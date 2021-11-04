package com.nikita.task3spring.controllers;

import com.nikita.task3spring.constants.Constants;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class WelcomeController {


    @RequestMapping("/")
    public String welcome() {
        return "index";
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView welcomePage() {
        return new ModelAndView(Constants.INDEX_JSP);
    }
}
