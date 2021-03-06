package com.service;

import com.domain.Banner;
import com.domain.City;

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

    /**
     * 开启前台照片
     * @return
     */
    boolean openBanner(Banner banner);

    /**
     * 关闭前台照片
     * @return
     */
    boolean closeBanner(Banner banner);

    /**
     * 根据ID查找图片
     * @param id
     * @return
     */
    List<Banner> getBannerById(int id);

}
