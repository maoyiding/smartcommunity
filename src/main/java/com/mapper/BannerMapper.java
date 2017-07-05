package com.mapper;

import com.domain.Banner;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by maoyiding on 17-7-4.
 */

@Component
@Mapper
public interface BannerMapper {
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
