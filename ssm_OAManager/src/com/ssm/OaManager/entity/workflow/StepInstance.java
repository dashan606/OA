package com.ssm.OaManager.entity.workflow;

import java.util.Date;

import com.ssm.OaManager.entity.hrm.Employee;
import com.ssm.OaManager.entity.official.Official;
/**
 * 步骤实例实体类
 * @author Administrator
 *
 */
public class StepInstance {

	/*step_instance_id     int not null,
	   step_id              int,
	   start_date           date,
	   finish_date          date,
	   status               int,
	   emp_id               int,*/
	private Integer stepInstanceId;
	
	private StepTemplate step;
	private FlowInstance flowInstance;
	 
	private Date startDate;
	private Date finishDate;
	private Integer status;
	private Employee emp;
	private Official official;
	private Integer commit;
	
	
	public static final Integer ING = 1;//步骤实例正在运行
	public static final Integer STOP = 2;//步骤实例已停止
	
	public StepInstance() {
	}

	public StepInstance(Integer stepInstanceId, StepTemplate step,
			FlowInstance flowInstance, Date startDate, Date finishDate,
			Integer status, Employee emp) {
		super();
		this.stepInstanceId = stepInstanceId;
		this.step = step;
		this.flowInstance = flowInstance;
		this.startDate = startDate;
		this.finishDate = finishDate;
		this.status = status;
		this.emp = emp;
	}

	
	public Integer getCommit() {
		return commit;
	}

	public void setCommit(Integer commit) {
		this.commit = commit;
	}

	public Integer getStepInstanceId() {
		return stepInstanceId;
	}

	public void setStepInstanceId(Integer stepInstanceId) {
		this.stepInstanceId = stepInstanceId;
	}

	public StepTemplate getStep() {
		return step;
	}

	public void setStep(StepTemplate step) {
		this.step = step;
	}

	public FlowInstance getFlowInstance() {
		return flowInstance;
	}

	public void setFlowInstance(FlowInstance flowInstance) {
		this.flowInstance = flowInstance;
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

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Employee getEmp() {
		return emp;
	}

	public void setEmp(Employee emp) {
		this.emp = emp;
	}

	public Official getOfficial() {
		return official;
	}

	public void setOfficial(Official official) {
		this.official = official;
	}

	
}
