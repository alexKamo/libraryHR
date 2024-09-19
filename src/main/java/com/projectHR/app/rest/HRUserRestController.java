package com.projectHR.app.rest;

import com.projectHR.app.service.HRUserService;
import com.projectHR.app.entity.HR_User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/users/{id}")
    public HR_User getHrUser(@PathVariable int id){
        HR_User hrUser = hrUserService.findByIdHrUser(id);
        if (hrUser == null) throw new RuntimeException("User not found by id: " + id);
        return hrUser;
    }

    @PostMapping("/users")
    public HR_User addHrUser(@RequestBody HR_User hrUser){
        hrUser.setUserId(0);
        HR_User hrUser1 = hrUserService.saveHrUser(hrUser);
        return hrUser1;
    }

    @PutMapping("/user")
    public HR_User updateHrUser(@RequestBody HR_User hrUser){
        HR_User hrUser1 = hrUserService.saveHrUser(hrUser);
        return hrUser1;
    }

    @DeleteMapping("/user/{id}")
    public String deleteHrUser(@PathVariable int id){
        HR_User hrUser = hrUserService.findByIdHrUser(id);
        if (hrUser == null) return "No such users with id: " + id;
        hrUserService.deleteByIdHrUser(id);
        return "Deleted users with id: " + id;
    }
}
