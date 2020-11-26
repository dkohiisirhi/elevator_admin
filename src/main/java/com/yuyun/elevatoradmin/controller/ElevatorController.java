package com.yuyun.elevatoradmin.controller;

import com.yuyun.elevatoradmin.entity.ElevatorBrand;
import com.yuyun.elevatoradmin.service.ElevatorService;
import com.yuyun.elevatoradmin.vo.ElevatorInfoVo;
import com.yuyun.elevatoradmin.vo.ElevatorProjectVo;
import com.yuyun.elevatoradmin.vo.ElevatorRunMileageVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class ElevatorController {
    @Autowired
    ElevatorService elevatorService;

    @RequestMapping("/elevators")
    @ResponseBody
    public Map<String,Object> getElevators(){
        List<ElevatorInfoVo> elevators = elevatorService.getElevators();
        Map<String,Object> map=new HashMap<>();
        map.put("data",elevators);
        return map;
    }
    @RequestMapping("/elevator/isonline")
    @ResponseBody
    public Map<String,Object> getElevatorIsOnline(){
        Map<String, Object> map = elevatorService.getElevatorIsOnline();
        return map;
    }

    /**
     * 获取电梯里程数据
     * @return
     */
    @RequestMapping("/elevator/runMileage")
    @ResponseBody
    public List<ElevatorRunMileageVo> getElevatorRunMileage(){
        List<ElevatorRunMileageVo> list = elevatorService.getElevatorRunMilege();
        return list;
    }
    /**
     * 获取电梯里程数据
     * @return
     */
    @RequestMapping("/elevator/brands")
    @ResponseBody
    public List<ElevatorBrand> getElevatorBrand(){
        List<ElevatorBrand> list = elevatorService.getElevatorBrand();
        return list;
    }

    /**
     * 获取所有楼盘对应的电梯数量
     * @return
     */
    @RequestMapping("/elevator/projects")
    @ResponseBody
    public List<ElevatorProjectVo> getElevatorProject(){
        List<ElevatorProjectVo> list = elevatorService.getElevatorProject();
        return list;
    }

}
