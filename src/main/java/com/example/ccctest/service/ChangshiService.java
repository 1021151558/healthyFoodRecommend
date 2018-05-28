package com.example.ccctest.service;

import com.example.ccctest.model.Changshi;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * @Author: kong
 * @Descripton:
 * @Date: created in 10:45 2018/5/28/028
 */
public interface ChangshiService {
    Page<Changshi> findAll(Pageable pageable);
    Changshi findById(Integer id);
}
