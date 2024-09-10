package com.projectHR.app.dao.service;

import com.projectHR.app.dao.HR_UserDAO;
import com.projectHR.app.dao.HR_UserDAOImpl;
import com.projectHR.app.user.HR_User;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class HRUserServiceImpl implements HRUserService{

    HR_UserDAO userDAO;

    @Autowired
    public HRUserServiceImpl(HR_UserDAO userDAO){
        this.userDAO = userDAO;
    }

    @Override
    public List<HR_User> findUser() {
        return userDAO.findUser();
    }
}
