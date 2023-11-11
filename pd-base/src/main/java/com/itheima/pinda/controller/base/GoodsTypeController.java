package com.itheima.pinda.controller.base;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.itheima.pinda.DTO.base.GoodsTypeDto;
import com.itheima.pinda.common.utils.Constant;
import com.itheima.pinda.common.utils.PageResponse;
import com.itheima.pinda.common.utils.Result;
import com.itheima.pinda.entity.base.PdGoodsType;
import com.itheima.pinda.entity.truck.PdTruckTypeGoodsType;
import com.itheima.pinda.service.base.IPdGoodsTypeService;
import com.itheima.pinda.service.truck.IPdTruckTypeGoodsTypeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
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
    public GoodsTypeDto saveGoodsType(@Validated @RequestBody GoodsTypeDto dto) {
        PdGoodsType pdGoodsType = new PdGoodsType();
        BeanUtils.copyProperties(dto, pdGoodsType);
        pdGoodsType = goodsTypeService.saveGoodsType(pdGoodsType);
        String goodsTypeId = pdGoodsType.getId();

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

    @ApiOperation(value = "查询所有货物")
    @GetMapping("/all")
    public List<GoodsTypeDto> findAll() {
        List<PdGoodsType> goodsTypeList = goodsTypeService.findAll();
        List<GoodsTypeDto> goodsTypeDtoList = goodsTypeList.stream().map(item -> {
            GoodsTypeDto dto = new GoodsTypeDto();
            BeanUtils.copyProperties(item, dto);
            return dto;
        }).collect(Collectors.toList());

        return goodsTypeDtoList;
    }


    /**
     * 获取分页货物类型数据
     *
     * @param page          页码
     * @param pageSize      页尺寸
     * @param name          货物类型名称
     * @param truckTypeId   车辆类型Id
     * @param truckTypeName 车辆类型名称
     * @return
     */
    @GetMapping("/page")
    @ApiOperation(value = "获取分页货物类型数据")
    public PageResponse<GoodsTypeDto> findByPage(
            @RequestParam(name = "page") Integer page,
            @RequestParam(name = "pageSize") Integer pageSize,
            @RequestParam(name = "name", required = false) String name,
            @RequestParam(name = "truckTypeId", required = false) String truckTypeId,
            @RequestParam(name = "truckTypeName", required = false) String truckTypeName
    ) {
        IPage<PdGoodsType> goodsTypePage = goodsTypeService.findByPage(page, pageSize, name, truckTypeId, truckTypeName);
        List<GoodsTypeDto> goodsTypeDtoList = goodsTypePage.getRecords().stream().map(
                item -> {
                    GoodsTypeDto dto = new GoodsTypeDto();
                    BeanUtils.copyProperties(item, dto);
                    dto.setTruckTypeIds(
                            truckTypeGoodsTypeService.findAll(null, dto.getId()).stream().map(
                                    truckTypeGoodsType -> truckTypeGoodsType.getTruckTypeId()).collect(Collectors.toList()));
                    return dto;
                }
        ).collect(Collectors.toList());
        return PageResponse.<GoodsTypeDto>builder().items(goodsTypeDtoList).counts(goodsTypePage.getTotal()).page(page).pages(goodsTypePage.getPages()).pagesize(pageSize).build();
    }


    /**
     *获取货物类型列表
     * @param ids
     * @return 货物类型列表
     */
    @GetMapping("")
    @ApiOperation(value = "获取货物类型列表")
    public List<GoodsTypeDto> findAll (@RequestParam(name = "ids", required = false) List<String> ids) {
        return goodsTypeService.findAll(ids).stream().map( item -> {
            GoodsTypeDto dto = new GoodsTypeDto();
            BeanUtils.copyProperties(item, dto);
            dto.setTruckTypeIds(truckTypeGoodsTypeService.findAll(null, dto.getId()).stream().map(
                    truckTypeGoodsType -> truckTypeGoodsType.getTruckTypeId()).collect(Collectors.toList()));
            return dto;
        }).collect(Collectors.toList());
    }


    /**
     * 更新货物类型信息
     *
     * @param dto 货物类型信息
     * @return 货物类型信息
     */
    @PutMapping("/{id}")
    @ApiOperation(value = "更新货物类型信息")
    public GoodsTypeDto update(@PathVariable(name = "id") String id, @RequestBody GoodsTypeDto dto) {
        dto.setId(id);
        PdGoodsType pdGoodsType = new PdGoodsType();
        BeanUtils.copyProperties(dto, pdGoodsType);
        goodsTypeService.updateById(pdGoodsType);
        if (dto.getTruckTypeIds() != null) {
            truckTypeGoodsTypeService.delete(null, id);
            truckTypeGoodsTypeService.batchSave(dto.getTruckTypeIds().stream().map(
                    item -> {
                        PdTruckTypeGoodsType truckTypeGoodsType = new PdTruckTypeGoodsType();
                        truckTypeGoodsType.setTruckTypeId(item);
                        truckTypeGoodsType.setGoodsTypeId(id);
                        return truckTypeGoodsType;
                    }
            ).collect(Collectors.toList()));
        }
        return dto;
    }

    /**
     * 删除货物类型
     *
     * @param id 货物类型id
     * @return 返回信息
     */
    @PutMapping("/{id}/disable")
    @ApiOperation(value = "删除货物类型")
    public Result disable(@PathVariable(name = "id") String id) {
        PdGoodsType pdGoodsType = new PdGoodsType();
        pdGoodsType.setId(id);
        pdGoodsType.setStatus(Constant.DATA_DISABLE_STATUS);
        goodsTypeService.updateById(pdGoodsType);
        return Result.ok();
    }
}