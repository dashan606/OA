package com.ssm.OaManager.entity.fixedAsset;

import java.util.Date;

import com.ssm.OaManager.entity.User;

/**
 * 固定资产维护实体类
 * @author Administrator
 *
 */
public class AssetMaintain {
	
	private Integer maintainId;//维护编号
	
	private Asset asset;//	资产
	
	private MaintainType maintainType;//维护类型
	
	private Date maintainDate;//维护时间
	
	private User user;//维护人
	
	private String maintainDescripti;//维护备注

	public Integer getMaintainId() {
		return maintainId;
	}

	public void setMaintainId(Integer maintainId) {
		this.maintainId = maintainId;
	}

	public Asset getAsset() {
		return asset;
	}

	public void setAsset(Asset asset) {
		this.asset = asset;
	}

	public MaintainType getMaintainType() {
		return maintainType;
	}

	public void setMaintainType(MaintainType maintainType) {
		this.maintainType = maintainType;
	}

	public Date getMaintainDate() {
		return maintainDate;
	}

	public void setMaintainDate(Date maintainDate) {
		this.maintainDate = maintainDate;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getMaintainDescripti() {
		return maintainDescripti;
	}

	public void setMaintainDescripti(String maintainDescripti) {
		this.maintainDescripti = maintainDescripti;
	}
	

}
