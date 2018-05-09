package com.ssm.OaManager.service.system.accessory;

import java.util.List;

import com.ssm.OaManager.entity.accessory.ReimType;

public interface ReimTypeService {

	/**
	 * 查询所有记录数
	 * @return
	 */
	List<ReimType> findAll();

}
