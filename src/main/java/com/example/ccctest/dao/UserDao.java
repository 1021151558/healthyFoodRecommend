package com.example.ccctest.dao;

import com.example.ccctest.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserDao extends JpaRepository<UserEntity,Integer> {

     UserEntity findByUserNameAndPassword(String userName, String password);
     UserEntity findByUserName(String userName);
     UserEntity findByNicheng(String nicheng);
}
