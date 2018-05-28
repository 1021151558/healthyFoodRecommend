package com.example.ccctest.service.impl;

import com.example.ccctest.dao.ChangshiDao;
import com.example.ccctest.model.Changshi;
import com.example.ccctest.service.ChangshiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 * @Author: kong
 * @Descripton:
 * @Date: created in 10:48 2018/5/28/028
 */
@Service
public class ChangshiServiceImpl implements ChangshiService {

    @Autowired
    private ChangshiDao changshiDao;


    @Override
    public Page<Changshi> findAll(Pageable pageable) {
        return changshiDao.findAll(pageable);
    }

    @Override
    public Changshi findById(Integer id) {
        return changshiDao.findById(id).get();
    }
}
