package com.example.ccctest.controller;

import com.example.ccctest.model.UserEntity;

import com.example.ccctest.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


/**
 * @Author: kong
 * @Descripton:
 * @Date: created in 14:23 2018/4/4/004
 */

@Controller
public class LoginController {

    @Autowired
    private UserServiceImpl userDao;


    @RequestMapping("/")
    public String login() {
        return "login";
    }

    //登陆注册界面
    @RequestMapping("/register")
    public String regiester() {
        return "register";
    }



    @RequestMapping(value = "/userLogin", method = RequestMethod.POST)
    public String userLogin(@RequestParam("username") String username, @RequestParam("password") String password, ModelMap map) {


        UserEntity userEntity = userDao.findByUserNameAndPassword(username, password);

        if (userEntity!=null){

            if (username.equals("admins")&&password.equals("admins")){
                return "admin";
            }
            map.put("nicheng",userEntity.getNicheng());
            return "main";
        }else{
            map.addAttribute("error","账号密码错误");
        }

        return  "login";

    }



    @RequestMapping(value = "/addregister", method = RequestMethod.POST)
    public String register(@RequestParam("username") String username, @RequestParam("password") String password, @RequestParam("cfPassword") String password2,
                           @RequestParam("nicheng") String nicheng,ModelMap map) {

        if(userDao.findByUserName(username) == null){
            if (password.equals(password2)) {
                if(userDao.findByNicheng(nicheng) == null){
                    UserEntity userEntity = new UserEntity();
                    userEntity.setUserName(username);
                    userEntity.setPassword(password);
                    userEntity.setNicheng(nicheng);
                    userDao.save(userEntity);

                    map.addAttribute("CG","alert('恭喜您注册成功！')");
                    return "login";
                }
                map.addAttribute("CZ","该昵称已存在");
              return "register";

            } else {
                return "register";
 //               throw new RegisterException(RegisterEnum.FAIL);
            }
        }else {
            map.addAttribute("CZ","该账号已存在");
            return "register";
//            throw new RegisterException(RegisterEnum.FAIL);
        }




    }

    @RequestMapping("/upPassword")
    public String upPassword(){

        return "passwordUpdate";
    }

    @RequestMapping(value = "/passwordUpdate",method = RequestMethod.POST)
    public String passwordUpdate(@RequestParam("username") String username,@RequestParam("password") String password,@RequestParam("Newpassword") String Newpassword,
                                  @RequestParam("checkNewpassword") String checkNewpassword,ModelMap modelMap){

        UserEntity userEntity = userDao.findByUserNameAndPassword(username, password);
        if(userEntity!=null && Newpassword.equals(checkNewpassword)){
            userEntity.setPassword(Newpassword);
            userDao.save(userEntity);
        }else {
            modelMap.addAttribute("error","账号密码错误");
            return "passwordUpdate";
        }
        return "login";
    }





}
