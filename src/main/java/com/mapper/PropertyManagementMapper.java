package com.mapper;

import com.domain.PropertyManagement;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by maoyiding on 6/29/17.
 */
@Component
@Mapper
public interface PropertyManagementMapper {
    /**
     * 获得所有物业公告
     * @return 物业公告
     */
    List<PropertyManagement> getAllTitle();

    /**
     * 添加物业公告
     * @return 物业公告
     */
    boolean addTitle();

}
