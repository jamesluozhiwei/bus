package com.whx.bus.controller;

import com.whx.bus.entity.Admin;
import com.whx.bus.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 管理员控制类
 */
@Controller
@RequestMapping(value = "/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    /**
     * 保存管理员
     * @param admin
     * @return
     */
    @RequestMapping(value = "/saveAdmin",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> saveAdmin(Admin admin){
        Map<String,Object> map = new HashMap<>();
        //调用service保存
        try {
            admin.setRole("ROLE_ADMIN");
            BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
            admin.setPassword(encoder.encode(admin.getPassword()));
            int num = this.adminService.saveAdmin(admin);
            map.put("code",num);
            map.put("admin ",admin);
            map.put("msg ",num>1?"保存成功！":"保存失败！");
        }catch (Exception e){
            e.printStackTrace();
            map.put("code",-1);
            map.put("admin ",null);
            map.put("msg ","保存失败!");
        }
        return map;
    }

    /**
     * 获取管理员列表页面
     * @return
     */
    @RequestMapping(value="/adminList")
    public ModelAndView adminList(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("adminList");
        return modelAndView;
    }
    /**
     * 使用datatable客户端分页获取管理员集数据用
     * @return
     */
    @RequestMapping(value="/datatable",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> getAdminsByDatatable(){
        Map<String,Object> map = new HashMap<>();
        try {
            List<Admin> admins = this.adminService.getAdmins();
            map.put("code",1);
            map.put("msg","获取数据成功！");
            map.put("admins",admins);
        }catch (Exception e){
            e.printStackTrace();
            map.put("code",-1);
            map.put("msg","获取数据失败！");
            map.put("admins",null);
        }
        return map;
    }
}
