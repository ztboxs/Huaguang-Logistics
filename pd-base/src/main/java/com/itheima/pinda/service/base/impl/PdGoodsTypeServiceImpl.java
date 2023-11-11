package com.itheima.pinda.service.base.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.metadata.OrderItem;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.itheima.pinda.common.CustomIdGenerator;
import com.itheima.pinda.entity.base.PdGoodsType;
import com.itheima.pinda.mapper.base.PdGoodsTypeMapper;
import com.itheima.pinda.service.base.IPdGoodsTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 天天进步
 *
 * @Author: ztbox
 * @Date: 2023/11/10/20:06
 * @Description: 货物类型实现类
 */
@Service
public class PdGoodsTypeServiceImpl extends ServiceImpl<PdGoodsTypeMapper, PdGoodsType> implements IPdGoodsTypeService {

    @Autowired
    private CustomIdGenerator idGenerator;

    @Override
    public PdGoodsType saveGoodsType(PdGoodsType pdGoodsType) {
        pdGoodsType.setId(idGenerator.nextId(pdGoodsType) + "");
        baseMapper.insert(pdGoodsType);
        return pdGoodsType;
    }

    @Override
    public List<PdGoodsType> findAll() {
        QueryWrapper<PdGoodsType> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("status",1); // 筛选条件 status =1
        return baseMapper.selectList(queryWrapper);
    }

    @Override
    public IPage<PdGoodsType> findByPage(Integer page, Integer pageSize, String name, String truckTypeId, String truckTypeName) {

        Page<PdGoodsType> iPage = new Page(page, pageSize);

        iPage.addOrder(OrderItem.asc("id"));
        iPage.setRecords(baseMapper.findByPage(iPage, name, truckTypeId, truckTypeName));
        return iPage;
    }

    @Override
    public List<PdGoodsType> findAll(List<String> ids) {
        LambdaQueryWrapper<PdGoodsType> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        if (ids != null && ids.size() > 0) {
            lambdaQueryWrapper.in(PdGoodsType::getId, ids);
        }
        return baseMapper.selectList(lambdaQueryWrapper);
    }
}
