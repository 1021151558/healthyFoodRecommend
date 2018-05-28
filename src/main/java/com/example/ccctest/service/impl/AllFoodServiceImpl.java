package com.example.ccctest.service.impl;

import com.example.ccctest.dao.AllFoodDao;
import com.example.ccctest.model.AllFood;
import com.example.ccctest.service.AllFoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 * @Author: kong
 * @Descripton:
 * @Date: created in 10:29 2018/5/28/028
 */
@Service
public class AllFoodServiceImpl implements AllFoodService {

    @Autowired
    private AllFoodDao allFoodDao;

    @Override
    public Page<AllFood> findAllByFoodTable(Pageable page, String foodTable) {
        return allFoodDao.findAllByFoodTable(page,foodTable);
    }

    @Override
    public AllFood findById(Integer id) {
        return allFoodDao.findById(id).get();
    }
}
