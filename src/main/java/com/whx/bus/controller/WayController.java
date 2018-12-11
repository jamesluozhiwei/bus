package com.whx.bus.controller;

import com.whx.bus.entity.Station;
import com.whx.bus.entity.Way;
import com.whx.bus.service.WayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 路线控制类
 */
@Controller
@RequestMapping(value = "/admin")
public class WayController {

    @Autowired
    private WayService wayService;

    /**
     * 获取站点管理页面
     * @return
     */
    @RequestMapping("/station")
    public ModelAndView stationList(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("station_list");
        return modelAndView;
    }

    /**
     * 使用datatable客户端分页获取站点集数据用
     * @return
     */
    @RequestMapping(value="/station/datatable",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> getStationsByDatatable(){
        Map<String,Object> map = new HashMap<>();
        try {
            List<Station> stations = this.wayService.getStations();
            map.put("code",1);
            map.put("msg","获取数据成功！");
            map.put("stations",stations);
        }catch (Exception e){
            e.printStackTrace();
            map.put("code",-1);
            map.put("msg","获取数据失败！");
            map.put("stations",null);
        }
        return map;
    }

    /**
     * 保存站点信息
     * @param station
     * @return
     */
    @RequestMapping(value = "/station/save",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> saveStation(Station station){
        Map<String,Object> map = new HashMap<>();
        try {
            int num = this.wayService.saveStation(station);
            map.put("code",num);
            map.put("msg",num > 0?"保存成功！":(num == -1?"当前站点已存在！":"保存失败！请稍后重试"));
            map.put("data",station);
        }catch (Exception e){
            e.printStackTrace();
            map.put("code",-1);
            map.put("msg","error_param");
            map.put("data",null);
        }
        return map;
    }

    /**
     * 删除站点信息
     * @param id
     * @return
     */
    @RequestMapping(value = "/station/delete",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> deleteStation(Integer id){
        Map<String,Object> map = new HashMap<>();
        try {
            int num = this.wayService.deleteStationById(id);
            map.put("code",num);
            map.put("msg",num>0?"删除成功！":(num == -1?"请先解除当前站点与路线的绑定信息，再删除当前站点信息！":"删除失败！请稍后重试！"));
            map.put("data",null);
        }catch (Exception e){
            e.printStackTrace();
        }
        return map;
    }

    /**
     * 获取路线管理页面
     * @return
     */
    @RequestMapping(value = "/way")
    public ModelAndView wayList(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("way_list");
        return modelAndView;
    }

    /**
     * 使用datatable客户端分页获取路线集数据用
     * @return
     */
    @RequestMapping(value="/way/datatable",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> getWaysByDatatable(){
        Map<String,Object> map = new HashMap<>();
        try {
            List<Way> ways = this.wayService.getWays();
            map.put("code",1);
            map.put("msg","获取数据成功！");
            map.put("ways",ways);
        }catch (Exception e){
            e.printStackTrace();
            map.put("code",-1);
            map.put("msg","获取数据失败！");
            map.put("ways",null);
        }
        return map;
    }

    /**
     * 删除路线信息
     * @param id
     * @return
     */
    @RequestMapping(value = "/way/delete",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> deleteWay(Integer id){
        Map<String,Object> map = new HashMap<>();
        try {
            int num = this.wayService.deleteWayById(id);
            map.put("code",num);
            map.put("msg",num>0?"删除成功！":(num == -1?"请先解除当前路线与公交的绑定信息，再删除当前路线信息！":"删除失败！请稍后重试！"));
            map.put("data",null);
        }catch (Exception e){
            e.printStackTrace();
        }
        return map;
    }

    /**
     * 获取编辑路线或新增路线页面
     * @param id
     * @return
     */
    @RequestMapping(value = {"/way/edit","/way/edit/{id}"})
    public ModelAndView editWay(@PathVariable(required = false)  Integer id){
        ModelAndView modelAndView = new ModelAndView();
        Way targetWay = new Way();
        targetWay.setStations(new ArrayList<>());
        modelAndView.addObject("way",targetWay);
        if (id != null){
            //如果id不为空则是修改，获取相应的信息添加到模型中
            Way way = this.wayService.getWayById(id);
            modelAndView.addObject("way",way);
            modelAndView.addObject("stations",way.getStations());
        }
        modelAndView.setViewName("way_edit");
        return modelAndView;
    }

    /**
     * 保存路线基本信息
     * @param way
     * @return
     */
    @RequestMapping(value = "/way/save/basic",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> saveWayBasic(Way way){
        Map<String,Object> map = new HashMap<>();
        try {
            int num = this.wayService.saveWay(way);
            map.put("code",num);
            map.put("msg",num > 0?"保存成功！":"保存失败！请稍后重试");
            map.put("data",way);
        }catch (Exception e){
            e.printStackTrace();
            map.put("code",-1);
            map.put("msg","error_param");
            map.put("data",null);
        }
        return map;
    }

    /**
     * 保存路线站点信息
     * @param way
     * @return
     */
    @RequestMapping(value = "/way/save/stations",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> saveWayStations(@RequestBody Way way){
        Map<String,Object> map = new HashMap<>();
        try {
            int num = this.wayService.saveWayStations(way);
            map.put("code",num);
            map.put("msg",num > 0?"保存成功！":"保存失败！请稍后重试");
            map.put("data",way);
        }catch (Exception e){
            e.printStackTrace();
            map.put("code",-1);
            map.put("msg","error_param");
            map.put("data",null);
        }
        return map;
    }

    /**
     * 通过站点名称获取站点信息
     * @param name
     * @return
     */
    @RequestMapping(value = "/station/info/name",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> getStationByName(String name){
        Map<String,Object> map = new HashMap<>();
        try {
            List<Station> stations = this.wayService.getStationsByName(name);
            map.put("code",stations.size());
            map.put("msg",stations.size()>0?"获取数据成功！":"获取数据失败！");
            map.put("data",stations.size()>0?stations.get(0):null);
        }catch (Exception e){
            e.printStackTrace();
        }
        return map;
    }

}
