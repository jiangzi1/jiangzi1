package com.naughty.userlogin02.service;

import com.naughty.userlogin02.bean.UserAdd;

import java.util.List;

public interface UserAddService {
    void save(UserAdd useradd);
    void update(UserAdd useradd);
    void delete(String id);
    List<UserAdd> findAll();
    UserAdd finById(String id);
}
