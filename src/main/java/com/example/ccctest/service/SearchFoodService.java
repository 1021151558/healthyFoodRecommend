package com.example.ccctest.service;

import com.example.ccctest.model.SearchFood;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * @Author: kong
 * @Descripton:
 * @Date: created in 11:04 2018/5/28/028
 */
public interface SearchFoodService {
    Page<SearchFood> findAllByFoodNameContainingOrFoodTableContainingOrFoodWorkContaining(String name1 , String name2 , String name3 , Pageable pageable);

    Page<SearchFood> findAllByFoodWorkContainingOrFoodNameContaining(String foodWork,String foodName,Pageable pageable);

    Page<SearchFood> findAllByFoodWorkContainingOrFoodTableContaining(String foodWork,String foodTable,Pageable pageable);
}
