package com.whx.bus.service;

import com.whx.bus.entity.Bus;

import java.util.List;

/**
 * 公交业务处理接口
 */
public interface BusService {

    /**
     * 获取所有公交信息
     * @return
     */
    public List<Bus> getBuses();

    /**
     * 保存公交信息
     * @param bus
     * @return
     */
    public int saveBus(Bus bus);

    /**
     * 删除工具信息
     * @param id
     * @return
     */
    public int deleteBus(Integer id);

    /**
     * 通过主键获取公交信息
     * @param id
     * @return
     */
    public Bus getBusById(Integer id);
}
