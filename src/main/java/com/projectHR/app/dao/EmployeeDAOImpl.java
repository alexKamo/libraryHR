package com.projectHR.app.dao;

import com.projectHR.app.dao.EmployeeDAO;
import com.projectHR.app.employee.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {

    private EntityManager entityManager;

    @Autowired
    public EmployeeDAOImpl(EntityManager theEntityManager){
        entityManager = theEntityManager;
    }

    @Override
    public List<Employee> findEmployee() {
        TypedQuery<Employee> query = entityManager.createQuery("from employee", Employee.class);
        List<Employee> employees = query.getResultList();
        return employees;
    }
    @Override
    public Employee findByIdEmployee(int id) {
        return entityManager.find(Employee.class,id);
    }

    @Override
    public Employee saveEmployee(Employee employee) {
        return entityManager.merge(employee);
    }

    @Override
    public void deleteByIdEmployee(int id) {
        Employee employee = entityManager.find(Employee.class,id);
        entityManager.remove(employee);
    }
}
