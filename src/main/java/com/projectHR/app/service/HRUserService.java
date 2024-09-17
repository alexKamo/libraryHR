package com.projectHR.app.service;

import com.projectHR.app.department.Department;
import com.projectHR.app.user.HR_User;

import java.util.List;

public interface HRUserService {

    List<HR_User> findUser();

    HR_User findByIdHrUser(int id);

    HR_User saveHrUser(HR_User hrUser);

    void deleteByIdHrUser(int id);

}
