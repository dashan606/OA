package com.ssm.OaManager.service.system.impl.accessory;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ssm.OaManager.dao.system.accessory.AflTypeDao;
import com.ssm.OaManager.entity.accessory.AflType;
import com.ssm.OaManager.service.system.accessory.AflTypeService;

/**
 * 请假类型
 * @author Administrator
 *
 */
@Service
public class aflTypeServiceImpl implements AflTypeService {
	
	private AflTypeDao aflTypeDao;

	@Resource
	public void setAflTypeDao(AflTypeDao aflTypeDao) {
		this.aflTypeDao = aflTypeDao;
	}

	/**
	 * 查询所有
	 */
	public List<AflType> findAll() {
		return aflTypeDao.findAll();
	}
	
	
}
