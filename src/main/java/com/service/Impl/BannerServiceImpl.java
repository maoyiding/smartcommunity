package com.service.Impl;

import com.domain.Banner;
import com.domain.City;
import com.mapper.BannerMapper;
import com.service.BannerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by maoyiding on 17-7-4.
 */
@Service
public class BannerServiceImpl implements BannerService {

    @Autowired
    private BannerMapper bannerMapper;


    @Override
    public boolean addBanner(Banner banner) {
        return this.bannerMapper.addBanner(banner);
    }

    @Override
    public List<Banner> getAll() {
        return this.bannerMapper.getAll();
    }

    @Override
    public boolean openBanner(Banner banner) {
        return this.bannerMapper.openBanner(banner);
    }

    @Override
    public boolean closeBanner(Banner banner) {
        return this.bannerMapper.closeBanner(banner);
    }


    @Override
    public List<Banner> getBannerById(int id) {
        return this.bannerMapper.getBannerById(id);
    }
}
