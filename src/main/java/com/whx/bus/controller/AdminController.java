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
            admin.setRole("ADMIN");
            BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
            admin.setPassword(encoder.encode(admin.getPassword()));
            int num = this.adminService.saveAdmin(admin);
            map.put("code",num);
            map.put("admin ",admin);
        }catch (Exception e){
            e.printStackTrace();
            map.put("code",-1);
            map.put("admin ",null);
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

}
