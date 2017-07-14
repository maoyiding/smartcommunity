package com.mapper;

import com.domain.Appraise;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by maoyiding on 17-7-11.
 */
@Component
@Mapper
public interface AppraiseMapper {

    /**
     * 获取所有评价
     * @return
     */
    List<Appraise> getAll();

    /**
     * 添加评价
     * @return
     */
    boolean addAppraise(Appraise appraise);
}
