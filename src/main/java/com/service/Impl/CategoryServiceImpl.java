package com.service.Impl;

import com.domain.Category;
import com.mapper.CategoryMapper;
import com.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by maoyiding on 17-7-10.
 */
@Service
public class CategoryServiceImpl implements CategoryService{

    @Autowired
    public CategoryMapper categoryMapper;

    @Override
    public List<Category> getAll() {
        return this.categoryMapper.getAll();
    }

    @Override
    public boolean addCategory(Category category) {
        return this.categoryMapper.addCategory(category);
    }
}
