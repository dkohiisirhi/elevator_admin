package com.yuyun.elevatoradmin.vo;

import lombok.Data;

@Data
public class ElevatorInfoVo {

    private String eleno;
    private String floor;
    private String isOpen;
    private String direction;
    private String openNum;
    private String floorsStopsDoor;
    private String speed;
    private String runMileage;
}
