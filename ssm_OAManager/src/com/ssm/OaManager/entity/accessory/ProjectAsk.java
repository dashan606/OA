package com.ssm.OaManager.entity.accessory;

import java.util.Date;

import com.ssm.OaManager.entity.User;

/**
 * 项目资金申请实体类
 * @author Administrator
 *
 */
public class ProjectAsk {

	private Integer projectId;
	private String projectName;
	private String projectContent;
	private Date projectDate;
	private Double projectMoney;
	
	private User user;

	public ProjectAsk() {
	}

	public ProjectAsk(Integer projectId, String projectName,
			String projectContent, Date projectDate, Double projectMoney,
			User user) {
		this.projectId = projectId;
		this.projectName = projectName;
		this.projectContent = projectContent;
		this.projectDate = projectDate;
		this.projectMoney = projectMoney;
		this.user = user;
	}

	public Integer getProjectId() {
		return projectId;
	}

	public void setProjectId(Integer projectId) {
		this.projectId = projectId;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getProjectContent() {
		return projectContent;
	}

	public void setProjectContent(String projectContent) {
		this.projectContent = projectContent;
	}

	public Date getProjectDate() {
		return projectDate;
	}

	public void setProjectDate(Date projectDate) {
		this.projectDate = projectDate;
	}

	public Double getProjectMoney() {
		return projectMoney;
	}

	public void setProjectMoney(Double projectMoney) {
		this.projectMoney = projectMoney;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	
}
