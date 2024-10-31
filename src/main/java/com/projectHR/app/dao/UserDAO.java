package com.projectHR.app.dao;


import com.projectHR.app.entity.User;

import java.util.List;

public interface UserDAO {

    List<User> findUser();

    User findByIdHrUser(int id);

    User saveHrUser(User hrUser);

    void deleteByIdHrUser(int id);
}
