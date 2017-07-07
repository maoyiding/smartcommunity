package com.mapper;

import com.domain.City;
import com.domain.Community;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by Administrator on 2017/6/28.
 */
@Component
@Mapper
public interface CommunityMapper {
    /**
     * 获取所有城市社区
     * @return  所有社区
     */
    List<Community> getAllCommunityByCityId(int cityId);
    /**
     * 添加社区
     * @return 添加社区成功
     */
    boolean addCommunity(Community community);
}
