package com.projectHR.app.controller;

import com.projectHR.app.entity.User;
import com.projectHR.app.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/users")
public class UserController {

    private UserService userService;

    public UserController (UserService userService){
        this.userService = userService;
    }

    @GetMapping("/list")
    public String listUsers(Model theModel) {

        // get the users from db
        List<User> theUser = userService.findUser();

        // add to the spring model
        theModel.addAttribute("users", theUser);

        return "users/list-users";
    }

    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model theModel) {

        // create model attribute to bind form data
        User theUser = new User();

        theModel.addAttribute("user", theUser);

        return "users/user-form";
    }


    @PostMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("id") int theId,
                                    Model theModel) {

        // get the employee from the service
        User theUser = userService.findByIdHrUser(theId);

        // set user as a model attribute to pre-populate the form
        theModel.addAttribute("user", theUser);

        // send over to our form
        return "users/user-form";
    }

    @PostMapping("/save")
    public String saveUser(@ModelAttribute("user") User theUser) {

        // save the user
        userService.saveHrUser(theUser);

        // use a redirect to prevent duplicate submissions
        return "redirect:/users/list";
    }

    @PostMapping("/delete")
    public String delete(@RequestParam("id") int theId) {

        // delete the user
        userService.deleteByIdHrUser(theId);

        // redirect to /users/list
        return "redirect:/users/list";

    }
}
