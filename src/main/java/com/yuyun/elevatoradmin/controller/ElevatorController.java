package com.yuyun.elevatoradmin.controller;

import com.yuyun.elevatoradmin.entity.ElevatorEntity;
import com.yuyun.elevatoradmin.service.ElevatorService;
import com.yuyun.elevatoradmin.vo.ElevatorInfoVo;
import org.apache.ibatis.annotations.Mapper;
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
}
