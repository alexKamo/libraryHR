package com.projectHR.app.service;

import com.projectHR.app.entity.User;

import java.util.List;

public interface UserService {

    List<User> findUser();

    User findByIdHrUser(int id);

    User saveHrUser(User hrUser);

    void deleteByIdHrUser(int id);

}
