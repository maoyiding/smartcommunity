package com.service.Impl;

import com.domain.Appraise;
import com.mapper.AppraiseMapper;
import com.service.AppraiseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by maoyiding on 17-7-11.
 */
@Service
public class AppraiseServiceImpl implements AppraiseService {

    @Autowired
    public AppraiseMapper AppraiseService;


    @Override
    public List<Appraise> getAll() {
        return this.AppraiseService.getAll();
    }

    @Override
    public boolean addAppraise(Appraise appraise) {
        return this.AppraiseService.addAppraise(appraise);
    }
}
