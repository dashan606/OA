package com.ssm.OaManager.entity.stationery;

import java.util.Date;

import com.ssm.OaManager.entity.User;

/**
 * 采购入库表
 * @author 梦想
 *
 */
public class Purchase {
	
	/*PURCHASE_ID	Int	否		主键，自增	采购入库ID
	PURCHASE_MONEY	Double	否			单价
	STATIONERY_ID	int	否		外键，引用办公用品ID	办公用品
	STATIONERY_AMOUNT	int	否			数量
	STATIONERY_DATE	date	否			入库时间
	User_ID	int	否		外键，引用用户ID	采购人
	STATIONERY_descripti	Varchar(50)	是			采购入库描述*/
	
	/**采购入库ID*/
	private Integer purchaseId;
	
    /**引用办公用品ID*/
    private Stationery stationery;

    /**数量*/
    private Integer stationeryAmount;

    /**入库时间*/
    private Date stationeryDate;

    /**引用用户ID*/
    private User user;

    /**采购入库描述*/
    private String stationeryDescripti;

	public Integer getPurchaseId() {
		return purchaseId;
	}

	public void setPurchaseId(Integer purchaseId) {
		this.purchaseId = purchaseId;
	}


	public Stationery getStationery() {
		return stationery;
	}

	public void setStationery(Stationery stationery) {
		this.stationery = stationery;
	}

	public Integer getStationeryAmount() {
		return stationeryAmount;
	}

	public void setStationeryAmount(Integer stationeryAmount) {
		this.stationeryAmount = stationeryAmount;
	}

	public Date getStationeryDate() {
		return stationeryDate;
	}

	public void setStationeryDate(Date stationeryDate) {
		this.stationeryDate = stationeryDate;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getStationeryDescripti() {
		return stationeryDescripti;
	}

	public void setStationeryDescripti(String stationeryDescripti) {
		this.stationeryDescripti = stationeryDescripti;
	}

    
}
