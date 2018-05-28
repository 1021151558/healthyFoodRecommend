package com.example.ccctest.service.impl;

import com.example.ccctest.dao.SearchFoodDao;
import com.example.ccctest.model.SearchFood;
import com.example.ccctest.service.SearchFoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 * @Author: kong
 * @Descripton:
 * @Date: created in 11:07 2018/5/28/028
 */
@Service
public class SearchFoodServiceImpl implements SearchFoodService{

    @Autowired
    private SearchFoodDao searchFoodDao;

    @Override
    public Page<SearchFood> findAllByFoodNameContainingOrFoodTableContainingOrFoodWorkContaining(String name1, String name2, String name3, Pageable pageable) {
        return searchFoodDao.findAllByFoodNameContainingOrFoodTableContainingOrFoodWorkContaining(name1,name2,name3,pageable);
    }

    @Override
    public Page<SearchFood> findAllByFoodWorkContainingOrFoodNameContaining(String foodWork, String foodName, Pageable pageable) {
        return searchFoodDao.findAllByFoodWorkContainingOrFoodNameContaining(foodWork,foodName,pageable);
    }

    @Override
    public Page<SearchFood> findAllByFoodWorkContainingOrFoodTableContaining(String foodWork, String foodTable, Pageable pageable) {
        return searchFoodDao.findAllByFoodWorkContainingOrFoodTableContaining(foodWork,foodTable,pageable);
    }
}
