package com.whx.bus.controller;

import com.whx.bus.common.PageInfomation;
import com.whx.bus.entity.Driver;
import com.whx.bus.service.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

/**
 * 司机控制类
 */
@Controller
@RequestMapping("/admin")
public class DriverController {

    @Autowired
    private DriverService driverService;

    /**
     * 获取司机管理页面
     * @return
     */
    @RequestMapping(value = "/driver/list")
    public ModelAndView driverList(){
        ModelAndView modelAndView  = new ModelAndView();
        modelAndView.setViewName("driver_list");
        return modelAndView;
    }

    /**
     * 通过datatable获取司机列表
     * @param pageInfomation
     * @param driver
     * @return
     */
    @RequestMapping(value="/driver",method = RequestMethod.POST)
    @ResponseBody
    public Map<String  ,Object>  driverDataTableList(PageInfomation pageInfomation, Driver driver){
        Map<String,Object> map = new HashMap<>();
        try {
            map = this.driverService.driverDataTableInfo(pageInfomation,driver);
        }catch (Exception e){
            e.printStackTrace();
            map.put("sEcho",pageInfomation.getsEcho());
            map.put("iTotalRecords",0);
            map.put("iTotalDisplayRecords",0);
            map.put("aaData",null);
        }
        return map;
    }

}
