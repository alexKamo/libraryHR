package com.projectHR.app.controller;

import java.util.List;

import com.projectHR.app.dao.EmployeeDAOImpl;
import com.projectHR.app.entity.Employee;
import jakarta.persistence.EntityManager;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

    private EntityManager entityManager;
    EmployeeDAOImpl employeeDAO;

    public EmployeeController(EntityManager thEntityManager) {
        entityManager = thEntityManager;
    }

    // add mapping for "/list"

    @GetMapping("/listEmployee")
    public String listEmployees(Model theModel) {

        // get the employees from db
        List<Employee> theEmployees = employeeDAO.findEmployee();

        // add to the spring model
        theModel.addAttribute("employees", theEmployees);

        return "employees/list-employees";
    }

    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model theModel) {

        // create model attribute to bind form data
        Employee theEmployee = new Employee();

        theModel.addAttribute("employee", theEmployee);

        return "employees/employee-form";
    }

    @PostMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("employeeId") int theId,
                                    Model theModel) {

        // get the employee from the service
        Employee theEmployee = employeeDAO.findByIdEmployee(theId);

        // set employee as a model attribute to pre-populate the form
        theModel.addAttribute("employee", theEmployee);

        // send over to our form
        return "employees/employee-form";
    }

    @PostMapping("/save")
    public String saveEmployee(@ModelAttribute("employee") Employee theEmployee) {

        // save the employee
        employeeDAO.saveEmployee(theEmployee);

        // use a redirect to prevent duplicate submissions
        return "redirect:/employees/list";
    }

    @PostMapping("/delete")
    public String delete(@RequestParam("employeeId") int theId) {

        // delete the employee
        employeeDAO.deleteByIdEmployee(theId);

        // redirect to /employees/list
        return "redirect:/employees/list";

    }
}










