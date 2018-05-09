package com.ssm.OaManager.dao.system.impl.official;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.ssm.OaManager.dao.impl.BaseDaoImpl;
import com.ssm.OaManager.dao.system.official.OfficialDao;
import com.ssm.OaManager.entity.User;
import com.ssm.OaManager.entity.official.Official;
import com.ssm.OaManager.entity.workflow.StepInstance;

/**
 * 公文Dao层
 * @author Administrator
 *
 */
@Repository
public class OfficialImpl extends BaseDaoImpl<Official> implements OfficialDao {

	public OfficialImpl(){
		super.setNs(Official.class.getName());
	}

	/**
	 * 通过步骤实例获取公文
	 * @param stepInstances
	 * @return
	 */
	public List<Official> findByStepIntances(List<StepInstance> stepInstances) {
		return this.getSqlSession().selectList(Official.class.getName()+".findByStepIntances", stepInstances);
	}

	public void insertAndGetId(Official official) {
		this.getSqlSession().insert(Official.class.getName()+".insertAndGetId", official);
	}

	/**
	 * 查询我的公文
	 * @param user
	 * @return
	 */
	public List<Official> findByUser(User user) {
		return this.getSqlSession().selectList(Official.class.getName()+".findByUser", user);
	}

	/**
	 * 删除公文
	 */
	public void deleteOfficial(Official official) {
		this.getSqlSession().delete(Official.class.getName()+".deleteOfficial",official);
	}

}
