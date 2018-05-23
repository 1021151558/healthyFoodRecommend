package com.example.ccctest.service.impl;

import com.example.ccctest.dao.UserDao;
import com.example.ccctest.model.UserEntity;
import com.example.ccctest.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

/**
 * @Author: kong
 * @Descripton:
 * @Date: created in 15:08 2018/4/9/009
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;



    @Override
    public UserEntity findByUserNameAndPassword(String userName, String password) {
        return userDao.findByUserNameAndPassword(userName,password);
    }

    @Override
    public UserEntity save(UserEntity userEntity) {
        return userDao.save(userEntity);
    }
}
