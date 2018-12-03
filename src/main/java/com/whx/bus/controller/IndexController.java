package com.whx.bus.controller;

import com.whx.bus.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 * indexController
 */
@Controller
public class IndexController {

    @Autowired
    private AdminService adminService;

    /**
     * 首页
     * @return
     */
    @RequestMapping(value = "/index")
    public ModelAndView index(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("json","Hello spring boot");
        modelAndView.setViewName("index");
        return modelAndView;
    }

    /**
     * 获取登录页面
     * @param error
     * @param logout
     * @return
     */
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



}
