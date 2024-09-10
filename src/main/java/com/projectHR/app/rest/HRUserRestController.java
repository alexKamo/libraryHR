package com.projectHR.app.rest;

import com.projectHR.app.dao.HR_UserDAO;
import com.projectHR.app.dao.service.HRUserService;
import com.projectHR.app.user.HR_User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/hr")
public class HRUserRestController {

    private HRUserService hrUserService;

    @Autowired
    public HRUserRestController(HRUserService hrUserService){
        this.hrUserService = hrUserService;
    }

    @GetMapping("/users")
    public List<HR_User> getUser(){
        return hrUserService.findUser();
    }
}
