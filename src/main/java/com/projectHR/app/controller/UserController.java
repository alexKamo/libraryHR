package com.projectHR.app.controller;

import com.projectHR.app.entity.Employee;
import com.projectHR.app.entity.HR_User;
import com.projectHR.app.service.HRUserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/users")
public class UserController {

    private HRUserService hrUserService;

    public UserController (HRUserService hrUserService){
        this.hrUserService = hrUserService;
    }

    @GetMapping("/list")
    public String listUsers(Model theModel) {

        // get the users from db
        List<HR_User> theUser = hrUserService.findUser();

        // add to the spring model
        theModel.addAttribute("hr_user", theUser);

        return "users/list-users";
    }

    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model theModel) {

        // create model attribute to bind form data
        HR_User theUser = new HR_User();

        theModel.addAttribute("hr_user", theUser);

        return "users/user-form";
    }


    @PostMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("hr_userId") int theId,
                                    Model theModel) {

        // get the employee from the service
        HR_User theUser = hrUserService.findByIdHrUser(theId);

        // set user as a model attribute to pre-populate the form
        theModel.addAttribute("hr_user", theUser);

        // send over to our form
        return "users/user-form";
    }

    @PostMapping("/save")
    public String saveUser(@ModelAttribute("hr_user") HR_User theUser) {

        // save the user
        hrUserService.saveHrUser(theUser);

        // use a redirect to prevent duplicate submissions
        return "redirect:/users/list";
    }

    @PostMapping("/delete")
    public String delete(@RequestParam("hr_userId") int theId) {

        // delete the user
        hrUserService.deleteByIdHrUser(theId);

        // redirect to /users/list
        return "redirect:/users/list";

    }
}
