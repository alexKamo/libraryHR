package com.projectHR.app.dao;


import com.projectHR.app.entity.HR_User;

import java.util.List;

public interface HR_UserDAO {

    List<HR_User> findUser();

    HR_User findByIdHrUser(int id);

    HR_User saveHrUser(HR_User hrUser);

    void deleteByIdHrUser(int id);
}
