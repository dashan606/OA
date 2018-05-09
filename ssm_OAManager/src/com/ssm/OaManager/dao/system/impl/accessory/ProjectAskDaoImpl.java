package com.ssm.OaManager.dao.system.impl.accessory;

import org.springframework.stereotype.Repository;

import com.ssm.OaManager.dao.impl.BaseDaoImpl;
import com.ssm.OaManager.dao.system.accessory.ProjectAskDao;
import com.ssm.OaManager.entity.accessory.ProjectAsk;

/**
 * 项目资金申请DAO层
 * @author Administrator
 *
 */
@Repository
public class ProjectAskDaoImpl extends BaseDaoImpl<ProjectAsk> implements ProjectAskDao {

	public ProjectAskDaoImpl() {
		super.setNs(ProjectAsk.class.getName());
	}

	/**
	 * 插入并返回主键
	 * @param projectAsk
	 */
	public void insertAndGetId(ProjectAsk projectAsk) {
		
		this.getSqlSession().insert(this.getNs()+".insertAndGetId", projectAsk);
	
	}

	/**
	 * 根据对象查找
	 * @param projectAsk
	 * @return
	 */
	public ProjectAsk findByProject(ProjectAsk projectAsk) {
		
		return this.getSqlSession().selectOne(this.getNs()+".findByProject", projectAsk);
	
	}

	
}
