package com.naughty.userlogin02.service;

import com.naughty.userlogin02.bean.UserAdd;
import com.naughty.userlogin02.dao.UserAddDao;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional
public class UserAddServiceImpl implements UserAddService{
    @Resource
    private UserAddDao userAddDao;
    @Override
    public void save(UserAdd userAdd) {
        userAddDao.save(userAdd);
    }

    @Override
    public void update(UserAdd userAdd) {
        userAddDao.update(userAdd);
    }

    @Override
    public void delete(String id) {
        userAddDao.delete(id);
    }

    @Override
    public List<UserAdd> findAll() {
        return userAddDao.findAll();
    }

    @Override
    public UserAdd finById(String id) {
        return userAddDao.finById(id);
    }
}
