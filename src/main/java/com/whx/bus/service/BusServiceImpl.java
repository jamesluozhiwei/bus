package com.whx.bus.service;

import com.whx.bus.entity.Bus;
import com.whx.bus.entity.BusExample;
import com.whx.bus.mapper.BusMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 公交业务处理接口实现类
 */
@Service
public class BusServiceImpl implements BusService {

    @Autowired
    private BusMapper busMapper;

    @Override
    public List<Bus> getBuses() {
        return busMapper.selectByExample(null);
    }

    @Override
    public int saveBus(Bus bus) {
        //先判断车牌号是否重复
        BusExample example = new BusExample();
        BusExample.Criteria criteria = example.createCriteria();
        criteria.andCardEqualTo(bus.getCard());
        List<Bus> buses = this.busMapper.selectByExample(example);
        if (buses.size() > 0 && buses.get(0).getId() != bus.getId()){
            return -1;
        }
        //若不是车牌号重复，
        if (bus.getId() == null){
            //新增
            return this.busMapper.insertSelective(bus);
        }else{
            //更新
            return this.busMapper.updateByPrimaryKeySelective(bus);
        }
    }

    @Override
    public int deleteBus(Integer id) {
        //删除当前公交信息
        return this.busMapper.deleteByPrimaryKey(id);
    }

    @Override
    public Bus getBusById(Integer id) {
        return this.busMapper.selectByPrimaryKey(id);
    }
}
