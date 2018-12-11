package com.whx.bus.service;

import com.whx.bus.entity.*;
import com.whx.bus.mapper.BusMapper;
import com.whx.bus.mapper.StationMapper;
import com.whx.bus.mapper.WayMapper;
import com.whx.bus.mapper.WayStationMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 路线业务接口实现类
 */
@Service
public class WayServiceImpl implements WayService {

    @Autowired
    private StationMapper stationMapper;
    @Autowired
    private WayStationMapper wayStationMapper;
    @Autowired
    private WayMapper wayMapper;
    @Autowired
    private BusMapper busMapper;

    @Override
    public int saveStation(Station station) {
        //先查询当前名称是否已被使用
        StationExample example = new StationExample();
        StationExample.Criteria criteria = example.createCriteria();
        criteria.andNameEqualTo(station.getName());
        List<Station> stations = this.stationMapper.selectByExample(example);
        //若名称已被使用、并且id与当前的id不一致则返回名称已被使用
        if (stations.size()>0 && stations.get(0).getId() != station.getId()){
            return -1;
        }
        if (station.getId() == null){
            //新增
            return stationMapper.insertSelective(station);
        }else{
            //更新
            return stationMapper.updateByPrimaryKeySelective(station);
        }
    }

    @Override
    public List<Station> getStations() {
        return this.stationMapper.selectByExample(null);
    }

    @Override
    public int deleteStationById(Integer id) {
        //先判断是否已经在路线中，如果已经在路线中，则提示需先清除路线中的
        WayStationExample example = new WayStationExample();
        WayStationExample.Criteria criteria = example.createCriteria();
        criteria.andStationidEqualTo(id);
        List<WayStation> wayStations = this.wayStationMapper.selectByExample(example);
        if (wayStations.size()>0){
            return -1;//若存在则不允许删除
        }
        //若不存在，则执行删除并返回影响行数
        return this.stationMapper.deleteByPrimaryKey(id);
    }

    @Override
    public List<Way> getWays() {
        return this.wayMapper.selectByExample(null);
    }

    @Override
    public int deleteWayById(Integer id) {
        //先判断当前路线是否已经与公交绑定，若已绑定则不允许删除
        BusExample example = new BusExample();
        BusExample.Criteria criteria = example.createCriteria();
        criteria.andWayidEqualTo(id);
        List<Bus> buses = this.busMapper.selectByExample(example);
        if (buses.size()>0){
            return -1;
        }
        //若没有与公交绑定信息则删除路线
        return this.wayMapper.deleteByPrimaryKey(id);
    }

    @Override
    public Way getWayById(Integer id) {
        return this.wayMapper.selectByPrimaryKey(id);
    }

    @Override
    public int saveWay(Way way) {
        //先查询判断路线名称是否重复
        WayExample example = new WayExample();
        WayExample.Criteria criteria = example.createCriteria();
        criteria.andNameEqualTo(way.getName());
        List<Way> ways = this.wayMapper.selectByExample(example);
        if (ways.size() > 0 && ways.get(0).getId() != way.getId()){
            return -1;
        }
        if(way.getId() == null){
            //新增
            return this.wayMapper.insertSelective(way);
        }else{
            //更新
            return this.wayMapper.updateByPrimaryKeySelective(way);
        }
    }

    @Override
    @Transactional
    public int saveWayStations(Way way) {
        //先删除当前路线的站点信息，在插入新的保存
        WayStationExample example = new WayStationExample();
        WayStationExample.Criteria criteria = example.createCriteria();
        criteria.andWayidEqualTo(way.getId());
        //执行删除
        int delete = this.wayStationMapper.deleteByExample(example);
        //执行批量新增
        int add = this.wayStationMapper.insertWayStations(way);
        return add;
    }

    @Override
    public List<Station> getStationsByName(String name) {
        StationExample example = new StationExample();
        StationExample.Criteria criteria = example.createCriteria();
        criteria.andNameEqualTo(name);
        List<Station> stations = this.stationMapper.selectByExample(example);
        return stations;
    }
}
