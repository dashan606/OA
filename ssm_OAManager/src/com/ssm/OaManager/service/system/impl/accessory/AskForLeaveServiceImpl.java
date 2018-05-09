package com.ssm.OaManager.service.system.impl.accessory;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ssm.OaManager.dao.system.accessory.AskForLeaveDao;
import com.ssm.OaManager.entity.accessory.AskForLeave;
import com.ssm.OaManager.service.system.accessory.AskForLeaveService;
import com.ssm.OaManager.utils.MyAnnotation;

/**
 * 请假业务层
 * @author Administrator
 *
 */
@Service
public class AskForLeaveServiceImpl implements AskForLeaveService {

	private AskForLeaveDao askForLeaveDao;

	@Resource
	public void setAskForLeaveDao(AskForLeaveDao askForLeaveDao) {
		this.askForLeaveDao = askForLeaveDao;
	}

	/**
	 * 插入并返回主键
	 * @param askLeave
	 */
	@MyAnnotation(methodNames = "buildWord")
	public Integer insertAndGetId(AskForLeave askLeave) {
		askForLeaveDao.insertAndGetId(askLeave);
		
		return 1;
	}

	/**
	 * 通过对象进行查找
	 * @param askLeave
	 * @return
	 */
	public AskForLeave findByAskForLeave(AskForLeave askLeave) {
		AskForLeave askForLeave = askForLeaveDao.findByAskForLeave(askLeave);
		if(askForLeave==null){
			askForLeave = new AskForLeave();
		}
		return askForLeave;
	}
	
	
}
