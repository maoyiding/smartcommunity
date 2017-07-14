package com.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * Created by maoyiding on 17-7-10.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Category implements Serializable {
    private int categoryId;
    private String category;
    private List<Goods> goods;
}
