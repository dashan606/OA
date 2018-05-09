package com.ssm.OaManager.service.system.impl.accessory;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ssm.OaManager.dao.system.accessory.ProjectAskDao;
import com.ssm.OaManager.entity.accessory.ProjectAsk;
import com.ssm.OaManager.service.system.accessory.ProjectAskService;
import com.ssm.OaManager.utils.MyAnnotation;

/**
 * 项目资金申请业务层
 * @author Administrator
 *
 */
@Service
public class ProjectAskServiceImpl implements ProjectAskService {

	private ProjectAskDao projectAskDao;

	@Resource
	public void setProjectAskDao(ProjectAskDao projectAskDao) {
		this.projectAskDao = projectAskDao;
	}

	/**
	 * 插入并返回主键
	 * @param projectAsk
	 * @return 
	 */
	@MyAnnotation(methodNames = "buildWord")
	public Integer insertAndGetId(ProjectAsk projectAsk) {
		projectAskDao.insertAndGetId(projectAsk);
		
		return 1;
	}

	/**
	 * 根据对象查找
	 * @param projectAsk
	 * @return
	 */
	public ProjectAsk findByProject(ProjectAsk projectAsk) {
		ProjectAsk projectAsk1 = projectAskDao.findByProject(projectAsk);
				if(projectAsk1==null){
					projectAsk1 = new ProjectAsk();
				}
		return projectAsk1;
	}
	
	
}
