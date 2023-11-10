package com.itheima.pinda.entity.base;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;

/**
 * 天天进步
 *
 * @Author: ztbox
 * @Date: 2023/11/10/18:11
 * @Description: PdGoodsType表实体
 */
@Data
@TableName("pd_goods_type")
public class PdGoodsType {

    private static final long serialVersionUID = 1L;
    /**
     * id
     */
    @ApiModelProperty(value = "主键")
    @TableId(value = "id", type = IdType.INPUT)
    private String id;
    /**
     * 货物类型名称
     */
    @ApiModelProperty(value = "货物类型名称")
    private String name;
    /**
     * 默认重量，单位：千克
     */
    @ApiModelProperty(value = "默认重量，单位：千克")
    private BigDecimal defaultWeight;
    /**
     * 默认体积，单位：方
     */
    @ApiModelProperty(value = "默认体积，单位：方")
    private BigDecimal defaultVolume;
    /**
     * 说明
     */
    @ApiModelProperty(value = "说明")
    private String remark;
    /**
     * 状态 0：禁用 1：正常
     */
    @ApiModelProperty(value = "状态 0：禁用 1：正常")
    private Integer status;

}
