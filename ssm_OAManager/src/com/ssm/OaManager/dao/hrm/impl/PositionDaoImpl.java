package com.ssm.OaManager.dao.hrm.impl;


import org.springframework.stereotype.Repository;

import com.ssm.OaManager.dao.hrm.PositionDao;
import com.ssm.OaManager.dao.impl.BaseDaoImpl;
import com.ssm.OaManager.entity.hrm.Position;

/**
 * 岗位dao层实现类
 * @author HUX
 *
 */
@Repository
public class PositionDaoImpl extends BaseDaoImpl<Position> implements PositionDao {
	public PositionDaoImpl(){
		super.setNs(Position.class.getName());
	}
	
}
