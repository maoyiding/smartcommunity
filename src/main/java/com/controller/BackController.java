package com.controller;

import com.domain.*;
import com.service.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by maoyiding on 17-7-5.
 */
@Controller
@Slf4j
public class BackController {

    @Autowired
    private QiniuUploadService qiniuUploadService;

    @Autowired
    private BannerService bannerService;

    @Autowired
    private CityService cityService;

    @Autowired
    private CommunityService communityService;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private GoodsService goodsService;

    @GetMapping("/back")
    public String toBack(){
        return "backstage/index";
    }

    @GetMapping("/toCity")
    public String toCity(){
        return "backstage/addcity";
    }

    @PostMapping("/addCity")
    public String addCity(City city){
        cityService.addCity(city);
        return toBack();
    }

    @GetMapping("/toCommunity")
    public String toCommunity(Model model){
        String orderWrold="A,B,C,D,E,F,G,H,I,J,K,L,M,N,O,P,Q,R,S,T,U,V,W,X,Y,Z";
        String[] firstWords=orderWrold.split(",");
        List words=new ArrayList();
        List cities=new ArrayList();
        for (int i=0;i<firstWords.length;i++) {
            List<City> cityList = cityService.getAllCity(firstWords[i]);
            if (cityList.size()!=0){
                cities.add(cityList);
            }
        }
        model.addAttribute("cities",cities);

        return "backstage/addcommunity";
    }

    @PostMapping("/addCommunity")
    public String addCommunity(Community community){
        communityService.addCommunity(community);
        return toBack();
    }

    @GetMapping("/upload")
    public String toUploadPage(Model model) {
        List<Banner> banner = bannerService.getAll();
        model.addAttribute("banner",banner);
        return "backstage/adv";
    }


    @GetMapping("/token")
    @ResponseBody
    public String getUploadToken() {
        log.info("request token");
        String token = this.qiniuUploadService.getUploadToken();
        return token;
    }

    @PostMapping("/addBanner")
    @ResponseBody
    public void addBanner(@RequestBody Banner banner){
        bannerService.addBanner(banner);
    }

    @PostMapping("/modify")
    public String toModify(Banner banner){
        List<Banner> u = bannerService.getAll();
        System.out.println(banner);
        for(Banner banners : u){
            if(banner.getBannerId() == banners.getBannerId()){
                if(banner.getStatus()== 1){
                    bannerService.closeBanner(banner);
                    break;
                }
                if(banner.getStatus()== 0){
                    bannerService.openBanner(banner);
                    break;
                }
            }
        }
        return "backstage/adv";
    }


    @GetMapping("/toCategory")
    public String toCategory(Model model){
        List<Category> categories = categoryService.getAll();
        model.addAttribute("categories",categories);
        return "backstage/category";
    }


    @GetMapping("/toAddCategory")
    public String addCategory(){
        return "backstage/addcategory";
    }

    @PostMapping("/addCategory")
    public String addCategory(Category category,Model model){
        categoryService.addCategory(category);
        List<Category> categories = categoryService.getAll();
        model.addAttribute("categories",categories);
        return toCategory(model);
    }

    @GetMapping("/toProduct")
    public String toProduct(Model model){
        List categories = new ArrayList();
        List<Category> categoryList = categoryService.getAll();
        for (Category category : categoryList){

            category.setGoods(goodsService.getAllByCategoryId(category.getCategoryId()));
            categories.add(category);

        }
        System.out.println(categories);
        model.addAttribute("categories" , categories);
        return "backstage/product";
    }

    @GetMapping("/toAddproduct")
    public String toAddproduct(Model model){
        List<Category> categories  = categoryService.getAll();
        model.addAttribute("categories",categories);
        return "backstage/addproduct";
    }

    @PostMapping("/addProduct")
    public String addProduct(Goods goods,Model model){
        goodsService.addGoods(goods);
        List categories = new ArrayList();
        List<Category> categoryList = categoryService.getAll();
        for (Category category : categoryList){

            category.setGoods(goodsService.getAllByCategoryId(category.getCategoryId()));
            categories.add(category);

        }
        System.out.println(categories);
        model.addAttribute("categories" , categories);
        return toProduct(model);
    }

    @PostMapping("/shelves")
    @ResponseBody
    public String shelves( @RequestBody Goods goods){

        return null;
    }
}

