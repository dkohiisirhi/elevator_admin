package com.yuyun.elevatoradmin.vo;

import lombok.Data;

import java.util.Date;

@Data
public class ElevatorInfoVo {

    private String eleno;
    private String dname;
    private String model;
    private String brand;
    private String rload;
    private String eleProject;
    private String maintain;
    private Date lasttime;
}
