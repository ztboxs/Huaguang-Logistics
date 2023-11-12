package com.itheima.pinda.DTO.truck;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * TruckLicenseDto
 */
@Data
public class TruckLicenseDto implements Serializable {
    private static final long serialVersionUID = 15286301913386265L;
    /**
     * id
     */
    @ApiModelProperty(value = "主键")
    private String id;
    /**
     * 车辆id
     */
    @ApiModelProperty(value = "车辆id")
    private String truckId;
    /**
     * 发动机编号
     */
    @ApiModelProperty(value = "发动机编号")
    private String engineNumber;
    /**
     * 注册时间
     */
    @ApiModelProperty(value = "注册时间")
    @JsonFormat(
            pattern = "yyyy-MM-dd"
    )
    private LocalDate registrationDate;
    /**
     * 国家强制报废日期
     */
    @ApiModelProperty(value = "国家强制报废日期")
    @JsonFormat(
            pattern = "yyyy-MM-dd"
    )
    private LocalDate mandatoryScrap;
    /**
     * 检验有效期
     */
    @ApiModelProperty(value = "检验有效期")
    @JsonFormat(
            pattern = "yyyy-MM-dd"
    )
    private LocalDate expirationDate;
    /**
     * 整备质量
     */
    @ApiModelProperty(value = "整备质量")
    private BigDecimal overallQuality;
    /**
     * 核定载质量
     */
    @ApiModelProperty(value = "核定载质量")
    private BigDecimal allowableWeight;
    /**
     * 外廓尺寸
     */
    @ApiModelProperty(value = "外廓尺寸")
    private String outsideDimensions;
    /**
     * 行驶证有效期
     */
    @ApiModelProperty(value = "行驶证有效期")
    @JsonFormat(
            pattern = "yyyy-MM-dd"
    )
    private LocalDate validityPeriod;
    /**
     * 道路运输证号
     */
    @ApiModelProperty(value = "道路运输证号")
    private String transportCertificateNumber;
    /**
     * 图片信息
     */
    @ApiModelProperty(value = "图片信息")
    private String picture;
}