package com.whx.bus.service;

import com.whx.bus.entity.Admin;

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

}
