package com.projectHR.app.rest;

import com.projectHR.app.entity.Department;
import com.projectHR.app.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
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

    @PutMapping("/department")
    public Department updateDepartment(@RequestBody Department department){
        Department dep = departmentService.saveDepartment(department);
        return dep;
    }

    @DeleteMapping("/department/{id}")
    public String deleteDepartment(@PathVariable int id){
        Department department = departmentService.findByIdDepartment(id);
        if (department == null) return "No such department with id: " + id;
        departmentService.deleteByIdDepartment(id);
        return "Deleted departments with id: " + id;
    }
}
