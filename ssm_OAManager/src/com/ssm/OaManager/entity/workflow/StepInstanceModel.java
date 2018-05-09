package com.ssm.OaManager.entity.workflow;

import java.util.List;

/**
 * 步骤实例容器类
 * @author Administrator
 *
 */
public class StepInstanceModel {
	private List<StepInstance> stepInstances;

	public StepInstanceModel() {
		super();
	}

	public StepInstanceModel(List<StepInstance> stepInstances) {
		super();
		this.stepInstances = stepInstances;
	}

	public List<StepInstance> getStepInstances() {
		return stepInstances;
	}

	public void setStepInstances(List<StepInstance> stepInstances) {
		this.stepInstances = stepInstances;
	}
	
	
}
