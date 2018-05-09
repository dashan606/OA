package com.ssm.OaManager.entity.stationery;

import java.util.Date;

import com.ssm.OaManager.entity.User;

/**
 * 归还表
 * @author 梦想
 *
 */
public class Giveback {

	
	/*GIVEBACK_ID	Int	否		主键，自增	归还ID
	USER_ID	int	否		外键，引用用户ID	申请人
	GIVEBACK_STATUS	int		0未确定，1确定		状态
	STATIONERY_ID	int	否		外键，引用办公用品ID	办公用品
	GIVEBACK_descripti	Varchar(50)	是			归还描述*/
	
	/**归还ID*/
	private Integer givebackId;

	/**引用用户ID*/
    private User user;

    /**状态*/
    private Integer givebackStatus;

    /**引用办公用品ID*/
    private Stationery stationery;

    /**归还描述*/
    private String givebackDescripti;

    /**数量*/
    private Integer givebackAmount;
    
    private User oparateUser;//操作人
    
    private Date oparateDate;//操作时间
    
  	public Date getOparateDate() {
  		return oparateDate;
  	}

  	public void setOparateDate(Date oparateDate) {
  		this.oparateDate = oparateDate;
  	}
  	
	public Integer getGivebackId() {
		return givebackId;
	}

	public void setGivebackId(Integer givebackId) {
		this.givebackId = givebackId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Integer getGivebackStatus() {
		return givebackStatus;
	}

	public void setGivebackStatus(Integer givebackStatus) {
		this.givebackStatus = givebackStatus;
	}

	public Stationery getStationery() {
		return stationery;
	}

	public void setStationery(Stationery stationery) {
		this.stationery = stationery;
	}

	public String getGivebackDescripti() {
		return givebackDescripti;
	}

	public void setGivebackDescripti(String givebackDescripti) {
		this.givebackDescripti = givebackDescripti;
	}

	public User getOparateUser() {
		return oparateUser;
	}

	public void setOparateUser(User oparateUser) {
		this.oparateUser = oparateUser;
	}

	public Integer getGivebackAmount() {
		return givebackAmount;
	}

	public void setGivebackAmount(Integer givebackAmount) {
		this.givebackAmount = givebackAmount;
	}

	
}
