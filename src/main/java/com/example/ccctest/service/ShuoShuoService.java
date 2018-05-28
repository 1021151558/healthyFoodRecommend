package com.example.ccctest.service;

import com.example.ccctest.model.Shuoshuo;
import org.springframework.data.domain.Sort;

import java.util.List;

/**
 * @Author: kong
 * @Descripton:
 * @Date: created in 11:12 2018/5/28/028
 */
public interface ShuoShuoService {
    void save(Shuoshuo shuoshuo);
    List<Shuoshuo> findAll(Sort sort);
}
