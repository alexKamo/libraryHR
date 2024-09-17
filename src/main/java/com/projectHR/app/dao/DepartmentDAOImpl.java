package com.projectHR.app.dao;


import com.projectHR.app.department.Department;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DepartmentDAOImpl implements DepartmentDAO {

    private EntityManager entityManager;

    @Autowired
    public DepartmentDAOImpl(EntityManager theEntityManager){
        entityManager = theEntityManager;
    }


    @Override
    public List<Department> findDepartment() {
        TypedQuery<Department> query = entityManager.createQuery("from department",Department.class);
        List<Department> departments = query.getResultList();
        return departments;
    }
    @Override
    public Department findByIdDepartment(int id) {
        return entityManager.find(Department.class,id);
    }

    @Override
    public Department saveDepartment(Department department) {
        return entityManager.merge(department);
    }

    @Override
    public void deleteByIdDepartment(int id) {
        Department department = entityManager.find(Department.class,id);
        entityManager.remove(department);
    }
}
