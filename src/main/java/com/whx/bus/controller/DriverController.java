package com.whx.bus.controller;

import com.whx.bus.common.PageInfomation;
import com.whx.bus.entity.Driver;
import com.whx.bus.service.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
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

    /**
     * 获取新增或编辑页面
     * @param id
     * @return
     */
    @RequestMapping(value = {"/driver/edit/{id}","/driver/edit"})
    public ModelAndView editDriver(@PathVariable(required = false)  Integer id){
        ModelAndView m = new ModelAndView();
        m.addObject("targetUser",new Driver());
        if (id != null){
            Driver driver = this.driverService.getDriverById(id);
            m.addObject("targetUser",driver);
        }
        m.setViewName("driver_edit");
        return m;
    }

    /**
     * 保存司机信息
     * @param driver
     * @return
     */
    @RequestMapping(value = "/driver/save",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> saveDriver(Driver driver){
        Map<String,Object> map = new HashMap<>();
        try {
            int num = this.driverService.saveDriver(driver);
            map.put("code",num);
            map.put("msg",num > 0?"保存成功！":"保存失败！请稍后重试");
            map.put("data",driver);
        }catch (Exception e){
            e.printStackTrace();
            map.put("code",-1);
            map.put("msg","error_param");
            map.put("data",null);
        }
        return map;
    }

    /**
     * 删除司机（若当前司机与公交绑定了则拒绝删除）
     * @param id
     * @return
     */
    @RequestMapping(value = "/driver/delete",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> deleteDriverById(Integer id){
        Map<String,Object> map = new HashMap<>();
        try {
            int num = this.driverService.deleteDriverById(id);
            map.put("code",num);
            map.put("msg",num>0?"删除成功！":(num == -1?"请先解除当前司机与公交的绑定信息，再删除当前司机信息！":"删除失败！请稍后重试！"));
            map.put("data",null);
        }catch (Exception e){
            e.printStackTrace();
        }
        return map;
    }

}
