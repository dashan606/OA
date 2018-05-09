package com.ssm.OaManager.dao.system.impl.workflow;

import org.springframework.stereotype.Repository;

import com.ssm.OaManager.dao.impl.BaseDaoImpl;
import com.ssm.OaManager.dao.system.workflow.FlowTypeDao;
import com.ssm.OaManager.entity.workflow.FlowType;

/**
 * 流程类型Dao层
 * @author Administrator
 *
 */
@Repository
public class FlowTypeDaoImpl extends BaseDaoImpl<FlowType> implements FlowTypeDao {

	public FlowTypeDaoImpl() {
		super.setNs(FlowType.class.getName());
		
	}

	
}
