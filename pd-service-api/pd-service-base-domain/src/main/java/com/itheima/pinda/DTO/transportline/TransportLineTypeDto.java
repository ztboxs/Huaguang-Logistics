package com.itheima.pinda.DTO.transportline;

import java.io.Serializable;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * TransportLineType
 */
@Data
public class TransportLineTypeDto implements Serializable {
    private static final long serialVersionUID = -7006861734336133221L;
    /**
     * id
     */
    @ApiModelProperty(value = "主键")
    private String id;
    /**
     * 线路类型名称
     */
    @ApiModelProperty(value = "线路类型名称")
    private String name;
    /**
     * 线路类型编码
     */
    @ApiModelProperty(value = "线路类型编码")
    private String typeNumber;
    /**
     * 起始地机构类型
     */
    @ApiModelProperty(value = "起始地机构类型")
    private Integer startAgencyType;
    /**
     * 目的地机构类型
     */
    @ApiModelProperty(value = "目的地机构类型")
    private Integer endAgencyType;
    /**
     * 最后更新时间
     */
    @ApiModelProperty(value = "最后更新时间")
    @JsonFormat(
            pattern = "yyyy-MM-dd HH:mm:ss"
    )
    private LocalDateTime lastUpdateTime;
    /**
     * 最后更新人id
     */
    @ApiModelProperty(value = "最后更新人id")
    private String updater;
    /**
     * 状态 0：禁用 1：正常
     */
    @ApiModelProperty(value = "状态 0：禁用 1：正常")
    private Integer status;
}