package com.ssm.OaManager.entity.stationery;

import java.util.Date;

/**
 * 办公用品类别表
 * @author 梦想
 *
 */
public class Stationerytype {

	/*STATITYPE_ID	Int	否		主键，自增	类别ID
	STATITYPE_NAME	Varchar(50)	否			类别名称
	STATITYPE_DATE	date	否	当前时间		添加时间
	STATILIBRARY_ID				外键，引用库ID	办公用品库
	STATITYPE_descripti	Varchar(50)	是			类别描述
	*/
	/**类别ID*/
	private Integer statitypeId;

	/**类别名称*/
    private String statitypeName;

    /**添加时间*/
    private Date statitypeDate;

    /**引用库ID*/
    private Stationerylibrary stationerylibrary;
    
    /**类别描述*/
    private String statitypeDescripti;

	public Integer getStatitypeId() {
		return statitypeId;
	}

	public void setStatitypeId(Integer statitypeId) {
		this.statitypeId = statitypeId;
	}

	public String getStatitypeName() {
		return statitypeName;
	}

	public void setStatitypeName(String statitypeName) {
		this.statitypeName = statitypeName;
	}

	public Date getStatitypeDate() {
		return statitypeDate;
	}

	public void setStatitypeDate(Date statitypeDate) {
		this.statitypeDate = statitypeDate;
	}

	public Stationerylibrary getStationerylibrary() {
		return stationerylibrary;
	}

	public void setStationerylibrary(Stationerylibrary stationerylibrary) {
		this.stationerylibrary = stationerylibrary;
	}

	public String getStatitypeDescripti() {
		return statitypeDescripti;
	}

	public void setStatitypeDescripti(String statitypeDescripti) {
		this.statitypeDescripti = statitypeDescripti;
	}

    
}
