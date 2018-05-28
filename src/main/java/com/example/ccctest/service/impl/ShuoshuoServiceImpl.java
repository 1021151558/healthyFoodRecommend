package com.example.ccctest.service.impl;

import com.example.ccctest.dao.ShuoshuoDao;
import com.example.ccctest.model.Shuoshuo;
import com.example.ccctest.service.ShuoShuoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: kong
 * @Descripton:
 * @Date: created in 11:15 2018/5/28/028
 */
@Service
public class ShuoshuoServiceImpl implements ShuoShuoService {

    @Autowired
    private ShuoshuoDao shuoshuoDao;

    @Override
    public void save(Shuoshuo shuoshuo) {
        shuoshuoDao.save(shuoshuo);
    }

    @Override
    public List<Shuoshuo> findAll(Sort sort) {
        return shuoshuoDao.findAll(sort);
    }
}
