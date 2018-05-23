package com.example.ccctest.dao;

import com.example.ccctest.model.Changshi;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @Author: kong
 * @Descripton:
 * @Date: created in 11:03 2018/5/16/016
 */
@Repository
public interface ChangshiDao extends JpaRepository<Changshi,Integer>{

}
