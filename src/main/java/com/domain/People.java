package com.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * Created by Administrator on 2017/6/26.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class People implements Serializable {
    private int id;
    private String phone;
    private String nickname;
    private String autonym;
    private String cityCommunity;
    private String address;
    private String password;
    private int state;//0为toot，1为管理员，2为店长，3为客户
}
