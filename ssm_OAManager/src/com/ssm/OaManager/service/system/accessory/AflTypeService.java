package com.ssm.OaManager.service.system.accessory;

import java.util.List;

import com.ssm.OaManager.entity.accessory.AflType;

public interface AflTypeService {

	/**
	 * 查询所有
	 * @return 
	 */
	List<AflType> findAll();

}
