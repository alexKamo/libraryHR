package com.projectHR.app.dao;


import com.projectHR.app.entity.Employee;

import java.util.List;

public interface EmployeeDAO {

  List<Employee> findEmployee();

  Employee findByIdEmployee(int id);

  Employee saveEmployee(Employee employee);

  void deleteByIdEmployee(int id);
}
