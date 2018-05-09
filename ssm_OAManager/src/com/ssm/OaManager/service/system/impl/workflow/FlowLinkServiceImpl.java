package com.ssm.OaManager.service.system.impl.workflow;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ssm.OaManager.dao.system.workflow.FlowLinkDao;
import com.ssm.OaManager.entity.workflow.FlowLink;
import com.ssm.OaManager.entity.workflow.FlowTemplate;
import com.ssm.OaManager.service.system.workflow.FlowLinkService;
import com.ssm.OaManager.utils.MyAnnotation;

/**
 * 流程链路业务层
 * @author Administrator
 *
 */
@Service
public class FlowLinkServiceImpl implements FlowLinkService {

	private FlowLinkDao flowLinkDao;

	@Resource
	public void setFlowLinkDao(FlowLinkDao flowLinkDao) {
		this.flowLinkDao = flowLinkDao;
	}

	/**
	 * 批量插入流程步骤
	 * @param userList
	 * @return
	 */
	@MyAnnotation(methodNames = "addWorkFlow")
	public int insertBatch(List<FlowLink> flowLinkList) {
		flowLinkDao.insertBatch(flowLinkList);
		
		return 1;
	}

	/**
	 * 根据流程获取流程链路
	 * @param flow
	 * @return
	 */
	public List<FlowLink> findByFlow(FlowTemplate flow) {
		List<FlowLink> flowLink = flowLinkDao.findAllByFlow(flow);
		if(flowLink==null){
			flowLink = new ArrayList<FlowLink>();
		}
		return flowLink;
	}
	
	@MyAnnotation(methodNames = "deleteWorkFlow")
	public Integer deleteByFlowTemplate(FlowTemplate flow) {
		return flowLinkDao.deleteByFlowTemplate(flow);
	}
	
	
}
