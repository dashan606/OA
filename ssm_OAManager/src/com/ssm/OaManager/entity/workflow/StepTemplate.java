package com.ssm.OaManager.entity.workflow;

/**
 * 步骤模板实体类
 * @author Administrator
 *
 */
public class StepTemplate {

	/*step_id              int not null,
   step_name            varchar(100 ),
   step_form_url        varchar(200),
   step_description     varchar(200),
   step_appoint         varchar(50),*/
	private Integer stepId;
	private String stepName;
	private String stepFormUrl;
	private String description;
	
	private String stepAppoint;

	public StepTemplate() {
		super();
	}
	
	

	public StepTemplate(Integer stepId, String stepName, String stepFormUrl,
			String description, String stepAppoint) {
		super();
		this.stepId = stepId;
		this.stepName = stepName;
		this.stepFormUrl = stepFormUrl;
		this.description = description;
		this.stepAppoint = stepAppoint;
	}

	

	public Integer getStepId() {
		return stepId;
	}

	public void setStepId(Integer stepId) {
		this.stepId = stepId;
	}

	public String getStepName() {
		return stepName;
	}

	public void setStepName(String stepName) {
		this.stepName = stepName;
	}

	public String getStepFormUrl() {
		return stepFormUrl;
	}

	public void setStepFormUrl(String stepFormUrl) {
		this.stepFormUrl = stepFormUrl;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getStepAppoint() {
		return stepAppoint;
	}

	public void setStepAppoint(String stepAppoint) {
		this.stepAppoint = stepAppoint;
	}

	
}
