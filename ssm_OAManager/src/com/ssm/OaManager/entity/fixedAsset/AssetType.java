package com.ssm.OaManager.entity.fixedAsset;

import java.util.Date;

/**
 * 资产类别实体类
 * @author Administrator
 *
 */
public class AssetType {
	
	private Integer assetTypeId;//资产类别ID
	
	private String assetTypeName;//类别名称
	
	private Date assetTypeDate;//添加时间
	
	private String assetTypeDescripti;//类别描述

	public Integer getAssetTypeId() {
		return assetTypeId;
	}

	public void setAssetTypeId(Integer assetTypeId) {
		this.assetTypeId = assetTypeId;
	}

	public String getAssetTypeName() {
		return assetTypeName;
	}

	public void setAssetTypeName(String assetTypeName) {
		this.assetTypeName = assetTypeName;
	}

	public Date getAssetTypeDate() {
		return assetTypeDate;
	}

	public void setAssetTypeDate(Date assetTypeDate) {
		this.assetTypeDate = assetTypeDate;
	}

	public String getAssetTypeDescripti() {
		return assetTypeDescripti;
	}

	public void setAssetTypeDescripti(String assetTypeDescripti) {
		this.assetTypeDescripti = assetTypeDescripti;
	}
	
	
	

}
