package com.yuyun.elevatoradmin.entity;

import java.io.Serializable;
import java.util.Date;

public class ElevatorEntity implements Serializable {

	private Integer id;
	private String eleno;
	private String dname;
	private String model;
	private Integer eleType;
	private String brand;
	private String speed;
	private String rload;
	private String identicode;
	private String floorsStopsDoor;
	private String eleAddress;
	private String eleProject;
	private String projectCode;
	private String unitCode;
	private Integer maintainId;
	private String maintain;
	private Integer useCompanyId;
	private String usecompany;
	private Integer propertyId;
	private String property;
	private Integer manufacturerId;
	private String manufacturerName;
	private String badCodes;
	private String warnNames;
	private String warnPhones;
	private Integer badNum;
	private Date lasttime;
	private Date nexttime;
	private Date yearlycheck;
	private String register;
	private String internalnum;
	private Date manufdate;
	private Date usedate;
	private String elestate;
	private String advertisingScreen;

	public ElevatorEntity() {
	}

	public ElevatorEntity(Integer id, String eleno, String dname, String model, Integer eleType, String brand, String speed, String rload, String identicode, String floorsStopsDoor, String eleAddress, String eleProject, String projectCode, String unitCode, Integer maintainId, String maintain, Integer useCompanyId, String usecompany, Integer propertyId, String property, Integer manufacturerId, String manufacturerName, String badCodes, String warnNames, String warnPhones, Integer badNum, Date lasttime, Date nexttime, Date yearlycheck, String register, String internalnum, Date manufdate, Date usedate, String elestate, String advertisingScreen) {
		this.id = id;
		this.eleno = eleno;
		this.dname = dname;
		this.model = model;
		this.eleType = eleType;
		this.brand = brand;
		this.speed = speed;
		this.rload = rload;
		this.identicode = identicode;
		this.floorsStopsDoor = floorsStopsDoor;
		this.eleAddress = eleAddress;
		this.eleProject = eleProject;
		this.projectCode = projectCode;
		this.unitCode = unitCode;
		this.maintainId = maintainId;
		this.maintain = maintain;
		this.useCompanyId = useCompanyId;
		this.usecompany = usecompany;
		this.propertyId = propertyId;
		this.property = property;
		this.manufacturerId = manufacturerId;
		this.manufacturerName = manufacturerName;
		this.badCodes = badCodes;
		this.warnNames = warnNames;
		this.warnPhones = warnPhones;
		this.badNum = badNum;
		this.lasttime = lasttime;
		this.nexttime = nexttime;
		this.yearlycheck = yearlycheck;
		this.register = register;
		this.internalnum = internalnum;
		this.manufdate = manufdate;
		this.usedate = usedate;
		this.elestate = elestate;
		this.advertisingScreen = advertisingScreen;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEleno() {
		return eleno;
	}

	public void setEleno(String eleno) {
		this.eleno = eleno;
	}

	public String getDname() {
		return dname;
	}

	public void setDname(String dname) {
		this.dname = dname;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public Integer getEleType() {
		return eleType;
	}

	public void setEleType(Integer eleType) {
		this.eleType = eleType;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getSpeed() {
		return speed;
	}

	public void setSpeed(String speed) {
		this.speed = speed;
	}

	public String getRload() {
		return rload;
	}

	public void setRload(String rload) {
		this.rload = rload;
	}

	public String getIdenticode() {
		return identicode;
	}

	public void setIdenticode(String identicode) {
		this.identicode = identicode;
	}

	public String getFloorsStopsDoor() {
		return floorsStopsDoor;
	}

	public void setFloorsStopsDoor(String floorsStopsDoor) {
		this.floorsStopsDoor = floorsStopsDoor;
	}

	public String getEleAddress() {
		return eleAddress;
	}

	public void setEleAddress(String eleAddress) {
		this.eleAddress = eleAddress;
	}

	public String getEleProject() {
		return eleProject;
	}

	public void setEleProject(String eleProject) {
		this.eleProject = eleProject;
	}

	public String getProjectCode() {
		return projectCode;
	}

	public void setProjectCode(String projectCode) {
		this.projectCode = projectCode;
	}

	public String getUnitCode() {
		return unitCode;
	}

	public void setUnitCode(String unitCode) {
		this.unitCode = unitCode;
	}

	public Integer getMaintainId() {
		return maintainId;
	}

	public void setMaintainId(Integer maintainId) {
		this.maintainId = maintainId;
	}

	public String getMaintain() {
		return maintain;
	}

	public void setMaintain(String maintain) {
		this.maintain = maintain;
	}

	public Integer getUseCompanyId() {
		return useCompanyId;
	}

	public void setUseCompanyId(Integer useCompanyId) {
		this.useCompanyId = useCompanyId;
	}

	public String getUsecompany() {
		return usecompany;
	}

	public void setUsecompany(String usecompany) {
		this.usecompany = usecompany;
	}

	public Integer getPropertyId() {
		return propertyId;
	}

	public void setPropertyId(Integer propertyId) {
		this.propertyId = propertyId;
	}

	public String getProperty() {
		return property;
	}

	public void setProperty(String property) {
		this.property = property;
	}

	public Integer getManufacturerId() {
		return manufacturerId;
	}

	public void setManufacturerId(Integer manufacturerId) {
		this.manufacturerId = manufacturerId;
	}

	public String getManufacturerName() {
		return manufacturerName;
	}

	public void setManufacturerName(String manufacturerName) {
		this.manufacturerName = manufacturerName;
	}

	public String getBadCodes() {
		return badCodes;
	}

	public void setBadCodes(String badCodes) {
		this.badCodes = badCodes;
	}

	public String getWarnNames() {
		return warnNames;
	}

	public void setWarnNames(String warnNames) {
		this.warnNames = warnNames;
	}

	public String getWarnPhones() {
		return warnPhones;
	}

	public void setWarnPhones(String warnPhones) {
		this.warnPhones = warnPhones;
	}

	public Integer getBadNum() {
		return badNum;
	}

	public void setBadNum(Integer badNum) {
		this.badNum = badNum;
	}

	public Date getLasttime() {
		return lasttime;
	}

	public void setLasttime(Date lasttime) {
		this.lasttime = lasttime;
	}

	public Date getNexttime() {
		return nexttime;
	}

	public void setNexttime(Date nexttime) {
		this.nexttime = nexttime;
	}

	public Date getYearlycheck() {
		return yearlycheck;
	}

	public void setYearlycheck(Date yearlycheck) {
		this.yearlycheck = yearlycheck;
	}

	public String getRegister() {
		return register;
	}

	public void setRegister(String register) {
		this.register = register;
	}

	public String getInternalnum() {
		return internalnum;
	}

	public void setInternalnum(String internalnum) {
		this.internalnum = internalnum;
	}

	public Date getManufdate() {
		return manufdate;
	}

	public void setManufdate(Date manufdate) {
		this.manufdate = manufdate;
	}

	public Date getUsedate() {
		return usedate;
	}

	public void setUsedate(Date usedate) {
		this.usedate = usedate;
	}

	public String getElestate() {
		return elestate;
	}

	public void setElestate(String elestate) {
		this.elestate = elestate;
	}

	public String getAdvertisingScreen() {
		return advertisingScreen;
	}

	public void setAdvertisingScreen(String advertisingScreen) {
		this.advertisingScreen = advertisingScreen;
	}

	@Override
	public String toString() {
		return "ElevatorEntity{" +
				"id=" + id +
				", eleno='" + eleno + '\'' +
				", dname='" + dname + '\'' +
				", model='" + model + '\'' +
				", eleType=" + eleType +
				", brand='" + brand + '\'' +
				", speed='" + speed + '\'' +
				", rload='" + rload + '\'' +
				", identicode='" + identicode + '\'' +
				", floorsStopsDoor='" + floorsStopsDoor + '\'' +
				", eleAddress='" + eleAddress + '\'' +
				", eleProject='" + eleProject + '\'' +
				", projectCode='" + projectCode + '\'' +
				", unitCode='" + unitCode + '\'' +
				", maintainId=" + maintainId +
				", maintain='" + maintain + '\'' +
				", useCompanyId=" + useCompanyId +
				", usecompany='" + usecompany + '\'' +
				", propertyId=" + propertyId +
				", property='" + property + '\'' +
				", manufacturerId=" + manufacturerId +
				", manufacturerName='" + manufacturerName + '\'' +
				", badCodes='" + badCodes + '\'' +
				", warnNames='" + warnNames + '\'' +
				", warnPhones='" + warnPhones + '\'' +
				", badNum=" + badNum +
				", lasttime=" + lasttime +
				", nexttime=" + nexttime +
				", yearlycheck=" + yearlycheck +
				", register='" + register + '\'' +
				", internalnum='" + internalnum + '\'' +
				", manufdate=" + manufdate +
				", usedate=" + usedate +
				", elestate='" + elestate + '\'' +
				", advertisingScreen='" + advertisingScreen + '\'' +
				'}';
	}
}
