package com.naughty.userlogin02.dao;

import com.naughty.userlogin02.bean.UserAdd;

import java.util.List;

public interface UserAddDao {
    void save(UserAdd useradd);
    void update(UserAdd useradd);
    void delete(String id);
    List<UserAdd> findAll();
    UserAdd finById(String id);
}
