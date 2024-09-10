package com.projectHR.app.dao;

import com.projectHR.app.dao.HR_UserDAO;
import com.projectHR.app.employee.Employee;
import com.projectHR.app.user.HR_User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class HR_UserDAOImpl implements HR_UserDAO {

    private EntityManager entityManager;

    @Autowired
    public HR_UserDAOImpl(EntityManager theEntityManager){
        entityManager = theEntityManager;
    }


    @Override
    public List<HR_User> findUser() {
        TypedQuery<HR_User> query = entityManager.createQuery("from hr_user", HR_User.class);
        List<HR_User> users = query.getResultList();
        return users;
    }
}
