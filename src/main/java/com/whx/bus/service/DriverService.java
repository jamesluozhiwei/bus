package com.whx.bus.service;

import com.whx.bus.common.PageInfomation;
import com.whx.bus.entity.Driver;

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

}
