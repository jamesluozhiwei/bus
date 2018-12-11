package com.whx.bus.mapper;

import com.whx.bus.entity.Way;
import com.whx.bus.entity.WayStation;
import com.whx.bus.entity.WayStationExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface WayStationMapper {
    int countByExample(WayStationExample example);

    int deleteByExample(WayStationExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(WayStation record);

    int insertSelective(WayStation record);

    List<WayStation> selectByExample(WayStationExample example);

    WayStation selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") WayStation record, @Param("example") WayStationExample example);

    int updateByExample(@Param("record") WayStation record, @Param("example") WayStationExample example);

    int updateByPrimaryKeySelective(WayStation record);

    int updateByPrimaryKey(WayStation record);

    /**
     * 执行批量新增站点路线绑定信息
     * @param way
     * @return
     */
    int insertWayStations(Way way);
}