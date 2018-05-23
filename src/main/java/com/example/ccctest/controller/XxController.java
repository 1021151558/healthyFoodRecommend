package com.example.ccctest.controller;

import com.example.ccctest.dao.*;
import com.example.ccctest.model.*;

import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;

import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author: kong
 * @Descripton:
 * @Date: created in 15:21 2018/4/16/016
 */
@Controller
public class XxController {

    @Autowired
    private AllFoodDao allFoodDao;

    @Autowired
    private CollectionFoodDao collectionFoodDao;

    @Autowired
    private ChangshiDao changshiDao;

    @Autowired
    private SearchFoodDao searchFoodDao;

    @Autowired
    private UserDao userDao;

    @Autowired
    private ShuoshuoDao shuoshuoDao;


    @RequestMapping(value = "/meirong", method = RequestMethod.POST)
    @ResponseBody
    public Page<AllFood> meirong(Pageable pageable, @RequestParam("pageNum") Integer pageNum, @RequestParam("foodTable") String foodTable) {

        pageable = new PageRequest(pageNum, 8);
        Page<AllFood> foodPage = allFoodDao.findAllByFoodTable(pageable, foodTable);
        System.out.println("meirong:" + pageNum);

        return foodPage;
    }

    @RequestMapping(value = "/saveFood", method = RequestMethod.POST)
    @ResponseBody
    public String collectionFood(@RequestParam("foodId") Integer foodId, @RequestParam("nicheng") String nicheng) {

        AllFood allFood = allFoodDao.findById(foodId).get();
        UserEntity userEntity = userDao.findByNicheng(nicheng);

        if (userEntity != null) {
            if (collectionFoodDao.findById(foodId).isPresent()) {
            } else {
                CollectionFood collectionFood = new CollectionFood();
                collectionFood.setId(allFood.getId());
                collectionFood.setFoodIcon(allFood.getFoodIcon());
                collectionFood.setFoodMethod(allFood.getFoodMethod());
                collectionFood.setFoodName(allFood.getFoodName());
                collectionFood.setFoodPopularity(allFood.getFoodPopularity());
                collectionFood.setFoodTable(allFood.getFoodTable());
                collectionFood.setFoodWork(allFood.getFoodWork());
                collectionFood.setUserId(userEntity.getId());
                collectionFoodDao.save(collectionFood);
            }
        }


        return "已收藏";
    }

    @RequestMapping(value = "/myCollection", method = RequestMethod.POST)
    @ResponseBody
    public Page<CollectionFood> myCollection(Pageable pageable, @RequestParam("pageNum") Integer pageNum, @RequestParam("nicheng") String nicheng) {


        UserEntity userEntity = userDao.findByNicheng(nicheng);

        pageable = new PageRequest(pageNum, 8);
        Page<CollectionFood> collectionFoodPage = collectionFoodDao.findAllByUserId(userEntity.getId(), pageable);
        System.out.println("collection:" + pageNum);

        return collectionFoodPage;
    }

    @RequestMapping(value = "/foodSearch", method = RequestMethod.POST)
    @ResponseBody
    public Page<SearchFood> foodSearch(Pageable pageable, @RequestParam("name") String name, @RequestParam("pageNum") Integer pageNum) {

        pageable = new PageRequest(pageNum, 8);
        Page<SearchFood> allFoodPage = searchFoodDao.findAllByFoodNameContainingOrFoodTableContainingOrFoodWorkContaining(name, name, name, pageable);
        System.out.println("foodSearch:" + pageNum);
        return allFoodPage;
    }

    @RequestMapping(value = "/homePage", method = RequestMethod.POST)
    @ResponseBody
    public Page<Changshi> homePage(Pageable pageable, @RequestParam("pageNum") Integer pageNum) {
        pageable = new PageRequest(pageNum, 8);
        Page<Changshi> changshiPage = changshiDao.findAll(pageable);
        System.out.println("changshi:" + pageNum);
        return changshiPage;
    }

    @RequestMapping(value = "/changshi", method = RequestMethod.GET)
    public String changshi(ModelMap modelMap, @RequestParam("foodId") Integer foodId) {

        Changshi changshi = changshiDao.findById(foodId).get();
        modelMap.put("title", changshi.getTitle());
        modelMap.put("content", changshi.getContent());

        return "changshi";
    }

    @RequestMapping(value = "/foodMethod", method = RequestMethod.GET)
    public String foodMethod(ModelMap modelMap, @RequestParam("foodId") Integer foodId) {

        AllFood allFood = allFoodDao.findById(foodId).get();
        modelMap.put("foodName", allFood.getFoodName());
        modelMap.put("content", allFood.getFoodMethod());
        return "foodMethod";
    }


    @RequestMapping(value = "/tuijian", method = RequestMethod.POST)
    @ResponseBody
    public Page<SearchFood> tuijian(Pageable pageable, @RequestParam("bmi") double bmi, @RequestParam("wish") String wish,
                                    @RequestParam("pageNum") Integer pageNum) {
        System.out.println("bmi:" + bmi);
        System.out.println("wish:" + wish);
        String key = "";

        if (bmi < 18.5) {
            key = "开胃";
        } else if (bmi <= 23.9) {
            key = "健";
        } else if (bmi <= 27.9) {
            key = "减";
        } else if (bmi <= 32) {
            key = "减";
        } else {
            key = "降";
        }

        System.out.println("key:" + key);
        String table = null;
        if (wish.equals("营养")) {
            table = "yingyang";
        } else if (wish.equals("养身")) {
            table = "yangshen";
        } else if (wish.equals("清淡")) {
            table = "jiedu";
        } else {
            table = null;
        }
        System.out.println("table:" + table);
        Page<SearchFood> allFoodPage;
        pageable = new PageRequest(pageNum, 8);
        if (table == null) {
            allFoodPage = searchFoodDao.findAllByFoodWorkContainingOrFoodNameContaining(key, "肉", pageable);
        } else {
            allFoodPage = searchFoodDao.findAllByFoodWorkContainingOrFoodTableContaining(key, table, pageable);
        }

        return allFoodPage;
    }


    @ResponseBody
    @RequestMapping(value = "/saveShuoshuo", method = RequestMethod.POST)
    public void saveShuoshuo(@RequestParam("nicheng") String nicheng, @RequestParam("content") String content, @RequestParam("time") String time) {

        System.out.println("save shuo shuo");

        UserEntity userEntity = userDao.findByNicheng(nicheng);
        Shuoshuo shuoshuo = new Shuoshuo();
        shuoshuo.setUserId(userEntity.getId());
        shuoshuo.setContent(content);
        shuoshuo.setCreateTime(time);
        shuoshuo.setNicheng(nicheng);

        shuoshuoDao.save(shuoshuo);

    }

    @ResponseBody
    @RequestMapping(value = "/refreshShuoshuo", method = RequestMethod.POST)
    public List<Shuoshuo> refreshShuoshuo() {

        System.out.println("refresh Shuo shuo");

        Sort sort = new Sort(Sort.Direction.DESC, "createTime");
        List<Shuoshuo> ss = shuoshuoDao.findAll(sort);
        if (ss == null){
            return null;
        }else
        return ss;
    }

    @RequestMapping(value = "/shuoshuo", method = RequestMethod.POST)
    public String shuoshuo(ModelMap modelMap,@RequestParam("nicheng") String nicheng){

        System.out.println("nicheng:" +nicheng);

//        String name = new String(Base64.decodeBase64(nicheng));

//        System.out.println("name:" +name);

        UserEntity userEntity = userDao.findByNicheng(nicheng);

        if (userEntity!=null){
            return "shuoshuo";
        }else {
            return "login";
        }

    }


}
