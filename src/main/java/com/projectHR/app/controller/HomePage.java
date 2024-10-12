package com.projectHR.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomePage {

    @GetMapping("/")
    public String showHome() {
        return "home";
    }

    // add a request mapping for /employee

    @GetMapping("/employee")
    public String showEmployee() {
        return "employee";
    }

    // add request mapping for /manager

    @GetMapping("/manager")
    public String showManager() {
        return "manager";
    }

}
