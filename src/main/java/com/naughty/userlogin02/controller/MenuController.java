package com.naughty.userlogin02.controller;

import com.alibaba.fastjson.JSON;
import com.naughty.userlogin02.bean.MainMenu;
import com.naughty.userlogin02.bean.SubMenu;
import com.naughty.userlogin02.dao.MenuDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@RestController
public class MenuController {
    @Autowired
    MenuDao menuDao;

    @CrossOrigin
    @RequestMapping("/menus")
    public String getAllMenus(){
        HashMap<String, Object> data = new HashMap<>();
        List<MainMenu> mainMenus = menuDao.getMainMenus();
        data.put("data",mainMenus);
        data.put("status",200);
        String data_json = JSON.toJSONString(data);
        System.out.println("成功访问！！！");
        return data_json;
    }
}
//
//    // 子分支一
//    SubMenu sub1_1 = new SubMenu(101, "用户列表", "/user");
//    SubMenu sub1_2 = new SubMenu(102, "修改权限", "/rights");
//    SubMenu sub1_3 = new SubMenu(103, "运动模块", "/sport");
//    SubMenu sub1_4 = new SubMenu(104, "商品模块", "/goods");
//    // 子分支二
//    SubMenu sub2_1 = new SubMenu(201, "运动科普", "/Introduction");
//    SubMenu sub2_2 = new SubMenu(202, "卡路里查询", "/calories");
//    SubMenu sub2_3 = new SubMenu(203, "营养配餐", "/food");
//    SubMenu sub2_4 = new SubMenu(204, "个人计划", "/plan");
//
//    // 分支一集合
//    ArrayList<SubMenu> subMenus1 = new ArrayList<>();
//        subMenus1.add(sub1_1);
//                subMenus1.add(sub1_2);
//                subMenus1.add(sub1_3);
//                subMenus1.add(sub1_4);
//                // 分支二集合
//                ArrayList<SubMenu> subMenus2 = new ArrayList<>();
//        subMenus2.add(sub2_1);
//        subMenus2.add(sub2_2);
//        subMenus2.add(sub2_3);
//        subMenus2.add(sub2_4);
//
//        // 主分支
//        MainMenu main1 = new MainMenu(100, "权限管理", "/admin", subMenus1);
//        // 次分支
//        MainMenu main2 = new MainMenu(200, "运动平台", "/use", subMenus2);
//        ArrayList<MainMenu> mainMenus = new ArrayList<>();
//        mainMenus.add(main1);
//        mainMenus.add(main2);