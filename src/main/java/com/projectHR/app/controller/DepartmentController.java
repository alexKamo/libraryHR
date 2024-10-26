package com.projectHR.app.controller;

import java.util.List;

import com.projectHR.app.entity.Department;
import com.projectHR.app.service.DepartmentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/departments")
public class DepartmentController {

    private DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService){
        this.departmentService = departmentService;
    }

    // add mapping for "/list"

    @GetMapping("/list")
    public String listDepartments(Model theModel) {

        // get the employees from db
        List<Department> theDepartment = departmentService.findDepartment();

        // add to the spring model
        theModel.addAttribute("departments", theDepartment);

        return "departments/list-departments";
    }

    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model theModel) {

        // create model attribute to bind form data
        Department theDepartment = new Department();

        theModel.addAttribute("department", theDepartment);

        return "departments/department-form";
    }


    @PostMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("departmentId") int theId,
                                    Model theModel) {

        // get the employee from the service
        Department theDepartment = departmentService.findByIdDepartment(theId);

        // set employee as a model attribute to pre-populate the form
        theModel.addAttribute("department", theDepartment);

        // send over to our form
        return "departments/department-form";
    }

    @PostMapping("/save")
    public String saveDepartment(@ModelAttribute("department") Department theDepartment) {

        // save the department
        departmentService.saveDepartment(theDepartment);

        // use a redirect to prevent duplicate submissions
        return "redirect:/departments/list";
    }

    @PostMapping("/delete")
    public String delete(@RequestParam("departmentId") int theId) {

        // delete the department
        departmentService.deleteByIdDepartment(theId);

        // redirect to departments/list
        return "redirect:/departments/list";

    }
}











