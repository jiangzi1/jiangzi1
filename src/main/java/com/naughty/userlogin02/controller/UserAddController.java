package com.naughty.userlogin02.controller;

import com.naughty.userlogin02.bean.UserAdd;
import com.naughty.userlogin02.service.UserAddService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping("/userAdd")
public class UserAddController {

    @Autowired
    private UserAddService userAddService;

    /**
     * 更新用户
     */
    @PostMapping("/update")
    public Map<String,Object> update(@RequestBody UserAdd useradd){
        HashMap<String,Object> map =new HashMap<>();
        try {
            userAddService.update(useradd);
            map.put("success",true);
            map.put("msg","更新用户信息成功");
        } catch (Exception e) {
            e.printStackTrace();
            map.put("success",false);
            map.put("msg","更新用户信息失败:"+e.getMessage());
        }
        return map;
    }
    /**
     * 查询一个
     */
    @GetMapping("findOne")
    public UserAdd findOne(String id){
        return userAddService.finById(id);
    }
    /**
     * 删除用户
     *
     */
    @GetMapping("delete")
    public Map<String,Object> delete(String id){
        HashMap<String,Object> map =new HashMap<>();
        try {
            userAddService.delete(id);
            map.put("success",true);
            map.put("msg","删除用户信息成功");
        } catch (Exception e) {
            e.printStackTrace();
            map.put("success",false);
            map.put("msg","删除用户信息失败:"+e.getMessage());
        }
        return  map;
    }
    /**
     * 添加用户
     * 查询所有
     */
    @PostMapping("add")
  public Map<String,Object> add(@RequestBody UserAdd userAdd){
        System.out.println(userAdd);
        HashMap<String,Object> map =new HashMap<>();
        try {
            userAddService.save(userAdd);
            map.put("success",true);
            map.put("msg","添加信息成功");
        } catch (Exception e) {
            e.printStackTrace();
            map.put("success",false);
            map.put("msg","添加信息失败:"+e.getMessage());
        }
        return  map;
    }
    /**
     * 添加用户
     * 查询所有
     */
    @PostMapping("add")
    public Map<String,Object> add( @RequestBody  UserAdd userAdd){
        System.out.println(userAdd);
        HashMap<String,Object> map =new HashMap<>();
        try {
            userAddService.save(userAdd);
            map.put("success",true);
            map.put("msg","添加信息成功");
        } catch (Exception e) {
            e.printStackTrace();
            map.put("success",false);
            map.put("msg","添加信息失败:"+e.getMessage());
        }
        return  map;
    }
    @GetMapping("findAll")
    public Map<String, Object> findAll( Integer page,Integer rows) {
        Map <String,Object> map= new HashMap<>();
        List<UserAdd> results = userAddService.findAll();
        map.put("total", 10);
        map.put("totalPage", 1);
        map.put("page", page);
        map.put("results", results);
        return  map;
    }
    }

