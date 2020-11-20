package com.yuyun.elevatoradmin.service.impl;

import com.yuyun.elevatoradmin.dao.ElevatorDao;
import com.yuyun.elevatoradmin.entity.ElevatorEntity;
import com.yuyun.elevatoradmin.enums.ElevatorCode;
import com.yuyun.elevatoradmin.service.ElevatorService;
import com.yuyun.elevatoradmin.vo.ElevatorChangeInfoVo;
import com.yuyun.elevatoradmin.vo.ElevatorInfoVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;


import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class ElevatorServiceImpl implements ElevatorService {

    @Autowired
    ElevatorDao elevatorDao;

    @Autowired
    private RedisTemplate redisTemplate;

    @Override
    public  List<ElevatorInfoVo> getElevators() {
        List<ElevatorEntity> elevators = elevatorDao.getElevators();
        List<ElevatorInfoVo> collect = elevators.stream().map(item -> {
            ElevatorInfoVo elevatorInfoVo = new ElevatorInfoVo();
            elevatorInfoVo.setEleno(item.getEleno());
            elevatorInfoVo.setSpeed(item.getSpeed());
            elevatorInfoVo.setFloorsStopsDoor(item.getFloorsStopsDoor());
            Map<String,Object> elevatorData = findElevatorData(item.getEleno());
            elevatorInfoVo.setDirection((String) elevatorData.get("direction"));
            elevatorInfoVo.setIsOpen((String) elevatorData.get("isOpen"));
            elevatorInfoVo.setFloor((String) elevatorData.get("floor"));
            elevatorInfoVo.setOpenNum((String) elevatorData.get("openNum"));
            elevatorInfoVo.setRunMileage(elevatorData.get("runMileage")+"");
            return elevatorInfoVo;
        }).collect(Collectors.toList());
        return  collect;
    }

<<<<<<< HEAD
    public Map<String,Object>  findElevatorData(String msg) {
=======
    @Override
    public ElevatorChangeInfoVo getElevatorChange(String eleNo){
        Map data = findElevatorData(eleNo);
        ElevatorChangeInfoVo elevatorChangeInfoVo = new ElevatorChangeInfoVo();
        elevatorChangeInfoVo.setEleno(eleNo);
        elevatorChangeInfoVo.setFloor((String) data.get("floor"));
        elevatorChangeInfoVo.setDirection((String) data.get("direction"));
        elevatorChangeInfoVo.setIsOpen((String) data.get("isOpen"));
        elevatorChangeInfoVo.setRunMileage((String) data.get("runMileage"));
        return elevatorChangeInfoVo;
    }

    public Map findElevatorData(String msg) {
>>>>>>> 518c37a031d34b92f1c167774586b14635b1dac3
        ElevatorCode[] values = ElevatorCode.values();
        int elePort = 0;
        for (ElevatorCode value : values) {
            if (value.getEleCode().equals(msg)) {
                elePort = value.getElePort();
            }
        }
        //TODO 待做
        Map<String,Object> elevatorMap = new HashMap<String,Object>();
        String floor = (String) redisTemplate.opsForValue().get(elePort+":floor");
        String isOpen = (String) redisTemplate.opsForValue().get(elePort+":isOpen");
        String direction = (String) redisTemplate.opsForValue().get(elePort+":direction");
        Integer openNum = (Integer) redisTemplate.opsForValue().get(elePort+":openNum");
        String runMileage = redisTemplate.opsForValue().get(msg+":runMileage")+"";
        elevatorMap.put("floor", floor == null?"已离线":floor);
        elevatorMap.put("isOpen", "1".equals(isOpen)?"开门":"关门");
        elevatorMap.put("direction","1".equals(direction)?"上行":("-1".equals(direction)?"下行":"平层"));
        elevatorMap.put("openNum", openNum+"");
        elevatorMap.put("runMileage", runMileage == null? "0": runMileage.substring(0,runMileage.indexOf(".")+2));
        return elevatorMap;
    }
}
