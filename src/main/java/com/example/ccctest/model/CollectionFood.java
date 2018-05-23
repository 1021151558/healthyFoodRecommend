package com.example.ccctest.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @Author: kong
 * @Descripton:
 * @Date: created in 14:51 2018/5/11/011
 */
@Data
@Entity(name = "collectionFood")
public class CollectionFood {
    @Id
    private Integer id;

    private String foodName;

    private String foodPopularity;

    private String foodWork;

    private String foodIcon;

    private String foodTable;

    private String foodMethod;

    private Integer userId;
}
