package com.example.ccctest.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @Author: kong
 * @Descripton:
 * @Date: created in 14:34 2018/5/18/018
 */
@Data
@Entity(name = "shuoshuo")
public class Shuoshuo {


    private Integer userId;

    private String content;

    @Id
    private String createTime;

    private String nicheng;

}
