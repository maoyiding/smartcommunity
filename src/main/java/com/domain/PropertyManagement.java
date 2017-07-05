package com.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * 物业公告
 * Created by Administrator on 2017/6/28.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PropertyManagement {
    private int id;
    private String title;
    private Date time;

}
