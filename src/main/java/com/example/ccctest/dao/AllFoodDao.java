package com.example.ccctest.dao;

import com.example.ccctest.model.AllFood;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @Author: kong
 * @Descripton:
 * @Date: created in 15:55 2018/5/9/009
 */
@Repository
public interface AllFoodDao extends JpaRepository<AllFood,Integer> {
    Page<AllFood> findAllByFoodTable(Pageable page ,String foodTable);

//    @Query(value = "select allfood from AllFood allfood where concat(allfood.foodName,allfood.foodWork,allfood.foodTable) like %:name%")
//    Page<AllFood> findAllByFoodNameContainingOrFoodTableContainingOrFoodWorkContaining(String name1 ,String name2 ,String name3 , Pageable pageable);
//
//    Page<AllFood> findAllByFoodWorkContainingOrFoodNameContaining(String foodWork,String foodName,Pageable pageable);
//
//    Page<AllFood> findAllByFoodWorkContainingOrFoodTableContaining(String foodWork,String foodTable,Pageable pageable);
}
