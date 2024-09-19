package com.projectHR.app.dao;

import com.projectHR.app.entity.HR_User;
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
    @Override
    public HR_User findByIdHrUser(int id) {
        return entityManager.find(HR_User.class,id);
    }

    @Override
    public HR_User saveHrUser(HR_User hrUser) {
        return entityManager.merge(hrUser);
    }

    @Override
    public void deleteByIdHrUser(int id) {
        HR_User hrUser = entityManager.find(HR_User.class,id);
        entityManager.remove(hrUser);
    }
}
