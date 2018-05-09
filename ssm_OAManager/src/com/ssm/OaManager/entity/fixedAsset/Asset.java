package com.ssm.OaManager.entity.fixedAsset;

import java.util.Date;

import com.ssm.OaManager.entity.User;
import com.ssm.OaManager.entity.hrm.Department;

/**
 * 固定资产实体类
 * @author Administrator
 *
 */
public class Asset {
	
	private String assetNo;//资产编号
	
	private String assetName;//资产名称
	
	private Department	department;//	部门
	
	private AssetType	assetType;//类别
	
	private Double assetMoney;//原价
	
	private Double depreciationYear	;//折旧年限
	
	private Double incompleteRate	;//残值率
	
	private Double monthDepreciation	;//月折旧额
	
	private Integer assetNature	;//资产性质
	
	private Date assetDate	;//增加时间
	
	private Date usingDate	;//启用时间
	
	private User	user	;//保管人
	
	private  FortifyType fortifyType;//	增加类型
	
	private String assetImg;//资产照片
	
	private String assetDescripti;//备注

	public String getAssetNo() {
		return assetNo;
	}

	public void setAssetNo(String assetNo) {
		this.assetNo = assetNo;
	}

	public String getAssetName() {
		return assetName;
	}

	public void setAssetName(String assetName) {
		this.assetName = assetName;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public AssetType getAssetType() {
		return assetType;
	}

	public void setAssetType(AssetType assetType) {
		this.assetType = assetType;
	}

	public Double getAssetMoney() {
		return assetMoney;
	}

	public void setAssetMoney(Double assetMoney) {
		this.assetMoney = assetMoney;
	}

	public Double getDepreciationYear() {
		return depreciationYear;
	}

	public void setDepreciationYear(Double depreciationYear) {
		this.depreciationYear = depreciationYear;
	}

	public Double getIncompleteRate() {
		return incompleteRate;
	}

	public void setIncompleteRate(Double incompleteRate) {
		this.incompleteRate = incompleteRate;
	}

	public Double getMonthDepreciation() {
		return monthDepreciation;
	}

	public void setMonthDepreciation(Double monthDepreciation) {
		this.monthDepreciation = monthDepreciation;
	}


	public Integer getAssetNature() {
		return assetNature;
	}

	public void setAssetNature(Integer assetNature) {
		this.assetNature = assetNature;
	}

	public Date getAssetDate() {
		return assetDate;
	}

	public void setAssetDate(Date assetDate) {
		this.assetDate = assetDate;
	}

	public Date getUsingDate() {
		return usingDate;
	}

	public void setUsingDate(Date usingDate) {
		this.usingDate = usingDate;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public FortifyType getFortifyType() {
		return fortifyType;
	}

	public void setFortifyType(FortifyType fortifyType) {
		this.fortifyType = fortifyType;
	}

	public String getAssetDescripti() {
		return assetDescripti;
	}

	public void setAssetDescripti(String assetDescripti) {
		this.assetDescripti = assetDescripti;
	}

	public String getAssetImg() {
		return assetImg;
	}

	public void setAssetImg(String assetImg) {
		this.assetImg = assetImg;
	}

	

	
}
