package com.mapper;

import com.domain.Category;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by maoyiding on 17-7-10.
 */

@Component
@Mapper
public interface CategoryMapper {

    /**
     * 获取所有商品类型列表
     * @return
     */
    List<Category> getAll();

    /**
     * 添加商品分类
     * @param category
     * @return
     */
    boolean addCategory(Category category);
}
