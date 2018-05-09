package com.ssm.OaManager.entity.stationery;

import java.util.Date;

/**
 * 办公用品表
 * @author 梦想
 *
 */
public class Stationery {
	/*
	STATIONERY_ID	Int	否		主键，自增	办公用品ID
	STATIONERY_NAME	Varchar(50)	否			办公用品名称
	STATIONERY_DATE	date	否	当前时间		添加时间
	STATIONERY_MONERY	double	否			单价
	STATITYPE_ID				外键，引用类别ID	办公用品类别
	STATIONERY_descripti	Varchar(50)	是			办公用品描述
	*/
	/**办公用品ID*/
	private Integer stationeryId;

	/**办公用品名称*/
    private String stationeryName;

    /**添加时间*/
    private Date stationeryDate;

    /**单价*/
    private Double stationeryMonery;
    
    /**数量*/
    private Long stationeryAmount;

    /**引用类别ID*/
    private Stationerytype stationerytype;

    /**办公用品描述*/
    private String stationeryDescripti;

	public Integer getStationeryId() {
		return stationeryId;
	}

	public void setStationeryId(Integer stationeryId) {
		this.stationeryId = stationeryId;
	}

	public String getStationeryName() {
		return stationeryName;
	}

	public void setStationeryName(String stationeryName) {
		this.stationeryName = stationeryName;
	}

	public Date getStationeryDate() {
		return stationeryDate;
	}

	public void setStationeryDate(Date stationeryDate) {
		this.stationeryDate = stationeryDate;
	}

	public Double getStationeryMonery() {
		return stationeryMonery;
	}

	public void setStationeryMonery(Double stationeryMonery) {
		this.stationeryMonery = stationeryMonery;
	}

	public Stationerytype getStationerytype() {
		return stationerytype;
	}

	public void setStationerytype(Stationerytype stationerytype) {
		this.stationerytype = stationerytype;
	}

	public String getStationeryDescripti() {
		return stationeryDescripti;
	}

	public void setStationeryDescripti(String stationeryDescripti) {
		this.stationeryDescripti = stationeryDescripti;
	}

	public Long getStationeryAmount() {
		return stationeryAmount;
	}

	public void setStationeryAmount(Long stationeryAmount) {
		this.stationeryAmount = stationeryAmount;
	}

    
}
