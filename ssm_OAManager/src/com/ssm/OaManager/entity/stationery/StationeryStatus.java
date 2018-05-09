package com.ssm.OaManager.entity.stationery;

import java.util.Date;

import com.ssm.OaManager.entity.User;
/**
 * 办公用品
 * @author Administrator
 *
 */
public class StationeryStatus {
	
	private Integer stationeryStatusId;//主键
	
	private Stationery stationery;//办公用品
	
	private String registerType;//类型
	
	private User proposerName;//申请人
	
	private Integer amount;//数量
	
	private Date oparateDate;//操作时间
	
	private User oparateName;//操作人
	
	private String desprict;//备注
	
	private String additionMassage;//附加信息

	
	public Stationery getStationery() {
		return stationery;
	}

	public void setStationery(Stationery stationery) {
		this.stationery = stationery;
	}

	public String getRegisterType() {
		return registerType;
	}

	public void setRegisterType(String registerType) {
		this.registerType = registerType;
	}

	public User getProposerName() {
		return proposerName;
	}

	public void setProposerName(User proposerName) {
		this.proposerName = proposerName;
	}

	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	public Date getOparateDate() {
		return oparateDate;
	}

	public void setOparateDate(Date oparateDate) {
		this.oparateDate = oparateDate;
	}

	public User getOparateName() {
		return oparateName;
	}

	public void setOparateName(User oparateName) {
		this.oparateName = oparateName;
	}

	public String getDesprict() {
		return desprict;
	}

	public void setDesprict(String desprict) {
		this.desprict = desprict;
	}

	public String getAdditionMassage() {
		return additionMassage;
	}

	public void setAdditionMassage(String additionMassage) {
		this.additionMassage = additionMassage;
	}

	public Integer getStationeryStatusId() {
		return stationeryStatusId;
	}

	public void setStationeryStatusId(Integer stationeryStatusId) {
		this.stationeryStatusId = stationeryStatusId;
	}
	
	

}
