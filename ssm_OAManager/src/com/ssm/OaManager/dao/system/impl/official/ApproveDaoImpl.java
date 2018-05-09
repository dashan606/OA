package com.ssm.OaManager.dao.system.impl.official;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.ssm.OaManager.dao.impl.BaseDaoImpl;
import com.ssm.OaManager.dao.system.official.ApproveDao;
import com.ssm.OaManager.entity.official.Approve;
import com.ssm.OaManager.entity.official.Official;

/**
 * 审批DAO层
 * @author Administrator
 *
 */
@Repository
public class ApproveDaoImpl extends BaseDaoImpl<Approve> implements ApproveDao {

	public ApproveDaoImpl(){
		super.setNs(Approve.class.getName());
	}

	/**
	 * 根据公文查找审批历史
	 * @param official
	 * @return
	 */
	public List<Approve> findByOffical(Official official) {
		return this.getSqlSession().selectList(Approve.class.getName()+".findByOffical", official);
	}

	/**
	 * 批量删除
	 * @param approves
	 */
	public void deleteBatch(List<Approve> approves) {
		this.getSqlSession().delete(Approve.class.getName()+".deleteBatch", approves);
	}

}
