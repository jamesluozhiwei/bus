package com.whx.bus.controller;

import com.whx.bus.entity.Bus;
import com.whx.bus.entity.Driver;
import com.whx.bus.entity.Way;
import com.whx.bus.service.BusService;
import com.whx.bus.service.DriverService;
import com.whx.bus.service.WayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 公交控制类
 */
@Controller
@RequestMapping(value = "/admin")
public class BusController {

    @Autowired
    private BusService busService;
    @Autowired
    private WayService wayService;
    @Autowired
    private DriverService driverService;

    /**
     * 获取公交管理页面
     * @return
     */
    @RequestMapping(value = "/bus/list")
    public ModelAndView busList(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("bus_list");
        return modelAndView;
    }

    /**
     * 使用datatable客户端分页获取公交集数据用
     * @return
     */
    @RequestMapping(value="/bus/datatable",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> getBusesByDatatable(){
        Map<String,Object> map = new HashMap<>();
        try {
            List<Bus> buses = this.busService.getBuses();
            map.put("code",1);
            map.put("msg","获取数据成功！");
            map.put("buses",buses);
        }catch (Exception e){
            e.printStackTrace();
            map.put("code",-1);
            map.put("msg","获取数据失败！");
            map.put("ways",null);
        }
        return map;
    }

    /**
     * 删除公交信息
     * @param id
     * @return
     */
    @RequestMapping(value = "/bus/delete",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> deleteBus(Integer id){
        Map<String,Object> map = new HashMap<>();
        try {
            int num = this.busService.deleteBus(id);
            map.put("code",num);
            map.put("msg",num>0?"删除成功！":(num == -1?"当前公交已存在出现记录，不允许删除！":"删除失败！请稍后重试！"));
            map.put("data",null);
        }catch (Exception e){
            e.printStackTrace();
            map.put("code",-1);
            map.put("msg","系统出错，请联系管理员维护！");
            map.put("data",null);
        }
        return map;
    }

    /**
     * 获取编辑公交或新增公交页面
     * @param id
     * @return
     */
    @RequestMapping(value = {"/bus/edit","/bus/edit/{id}"})
    public ModelAndView editBus(@PathVariable(required = false)  Integer id){
        ModelAndView modelAndView = new ModelAndView();
        Bus targetBus = new Bus();
        targetBus.setDriver(new Driver());
        targetBus.setWay(new Way());
        targetBus.getWay().setStations(new ArrayList<>());//这样写是防止thymeleaf获取不到数据无法初始化模板
        modelAndView.addObject("bus",targetBus);
        if (id != null){
            //如果id不为空则是修改，获取相应的信息添加到模型中
            Bus bus = this.busService.getBusById(id);
            modelAndView.addObject("bus",bus);
        }
        //获取公交列表和司机列表
        List<Driver> drivers = this.driverService.getDrivers();
        List<Way> ways = this.wayService.getWays();
        modelAndView.addObject("drivers",drivers);
        modelAndView.addObject("ways",ways);
        modelAndView.setViewName("bus_edit");
        return modelAndView;
    }

    /**
     * 保存公交基本信息
     * @param bus
     * @return
     */
    @RequestMapping(value = "/bus/save",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> saveBus(Bus bus){
        Map<String,Object> map = new HashMap<>();
        try {
            int num = this.busService.saveBus(bus);
            map.put("code",num);
            map.put("msg",num > 0?"保存成功！":"保存失败！请稍后重试");
            map.put("data",bus);
        }catch (Exception e){
            e.printStackTrace();
            map.put("code",-1);
            map.put("msg","error_param");
            map.put("data",null);
        }
        return map;
    }

}
