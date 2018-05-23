package com.example.ccctest.dao;

import com.example.ccctest.model.CollectionFood;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @Author: kong
 * @Descripton:
 * @Date: created in 14:55 2018/5/11/011
 */
@Repository
public interface CollectionFoodDao extends JpaRepository<CollectionFood,Integer> {

    Page<CollectionFood> findAllByUserId(Integer userId, Pageable pageable);
}
