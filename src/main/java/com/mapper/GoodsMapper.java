package com.mapper;

import com.domain.Goods;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by maoyiding on 17-7-10.
 */
@Component
@Mapper
public interface GoodsMapper {

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
