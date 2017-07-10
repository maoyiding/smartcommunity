package com.controller;

import com.domain.Banner;
import com.domain.City;
import com.domain.Community;
import com.service.BannerService;
import com.service.CityService;
import com.service.CommunityService;
import com.service.QiniuUploadService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

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
            if(banner.getId() == banners.getId()){
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

}

