package com.example.ccctest.service.impl;

import com.example.ccctest.dao.UserDao;
import com.example.ccctest.enums.RegisterEnum;
import com.example.ccctest.exception.RegisterException;
import com.example.ccctest.model.UserEntity;
import com.example.ccctest.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
    public UserEntity findByUserName(String userName) {
        return userDao.findByUserName(userName);
    }

    @Override
    public UserEntity findByNicheng(String nicheng) {
        return userDao.findByNicheng(nicheng);
    }

    @Override
    public UserEntity findById(Integer id) {
        return userDao.findById(id).get();
    }

    @Override
    public UserEntity save(UserEntity userEntity) {
        return userDao.save(userEntity);
    }

    @Override
    public List<UserEntity> findAll() {
        return userDao.findAll();
    }

    @Override
    public void delete(UserEntity userEntity) {
        try {
            userDao.delete(userEntity);
        }catch ( RegisterException e){
            throw new RegisterException(RegisterEnum.DELETE);
        }

    }
}
