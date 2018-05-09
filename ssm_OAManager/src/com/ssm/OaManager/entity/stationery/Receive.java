package com.ssm.OaManager.entity.stationery;

import java.util.Date;

import com.ssm.OaManager.entity.User;

/**
 * 领用表
 * @author 梦想
 *
 */
public class Receive {
	
	/*RECEIVE_ID	Int	否		主键，自增	领用ID
	USER_ID	int	否		外键，引用用户ID	申请人
	STATIONERY_ID	int	否		外键，引用办公用品ID	办公用品
	RECEIVE_STATUS	int		0未批准，1批准		领用状态
	RECEIVE_AMOUNT	int	否			数量
	RECEIVE_descripti	Varchar(50)	是			领用描述
	*/
	/**领用ID*/
	private Integer receiveId;

	/**引用用户ID*/
    private User user;

    /**引用办公用品ID*/
    private Stationery stationery;

    /**领用状态*/
    private Integer receiveStatus;

    /**数量*/
    private Integer receiveAmount;

    /**领用描述*/
    private String receiveDescripti;

    
    private User oparateUser;//操作人
    
    private Date oparateDate;//操作时间
    
  	public Date getOparateDate() {
  		return oparateDate;
  	}

  	public void setOparateDate(Date oparateDate) {
  		this.oparateDate = oparateDate;
  	}
  	
	public Integer getReceiveId() {
		return receiveId;
	}

	public void setReceiveId(Integer receiveId) {
		this.receiveId = receiveId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Stationery getStationery() {
		return stationery;
	}

	public void setStationery(Stationery stationery) {
		this.stationery = stationery;
	}

	public Integer getReceiveStatus() {
		return receiveStatus;
	}

	public void setReceiveStatus(Integer receiveStatus) {
		this.receiveStatus = receiveStatus;
	}

	public Integer getReceiveAmount() {
		return receiveAmount;
	}

	public void setReceiveAmount(Integer receiveAmount) {
		this.receiveAmount = receiveAmount;
	}

	public String getReceiveDescripti() {
		return receiveDescripti;
	}

	public void setReceiveDescripti(String receiveDescripti) {
		this.receiveDescripti = receiveDescripti;
	}

	public User getOparateUser() {
		return oparateUser;
	}

	public void setOparateUser(User oparateUser) {
		this.oparateUser = oparateUser;
	}
    
    
}
