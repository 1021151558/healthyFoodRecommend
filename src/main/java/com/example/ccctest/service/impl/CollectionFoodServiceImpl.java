package com.example.ccctest.service.impl;

import com.example.ccctest.dao.CollectionFoodDao;
import com.example.ccctest.model.CollectionFood;
import com.example.ccctest.service.CollectionFoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @Author: kong
 * @Descripton:
 * @Date: created in 10:57 2018/5/28/028
 */
@Service
public class CollectionFoodServiceImpl implements CollectionFoodService {

    @Autowired
    private CollectionFoodDao collectionFoodDao;

    @Override
    public Page<CollectionFood> findAllByUserId(Integer userId, Pageable pageable) {
        return collectionFoodDao.findAllByUserId(userId,pageable);
    }

    @Override
    public Optional<CollectionFood> findById(Integer id) {
        return collectionFoodDao.findById(id);
    }

    @Override
    public void save(CollectionFood collectionFood) {
        collectionFoodDao.save(collectionFood);
    }


}
