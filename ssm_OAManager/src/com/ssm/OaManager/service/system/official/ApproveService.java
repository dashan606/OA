package com.ssm.OaManager.service.system.official;

import java.util.List;

import com.ssm.OaManager.entity.official.Approve;
import com.ssm.OaManager.entity.official.Official;

public interface ApproveService {

	/**
	 * 添加审批记录
	 * @param approve
	 * @return
	 */
	Integer add(Approve approve);

	/**
	 * 查看审批历史
	 * @param official
	 * @return
	 */
	List<Approve> findByOffical(Official official);

	/**
	 * 批量删除
	 * @param approves
	 * @return 
	 */
	Integer deleteBatch(List<Approve> approves);

}
