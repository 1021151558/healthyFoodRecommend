package com.example.ccctest.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @Author: kong
 * @Descripton:
 * @Date: created in 15:48 2018/5/17/017
 */
@Data
@Entity(name = "foods_copy")
public class SearchFood {
    @Id
    private Integer id;

    private String foodName;

    private String foodPopularity;

    private String foodWork;

    private String foodIcon;

    private String foodTable;

    private String foodMethod;
}
