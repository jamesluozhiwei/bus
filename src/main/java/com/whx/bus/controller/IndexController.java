package com.whx.bus.controller;

import com.whx.bus.entity.Admin;
import com.whx.bus.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

/**
 * indexController
 */
@Controller
public class IndexController {

    @Autowired
    private AdminService adminService;

    @RequestMapping(value = "/index")
    public ModelAndView index(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("json","Hello spring boot");
        modelAndView.setViewName("index");
        return modelAndView;
    }

    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public ModelAndView login(@RequestParam(value = "error",required = false) String error,
                              @RequestParam(value = "logout",required = false) String logout){
        ModelAndView modelAndView = new ModelAndView();
        if (error != null){
            modelAndView.addObject("error","账号或密码错误");
        }
        if (logout != null){
            modelAndView.addObject("logout","您已成功退出系统");
        }
        modelAndView.setViewName("login");
        return modelAndView;
    }

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

    @RequestMapping(value="/admin/adminList")
    public ModelAndView adminList(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("adminList");
        return modelAndView;
    }

}
