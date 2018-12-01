package com.whx.bus.mapper;

import com.whx.bus.entity.Bus;
import com.whx.bus.entity.BusExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface BusMapper {
    int countByExample(BusExample example);

    int deleteByExample(BusExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Bus record);

    int insertSelective(Bus record);

    List<Bus> selectByExample(BusExample example);

    Bus selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Bus record, @Param("example") BusExample example);

    int updateByExample(@Param("record") Bus record, @Param("example") BusExample example);

    int updateByPrimaryKeySelective(Bus record);

    int updateByPrimaryKey(Bus record);
}