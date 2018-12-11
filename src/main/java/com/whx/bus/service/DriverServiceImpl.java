package com.whx.bus.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.whx.bus.common.PageInfomation;
import com.whx.bus.entity.Bus;
import com.whx.bus.entity.BusExample;
import com.whx.bus.entity.Driver;
import com.whx.bus.entity.DriverExample;
import com.whx.bus.mapper.BusMapper;
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
    @Autowired
    private BusMapper busMapper;

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
        if (driver.getSex() != null && !"".equals(driver.getSex())){
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

    @Override
    public int saveDriver(Driver driver) {
        if (driver.getId() == null || driver.getId() < 1){
            //新增
            return this.driverMapper.insertSelective(driver);
        }else{
            //更新
            return this.driverMapper.updateByPrimaryKeySelective(driver);
        }
    }

    @Override
    public Driver getDriverById(Integer id) {
        return this.driverMapper.selectByPrimaryKey(id);
    }

    @Override
    public int deleteDriverById(Integer id) {
        //查询当前司机是否正在任职
        BusExample example = new BusExample();
        BusExample.Criteria criteria = example.createCriteria();
        criteria.andDriveridEqualTo(id);
        List<Bus> buses = this.busMapper.selectByExample(example);
        if (buses.size()>0){
            return -1;
        }
        //若未与公交车绑定，则执行删除
        return this.driverMapper.deleteByPrimaryKey(id);
    }

    @Override
    public List<Driver> getDrivers() {
        return this.driverMapper.selectByExample(null);
    }
}
