package com.example.ccctest.service;

import com.example.ccctest.model.CollectionFood;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.Optional;

/**
 * @Author: kong
 * @Descripton:
 * @Date: created in 10:52 2018/5/28/028
 */
public interface CollectionFoodService {
    Page<CollectionFood> findAllByUserId(Integer userId, Pageable pageable);

    Optional<CollectionFood> findById(Integer id);

    void save(CollectionFood collectionFood);

}
