package com.projectHR.app.service;

import com.projectHR.app.dao.UserDAO;
import com.projectHR.app.entity.User;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    UserDAO userDAO;

    @Autowired
    public UserServiceImpl(UserDAO userDAO){
        this.userDAO = userDAO;
    }

    @Override
    public List<User> findUser() {
        return userDAO.findUser();
    }

    @Override
    public User findByIdHrUser(int id) {
        return userDAO.findByIdHrUser(id);
    }

    @Transactional
    @Override
    public User saveHrUser(User hrUser) {
        return userDAO.saveHrUser(hrUser);
    }


    @Transactional
    @Override
    public void deleteByIdHrUser(int id) {
        userDAO.deleteByIdHrUser(id);
    }

}
