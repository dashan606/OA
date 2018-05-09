package com.ssm.OaManager.entity;

import java.util.Date; 
/**
 * 公告信息
 * @author lty
 *
 */
public class Announcement {
	private Integer amId;//id
	private String amTheme;//标题
	private String amConten;//内容
	private Date amDate;//创建时间
	private Integer amState;//状态
	
	private User user;//一对多
	
	
	public Integer getAmId() {
		return amId;
	}
	public void setAmId(Integer amId) {
		this.amId = amId;
	}

	
	
	public Integer getAmState() {
		return amState;
	}
	public void setAmState(Integer amState) {
		this.amState = amState;
	}
	
	public String getAmTheme() {
		return amTheme;
	}
	public void setAmTheme(String amTheme) {
		this.amTheme = amTheme;
	}
	public String getAmConten() {
		return amConten;
	}
	public void setAmConten(String amConten) {
		this.amConten = amConten;
	}
	public Date getAmDate() {
		return amDate;
	}
	public void setAmDate(Date amDate) {
		this.amDate = amDate;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	

}
