package com.example.ccctest.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @Author: kong
 * @Descripton:
 * @Date: created in 10:53 2018/5/16/016
 */
@Entity(name = "changshi")
@Data
public class Changshi {

    @Id
    private Integer id;

    private String icon;

    private String title;

    private String content;

    private String popularity;

}
