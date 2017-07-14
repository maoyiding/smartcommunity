package com.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * Created by maoyiding on 17-7-10.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Goods implements Serializable{
    private int goodsId;
    private String goods;
    private String description;
    private float price;
    private int repertory;
    private int status;
    private int categoryId;
}
