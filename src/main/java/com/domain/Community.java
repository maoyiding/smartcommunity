package com.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * Created by Administrator on 2017/6/28.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Community implements Serializable {
    private int communityId;
    private String community;
    private int cityId;
}
