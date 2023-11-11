package com.itheima.pinda.service.truck;

import com.baomidou.mybatisplus.extension.service.IService;
import com.itheima.pinda.entity.truck.PdTruckTypeGoodsType;

import java.util.List;

/**
 * 天天进步
 *
 * @Author: ztbox
 * @Date: 2023/11/10/19:03
 * @Description: 车辆类型与货物类型关联
 */
public interface IPdTruckTypeGoodsTypeService  extends IService<PdTruckTypeGoodsType> {

    /**
     * 批量保存
     * @param pdTruckTypeGoodsTypes
     */
     void batchSave(List<PdTruckTypeGoodsType> pdTruckTypeGoodsTypes);

    /**
     * 获取车辆类型与货物类型关联
     * @param truckTypeId 车辆类型id
     * @param goodsTypeId 货物类型id
     * @return 车辆类型与货物类型关联
     */
    List<PdTruckTypeGoodsType> findAll(String truckTypeId, String goodsTypeId);

    /**
     * 删除关联关系
     *
     * @param truckTypeId 车辆类型id
     * @param goodsTypeId 货物类型id
     */
    void delete(String truckTypeId, String goodsTypeId);
}
