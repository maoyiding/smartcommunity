package com.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * Created by maoyiding on 17-7-4.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Banner implements Serializable{

    private int id;
    private String url;
    
}
