package com.example.ccctest.service;

import com.example.ccctest.model.UserEntity;

import java.util.List;
import java.util.Optional;

/**
 * @Author: kong
 * @Descripton:
 * @Date: created in 15:06 2018/4/9/009
 */
public interface UserService {

    UserEntity findByUserNameAndPassword(String userName, String password);
    UserEntity findByUserName(String userName);
    UserEntity findByNicheng(String nicheng);
    UserEntity findById(Integer id);
    UserEntity save(UserEntity userEntity);
    List<UserEntity> findAll();
    void delete(UserEntity userEntity);
}
