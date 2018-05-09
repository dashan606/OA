package com.ssm.OaManager.entity.stationery;

import java.util.Date;

import com.ssm.OaManager.entity.User;

/**
 * 借用表
 * @author 梦想
 *
 */
public class Borrow {
	
	/*BORROW_ID	Int	否		主键，自增	借用ID
	USER_ID	int	否		外键，引用用户ID	申请人
	STATIONERY_ID	int	否		外键，引用办公用品ID	办公用品
	BORROW_STATUS	int		0未批准，1批准		借用状态
	GIVEBACK_STATUS	int		0未归还，1，归还		归还状态
	BORROW_AMOUNT	int	否			数量
	BORROW_descripti	Varchar(50)	是			借用描述*/
	
	/**借用ID*/
	private Integer borrowId;

	/**申请人*/
    private User user;

    /** 引用办公用品ID*/
    private Stationery  stationery;

    /**借用状态*/
    private Integer borrowStatus;

    /**归还状态*/
    private Integer givebackStatus;

    /**数量*/
    private Integer borrowAmount;

    /**借用描述*/
    private String borrowDescripti;

    private User oparateUser;//操作人
    
    private Date oparateDate;//操作时间
    
	public Date getOparateDate() {
		return oparateDate;
	}

	public void setOparateDate(Date oparateDate) {
		this.oparateDate = oparateDate;
	}

	public Integer getBorrowId() {
		return borrowId;
	}

	public void setBorrowId(Integer borrowId) {
		this.borrowId = borrowId;
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

	public Integer getBorrowStatus() {
		return borrowStatus;
	}

	public void setBorrowStatus(Integer borrowStatus) {
		this.borrowStatus = borrowStatus;
	}

	public Integer getGivebackStatus() {
		return givebackStatus;
	}

	public void setGivebackStatus(Integer givebackStatus) {
		this.givebackStatus = givebackStatus;
	}

	public Integer getBorrowAmount() {
		return borrowAmount;
	}

	public void setBorrowAmount(Integer borrowAmount) {
		this.borrowAmount = borrowAmount;
	}

	public String getBorrowDescripti() {
		return borrowDescripti;
	}

	public void setBorrowDescripti(String borrowDescripti) {
		this.borrowDescripti = borrowDescripti;
	}

	public User getOparateUser() {
		return oparateUser;
	}

	public void setOparateUser(User oparateUser) {
		this.oparateUser = oparateUser;
	}

	
	
}
