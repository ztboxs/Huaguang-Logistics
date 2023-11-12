package com.itheima.pinda.DTO.user;

import java.io.Serializable;
import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * TruckDriverLicenseDto
 */
@Data
public class TruckDriverLicenseDto implements Serializable {
    private static final long serialVersionUID = -4107492549177544243L;
    /**
     * id
     */
    @ApiModelProperty(value = "主键")
    private String id;
    /**
     * 用户id
     */
    @ApiModelProperty(value = "用户id")
    private String userId;

    /**
     * 准驾车型
     */
    @ApiModelProperty(value = "准驾车型")
    private String allowableType;

    /**
     * 初次领证日期
     */
    @ApiModelProperty(value = "初次领证日期")
    @JsonFormat(
            pattern = "yyyy-MM-dd"
    )
    private LocalDate initialCertificateDate;

    /**
     * 有效期限
     */
    @ApiModelProperty(value = "有效期限")
    private String validPeriod;

    /**
     * 驾驶证号
     */
    @ApiModelProperty(value = "驾驶证号")
    private String licenseNumber;

    /**
     * 驾龄
     */
    @ApiModelProperty(value = "驾龄")
    private Integer driverAge;

    /**
     * 驾驶证类型
     */
    @ApiModelProperty(value = "驾驶证类型")
    private String licenseType;

    /**
     * 从业资格证信息
     */
    @ApiModelProperty(value = "从业资格证信息")
    private String qualificationCertificate;

    /**
     * 入场证信息
     */
    @ApiModelProperty(value = "入场证信息")
    private String passCertificate;

    /**
     * 图片
     */
    @ApiModelProperty(value = "图片")
    private String picture;
}