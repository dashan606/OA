package com.ssm.OaManager.entity.workflow;

/**
 * 流程类型实体类
 * @author Administrator
 *
 */
public class FlowType {

		/*flow_type_id         int not null,
	   flow_type_name       varchar(50),
	   flowDescription          varchar(200),*/
	private Integer flowTypeId;
	private String flowTypeName;
	private String flowDescription;
	
	public FlowType() {
	}

	public FlowType(Integer flowTypeId, String flowTypeName, String flowDescription) {
		super();
		this.flowTypeId = flowTypeId;
		this.flowTypeName = flowTypeName;
		this.flowDescription = flowDescription;
	}

	public Integer getFlowTypeId() {
		return flowTypeId;
	}

	public void setFlowTypeId(Integer flowTypeId) {
		this.flowTypeId = flowTypeId;
	}

	public String getFlowTypeName() {
		return flowTypeName;
	}

	public void setFlowTypeName(String flowTypeName) {
		this.flowTypeName = flowTypeName;
	}

	public String getflowDescription() {
		return flowDescription;
	}

	public void setflowDescription(String flowDescription) {
		this.flowDescription = flowDescription;
	}
	
	
}
