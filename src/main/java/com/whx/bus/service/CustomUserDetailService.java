package com.whx.bus.service;

import com.whx.bus.entity.Admin;
import com.whx.bus.mapper.AdminMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class CustomUserDetailService implements UserDetailsService {
    @Autowired
    AdminMapper adminMapper;                        //管理员mapper代理接口


    //UserDetailService接口方法实现，通过用户名加载用户对象
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        //通过用户名查询管理员信息
        Admin admin = adminMapper.getAdminByName(s);
        if (admin == null){
            //若不存在
            throw new UsernameNotFoundException("用户名不存在");
        }
        //若存在，则返回管理员信息
        return admin;
    }

}
