package com.yuyun.elevatoradmin.service;

import com.yuyun.elevatoradmin.entity.ElevatorBrand;
import com.yuyun.elevatoradmin.vo.ElevatorChangeInfoVo;
import com.yuyun.elevatoradmin.vo.ElevatorInfoVo;
import com.yuyun.elevatoradmin.vo.ElevatorProjectVo;
import com.yuyun.elevatoradmin.vo.ElevatorRunMileageVo;

import java.util.List;
import java.util.Map;

public interface ElevatorService {

    List<ElevatorInfoVo> getElevators();

    ElevatorChangeInfoVo getElevatorChange(String eleNo);

    Map<String,Object> getElevatorIsOnline();

    List<ElevatorRunMileageVo>getElevatorRunMilege();

    List<ElevatorBrand>getElevatorBrand();

    List<ElevatorProjectVo> getElevatorProject();
}
