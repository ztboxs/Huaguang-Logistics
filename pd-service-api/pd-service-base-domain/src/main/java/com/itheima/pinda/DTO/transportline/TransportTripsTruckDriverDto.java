package com.itheima.pinda.DTO.transportline;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * TransportTripsDto
 */
@Data
public class TransportTripsTruckDriverDto implements Serializable {
    private static final long serialVersionUID = -477835165829525987L;
    /**
     * id
     */
    @ApiModelProperty(value = "主键")
    private String id;
    /**
     * 车辆id
     */
    @ApiModelProperty(value = "车辆id")
    private String truckId;
    /**
     * 车次id
     */
    @ApiModelProperty(value = "车次id")
    private String transportTripsId;
    /**
     * 司机Id
     */
    @ApiModelProperty(value = "司机Id")
    private String userId;
}