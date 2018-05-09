package com.ssm.OaManager.service.system.impl.workflow;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ssm.OaManager.dao.system.workflow.FlowInstanceDao;
import com.ssm.OaManager.entity.official.Official;
import com.ssm.OaManager.entity.workflow.FlowInstance;
import com.ssm.OaManager.entity.workflow.FlowTemplate;
import com.ssm.OaManager.service.system.workflow.FlowInstanceService;
import com.ssm.OaManager.utils.MyAnnotation;

/**
 * 流程实例业务层
 * @author Administrator
 *
 */
@Service
public class FlowInstanceServiceImpl implements FlowInstanceService {

	private FlowInstanceDao flowInstanceDao;

	@Resource
	public void setFlowInstanceDao(FlowInstanceDao flowInstanceDao) {
		this.flowInstanceDao = flowInstanceDao;
	}

	/**
	 * 添加
	 */
	@MyAnnotation(methodNames = "officialAdd")
	public int add(FlowInstance flowInstance) {
		return flowInstanceDao.insert(flowInstance);
	}

	/**
	 * 根据公文获取流程实例
	 * @param official
	 * @return
	 */
	public FlowInstance findFlowInstance(Official official) {
		FlowInstance flowInstance = flowInstanceDao.findByOffiId(official);
		if(flowInstance==null){
			flowInstance = new FlowInstance();
		}
		return flowInstance;
	}

	/**
	 * 通过流程实例查找s
	 * @param flowInstance
	 * @return
	 */
	public FlowInstance findByFlowInstance(FlowInstance flowInstance) {
		FlowInstance flowInstance1 =  flowInstanceDao.findByFlowInstance(flowInstance);
		if(flowInstance1==null){
			flowInstance1 = new FlowInstance();
		}
		return flowInstance1;
	}

	/**
	 * 删除
	 * @param flowInstance
	 */
	
	@MyAnnotation(methodNames = "officialCommitDeleteApprove")
	public Integer delete(FlowInstance flowInstance) {
		flowInstanceDao.delete(flowInstance);	
		
		return 1;
	}

	/**
	 * 通过流程查找流程实例
	 */
	public List<FlowInstance> findByFlow(FlowTemplate flow) {
		List<FlowInstance> flowInstance1 =  flowInstanceDao.findByFlow(flow);
		if(flowInstance1==null){
			flowInstance1 = new ArrayList<FlowInstance>();
		}
		return flowInstance1;
	}

	/**
	 * 批量删除
	 * @param flowInstances
	 * @return
	 */
	@MyAnnotation(methodNames = "officialCommitDeleteApprove")
	public Integer deleteBatch(List<FlowInstance> flowInstances) {
		return flowInstanceDao.deleteBatch(flowInstances);
	}
	
	
}
