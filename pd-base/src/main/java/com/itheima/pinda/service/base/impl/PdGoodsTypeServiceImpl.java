package com.itheima.pinda.service.base.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.itheima.pinda.common.CustomIdGenerator;
import com.itheima.pinda.entity.base.PdGoodsType;
import com.itheima.pinda.mapper.base.PdGoodsTypeMapper;
import com.itheima.pinda.service.base.IPdGoodsTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
