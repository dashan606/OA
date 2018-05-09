package com.ssm.OaManager.entity.workflow;

import java.util.Date;

import com.ssm.OaManager.entity.User;

/**
 * 任务列表实体类
 * @author Administrator
 *
 */
public class TaskList {

	/*task_id              int not null,
	   step_instance_id     int,
	   task_name            varchar(50),
	   start_date           date,
	   finish_date          date,
	   user_id              int,
	   status               int,
	   flow_instance_id     int,
	*/
	private Integer taskId;
	private StepInstance stepInstance;
	private String taskName;
	private Date startDate;
	private Date finishDate;
	private User user;
	private Integer status;
	private FlowInstance flowInstance;
	
	public TaskList() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TaskList(Integer taskId, StepInstance stepInstance, String taskName,
			Date startDate, Date finishDate, User user, Integer status,
			FlowInstance flowInstance) {
		super();
		this.taskId = taskId;
		this.stepInstance = stepInstance;
		this.taskName = taskName;
		this.startDate = startDate;
		this.finishDate = finishDate;
		this.user = user;
		this.status = status;
		this.flowInstance = flowInstance;
	}

	public Integer getTaskId() {
		return taskId;
	}

	public void setTaskId(Integer taskId) {
		this.taskId = taskId;
	}

	public StepInstance getStepInstance() {
		return stepInstance;
	}

	public void setStepInstance(StepInstance stepInstance) {
		this.stepInstance = stepInstance;
	}

	public String getTaskName() {
		return taskName;
	}

	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getFinishDate() {
		return finishDate;
	}

	public void setFinishDate(Date finishDate) {
		this.finishDate = finishDate;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public FlowInstance getFlowInstance() {
		return flowInstance;
	}

	public void setFlowInstance(FlowInstance flowInstance) {
		this.flowInstance = flowInstance;
	}
	
	
}
