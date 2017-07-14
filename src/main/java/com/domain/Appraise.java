package com.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import sun.plugin2.message.Serializer;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

/**
 * Created by maoyiding on 17-7-11.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Appraise implements Serializable{
    private int appraiseId;
    private String appraise;
    private Timestamp time;
    private String url;
    private int id;


}
