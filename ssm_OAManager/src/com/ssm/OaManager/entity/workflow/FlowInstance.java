package com.ssm.OaManager.entity.workflow;

import java.util.Date;

import com.ssm.OaManager.entity.User;
import com.ssm.OaManager.entity.official.Official;

/**
 * 流程实例实体类
 * @author Administrator
 *
 */
public class FlowInstance {

	/*flow_instance_id     int not null,
	   flow_instance_name   varchar(100),
	   create_user_id       int,
	   create_date          date,
	   finish_date          date,
	   status               int,*/
	private Integer flowInstanceId;
	private String flowInstanceName;
	
	private User createUser;
	private FlowTemplate flow;
	private Official official;
	


	private Date createDate;
	private Date finishDate;
	private Integer status;
	
	public static Integer NEW = 0;
	public static Integer ING = 1;
	public static Integer END = 2;
	
	public FlowInstance() {
		super();
		// TODO Auto-generated constructor stub
	}

	public FlowInstance(Integer flowInstanceId, String flowInstanceName,
			User createUser, FlowTemplate flow, Date createDate,
			Date finishDate, Integer status) {
		super();
		this.flowInstanceId = flowInstanceId;
		this.flowInstanceName = flowInstanceName;
		this.createUser = createUser;
		this.flow = flow;
		this.createDate = createDate;
		this.finishDate = finishDate;
		this.status = status;
	}

	
	public Official getOfficial() {
		return official;
	}

	public void setOfficial(Official official) {
		this.official = official;
	}
	public Integer getFlowInstanceId() {
		return flowInstanceId;
	}

	public void setFlowInstanceId(Integer flowInstanceId) {
		this.flowInstanceId = flowInstanceId;
	}

	public String getFlowInstanceName() {
		return flowInstanceName;
	}

	public void setFlowInstanceName(String flowInstanceName) {
		this.flowInstanceName = flowInstanceName;
	}

	public User getCreateUser() {
		return createUser;
	}

	public void setCreateUser(User createUser) {
		this.createUser = createUser;
	}

	public FlowTemplate getFlow() {
		return flow;
	}

	public void setFlow(FlowTemplate flow) {
		this.flow = flow;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getFinishDate() {
		return finishDate;
	}

	public void setFinishDate(Date finishDate) {
		this.finishDate = finishDate;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	
	
}
