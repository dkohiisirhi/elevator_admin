package com.yuyun.elevatoradmin.enums;

public enum ElevatorCode {

    _004611("004611",5000),
    _004620("004620",2000),
    _004612("004612",2005),
    _004613("004613",2006),
    _004614("004614",2007),
    _004615("004615",2008),
    _004616("004616",2009),
    _004617("004617",2010),
    _004618("004618",2011),
    _004619("004619",2012),
    _GD00000010("GD00000010",1014),
    _GD00000011("GD00000011",1015),
    _GD00000014("GD00000014",1021),
    _GD00000015("GD00000015",1022),
    _GD00000016("GD00000016",1023),
    _GD00000017("GD00000017",1024),
    _JS00000001("JS00000001",3000),
    _ZJ00000001("ZJ00000001",5001),
    _FJ00000001("FJ00000001",4001),
    _sh00000001("sh00000001",4001)
    ;

    private String eleCode;
    private Integer elePort;

    ElevatorCode(String eleCode, Integer elePort) {
        this.eleCode = eleCode;
        this.elePort = elePort;
    }

    public String getEleCode() {
        return eleCode;
    }

    public Integer getElePort() {
        return elePort;
    }
}
