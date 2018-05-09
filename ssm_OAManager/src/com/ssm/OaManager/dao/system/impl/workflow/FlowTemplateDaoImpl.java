package com.ssm.OaManager.dao.system.impl.workflow;

import org.springframework.stereotype.Repository;

import com.ssm.OaManager.dao.impl.BaseDaoImpl;
import com.ssm.OaManager.dao.system.workflow.FlowTemplateDao;
import com.ssm.OaManager.entity.workflow.FlowTemplate;

/**
 * 流程定义模型
 * @author Administrator
 *
 */
@Repository
public class FlowTemplateDaoImpl extends BaseDaoImpl<FlowTemplate> implements FlowTemplateDao {

	public FlowTemplateDaoImpl() {
		super.setNs(FlowTemplate.class.getName());
	}

	/**
	 * 插入数据并返回主键
	 */
	public void insertAndGetId(FlowTemplate flow) {
		this.getSqlSession().insert(FlowTemplate.class.getName()+".insertAndGetId", flow);
	}

	
}
