package com.service;

import com.domain.Category;

import java.util.List;

/**
 * Created by maoyiding on 17-7-10.
 */
public interface CategoryService {
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
