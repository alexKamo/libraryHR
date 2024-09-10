package com.projectHR.app.dao;


import com.projectHR.app.dao.DepartmentDAO;
import com.projectHR.app.department.Department;
import jakarta.persistence.EntityManager;
import org.springframework.stereotype.Repository;

@Repository
public class DepartmentDAOImpl implements DepartmentDAO {

    private EntityManager entityManager;

    public DepartmentDAOImpl(EntityManager theEntityManager){
        entityManager = theEntityManager;
    }

    @Override
    public void save(Department theDepartment) {
        entityManager.persist(theDepartment);
    }
}
