package com.ssm.OaManager.dao.system.impl.accessory;

import org.springframework.stereotype.Repository;

import com.ssm.OaManager.dao.impl.BaseDaoImpl;
import com.ssm.OaManager.dao.system.accessory.ReimburseDao;
import com.ssm.OaManager.entity.accessory.Reimburse;

/**
 * 报销Dao层
 * @author Administrator
 *
 */
@Repository
public class ReimburseDaoImpl extends BaseDaoImpl<Reimburse> implements ReimburseDao {

	public ReimburseDaoImpl(){
		super.setNs(Reimburse.class.getName());
	}

	/**
	 * 添加并返回主键
	 * @param reimburse
	 */
	public void insertAndGetId(Reimburse reimburse) {
		this.getSqlSession().insert(Reimburse.class.getName()+".insertAndGetId", reimburse);
	}

	/**
	 * 查找
	 * @param reimburse
	 * @return
	 */
	public Reimburse findByReimburse(Reimburse reimburse) {
		return this.getSqlSession().selectOne(Reimburse.class.getName()+".findByReimburse", reimburse);
	}
}
