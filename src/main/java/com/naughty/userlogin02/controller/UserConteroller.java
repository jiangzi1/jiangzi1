package com.naughty.userlogin02.controller;

import com.alibaba.fastjson.JSON;
import com.naughty.userlogin02.bean.QueryInfo;
import com.naughty.userlogin02.bean.User;
import com.naughty.userlogin02.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;


@RestController
public class UserConteroller {
    
    @Autowired
    UserDao userDao;

    @CrossOrigin
    @RequestMapping("/allUser")
    public String getUserList(QueryInfo queryInfo){
        System.out.println(queryInfo);
        int numbers = userDao.getUserCounts("%"+queryInfo.getQuery()+"%");// 获取数据总数
        int pageStart = (queryInfo.getPageNum()-1)*queryInfo.getPageSize();
        List<User> users = userDao.getAllUser("%"+queryInfo.getQuery()+"%",pageStart,queryInfo.getPageSize());
        HashMap<String, Object> res = new HashMap<>();
        res.put("numbers",numbers);
        res.put("data",users);
        System.out.println("总条数："+numbers);
        String users_json = JSON.toJSONString(res);
        return users_json;
    }

    @RequestMapping("/userState")
    public String updateUserState(@RequestParam("id") Integer  id,
                                  @RequestParam("state") Boolean state){
        int i = userDao.updateState(id, state);
        System.out.println("用户编号:"+id);
        System.out.println("用户状态:"+state);
        String str = i >0?"success":"error";
        return str;
    }

    @RequestMapping("/addUser")
    public String addUser(@RequestBody User user){
        System.out.println(user);
        user.setRole("普通用户");
        user.setState(false);
        int i = userDao.addUser(user);
        String str = i >0?"success":"error";
        return str;
    }

    @RequestMapping("/getUpdate")
    public String getUpdateUser(int id){
        System.out.println("编号:"+id);
        User updateUser = userDao.getUpdateUser(id);
        String users_json = JSON.toJSONString(updateUser);
        return users_json;
    }

    @RequestMapping("/editUser")
    public String editUser(@RequestBody User user){
        System.out.println(user);
        int i = userDao.editUser(user);
        String str = i >0?"success":"error";
        return str;
    }

    @RequestMapping("/deleteUser")
    public String deleteUser(int id){
        System.out.println(id);
        int i = userDao.deleteUser(id);
        String str = i >0?"success":"error";
        return str;
    }
}
