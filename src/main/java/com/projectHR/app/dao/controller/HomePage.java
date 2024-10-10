package com.projectHR.app.dao.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomePage {

    @GetMapping("/home")
    public String showHome(){
        return "home";
    }

}
