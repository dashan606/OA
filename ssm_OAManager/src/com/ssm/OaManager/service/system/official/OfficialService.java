package com.ssm.OaManager.service.system.official;

import java.util.List;

import com.ssm.OaManager.entity.User;
import com.ssm.OaManager.entity.official.Official;
import com.ssm.OaManager.entity.workflow.StepInstance;
import com.ssm.OaManager.utils.PageBean;

public interface OfficialService {

	/**
	 * 
	 * 添加公文
	 * @param official
	 * @return
	 */
	int add(Official official);

	/**
	 * 分页查询
	 * @param pageBean
	 * @return
	 */
	PageBean<Official> findByPage(PageBean<Official> pageBean);

	/**
	 * 获取所有记录
	 * @return
	 */
	List<Official> findAll();

	/**
	 * 修改公文
	 * @param official
	 * @return
	 */
	Integer update(Official official);

	/**
	 * 通过步骤实例查询公文
	 * @param stepInstances
	 * @return
	 */
	List<Official> findByStepIntances(List<StepInstance> stepInstances);

	/**
	 * 根据ID查找
	 * @param offiId
	 * @return
	 */
	Official findById(Integer offiId);

	/**
	 * 
	 * @param official
	 * @return
	 */
	Integer insertAndGetId(Official official);

	/**
	 * 查询我的公文
	 * @param user
	 * @return
	 */
	List<Official> findByUser(User user);

	/**
	 * 删除公文
	 * @param official
	 * @return 
	 */
	Integer delete(Official official);

}
