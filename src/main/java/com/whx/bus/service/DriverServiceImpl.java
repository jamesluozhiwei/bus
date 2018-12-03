package com.whx.bus.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.whx.bus.common.PageInfomation;
import com.whx.bus.entity.Driver;
import com.whx.bus.entity.DriverExample;
import com.whx.bus.mapper.DriverMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 司机业务接口实现类
 */
@Service
@Transactional
public class DriverServiceImpl implements DriverService {

    @Autowired
    private DriverMapper driverMapper;

    @Override
    public Map<String, Object> driverDataTableInfo(PageInfomation pageInfomation, Driver driver) {
        Map<String,Object> map = new HashMap<>();
        DriverExample example = new DriverExample();
        DriverExample.Criteria criteria = example.createCriteria();
        if (driver.getName() != null){
            criteria.andNameLike("%"+driver.getName()+"%");
        }
        if (driver.getAge() != null){
            criteria.andAgeEqualTo(driver.getAge());
        }
        if (driver.getDriverCard() != null){
            criteria.andDriverCardLike("%"+driver.getDriverCard()+"%");
        }
        if (driver.getMobile() != null){
            criteria.andMobileLike("%"+driver.getMobile()+"%");
        }
        if (driver.getSex() != null){
            criteria.andSexEqualTo(driver.getSex());
        }
        if (driver.getState() != null && driver.getState() != 1){
            criteria.andStateEqualTo(driver.getState());
        }
        //执行sql
        List<Driver> drivers = this.driverMapper.selectByExample(example);
        //设置分页
        PageHelper.startPage(Integer.parseInt(pageInfomation.getiDisplayStart())/Integer.parseInt(pageInfomation.getiDisplayLength())+1,
                Integer.parseInt(pageInfomation.getiDisplayLength()));
        PageInfo<Driver> page = new PageInfo<>(drivers);
        map.put("sEcho",pageInfomation.getsEcho());
        map.put("iTotalRecords",page.getTotal());
        map.put("iTotalDisplayRecords",page.getTotal());
        map.put("aaData",page.getList());
        return map;
    }
}
