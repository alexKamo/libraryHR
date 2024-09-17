package com.projectHR.app.service;

import com.projectHR.app.dao.DepartmentDAO;
import com.projectHR.app.dao.DepartmentDAOImpl;
import com.projectHR.app.department.Department;
import com.projectHR.app.employee.Employee;
import jakarta.transaction.Transactional;
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

    @Override
    public Department findByIdDepartment(int id) {
        return departmentDAO.findByIdDepartment(id);
    }

    @Transactional
    @Override
    public Department saveDepartment(Department dep) {
        return departmentDAO.saveDepartment(dep);
    }


    @Transactional
    @Override
    public void deleteByIdDepartment(int id) {
        departmentDAO.deleteByIdDepartment(id);
    }

}
