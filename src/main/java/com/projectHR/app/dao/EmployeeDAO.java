package com.projectHR.app.dao;


import com.projectHR.app.employee.Employee;

import java.util.List;

public interface EmployeeDAO {

  List<Employee> findAll();

}
