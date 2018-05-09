package com.ssm.OaManager.dao.system.workflow;

import java.util.List;

import com.ssm.OaManager.dao.BaseDao;
import com.ssm.OaManager.entity.official.Official;
import com.ssm.OaManager.entity.workflow.FlowInstance;
import com.ssm.OaManager.entity.workflow.FlowTemplate;

public interface FlowInstanceDao extends BaseDao<FlowInstance>{

	/**
	 * 通过公文查询流程实例
	 * @param official
	 * @return
	 */
	FlowInstance findByOffiId(Official official);

	/**
	 * 通过流程实例查找s
	 * @param flowInstance
	 * @return
	 */
	FlowInstance findByFlowInstance(FlowInstance flowInstance);

	/**
	 * 删除
	 * @param flowInstance
	 */
	void delete(FlowInstance flowInstance);

	/**
	 * 通过流程查找流程实例
	 * @param flow
	 * @return
	 */
	List<FlowInstance> findByFlow(FlowTemplate flow);

	/**
	 * 批量删除
	 * @param flowInstances
	 * @return
	 */
	Integer deleteBatch(List<FlowInstance> flowInstances);

}
