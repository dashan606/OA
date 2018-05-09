package com.ssm.OaManager.service.system.workflow;

import java.util.List;

import com.ssm.OaManager.entity.official.Official;
import com.ssm.OaManager.entity.workflow.FlowInstance;
import com.ssm.OaManager.entity.workflow.FlowTemplate;

public interface FlowInstanceService {

	/**
	 * 添加流程实例
	 * @param flowInstance 
	 * @return
	 */
	int add(FlowInstance flowInstance);

	/**
	 * 根据公文获取流程实例
	 * @param official
	 * @return
	 */
	FlowInstance findFlowInstance(Official official);

	/**
	 * 通过流程实例查找s
	 * @param flowInstance
	 * @return
	 */
	FlowInstance findByFlowInstance(FlowInstance flowInstance);

	/**
	 * 删除
	 * @param flowInstance
	 * @return 
	 */
	Integer delete(FlowInstance flowInstance);

	/**
	 * 根据流程查找流程实例
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
