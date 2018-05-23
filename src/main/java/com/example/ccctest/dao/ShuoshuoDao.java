package com.example.ccctest.dao;

import com.example.ccctest.model.Shuoshuo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author: kong
 * @Descripton:
 * @Date: created in 14:39 2018/5/18/018
 */
@Repository
public interface ShuoshuoDao extends JpaRepository<Shuoshuo,String> {


}
