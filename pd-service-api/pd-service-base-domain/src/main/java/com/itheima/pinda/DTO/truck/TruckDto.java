package com.itheima.pinda.DTO.truck;

import java.io.Serializable;
import java.math.BigDecimal;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * TruckDto
 */
@Data
public class TruckDto implements Serializable {
    private static final long serialVersionUID = 4541866216281387846L;
    /**
     * id
     */
    @ApiModelProperty(value = "主键")
    private String id;
    /**
     * 车辆类型id
     */
    @ApiModelProperty(value = "车辆类型id")
    private String truckTypeId;
    /**
     * 所属车队id
     */
    @ApiModelProperty(value = "所属车队id")
    private String fleetId;
    /**
     * 品牌
     */
    @ApiModelProperty(value = "品牌")
    private String brand;
    /**
     * 车牌号码
     */
    @ApiModelProperty(value = "车牌号码")
    private String licensePlate;
    /**
     * GPS设备id
     */
    @ApiModelProperty(value = "GPS设备id")
    private String deviceGpsId;
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
     * 车辆行驶证信息id
     */
    @ApiModelProperty(value = "车辆行驶证信息id")
    private String truckLicenseId;
    /**
     * 状态 0：禁用 1：正常
     */
    @ApiModelProperty(value = "状态 0：禁用 1：正常")
    private Integer status;
}