package com.itheima.pinda.controller.user;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.itheima.pinda.DTO.user.TruckDriverDto;
import com.itheima.pinda.DTO.user.TruckDriverLicenseDto;
import com.itheima.pinda.common.utils.PageResponse;
import com.itheima.pinda.entity.user.PdTruckDriver;
import com.itheima.pinda.entity.user.PdTruckDriverLicense;
import com.itheima.pinda.service.user.IPdTruckDriverLicenseService;
import com.itheima.pinda.service.user.IPdTruckDriverService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 司机相关
 */
@RestController
@RequestMapping("sys/driver")
@Api(tags = "司机相关")
public class DriverController {
    @Autowired
    private IPdTruckDriverService truckDriverService;
    @Autowired
    private IPdTruckDriverLicenseService truckDriverLicenseService;

    /**
     * 保存司机基本信息
     *
     * @param dto 司机基本信息
     * @return 返回信息
     */
    @PostMapping("")
    @ApiOperation(value = "保存司机基本信息")
    public TruckDriverDto saveDriver(@RequestBody TruckDriverDto dto) {
        PdTruckDriver driver = new PdTruckDriver();
        BeanUtils.copyProperties(dto, driver);
        truckDriverService.saveTruckDriver(driver);
        BeanUtils.copyProperties(driver, dto);
        return dto;
    }

    /**
     * 获取司机基本信息列表
     *
     * @param userIds 司机id列表
     * @return 司机基本信息列表
     */
    @GetMapping("")
    @ApiOperation(value = "获取司机基本信息列表")
    public List<TruckDriverDto> findAllDriver(@RequestParam(name = "userIds", required = false) List<String> userIds, @RequestParam(name = "fleetId", required = false) String fleetId) {
        return truckDriverService.findAll(userIds, fleetId).stream().map(pdTruckDriver -> {
            TruckDriverDto dto = new TruckDriverDto();
            BeanUtils.copyProperties(pdTruckDriver, dto);
            return dto;
        }).collect(Collectors.toList());
    }

    /**
     * 获取司机基本信息
     *
     * @param id 司机id
     * @return 司机基本信息
     */
    @GetMapping("/{id}")
    @ApiOperation(value = "获取司机基本信息")
    public TruckDriverDto findOneDriver(@PathVariable(name = "id") String id) {
        PdTruckDriver pdTruckDriver = truckDriverService.findOne(id);
        TruckDriverDto dto = new TruckDriverDto();
        if (pdTruckDriver != null) {
            BeanUtils.copyProperties(pdTruckDriver, dto);
        }
        return dto;
    }

    /**
     * 保存司机驾驶证信息
     *
     * @param dto 司机驾驶证信息
     * @return 返回信息
     */
    @PostMapping("/driverLicense")
    @ApiOperation(value = "保存司机驾驶证信息")
    public TruckDriverLicenseDto saveDriverLicense(@RequestBody TruckDriverLicenseDto dto) {
        PdTruckDriverLicense driverLicense = new PdTruckDriverLicense();
        BeanUtils.copyProperties(dto, driverLicense);
        truckDriverLicenseService.saveTruckDriverLicense(driverLicense);
        BeanUtils.copyProperties(driverLicense, dto);
        return dto;
    }

    /**
     * 获取司机驾驶证信息
     *
     * @param id 司机id
     * @return 司机驾驶证信息
     */
    @GetMapping("/{id}/driverLicense")
    @ApiOperation(value = "获取司机驾驶证信息")
    public TruckDriverLicenseDto findOneDriverLicense(@PathVariable(name = "id") String id) {
        PdTruckDriverLicense driverLicense = truckDriverLicenseService.findOne(id);
        TruckDriverLicenseDto dto = new TruckDriverLicenseDto();
        if (driverLicense != null) {
            BeanUtils.copyProperties(driverLicense, dto);
        }
        return dto;
    }

    /**
     * 统计司机数量
     *
     * @param fleetId 车队id
     * @return 司机数量
     */
    @GetMapping("/count")
    @ApiOperation(value = "统计司机数量")
    public Integer count(@RequestParam(name = "fleetId", required = false) String fleetId) {
        return truckDriverService.count(fleetId);
    }

    /**
     * 获取司机分页数据
     *
     * @param page     页码
     * @param pageSize 页尺寸
     * @param fleetId  车队id
     * @return 司机分页数据
     */
    @GetMapping("/page")
    @ApiOperation(value = "获取司机分页数据")
    public PageResponse<TruckDriverDto> findByPage(@RequestParam(name = "page") Integer page,
                                                   @RequestParam(name = "pageSize") Integer pageSize,
                                                   @RequestParam(name = "fleetId", required = false) String fleetId) {
        IPage<PdTruckDriver> truckPage = truckDriverService.findByPage(page, pageSize, fleetId);
        List<TruckDriverDto> dtoList = new ArrayList<>();
        truckPage.getRecords().forEach(pdTruckDriver -> {
            TruckDriverDto dto = new TruckDriverDto();
            BeanUtils.copyProperties(pdTruckDriver, dto);
            dtoList.add(dto);
        });
        return PageResponse.<TruckDriverDto>builder().items(dtoList).pagesize(pageSize).page(page).counts(truckPage.getTotal())
                .pages(truckPage.getPages()).build();
    }


    @GetMapping("/findAll")
    @ApiOperation(value = "查询所有司机数据")
    public List<TruckDriverDto> findAll(@RequestParam(name = "ids", required = false) List<String> ids) {
        LambdaQueryWrapper<PdTruckDriver> wrapper = new LambdaQueryWrapper<>();
        wrapper.in(PdTruckDriver::getId, ids);
        return truckDriverService.list(wrapper).stream().map(pdTruckDriver -> {
            TruckDriverDto dto = new TruckDriverDto();
            BeanUtils.copyProperties(pdTruckDriver, dto);
            return dto;
        }).collect(Collectors.toList());
    }

}
