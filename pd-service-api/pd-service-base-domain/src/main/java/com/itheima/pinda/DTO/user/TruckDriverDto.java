package com.itheima.pinda.DTO.user;

import java.io.Serializable;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * TruckDriverDto
 */
@Data
public class TruckDriverDto implements Serializable {
    private static final long serialVersionUID = 4960262265247824283L;
    /**
     * id
     */
    @ApiModelProperty(value = "主键")
    private String id;
    /**
     * 用户Id
     */
    @ApiModelProperty(value = "用户Id")
    private String userId;
    /**
     * 所属车队id
     */
    @ApiModelProperty(value = "所属车队id")
    private String fleetId;
    /**
     * 年龄
     */
    @ApiModelProperty(value = "年龄")
    private Integer age;
    /**
     * 照片
     */
    @ApiModelProperty(value = "照片")
    private String picture;
    /**
     * 驾龄
     */
    @ApiModelProperty(value = "驾龄")
    private Integer drivingAge;
}