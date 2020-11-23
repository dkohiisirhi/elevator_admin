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
            elevatorInfoVo.setDname(item.getDname());
            elevatorInfoVo.setModel(item.getModel());
            elevatorInfoVo.setBrand(item.getBrand());
            elevatorInfoVo.setRload(item.getRload());
            elevatorInfoVo.setEleProject(item.getEleProject());
            elevatorInfoVo.setMaintain(item.getMaintain());
            elevatorInfoVo.setLasttime(item.getLasttime());
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
        elevatorChangeInfoVo.setOpenNum((String) data.get("openNum"));
        elevatorChangeInfoVo.setRunMileage((String) data.get("runMileage"));
        return elevatorChangeInfoVo;
    }

    @Override
    public Map<String, Object> getElevatorIsOnline() {
        List<ElevatorEntity> elevators = elevatorDao.getElevators();
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("size",elevators.size());
        int online=0;
        for (ElevatorEntity e :elevators) {
if (e.getElestate().equals("运行"))
    online++;
        }
        map.put("online",online);
        map.put("notonline",elevators.size()-online);
        return map;
    }


    public Map findElevatorData(String msg){
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
