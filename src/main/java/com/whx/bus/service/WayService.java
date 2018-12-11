package com.whx.bus.service;

import com.whx.bus.entity.Station;
import com.whx.bus.entity.Way;

import java.util.List;

/**
 * 路线业务处理接口
 */
public interface WayService {

    /**
     * 保存站点信息
     * @param station
     * @return
     */
    public int saveStation(Station station);

    /**
     * 获取所有站点信息
     * @return
     */
    public List<Station> getStations();

    /**
     * 通过主键删除站点信息
     * @param id
     * @return
     */
    public int deleteStationById(Integer id);

    /**
     * 获取所有路线信息
     * @return
     */
    public List<Way> getWays();

    /**
     * 通过主键删除路线信息
     * @return
     */
    public int deleteWayById(Integer id);

    /**
     * 通过主键获取路线信息
     * @param id
     * @return
     */
    public Way getWayById(Integer id);

    /**
     * 保存路线信息
     * @param way
     * @return
     */
    public int saveWay(Way way);

    /**
     * 保存路线的站点信息
     * @param way
     * @return
     */
    public int saveWayStations(Way way);

    /**
     * 通过站点名称获取站点信息
     * @param name
     * @return
     */
    public List<Station> getStationsByName(String name);
}
