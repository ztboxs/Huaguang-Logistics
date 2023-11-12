package com.itheima.pinda.DTO.angency;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

@Data
public class AgencyScopeDto implements Serializable {
    private static final long serialVersionUID = 3515302916861385887L;
    /**
     * id
     */
    @ApiModelProperty(value = "主键")
    private String id;
    /**
     * 机构id
     */
    @ApiModelProperty(value = "机构id")
    private String agencyId;

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
