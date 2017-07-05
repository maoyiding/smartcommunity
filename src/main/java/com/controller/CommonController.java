package com.controller;


import com.domain.Banner;
import com.domain.People;
import com.service.BannerService;
import com.service.QiniuUploadService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Rico on 2017/6/29.
 */
@Controller
@Slf4j
public class CommonController {

    @Autowired
    private QiniuUploadService qiniuUploadService;

    @Autowired
    private BannerService bannerService;

    @GetMapping("/upload")
    public String toUploadPage() {
        return "upload";
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
}
