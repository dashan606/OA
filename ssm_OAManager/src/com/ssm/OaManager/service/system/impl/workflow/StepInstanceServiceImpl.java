package com.ssm.OaManager.service.system.impl.workflow;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ssm.OaManager.dao.system.workflow.StepInstanceDao;
import com.ssm.OaManager.entity.hrm.Employee;
import com.ssm.OaManager.entity.official.Official;
import com.ssm.OaManager.entity.workflow.StepInstance;
import com.ssm.OaManager.entity.workflow.StepTemplate;
import com.ssm.OaManager.service.system.workflow.StepInstanceService;
import com.ssm.OaManager.utils.MyAnnotation;

/**
 * 步骤实例业务层
 * @author Administrator
 *
 */
@Service
public class StepInstanceServiceImpl implements StepInstanceService {

	private StepInstanceDao stepInstanceDao;

	@Resource
	public void setStepInstanceDao(StepInstanceDao stepInstanceDao) {
		this.stepInstanceDao = stepInstanceDao;
	}
	public List<StepInstance> findStepInstancesByOfficial(Official official) {
		List<StepInstance> stepInstance = stepInstanceDao.findStepInstancesByOfficial(official);
		if(stepInstance==null){
			stepInstance = new ArrayList<StepInstance>();
		}
		return stepInstance;
	}

	/**
	 * 批量插入步骤实例
	 * @param nowSteps
	 * @return
	 */
	@MyAnnotation(methodNames = "officialCommitDeleteApprove")
	public Integer insertBatch(List<StepInstance> stepInstances) {
		return stepInstanceDao.insertBatch(stepInstances);
	}

	/**
	 * 根据指派人查询相应的步骤实例
	 * @param emp
	 * @return
	 */
	public List<StepInstance> findAll(Employee emp) {
		List<StepInstance> stepInstance = stepInstanceDao.findAll(emp);
		if(stepInstance==null){
			stepInstance = new ArrayList<StepInstance>();
		}
		return stepInstance;
	}

	/**
	 * 修改步骤实例的状态
	 * @param step
	 * @return
	 */
	@MyAnnotation(methodNames = "officialCommitDeleteApprove")
	public Integer update(StepInstance step) {
		return stepInstanceDao.update(step);
	}

	/**
	 * 根据步骤模型查找步骤实例
	 * @param steps
	 * @return
	 */
	public List<StepInstance> findByStepTemplates(List<StepTemplate> steps) {
		List<StepInstance> stepInstance = stepInstanceDao.findByStepTemplates(steps);
		if(stepInstance==null){
			stepInstance = new ArrayList<StepInstance>();
		}
		return stepInstance;
	}

	/**
	 * 批量修改
	 * @param byOfficial
	 */
	@MyAnnotation(methodNames = "officialCommitDeleteApprove")
	public Integer update(List<StepInstance> byOfficial) {
		stepInstanceDao.updateByStepInstances(byOfficial);
		
		return 1;
	}
	
	@MyAnnotation(methodNames = "officialCommitDeleteApprove")
	public Integer deleteBatch(List<StepInstance> ss2) {
		stepInstanceDao.deleteBatch(ss2);
		
		return 1;
	}
	
	
}
