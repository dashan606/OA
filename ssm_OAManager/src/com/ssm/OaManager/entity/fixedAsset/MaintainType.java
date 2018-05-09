package com.ssm.OaManager.entity.fixedAsset;

import java.util.Date;

/**
 * 维护类型表
 * @author Administrator
 *
 */
public class MaintainType {
	
	private Integer maintainTypeId;//维护类别ID
	
	private String maintainTypeName;//维护类别名称
	
	private Date maintainTypeDate	;//添加时间
	
	private String maintainTypeDescripti;//维护类别描述

	public Integer getMaintainTypeId() {
		return maintainTypeId;
	}

	public void setMaintainTypeId(Integer maintainTypeId) {
		this.maintainTypeId = maintainTypeId;
	}

	public String getMaintainTypeName() {
		return maintainTypeName;
	}

	public void setMaintainTypeName(String maintainTypeName) {
		this.maintainTypeName = maintainTypeName;
	}

	public Date getMaintainTypeDate() {
		return maintainTypeDate;
	}

	public void setMaintainTypeDate(Date maintainTypeDate) {
		this.maintainTypeDate = maintainTypeDate;
	}

	public String getMaintainTypeDescripti() {
		return maintainTypeDescripti;
	}

	public void setMaintainTypeDescripti(String maintainTypeDescripti) {
		this.maintainTypeDescripti = maintainTypeDescripti;
	}
	
	
	

}
