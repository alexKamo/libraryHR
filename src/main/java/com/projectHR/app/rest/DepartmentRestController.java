package com.projectHR.app.rest;

import com.projectHR.app.department.Department;
import com.projectHR.app.employee.Employee;
import com.projectHR.app.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Repository
@RequestMapping("/hr")
public class DepartmentRestController {

    private DepartmentService departmentService;

    @Autowired
    public DepartmentRestController(DepartmentService departmentService){
        this.departmentService = departmentService;
    }

    @GetMapping("/departments")
    public List<Department> getDepartment(){
        return departmentService.findDepartment();
    }

    @GetMapping("/departments/{id}")
    public Department getDepartment(@PathVariable int id){
        Department dep = departmentService.findByIdDepartment(id);
        if (dep == null) throw new RuntimeException("Department not found by id: " + id);
        return dep;
    }

    @PostMapping("/departments")
    public Department addDepartment(@RequestBody Department department){
        department.setDepId(0);
        Department dep = departmentService.saveDepartment(department);
        return dep;
    }

    @PutMapping("/departments")
    public Employee updateEmployee(@RequestBody Employee employee){
        Employee emp = employeeService.saveEmployee(employee);
        return emp;
    }

    @DeleteMapping("/departments/{id}")
    public String deleteEmployee(@PathVariable int id){
        Employee employee = employeeService.findByIdEmployee(id);
        if (employee == null) return "nope";
        employeeService.deleteByIdEmployee(id);
        return "Deleted departments with id: " + id;
    }
}
