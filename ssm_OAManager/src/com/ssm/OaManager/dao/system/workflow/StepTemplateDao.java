package com.ssm.OaManager.dao.system.workflow;

import com.ssm.OaManager.dao.BaseDao;
import com.ssm.OaManager.entity.workflow.StepTemplate;

public interface StepTemplateDao extends BaseDao<StepTemplate>{

	/**
	 * 步骤查询
	 * @param step
	 * @return
	 */
	StepTemplate findStep(StepTemplate step);

}
