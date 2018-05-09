package com.ssm.OaManager.entity;

import java.util.Date;


/**
 * 日程
 * @author Administrator
 *
 */
public class Schedule {
	
	private Integer scheduleId;//编号
	
	private Date scheduleDate;//时间
	
	private String scheduleDesprict;//事件

	private User user;//用户
	
	public Integer getScheduleId() {
		return scheduleId;
	}

	public void setScheduleId(Integer scheduleId) {
		this.scheduleId = scheduleId;
	}


	public Date getScheduleDate() {
		return scheduleDate;
	}

	public void setScheduleDate(Date scheduleDate) {
		this.scheduleDate = scheduleDate;
	}

	public String getScheduleDesprict() {
		return scheduleDesprict;
	}

	public void setScheduleDesprict(String scheduleDesprict) {
		this.scheduleDesprict = scheduleDesprict;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	

}
