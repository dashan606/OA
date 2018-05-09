package com.ssm.OaManager.entity.fixedAsset;

import java.util.Date;


/**
 * 增加类别表
 * @author Administrator
 *
 */
public class FortifyType {
	
	private Integer fortifyTypeId;//增加类别ID
	
	private String fortifyTypeName;//增加类别名称
	
	private Date fortifyTypeDate;//添加时间
	
	private String fortifyTypeDescripti	;//增加类别描述

	public Integer getFortifyTypeId() {
		return fortifyTypeId;
	}

	public void setFortifyTypeId(Integer fortifyTypeId) {
		this.fortifyTypeId = fortifyTypeId;
	}

	public String getFortifyTypeName() {
		return fortifyTypeName;
	}

	public void setFortifyTypeName(String fortifyTypeName) {
		this.fortifyTypeName = fortifyTypeName;
	}

	public Date getFortifyTypeDate() {
		return fortifyTypeDate;
	}

	public void setFortifyTypeDate(Date fortifyTypeDate) {
		this.fortifyTypeDate = fortifyTypeDate;
	}

	public String getFortifyTypeDescripti() {
		return fortifyTypeDescripti;
	}

	public void setFortifyTypeDescripti(String fortifyTypeDescripti) {
		this.fortifyTypeDescripti = fortifyTypeDescripti;
	}
	

}
