package com.projectHR.app.service;

import com.projectHR.app.department.Department;

import java.util.List;

public interface DepartmentService {

    List<Department> findDepartment();
    Department findByIdDepartment(int id);
    Department saveDepartment(Department dep);
    void deleteByIdDepartment(int id);

}
