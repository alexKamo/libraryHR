package com.projectHR.app.dao;

import com.projectHR.app.department.Department;


import java.util.List;

public interface DepartmentDAO {

    List<Department> findDepartment();

    Department findByIdDepartment(int id);

    Department saveDepartment(Department department);

    void deleteByIdDepartment(int id);

}
