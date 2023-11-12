package com.itheima.pinda.DTO.user;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

@Data
public class CourierScopeDto implements Serializable {
    private static final long serialVersionUID = -7739737650020910495L;
    /**
     * id
     */
    @ApiModelProperty(value = "主键")
    private String id;
    /**
     * 快递员id
     */
    @ApiModelProperty(value = "快递员id")
    private String userId;

    /**
     * 行政区域id
     */
    @ApiModelProperty(value = "行政区域id")
    private String areaId;
    /**
     * 多边形经纬度坐标集合
     */
    @ApiModelProperty(value = "多边形经纬度坐标集合")
    private List<List<Map>> mutiPoints;

}
