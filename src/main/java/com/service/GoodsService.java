package com.service;

import com.domain.Goods;

import java.util.List;

/**
 * Created by maoyiding on 17-7-10.
 */
public interface GoodsService {
    /**
     * 根据categoryId获取商品列表
     * @param categoryId
     * @return
     */
    List<Goods> getAllByCategoryId(int categoryId);

    /**
     * 添加商品
     * @param goods
     * @return
     */
    boolean addGoods(Goods goods);

    /**
     * 增加库存
     * @param repertory
     * @return
     */
    boolean addRepertory(int goodsId,int repertory);

    /**
     * 商品购买减库存
     * @param repertory
     * @return
     */
    boolean buyRepertory(int goodsId,int repertory);
}
