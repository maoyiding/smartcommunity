package com.service;

import com.domain.City;

import java.util.List;

/**
 * Created by maoyiding on 17-7-2.
 */
public interface CityService {
    /**
     * 查询所有城市
     * @return  所有城市
     */
    List<City> getAllCity(String orderWrold);

    /**
     * 添加城市
     * @return
     */
    boolean addCity();
}
