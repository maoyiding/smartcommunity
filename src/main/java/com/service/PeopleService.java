package com.service;

import com.domain.People;

import java.util.List;

/**
 * Created by Administrator on 2017/6/27.
 */
public interface PeopleService {

    /**
     *  用户注册
     * @param people
     * @return 用户注册
     */
    boolean addCustomer(People people);

    /**
     * 用户修改密码
     * @param people
     * @return 用户修改
     */
    boolean updataPeoplePasswordByPhone(People people);

    /**
     * 根据手机号码查找用户
     * @param people
     * @return 用户信息
     */
    People selectPeopleByPhone(People people);

    /**
     * 查询所有用户
     * @return
     */
    List<People> selectPeople();
}
