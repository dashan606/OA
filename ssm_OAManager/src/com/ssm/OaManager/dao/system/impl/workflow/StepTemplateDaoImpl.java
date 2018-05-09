package com.ssm.OaManager.dao.system.impl.workflow;

import org.springframework.stereotype.Repository;

import com.ssm.OaManager.dao.impl.BaseDaoImpl;
import com.ssm.OaManager.dao.system.workflow.StepTemplateDao;
import com.ssm.OaManager.entity.workflow.StepTemplate;

/**
 * 步骤模型的Dao层
 * @author Administrator
 *
 */
@Repository
public class StepTemplateDaoImpl extends BaseDaoImpl<StepTemplate> implements StepTemplateDao {

	public StepTemplateDaoImpl() {
		super.setNs(StepTemplate.class.getName());
	}

	/**
	 * 步骤查询
	 * @param step
	 * @return
	 */
	public StepTemplate findStep(StepTemplate step) {
		return this.getSqlSession().selectOne(StepTemplate.class.getName()+".findStep", step);
	}

	
}
