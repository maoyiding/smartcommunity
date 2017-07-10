package com.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2017/6/27.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class City implements Serializable{
    private int cityId;
    private String orderWrold;
    private String cityName;
    private List<Community> community;
}
