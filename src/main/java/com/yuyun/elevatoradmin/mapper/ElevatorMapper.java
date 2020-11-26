package com.yuyun.elevatoradmin.mapper;

import com.yuyun.elevatoradmin.entity.ElevatorEntity;
import com.yuyun.elevatoradmin.entity.ElevatorBrand;
import com.yuyun.elevatoradmin.vo.ElevatorProjectVo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface ElevatorMapper {
    List<ElevatorEntity> getElevators();
    List<ElevatorBrand> getElevatorBrand();
    List<ElevatorProjectVo> getElevatorProject();
}
