package com.projectHR.app.implementations;


import com.projectHR.app.dao.EmployeeDAO;
import com.projectHR.app.employee.Employee;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class EmployeeDAOJpaImplementation implements EmployeeDAO {

    private EntityManager entityManager;

    @Autowired
    public EmployeeDAOJpaImplementation(EntityManager theEntityManager){
        entityManager = theEntityManager;
    }

    @Override
    public void save(Employee employee) {
        entityManager.persist(employee);
    }
}
