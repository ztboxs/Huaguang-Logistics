package com.itheima.pinda.service.base;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.itheima.pinda.entity.base.PdGoodsType;

import java.util.Arrays;
import java.util.List;

/**
 * 天天进步
 *
 * @Author: ztbox
 * @Date: 2023/11/10/19:02
 * @Description: 货物类型
 */
public interface IPdGoodsTypeService extends IService<PdGoodsType> {

    /**
     * 添加货物类型
     *
     * @param pdGoodsType 货物类型信息
     * @return 货物类型信息
     */
    PdGoodsType saveGoodsType(PdGoodsType pdGoodsType);

    /**
     *  查询所有状态为1的货物
     * @return
     */
    List<PdGoodsType> findAll();

    /**
     * 获取分页货物类型数据
     * @param page 页码
     * @param pageSize 页尺寸
     * @return 分页货物数据
     */
    IPage<PdGoodsType> findByPage(Integer page, Integer pageSize, String name, String truckTypeId, String truckTypeName);

    /**
     * 获取货物类型列表
     * @param ids 货物类型id
     * @return 货物类型列表
     */
    List<PdGoodsType> findAll(List<String> ids);
}
