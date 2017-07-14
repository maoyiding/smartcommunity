package com.service;

import com.domain.Appraise;

import java.util.List;

/**
 * Created by maoyiding on 17-7-11.
 */
public interface AppraiseService {
    /**
     * 获取所有评价
     * @return
     */
    List<Appraise> getAll();

    /**
     * 添加评价
     * @return
     * @param appraise
     */
    boolean addAppraise(Appraise appraise);
}
