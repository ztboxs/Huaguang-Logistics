package com.itheima.pinda.controller.base;

import com.itheima.pinda.DTO.base.GoodsTypeDto;
import com.itheima.pinda.entity.base.PdGoodsType;
import com.itheima.pinda.entity.truck.PdTruckTypeGoodsType;
import com.itheima.pinda.service.base.IPdGoodsTypeService;
import com.itheima.pinda.service.truck.IPdTruckTypeGoodsTypeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 天天进步
 *
 * @Author: ztbox
 * @Date: 2023/11/10/18:33
 * @Description: 货物类型管理
 */
@RestController
@RequestMapping("base/goodsType")
@Api(tags = "货物类型管理")
public class GoodsTypeController {

    @Autowired
    private IPdGoodsTypeService goodsTypeService;
    @Autowired
    private IPdTruckTypeGoodsTypeService truckTypeGoodsTypeService;

    /**
     * 添加货物类型
     *
     * @param dto 货物类型信息
     * @return 货物类型信息
     */
    @PostMapping("")
    @ApiOperation(value = "添加货物类型")
    public GoodsTypeDto saveGoodsType(@RequestBody GoodsTypeDto dto) {
        PdGoodsType pdGoodsType = new PdGoodsType();
        BeanUtils.copyProperties(dto, pdGoodsType);
        // TODO: 2023/11/10 保存货物类型信息到货物类型表 
        pdGoodsType = goodsTypeService.saveGoodsType(pdGoodsType);
        String goodsTypeId = pdGoodsType.getId();

        // TODO: 2023/11/10 保存货物类型和车俩类型到关联表 
        List<String> truckTypeIds = dto.getTruckTypeIds();
        if (truckTypeIds != null && truckTypeIds.size() > 0) {
            List<PdTruckTypeGoodsType> list = truckTypeIds.stream().map(truckTypeId -> {
                PdTruckTypeGoodsType truckTypeGoodsType = new PdTruckTypeGoodsType();
                truckTypeGoodsType.setGoodsTypeId(goodsTypeId);
                truckTypeGoodsType.setTruckTypeId(truckTypeId);
                return truckTypeGoodsType;
            }).collect(Collectors.toList());
            truckTypeGoodsTypeService.batchSave(list);
        }
        BeanUtils.copyProperties(pdGoodsType, dto);
        return dto;
    }

    @ApiOperation(value = "根据id查询货物")
    @GetMapping("/{id}")
    public GoodsTypeDto fineById(@PathVariable(name = "id") String id) {
        PdGoodsType pdGoodsType = goodsTypeService.getById(id);
        GoodsTypeDto goodsTypeDto = null;
        if (pdGoodsType != null) {
            goodsTypeDto = new GoodsTypeDto();
            BeanUtils.copyProperties(pdGoodsType, goodsTypeDto);
            goodsTypeDto.setTruckTypeIds(truckTypeGoodsTypeService.findAll(null, goodsTypeDto.getId()).stream()
                    .map(truckTypeGoodsType -> truckTypeGoodsType.getTruckTypeId())
                    .collect(Collectors.toList()));
        }
        return goodsTypeDto;
    }

}