package com.example.ccctest.model;

import lombok.Data;
import org.springframework.data.jpa.repository.Query;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @Author: kong
 * @Descripton:
 * @Date: created in 15:53 2018/5/9/009
 */
@Entity(name = "foods")
@Data
public class AllFood {
    @Id
    private Integer id;

    private String foodName;

    private String foodPopularity;

    private String foodWork;

    private String foodIcon;

    private String foodTable;

    private String foodMethod;
}
