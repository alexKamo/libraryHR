package com.projectHR.app.dao;

import com.projectHR.app.entity.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDAOImpl implements UserDAO {

    private EntityManager entityManager;

    @Autowired
    public UserDAOImpl(EntityManager theEntityManager){
        entityManager = theEntityManager;
    }


    @Override
    public List<User> findUser() {
        TypedQuery<User> query = entityManager.createQuery("from User", User.class);
        List<User> users = query.getResultList();
        return users;
    }
    @Override
    public User findByIdHrUser(int id) {
        return entityManager.find(User.class,id);
    }

    @Override
    public User saveHrUser(User hrUser) {
        return entityManager.merge(hrUser);
    }

    @Override
    public void deleteByIdHrUser(int id) {
        User hrUser = entityManager.find(User.class,id);
        entityManager.remove(hrUser);
    }
}
