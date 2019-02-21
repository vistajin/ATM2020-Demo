package com.hsbc.wealth.atm2020demo.controller;


import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@Controller
public class HtmlController implements ErrorController {

    @GetMapping(value="/")
    public String home(HttpServletRequest request) {
        request.setAttribute("key", "hello world");
        return "home";
    }

    @GetMapping(value="/qr")
    public String qr(HttpServletRequest request) {
        return "qr";
    }

    private static final String PATH = "/error";

    @RequestMapping(value = PATH)
    public String error() {
        return "Error handling";
    }

    @Override
    public String getErrorPath() {
        return PATH;
    }
}
