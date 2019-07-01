package com.viewscenes.storage.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class Storage implements Serializable {

    private Integer id;
    private String commodityCode;
    private String name;
    private Integer count;
}
