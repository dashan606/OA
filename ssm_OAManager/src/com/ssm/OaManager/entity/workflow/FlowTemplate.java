package com.ssm.OaManager.entity.workflow;

import java.util.Date;

import com.ssm.OaManager.entity.User;

/**
 * 流程定义模板实体类
 * @author Administrator
 *
 */
public class FlowTemplate {

	   /*flow_id              int not null,,
	   flow_name            varchar(50),
	   flow_type_id         varchar(50),
	   user_id              int,
	   create_date          date,
	   modify_user_id       int,
	   modify_date          date,
	   version              int,
	   primary key (flow_id)*/
	private Integer flowId;
	
	private String flowName;
	
	private Date createDate;
	
	private Date modifyDate;
	private Integer version;
	
	//private Integer flowTypeId;
	private FlowType flowType;
	
	//private Integer userId;
	private User user;
	
	//private Integer modifyUserId;;
	private User modifyUser;

	public FlowTemplate() {
		super();
		// TODO Auto-generated constructor stub
	}

	public FlowTemplate(Integer flowId, String flowName, Date createDate,
			Date modifyDate, Integer version, FlowType flowType, User user,
			User modifyUser) {
		super();
		this.flowId = flowId;
		this.flowName = flowName;
		this.createDate = createDate;
		this.modifyDate = modifyDate;
		this.version = version;
		this.flowType = flowType;
		this.user = user;
		this.modifyUser = modifyUser;
	}

	public Integer getFlowId() {
		return flowId;
	}

	public void setFlowId(Integer flowId) {
		this.flowId = flowId;
	}

	public String getFlowName() {
		return flowName;
	}

	public void setFlowName(String flowName) {
		this.flowName = flowName;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getModifyDate() {
		return modifyDate;
	}

	public void setModifyDate(Date modifyDate) {
		this.modifyDate = modifyDate;
	}

	public Integer getVersion() {
		return version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}

	public FlowType getFlowType() {
		return flowType;
	}

	public void setFlowType(FlowType flowType) {
		this.flowType = flowType;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public User getModifyUser() {
		return modifyUser;
	}

	public void setModifyUser(User modifyUser) {
		this.modifyUser = modifyUser;
	}
	
	
	
}
