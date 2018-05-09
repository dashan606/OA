package com.ssm.OaManager.service.system.impl.workflow;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ssm.OaManager.dao.system.workflow.FlowTypeDao;
import com.ssm.OaManager.entity.workflow.FlowType;
import com.ssm.OaManager.service.system.workflow.FlowTypeService;

/**
 * 流程类型业务层
 * @author Administrator
 *
 */
@Service
public class FlowTypeServiceImpl implements FlowTypeService {
	
	private FlowTypeDao flowTypeDao;

	@Resource
	public void setFlowTypeDao(FlowTypeDao flowTypeDao) {
		this.flowTypeDao = flowTypeDao;
	}

	/**
	 * 获取所有流程类型
	 * @return
	 */
	public List<FlowType> findAll() {
		List<FlowType> flowType = flowTypeDao.findAll();
		if(flowType==null){
			flowType = new ArrayList<FlowType>();
		}
		return flowType;
	}
	
	
}
