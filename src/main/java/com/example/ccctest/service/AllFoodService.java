package com.example.ccctest.service;

import com.example.ccctest.model.AllFood;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * @Author: kong
 * @Descripton:
 * @Date: created in 10:25 2018/5/28/028
 */
public interface AllFoodService {
    Page<AllFood> findAllByFoodTable(Pageable page , String foodTable);
    AllFood findById(Integer id);
}
