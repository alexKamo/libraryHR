package com.projectHR.app.service;

import com.projectHR.app.dao.HR_UserDAO;
import com.projectHR.app.department.Department;
import com.projectHR.app.user.HR_User;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
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

    @Override
    public HR_User findByIdHrUser(int id) {
        return userDAO.findByIdHrUser(id);
    }

    @Transactional
    @Override
    public HR_User saveHrUser(HR_User hrUser) {
        return userDAO.saveHrUser(hrUser);
    }


    @Transactional
    @Override
    public void deleteByIdHrUser(int id) {
        userDAO.deleteByIdHrUser(id);
    }

}
