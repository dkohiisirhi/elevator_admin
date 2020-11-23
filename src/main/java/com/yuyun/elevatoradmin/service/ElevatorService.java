package com.yuyun.elevatoradmin.service;

import com.yuyun.elevatoradmin.vo.ElevatorChangeInfoVo;
import com.yuyun.elevatoradmin.vo.ElevatorInfoVo;

import java.util.List;
import java.util.Map;

public interface ElevatorService {
    List<ElevatorInfoVo> getElevators();
    ElevatorChangeInfoVo getElevatorChange(String eleNo);
    Map<String,Object> getElevatorIsOnline();
}
