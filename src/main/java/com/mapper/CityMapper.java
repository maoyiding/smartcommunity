package com.mapper;

import com.domain.City;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by Administrator on 2017/6/28.
 */
@Component
@Mapper
public interface CityMapper {
    /**
     * 查询所有城市
     * @return  所有城市
     */
    List<City> getAllCity(String orderWrold);

    /**
     * 添加城市
     * @return
     */
    boolean addCity(City city);

}
