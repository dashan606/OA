package com.ssm.OaManager.service.system.impl.official;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ssm.OaManager.dao.system.official.OfficialDao;
import com.ssm.OaManager.entity.User;
import com.ssm.OaManager.entity.official.Official;
import com.ssm.OaManager.entity.workflow.StepInstance;
import com.ssm.OaManager.service.system.official.OfficialService;
import com.ssm.OaManager.utils.MyAnnotation;
import com.ssm.OaManager.utils.PageBean;

/**
 * 公文业务层
 * @author Administrator
 *
 */
@Service
public class OfficialServiceImpl implements OfficialService {

	private OfficialDao officialDao;

	@Resource
	public void setOfficialDao(OfficialDao officialDao) {
		this.officialDao = officialDao;
	}

	/**
	 * 
	 * 添加公文
	 * @param official
	 * @return
	 */
	@MyAnnotation(methodNames = "redact")
	public int add(Official official) {
		return officialDao.insert(official);
	}

	/**
	 * 分页数据
	 */
	public PageBean<Official> findByPage(PageBean<Official> pageBean) {
		//获得记录数
		Integer totalCount = this.officialDao.findCount(pageBean);
		//设置入分页对象
		if(totalCount != null){
			pageBean.setTotalCount(totalCount);
		}
		//设置当前页
		if(pageBean.getCurrentPage() < 1){
			pageBean.setCurrentPage(1);
		}
		//判断当前页
		/*if(pageBean.getCurrentPage() > pageBean.getTotalPage()){
			pageBean.setCurrentPage(pageBean.getTotalPage());
		}*/

		pageBean.setFirstPage((pageBean.getCurrentPage()-1)*pageBean.getPageSize());
		// 获得分页数据
		List<Official> datas = this.officialDao.findByPage(pageBean);

		pageBean.setDatas(datas);
		
		return pageBean;
	}

	/**
	 * 获取所有记录
	 * @return
	 */
	public List<Official> findAll() {
		List<Official> official = officialDao.findAll();
				if(official==null){
					official = new ArrayList<Official>();
				}
		return official;
	}

	/**
	 * 修改公文
	 * @param official
	 * @return
	 */
	@MyAnnotation(methodNames = "officialCommitDeleteApprove")
	public Integer update(Official official) {
		return officialDao.update(official);
	}

	/**
	 * 通过步骤实例查询公文
	 * @param stepInstances
	 * @return
	 */
	public List<Official> findByStepIntances(List<StepInstance> stepInstances) {
		List<Official> official = officialDao.findByStepIntances(stepInstances);
		if(official==null){
			official = new ArrayList<Official>();
		}
		return official;
	}

	/**
	 * 根据ID查找
	 * @param offiId
	 * @return
	 */
	public Official findById(Integer offiId) {
	   Official official =officialDao.findById(offiId);
		if(official==null){
			official = new Official();
		}
		return official;
	}

	/**
	 * 
	 */
	@MyAnnotation(methodNames = "officialAdd")
	public Integer insertAndGetId(Official official) {
		officialDao.insertAndGetId(official);
		
		return 1;
	}

	/**
	 * 查询我的公文
	 * @param user
	 * @return
	 */
	public List<Official> findByUser(User user) {
		List<Official> official = officialDao.findByUser(user);
		if(official==null){
			official = new ArrayList<Official>();
		}
		return official;
	}

	/**
	 * 删除公文
	 */
	@MyAnnotation(methodNames = "officialCommitDeleteApprove")
	public Integer delete(Official official) {
		officialDao.deleteOfficial(official);
		
		return 1;
	}


}
