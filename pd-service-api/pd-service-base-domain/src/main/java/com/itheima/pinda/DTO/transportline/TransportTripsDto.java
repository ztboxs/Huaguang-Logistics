package com.itheima.pinda.DTO.transportline;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * TransportTripsDto
 */
@Data
public class TransportTripsDto implements Serializable {
    private static final long serialVersionUID = -7242590031212408817L;
    /**
     * id
     */
    @ApiModelProperty(value = "主键")
    private String id;
    /**
     * 车次名称
     */
    @ApiModelProperty(value = "车次名称")
    private String name;

    /**
     * 发车时间
     */
    @ApiModelProperty(value = "发车时间")
    private String departureTime;

    /**
     * 所属线路id
     */
    @ApiModelProperty(value = "所属线路id")
    private String transportLineId;

    /**
     * 周期，1为天，2为周，3为月
     */
    @ApiModelProperty(value = "周期，1为天，2为周，3为月")
    private Integer period;

    /**
     * 状态  0：禁用   1：正常
     */
    @ApiModelProperty(value = "状态  0：禁用   1：正常")
    private Integer status;
}