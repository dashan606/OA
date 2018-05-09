package com.ssm.OaManager.service.system.workflow;

import java.util.List;

import com.ssm.OaManager.entity.hrm.Employee;
import com.ssm.OaManager.entity.official.Official;
import com.ssm.OaManager.entity.workflow.StepInstance;
import com.ssm.OaManager.entity.workflow.StepTemplate;

public interface StepInstanceService {

	/**
	 * 通过公文查询步骤实例
	 * @param official
	 * @return
	 */
	List<StepInstance> findStepInstancesByOfficial(Official official);

	/**
	 * 批量插入步骤实例
	 * @param stepInstances
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
	 * 修改步骤实例的状态
	 * @param step
	 * @return
	 */
	Integer update(StepInstance step);

	/**
	 * 根据步骤模型查找步骤实例
	 * @param steps
	 * @return
	 */
	List<StepInstance> findByStepTemplates(List<StepTemplate> steps);

	/**
	 * 批量修改
	 * @param byOfficial
	 * @return 
	 */
	Integer update(List<StepInstance> byOfficial);

	
	Integer deleteBatch(List<StepInstance> ss2);

}
