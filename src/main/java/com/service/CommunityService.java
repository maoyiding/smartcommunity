package com.service;

import com.domain.City;
import com.domain.Community;

import java.util.List;

/**
 * Created by maoyiding on 17-7-2.
 */
public interface CommunityService {
    /**
     * 获取所有城市社区
     * @return  所有社区
     */
    List<Community> getAllCommunityByCityId(int cityId);
    /**
     * 添加社区
     * @return 添加社区成功
     */
    boolean addCommunity();
}
