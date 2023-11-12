package com.itheima.pinda.DTO.angency;

import java.io.Serializable;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class FleetDto implements Serializable {
    private static final long serialVersionUID = -2715187322746603548L;
    /**
     * id
     */
    @ApiModelProperty(value = "主键")
    private String id;
    /**
     * 车队名称
     */
    @ApiModelProperty(value = "车队名称")
    private String name;
    /**
     * 车队编号
     */
    @ApiModelProperty(value = "车队编号")
    private String fleetNumber;
    /**
     * 机构id
     */
    @ApiModelProperty(value = "机构id")
    private String agencyId;
    /**
     * 负责人id
     */
    @ApiModelProperty(value = "负责人id")
    private String manager;
    /**
     * 状态 0：禁用 1：正常
     */
    @ApiModelProperty(value = "状态 0：禁用 1：正常")
    private Integer status;
}
