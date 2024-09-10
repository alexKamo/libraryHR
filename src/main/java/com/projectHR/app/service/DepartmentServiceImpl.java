package com.projectHR.app.service;

import com.projectHR.app.dao.DepartmentDAO;
import com.projectHR.app.dao.DepartmentDAOImpl;
import com.projectHR.app.department.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService{

    DepartmentDAO departmentDAO;

    @Autowired
    public DepartmentServiceImpl(DepartmentDAO departmentDAO){
        this.departmentDAO = departmentDAO;
    }

    @Override
    public List<Department> findDepartment() {
        return departmentDAO.findDepartment();
    }
}
