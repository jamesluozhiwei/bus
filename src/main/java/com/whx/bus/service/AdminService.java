package com.whx.bus.service;

import com.whx.bus.entity.Admin;

import java.util.List;

/**
 * 管理员业务接口
 */
public interface AdminService {

    /**
     * 保存管理员
     * @param admin
     * @return
     */
    public int saveAdmin(Admin admin);

    /**
     * 获取所有管理员信息
     * @return
     */
    public List<Admin> getAdmins();
}
