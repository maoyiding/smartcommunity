package com.service;

import com.domain.Banner;

import java.util.List;

/**
 * Created by maoyiding on 17-7-4.
 */
public interface BannerService {
    /**
     * 添加banner图片
     * @param banner
     * @return banner地址
     */
    boolean addBanner(Banner banner);

    /**
     * 获取所有图片
     * @return
     */
    List<Banner> getAll();
}
