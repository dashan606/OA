package com.ssm.OaManager.dao.system.impl.accessory;

import org.springframework.stereotype.Repository;

import com.ssm.OaManager.dao.impl.BaseDaoImpl;
import com.ssm.OaManager.dao.system.accessory.AskForLeaveDao;
import com.ssm.OaManager.entity.accessory.AskForLeave;

/**
 * 请假DAO层
 * @author Administrator
 *
 */
@Repository
public class AskForLeaveDaoImpl extends BaseDaoImpl<AskForLeave> implements AskForLeaveDao {

	public AskForLeaveDaoImpl(){
		super.setNs(AskForLeave.class.getName());
	}

	/**
	 * 插入并返回主键
	 * @param askLeave
	 */
	public void insertAndGetId(AskForLeave askLeave) {
		this.getSqlSession().insert(AskForLeave.class.getName()+".insertAndGetId", askLeave);
	}

	
	public AskForLeave findByAskForLeave(AskForLeave askLeave) {
		return this.getSqlSession().selectOne(AskForLeave.class.getName()+".findByAskForLeave", askLeave);
	}

}
