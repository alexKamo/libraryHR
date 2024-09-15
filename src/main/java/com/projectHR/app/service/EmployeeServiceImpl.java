package com.projectHR.app.service;

import com.projectHR.app.dao.EmployeeDAO;
import com.projectHR.app.employee.Employee;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    EmployeeDAO employeeDAO;

    @Autowired
    public EmployeeServiceImpl(EmployeeDAO employeeDAO){
        this.employeeDAO = employeeDAO;
    }

    @Override
    public List<Employee> findAll() {
        return employeeDAO.findEmployee();
    }
    @Override
    public Employee findByIdEmployee(int id) {
        return employeeDAO.findByIdEmployee(id);
    }

    @Transactional
    @Override
    public Employee saveEmployee(Employee emp) {
        return employeeDAO.saveEmployee(emp);
    }


    @Transactional
    @Override
    public void deleteByIdEmployee(int id) {
        employeeDAO.deleteByIdEmployee(id);
    }

}
