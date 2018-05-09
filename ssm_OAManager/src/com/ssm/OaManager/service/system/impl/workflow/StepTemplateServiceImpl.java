package com.ssm.OaManager.service.system.impl.workflow;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ssm.OaManager.dao.system.workflow.StepTemplateDao;
import com.ssm.OaManager.entity.workflow.StepTemplate;
import com.ssm.OaManager.service.system.workflow.StepTemplateService;

/**
 * 步骤模型业务层
 * @author Administrator
 *
 */
@Service
public class StepTemplateServiceImpl implements StepTemplateService {

	private StepTemplateDao stepTemplateDao;

	@Resource
	public void setStepTemplateDao(StepTemplateDao stepTemplateDao) {
		this.stepTemplateDao = stepTemplateDao;
	}

	/**
	 * 获取所有的步骤
	 * @return
	 */
	public List<StepTemplate> findAll() {
		List<StepTemplate> stepTemplate = stepTemplateDao.findAll();
		if(stepTemplate==null){
			stepTemplate = new ArrayList<StepTemplate>();
		}
		return stepTemplate;
	}

	/**
	 * 查询步骤
	 * @param step
	 * @return
	 */
	public StepTemplate findStep(StepTemplate step) {
		StepTemplate stepTemplate =  stepTemplateDao.findStep(step);
		if(stepTemplate==null){
			stepTemplate = new StepTemplate();
		}
		return stepTemplate;
	}
	
	
}
