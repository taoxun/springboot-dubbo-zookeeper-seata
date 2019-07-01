package com.viewscenes.common.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class StorageDTO implements Serializable {
    private Integer id;
    private String commodityCode;
    private String name;
    private Integer count;
}
