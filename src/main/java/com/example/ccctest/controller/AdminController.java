package com.example.ccctest.controller;

import com.example.ccctest.model.UserEntity;
import com.example.ccctest.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author: kong
 * @Descripton:
 * @Date: created in 14:34 2018/5/23/023
 */
@Controller
public class AdminController {

    @Autowired
    private UserServiceImpl userDao;

    @RequestMapping(value = "/userList",method = RequestMethod.POST)
    @ResponseBody
    public List<UserEntity> userList(){
       return userDao.findAll();
    }

    @RequestMapping(value = "/userDelete",method = RequestMethod.POST)
    @ResponseBody
    public String delete(@RequestBody UserEntity userEntity){

        System.out.println(userEntity.getId());
        UserEntity user = userDao.findById(userEntity.getId());
        userDao.delete(user);
        return "删除成功";
    }
}
