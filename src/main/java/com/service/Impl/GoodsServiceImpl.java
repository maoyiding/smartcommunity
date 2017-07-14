package com.service.Impl;

import com.domain.Goods;
import com.mapper.GoodsMapper;
import com.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by maoyiding on 17-7-10.
 */
@Service
public class GoodsServiceImpl implements GoodsService{

    @Autowired
    public GoodsMapper goodsMapper;

    @Override
    public List<Goods> getAllByCategoryId(int categoryId) {
        return this.goodsMapper.getAllByCategoryId(categoryId);
    }

    @Override
    public boolean addGoods(Goods goods) {
        return this.goodsMapper.addGoods(goods);
    }

    @Override
    public boolean addRepertory(int goodsId,int repertory) {
        return this.goodsMapper.addRepertory(goodsId,repertory);
    }

    @Override
    public boolean buyRepertory(int goodsId,int repertory) {
        return this.goodsMapper.buyRepertory(goodsId,repertory);
    }
}
