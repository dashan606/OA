package com.ssm.OaManager.dao.system.official;

import java.util.List;

import com.ssm.OaManager.dao.BaseDao;
import com.ssm.OaManager.entity.User;
import com.ssm.OaManager.entity.official.Official;
import com.ssm.OaManager.entity.workflow.StepInstance;

public interface OfficialDao extends BaseDao<Official>{

	/**
	 * 通过步骤实例获取公文
	 * @param stepInstances
	 * @return
	 */
	List<Official> findByStepIntances(List<StepInstance> stepInstances);

	void insertAndGetId(Official official);

	/**
	 * 查询我的公文
	 * @param user
	 * @return
	 */
	List<Official> findByUser(User user);

	/**
	 * 删除公文
	 * @param official
	 */
	void deleteOfficial(Official official);

}
