package com.ssm.OaManager.dao.system.impl.accessory;

import org.springframework.stereotype.Repository;

import com.ssm.OaManager.dao.impl.BaseDaoImpl;
import com.ssm.OaManager.dao.system.accessory.ReimTypeDao;
import com.ssm.OaManager.entity.accessory.ReimType;

/**
 * 报销类型DAO
 * @author Administrator
 *
 */
@Repository
public class ReimTypeDaoImpl extends BaseDaoImpl<ReimType> implements ReimTypeDao {

	public ReimTypeDaoImpl(){
		super.setNs(ReimType.class.getName());
	}

}
