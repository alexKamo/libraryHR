package com.projectHR.app.controller;

import com.projectHR.app.service.HRUserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/users")
public class UserController {

    private HRUserService hrUserService;

    public UserController (HRUserService hrUserService){
        this.hrUserService = hrUserService;
    }
}
