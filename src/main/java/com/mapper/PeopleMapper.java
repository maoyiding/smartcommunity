package com.mapper;


import com.domain.People;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by Administrator on 2017/6/26.
 */
@Component
@Mapper
public interface PeopleMapper {

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
