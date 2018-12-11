package com.whx.bus.service;

import com.whx.bus.common.PageInfomation;
import com.whx.bus.entity.Driver;

import java.util.List;
import java.util.Map;

/**
 * 司机业务处理接口
 */
public interface DriverService {

    /**
     * 通过datatable获取司机列表信息
     * @param pageInfomation
     * @param driver
     * @return
     */
    public Map<String,Object> driverDataTableInfo(PageInfomation pageInfomation, Driver driver);

    /**
     * 保存司机
     * @param driver
     * @return
     */
    public int saveDriver(Driver driver);

    /**
     * 通过id获取司机信息
     * @param id
     * @return
     */
    public Driver getDriverById(Integer id);

    /**
     * 通过主键删除司机信息
     * @param id
     * @return
     */
    public int deleteDriverById(Integer id);

    /**
     * 获取所有司机列表
     * @return
     */
    public List<Driver> getDrivers();

}
