package com.yuyun.elevatoradmin.service;

import com.yuyun.elevatoradmin.entity.ElevatorEntity;
import com.yuyun.elevatoradmin.vo.ElevatorInfoVo;

import java.util.List;

public interface ElevatorService {
    List<ElevatorInfoVo> getElevators();
}
