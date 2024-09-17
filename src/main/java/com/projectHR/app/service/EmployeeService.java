package com.projectHR.app.service;

import com.projectHR.app.employee.Employee;

import java.util.List;

public interface EmployeeService {

    List<Employee> findEmployee();

    Employee findByIdEmployee(int id);

    Employee saveEmployee(Employee emp);

    void deleteByIdEmployee(int id);


}
