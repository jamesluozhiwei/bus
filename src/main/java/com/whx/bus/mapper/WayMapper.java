package com.whx.bus.mapper;

import com.whx.bus.entity.Station;
import com.whx.bus.entity.Way;
import com.whx.bus.entity.WayExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface WayMapper {
    int countByExample(WayExample example);

    int deleteByExample(WayExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Way record);

    int insertSelective(Way record);

    List<Way> selectByExample(WayExample example);

    Way selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Way record, @Param("example") WayExample example);

    int updateByExample(@Param("record") Way record, @Param("example") WayExample example);

    int updateByPrimaryKeySelective(Way record);

    int updateByPrimaryKey(Way record);

    /**
     * 通过路线获取站点信息
     * @param id
     * @return
     */
    List<Station> selectStationsByWay(Integer id);
}