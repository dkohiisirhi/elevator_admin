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
        ElevatorCode[] values = ElevatorCode.values();
        int elePort = 0;
        for (ElevatorCode value : values) {
            if (value.getEleCode().equals(msg)) {
                elePort = value.getElePort();
            }
        }
        //TODO 待做
        Map elevatorMap = new HashMap();
        String floor = (String) redisTemplate.opsForValue().get(elePort+":floor");
        String isOpen = (String) redisTemplate.opsForValue().get(elePort+":isOpen");
        String direciton = (String) redisTemplate.opsForValue().get(elePort+":direction");
        String openNum = (String) redisTemplate.opsForValue().get(msg+":openNum");
        String runMileage = (String) redisTemplate.opsForValue().get(elePort+":runMileage");
        elevatorMap.put("floor", floor);
        elevatorMap.put("isOpen", isOpen);
        elevatorMap.put("direciton", direciton);
        elevatorMap.put("openNum", openNum);
        elevatorMap.put("runMileage", runMileage == null? 0: runMileage.substring(0,runMileage.indexOf(".")+2));
        return elevatorMap;
    }
}
