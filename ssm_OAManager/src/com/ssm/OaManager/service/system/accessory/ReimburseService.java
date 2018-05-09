package com.ssm.OaManager.service.system.accessory;

import java.util.List;

import com.ssm.OaManager.entity.accessory.Reimburse;
import com.ssm.OaManager.utils.PageBean;

public interface ReimburseService {

	/**
	 * 获取所有记录数
	 * @return
	 */
	List<Reimburse> findAll();

	/**
	 * 分页查询
	 * @param pageBean
	 * @return
	 */
	List<Reimburse> findByPage(PageBean<Reimburse> pageBean);

	/**
	 * 添加
	 * @param reimburse
	 * @return 
	 */
	Integer add(Reimburse reimburse);

	/**
	 * 查找
	 * @param reimburse
	 * @return
	 */
	Reimburse findByReimburse(Reimburse reimburse);

}
