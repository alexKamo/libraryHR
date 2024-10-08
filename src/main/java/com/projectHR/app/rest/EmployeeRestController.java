package com.projectHR.app.rest;


import com.projectHR.app.service.EmployeeService;
import com.projectHR.app.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hr")
public class EmployeeRestController {

    private EmployeeService employeeService;

    @Autowired
    public EmployeeRestController(EmployeeService employeeService){
        this.employeeService = employeeService;
    }

    @GetMapping("/employees")
    public List<Employee> getEmployees(){
        System.out.println("aaa");
        return employeeService.findEmployee();
    }

    @GetMapping("/employees/{id}")
    public Employee getEmployee(@PathVariable int id){
        Employee emp = employeeService.findByIdEmployee(id);
        if (emp == null) throw new RuntimeException("Employee not found by id: " + id);
        return emp;
    }

    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee employee){
        employee.setId(0);
        Employee emp = employeeService.saveEmployee(employee);
        return emp;
    }

    @PutMapping("/employee")
    public Employee updateEmployee(@RequestBody Employee employee){
        Employee emp = employeeService.saveEmployee(employee);
        return emp;
    }

    @DeleteMapping("/employee/{id}")
    public String deleteEmployee(@PathVariable int id){
        Employee employee = employeeService.findByIdEmployee(id);
        if (employee == null) return "No such employee with id: " + id;
        employeeService.deleteByIdEmployee(id);
        return "Deleted employee with id: " + id;
    }
}
