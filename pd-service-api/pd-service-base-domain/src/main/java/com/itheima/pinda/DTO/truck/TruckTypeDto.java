package com.itheima.pinda.DTO.truck;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * TruckTypeDto
 */
@Data
public class TruckTypeDto implements Serializable {
    private static final long serialVersionUID = -2762539095338170845L;
    /**
     * id
     */
    @ApiModelProperty(value = "主键")
    private String id;
    /**
     * 车辆类型名称
     */
    @ApiModelProperty(value = "车辆类型名称")
    private String name;
    /**
     * 准载重量
     */
    @ApiModelProperty(value = "准载重量")
    private BigDecimal allowableLoad;
    /**
     * 准载体积
     */
    @ApiModelProperty(value = "准载体积")
    private BigDecimal allowableVolume;
    /**
     * 长
     */
    @ApiModelProperty(value = "长")
    private BigDecimal measureLong;
    /**
     * 宽
     */
    @ApiModelProperty(value = "宽")
    private BigDecimal measureWidth;
    /**
     * 高
     */
    @ApiModelProperty(value = "高")
    private BigDecimal measureHigh;
    /**
     * 货物类型id列表
     */
    @ApiModelProperty(value = "货物类型id列表")
    private List<String> goodsTypeIds;
}