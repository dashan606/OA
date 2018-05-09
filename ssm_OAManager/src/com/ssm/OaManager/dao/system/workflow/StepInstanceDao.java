package com.ssm.OaManager.dao.system.workflow;

import java.util.List;

import com.ssm.OaManager.dao.BaseDao;
import com.ssm.OaManager.entity.hrm.Employee;
import com.ssm.OaManager.entity.official.Official;
import com.ssm.OaManager.entity.workflow.StepInstance;
import com.ssm.OaManager.entity.workflow.StepTemplate;


public interface StepInstanceDao extends BaseDao<StepInstance>{

	/**
	 * 通过公文获取步骤实例
	 * @param official
	 * @return
	 */
	List<StepInstance> findStepInstancesByOfficial(Official official);

	/**
	 *批量插入
	 * @param nowSteps
	 * @return
	 */
	Integer insertBatch(List<StepInstance> stepInstances);

	/**
	 * 根据指派人查询相应的步骤实例
	 * @param emp
	 * @return
	 */
	List<StepInstance> findAll(Employee emp);

	/**
	 * 根据步骤模型查找步骤实例
	 * @param steps
	 * @return
	 */
	List<StepInstance> findByStepTemplates(List<StepTemplate> steps);

	/**
	 * 批量修改
	 * @param byOfficial
	 */
	void updateByStepInstances(List<StepInstance> byOfficial);

	void deleteBatch(List<StepInstance> ss2);

	
}
