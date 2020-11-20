package com.yuyun.elevatoradmin.vo;

import lombok.Data;

@Data
public class ElevatorChangeInfoVo {

    private String eleno;
    private String floor;
    private String isOpen;
    private String direction;
    private String runMileage;
    private String openNum;
}
