package com.ssm.OaManager.dao.system.impl.accessory;

import org.springframework.stereotype.Repository;

import com.ssm.OaManager.dao.impl.BaseDaoImpl;
import com.ssm.OaManager.dao.system.accessory.AflTypeDao;
import com.ssm.OaManager.entity.accessory.AflType;

/**
 * 请假类型DAO
 * @author Administrator
 *
 */
@Repository
public class aflTypeDaoImpl extends BaseDaoImpl<AflType> implements AflTypeDao {

	public aflTypeDaoImpl() {
		super.setNs(AflType.class.getName());
	}

	
}
