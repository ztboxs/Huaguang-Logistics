package com.itheima.pinda.DTO.base;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
public class AreaDto implements Serializable {
    private static final long serialVersionUID = -3871917290775139926L;
    /**
     * id
     */
    @ApiModelProperty(value = "主键")
    private String id;
    /**
     * 父级行政
     */
    @ApiModelProperty(value = "父级行政")
    private String parentId;

    /**
     * 行政名称
     */
    @ApiModelProperty(value = "行政名称")
    private String name;
    /**
     * 行政区域编号
     */
    @ApiModelProperty(value = "行政区域编号")
    private String areaCode;
    /**
     * 城市编码
     */
    @ApiModelProperty(value = "城市编码")
    private String cityCode;
    /**
     * 合并名称
     */
    @ApiModelProperty(value = "合并名称")
    private String mergerName;
    /**
     * 简称
     */
    @ApiModelProperty(value = "简称")
    private String shortName;
    /**
     * 邮政编码
     */
    @ApiModelProperty(value = "邮政编码")
    private String zipCode;

    /**
     * 行政区域等级（0: 省级 1:市级 2:县级 3:镇级 4:乡村级）
     */
    @ApiModelProperty(value = "行政区域等级（0: 省级 1:市级 2:县级 3:镇级 4:乡村级）")
    private Integer level;
    /**
     * 经度
     */
    @ApiModelProperty(value = "经度")
    private String lng;
    /**
     * 纬度
     */
    @ApiModelProperty(value = "纬度")
    private String lat;

    /**
     * 拼音
     */
    @ApiModelProperty(value = "拼音")
    private String pinyin;

    /**
     * 首字母
     */
    @ApiModelProperty(value = "首字母")
    private String first;
}
