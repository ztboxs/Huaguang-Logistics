package com.itheima.pinda.service.truck.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.itheima.pinda.common.CustomIdGenerator;
import com.itheima.pinda.entity.truck.PdTruckTypeGoodsType;
import com.itheima.pinda.mapper.truck.PdTruckTypeGoodsTypeMapper;
import com.itheima.pinda.service.truck.IPdTruckTypeGoodsTypeService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 天天进步
 *
 * @Author: ztbox
 * @Date: 2023/11/10/20:14
 * @Description: 车辆类型与货物类型关联实现类
 */
@Service
public class PdTruckTypeGoodsTypeServiceImpl extends ServiceImpl<PdTruckTypeGoodsTypeMapper, PdTruckTypeGoodsType> implements IPdTruckTypeGoodsTypeService {

    @Autowired
    private CustomIdGenerator idGenerator;

    @Override
    public void batchSave(List<PdTruckTypeGoodsType> truckTypeGoodsTypeList) {
        truckTypeGoodsTypeList.forEach(pdTruckTypeGoodsType -> pdTruckTypeGoodsType.setId(idGenerator.nextId(pdTruckTypeGoodsType) + ""));
        saveBatch(truckTypeGoodsTypeList);
    }

    @Override
    public List<PdTruckTypeGoodsType> findAll(String truckTypeId, String goodsTypeId) {

        LambdaQueryWrapper<PdTruckTypeGoodsType> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        if (StringUtils.isNoneEmpty(goodsTypeId)) {
            lambdaQueryWrapper.eq(PdTruckTypeGoodsType::getGoodsTypeId,goodsTypeId);
        }
        if (StringUtils.isNoneEmpty(truckTypeId)) {
            lambdaQueryWrapper.eq(PdTruckTypeGoodsType::getTruckTypeId,truckTypeId);
        }
        return baseMapper.selectList(lambdaQueryWrapper);
    }
}
