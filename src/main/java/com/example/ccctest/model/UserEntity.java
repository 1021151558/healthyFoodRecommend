package com.example.ccctest.model;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity(name = "user")
@Data
public class UserEntity {

    @Id
    @GeneratedValue
    private Integer id;

    @Length(min = 6,max = 6, message = "账号长度为6")
    private String userName;

    @Length(min = 6,max = 6, message = "密码长度为6")
    private String password;

    private String nicheng;

}
