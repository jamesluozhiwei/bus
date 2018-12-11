package com.whx.bus.service;

import com.whx.bus.entity.Admin;
import com.whx.bus.mapper.AdminMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 管理员业务接口实现类
 */
@Service
public class AdminServiceImpl implements AdminService{

    @Autowired
    private AdminMapper adminMapper;

    @Override
    public int saveAdmin(Admin admin) {
        int num = -1;
        if (admin.getId() == null){
            //新增
            num = this.adminMapper.insertSelective(admin);
        }else{
            //更新
            num = this.adminMapper.updateByPrimaryKeySelective(admin);
        }
        return num;
    }

    @Override
    public List<Admin> getAdmins() {
        return this.adminMapper.selectByExample(null);
    }
}
