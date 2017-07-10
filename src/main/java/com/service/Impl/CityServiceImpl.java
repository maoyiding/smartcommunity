package com.service.Impl;


import com.domain.City;
import com.mapper.CityMapper;
import com.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by maoyiding on 17-7-2.
 */
@Service
public class CityServiceImpl implements CityService {

    @Autowired
    private CityMapper cityMapper;

    @Override
    public List<City> getAllCity(String orderWrold) {
        return this.cityMapper.getAllCity(orderWrold);
    }

    @Override
    public boolean addCity(City city) {
        return this.cityMapper.addCity(city);
    }
}
