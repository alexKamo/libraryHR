package com.projectHR.app.implementations;

import com.projectHR.app.dao.HR_UserDAO;
import com.projectHR.app.employee.Employee;
import com.projectHR.app.user.HR_User;
import jakarta.persistence.EntityManager;
import org.springframework.stereotype.Repository;

@Repository
public class HR_UserDAOImpl implements HR_UserDAO {

    private EntityManager entityManager;

    public HR_UserDAOImpl(EntityManager theEntityManager){
        entityManager = theEntityManager;
    }

    @Override
    public void save(HR_User theHR_User) {
        entityManager.persist(theHR_User);
    }
}
