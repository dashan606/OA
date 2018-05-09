package com.ssm.OaManager.service.system.workflow;

import java.util.List;

import com.ssm.OaManager.entity.workflow.StepTemplate;

public interface StepTemplateService {

	/**
	 * 获取所有的步骤
	 * @return
	 */
	List<StepTemplate> findAll();

	/**
	 * 查询步骤
	 * @param step
	 * @return
	 */
	StepTemplate findStep(StepTemplate step);

}
