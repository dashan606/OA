package com.ssm.OaManager.dao.system.impl.workflow;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.ssm.OaManager.dao.impl.BaseDaoImpl;
import com.ssm.OaManager.dao.system.workflow.StepInstanceDao;
import com.ssm.OaManager.entity.hrm.Employee;
import com.ssm.OaManager.entity.official.Official;
import com.ssm.OaManager.entity.workflow.StepInstance;
import com.ssm.OaManager.entity.workflow.StepTemplate;

/**
 * 步骤实例DAO层
 * @author Administrator
 *
 */
@Repository
public class StepInstanceDaoImpl extends BaseDaoImpl<StepInstance> implements StepInstanceDao {

	public StepInstanceDaoImpl(){
		super.setNs(StepInstance.class.getName());
	}

	/**
	 * 通过公文获取步骤实例
	 * @param official
	 * @return
	 */
	public List<StepInstance> findStepInstancesByOfficial(Official official) {
		return this.getSqlSession().selectList(StepInstance.class.getName()+".findStepInstancesByOfficial", official);
	}

	/**
	 *批量插入
	 * @param nowSteps
	 * @return
	 */
	public Integer insertBatch(List<StepInstance> stepInstances) {
		return this.getSqlSession().insert(StepInstance.class.getName()+".insertBatch", stepInstances);
	}

	/**
	 * 根据指派人查询相应的步骤实例
	 * @param emp
	 * @return
	 */
	public List<StepInstance> findAll(Employee emp) {
		return this.getSqlSession().selectList(StepInstance.class.getName()+".findAllByEmp", emp);
	}

	/**
	 * 根据步骤模型查找步骤实例
	 * @param steps
	 * @return
	 */
	public List<StepInstance> findByStepTemplates(List<StepTemplate> steps) {
		return this.getSqlSession().selectList(StepInstance.class.getName()+".findByStepTemplates", steps);
	}

	/**
	 * 批量修改
	 * @param byOfficial
	 */
	public void updateByStepInstances(List<StepInstance> byOfficial) {
		this.getSqlSession().update(StepInstance.class.getName()+".updateByStepInstances", byOfficial);
	}

	public void deleteBatch(List<StepInstance> ss2) {
		this.getSqlSession().delete(StepInstance.class.getName()+".deleteBatch", ss2);
	}
}
