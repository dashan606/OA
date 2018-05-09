package com.ssm.OaManager.service.system.impl.workflow;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ssm.OaManager.dao.system.workflow.FlowTemplateDao;
import com.ssm.OaManager.entity.workflow.FlowTemplate;
import com.ssm.OaManager.service.system.workflow.FlowTemplateService;
import com.ssm.OaManager.utils.MyAnnotation;

/**
 * 流程定义模型业务层
 * @author Administrator
 *
 */
@Service
public class FlowTemplateServiceImpl implements FlowTemplateService {

	private FlowTemplateDao flowTemplateDao;

	@Resource
	public void setFlowTemplateDao(FlowTemplateDao flowTemplateDao) {
		this.flowTemplateDao = flowTemplateDao;
	}

	/**
	 * 添加
	 * @param flow
	 * @return
	 */
	@MyAnnotation(methodNames = "addWorkFlow")
	public int insert(FlowTemplate flow) {
		flowTemplateDao.insertAndGetId(flow);
		
		return 1;
	}

	/**
	 * 查询所有流程
	 * @return
	 */
	public List<FlowTemplate> findAll() {
		List<FlowTemplate> flowTemplate = flowTemplateDao.findAll();
		if(flowTemplate==null){
			flowTemplate = new ArrayList<FlowTemplate>();
		}
		return flowTemplate;
	}

	/**
	 * 删除
	 */
	@MyAnnotation(methodNames = "deleteWorkFlow")
	public Integer delete(FlowTemplate flow) {
		return flowTemplateDao.deleteById(flow.getFlowId());
	}
	
	
}
