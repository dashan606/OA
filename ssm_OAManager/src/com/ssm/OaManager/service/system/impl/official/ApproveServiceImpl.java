package com.ssm.OaManager.service.system.impl.official;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ssm.OaManager.dao.system.official.ApproveDao;
import com.ssm.OaManager.entity.official.Approve;
import com.ssm.OaManager.entity.official.Official;
import com.ssm.OaManager.service.system.official.ApproveService;
import com.ssm.OaManager.utils.MyAnnotation;
/**
 * 审批业务层
 * @author Administrator
 *
 */
@Service
public class ApproveServiceImpl implements ApproveService {

	private ApproveDao approveDao;

	@Resource
	public void setApproveDao(ApproveDao approveDao) {
		this.approveDao = approveDao;
	}

	/**
	 * 添加审批记录
	 * @param approve
	 * @return
	 */
	@MyAnnotation(methodNames = "officialCommitDeleteApprove")
	public Integer add(Approve approve) {
		return approveDao.insert(approve);
	}

	/**
	 * 查看审批历史
	 * @param official
	 * @return
	 */
	public List<Approve> findByOffical(Official official) {
		List<Approve> approve = approveDao.findByOffical(official);
		if(approve==null){
			approve = new ArrayList<Approve>();
		}
		return approve;
	}

	/**
	 * 批量删除
	 * @param approves
	 */
	@MyAnnotation(methodNames = "officialCommitDeleteApprove")
	public Integer deleteBatch(List<Approve> approves) {
		approveDao.deleteBatch(approves);
		
		return 1;
	}
	
	
}
