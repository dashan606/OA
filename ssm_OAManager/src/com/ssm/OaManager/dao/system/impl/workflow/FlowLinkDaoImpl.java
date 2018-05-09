package com.ssm.OaManager.dao.system.impl.workflow;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.ssm.OaManager.dao.impl.BaseDaoImpl;
import com.ssm.OaManager.dao.system.workflow.FlowLinkDao;
import com.ssm.OaManager.entity.workflow.FlowLink;
import com.ssm.OaManager.entity.workflow.FlowTemplate;

/**
 * 流程链路Dao层
 * @author Administrator
 *
 */
@Repository
public class FlowLinkDaoImpl extends BaseDaoImpl<FlowLink> implements FlowLinkDao {

	public FlowLinkDaoImpl() {
		super.setNs(FlowLink.class.getName());
	}

	/**
	 * 批量插入
	 */
	public void insertBatch(List<FlowLink> flowLinkList) {
		
		this.getSqlSession().insert(FlowLink.class.getName()+".insertBatch",flowLinkList);
	}

	/**
	 * 通过ID查询所有
	 * @param flowId
	 * @return
	 */
	public List<FlowLink> findAllByFlow(FlowTemplate flow) {
		
		return this.getSqlSession().selectList(FlowLink.class.getName()+".findAllByFlow", flow);
	}

	public Integer deleteByFlowTemplate(FlowTemplate flow) {
		return this.getSqlSession().delete(this.getNs()+".deleteByFlowTemplate", flow);
	}

	

}
