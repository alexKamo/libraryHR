package com.projectHR.app.rest;

import com.projectHR.app.service.UserService;
import com.projectHR.app.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hr")
public class UserRestController {

    private UserService userService;

    @Autowired
    public UserRestController(UserService userService){
        this.userService = userService;
    }

    @GetMapping("/users")
    public List<User> getUser(){
        return userService.findUser();
    }

    @GetMapping("/users/{id}")
    public User getHrUser(@PathVariable int id){
        User hrUser = userService.findByIdHrUser(id);
        if (hrUser == null) throw new RuntimeException("User not found by id: " + id);
        return hrUser;
    }

    @PostMapping("/users")
    public User addHrUser(@RequestBody User hrUser){
        hrUser.setUserId(0);
        User hrUser1 = userService.saveHrUser(hrUser);
        return hrUser1;
    }

    @PutMapping("/user")
    public User updateHrUser(@RequestBody User hrUser){
        User hrUser1 = userService.saveHrUser(hrUser);
        return hrUser1;
    }

    @DeleteMapping("/user/{id}")
    public String deleteHrUser(@PathVariable int id){
        User hrUser = userService.findByIdHrUser(id);
        if (hrUser == null) return "No such users with id: " + id;
        userService.deleteByIdHrUser(id);
        return "Deleted users with id: " + id;
    }
}
