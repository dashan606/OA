package com.ssm.OaManager.entity.stationery;

import java.util.Date;

import com.ssm.OaManager.entity.User;

/**
 * 维护表
 * @author 梦想
 *
 */
public class Maintain {
	
	/*MAINTAIN_ID	Int	否		主键，自增	维护ID
	MAINTAIN_MONERY	Double	否			单价
	STATIONERY_ID	int	否		外键，引用办公用品ID	办公用品
	START_DATE	date	是			维护开始时间
	Ending_DATE	date	是			维护结束时间
	User_id	int	否		外键，引用用户ID	维护人
	maintaini_descripti	Varchar(50)	是			维护描述*/
	
	/**维护ID*/
	private Integer maintainiId;

	/**单价*/
    private Double maintainiMoney;

    /**引用办公用品ID*/
    private Stationery stationery;

    /**维护开始时间*/
    private Date startDate;

    /**维护结束时间*/
    private Date endingDate;

    /**维护描述*/
    private String maintainiDescripti;

    /**引用用户ID*/
    private User user;

	public Integer getMaintainiId() {
		return maintainiId;
	}

	public void setMaintainiId(Integer maintainiId) {
		this.maintainiId = maintainiId;
	}

	public Double getMaintainiMoney() {
		return maintainiMoney;
	}

	public void setMaintainiMoney(Double maintainiMoney) {
		this.maintainiMoney = maintainiMoney;
	}

	public Stationery getStationery() {
		return stationery;
	}

	public void setStationery(Stationery stationery) {
		this.stationery = stationery;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndingDate() {
		return endingDate;
	}

	public void setEndingDate(Date endingDate) {
		this.endingDate = endingDate;
	}

	public String getMaintainiDescripti() {
		return maintainiDescripti;
	}

	public void setMaintainiDescripti(String maintainiDescripti) {
		this.maintainiDescripti = maintainiDescripti;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

   

}
