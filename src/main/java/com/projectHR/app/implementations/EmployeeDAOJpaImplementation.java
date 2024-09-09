package com.projectHR.app.implementations;


import com.projectHR.app.dao.EmployeeDAO;
import com.projectHR.app.employee.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDAOJpaImplementation implements EmployeeDAO {

    private EntityManager entityManager;

    @Autowired
    public EmployeeDAOJpaImplementation(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Employee> findALL() {
        TypedQuery<Employee> query = entityManager.createQuery("from Employee",Employee.class);
        List<Employee> employees = query.getResultList();
        return employees;
    }
}
