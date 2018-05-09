package com.ssm.OaManager.dao.system.impl.workflow;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.ssm.OaManager.dao.impl.BaseDaoImpl;
import com.ssm.OaManager.dao.system.workflow.FlowInstanceDao;
import com.ssm.OaManager.entity.official.Official;
import com.ssm.OaManager.entity.workflow.FlowInstance;
import com.ssm.OaManager.entity.workflow.FlowTemplate;

/**
 * 流程实例DAO层
 * @author Administrator
 *
 */
@Repository
public class FlowInstanceDaoImpl extends BaseDaoImpl<FlowInstance> implements FlowInstanceDao {

	public FlowInstanceDaoImpl(){
		super.setNs(FlowInstance.class.getName());
	}

	public FlowInstance findByOffiId(Official official) {
		return this.getSqlSession().selectOne(FlowInstance.class.getName()+".findByOffi", official);
	}

	/**
	 * 通过流程实例查找s
	 * @param flowInstance
	 * @return
	 */
	public FlowInstance findByFlowInstance(FlowInstance flowInstance) {
		return this.getSqlSession().selectOne(FlowInstance.class.getName()+".findByFlowInstance", flowInstance);
	}

	/**
	 * 删除
	 * @param flowInstance
	 */
	public void delete(FlowInstance flowInstance) {
		this.getSqlSession().delete(FlowInstance.class.getName()+".deleteFlowInstance", flowInstance);
	}

	/**
	 * 通过流程查找流程实例
	 * @param flow
	 * @return
	 */
	public List<FlowInstance> findByFlow(FlowTemplate flow) {
		return this.getSqlSession().selectList(FlowInstance.class.getName()+".findByFlow", flow);
	}

	/**
	 * 批量删除
	 * @param flowInstances
	 * @return
	 */
	public Integer deleteBatch(List<FlowInstance> flowInstances) {
		return this.getSqlSession().delete(FlowInstance.class.getName()+".deleteBatch", flowInstances);
	}

}
