package com.example.ccctest.dao;

import com.example.ccctest.model.AllFood;
import com.example.ccctest.model.SearchFood;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Author: kong
 * @Descripton:
 * @Date: created in 15:49 2018/5/17/017
 */
public interface SearchFoodDao extends JpaRepository<SearchFood,Integer>{
    Page<SearchFood> findAllByFoodNameContainingOrFoodTableContainingOrFoodWorkContaining(String name1 , String name2 , String name3 , Pageable pageable);

    Page<SearchFood> findAllByFoodWorkContainingOrFoodNameContaining(String foodWork,String foodName,Pageable pageable);

    Page<SearchFood> findAllByFoodWorkContainingOrFoodTableContaining(String foodWork,String foodTable,Pageable pageable);
}
