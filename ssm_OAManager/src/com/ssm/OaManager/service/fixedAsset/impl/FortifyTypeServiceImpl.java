package com.ssm.OaManager.service.fixedAsset.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ssm.OaManager.dao.fixedAsset.FortifyTypeDao;
import com.ssm.OaManager.entity.fixedAsset.FortifyType;
import com.ssm.OaManager.service.fixedAsset.FortifyTypeService;
import com.ssm.OaManager.utils.MyAnnotation;
import com.ssm.OaManager.utils.PageBean;

/**
 *增加类别业务层实现类
 * 
 * @author Administrator
 * 
 */
@Service
public class FortifyTypeServiceImpl implements FortifyTypeService {

	@Resource
	private FortifyTypeDao fortifyTypeDao;


	public void setfortifyTypeDao(FortifyTypeDao fortifyTypeDao) {
		this.fortifyTypeDao = fortifyTypeDao;
	}

	public FortifyType findById(Serializable id) {
		FortifyType fortifyType = this.fortifyTypeDao.findById(id);
		if(fortifyType==null){
			fortifyType = new FortifyType();
		}
		return fortifyType;
	}
	@MyAnnotation(methodNames = "redact")
	public int insert(FortifyType entity) {
		return this.fortifyTypeDao.insert(entity);
	}
	@MyAnnotation(methodNames = "redact")
	public int update(FortifyType entity) {
		return this.fortifyTypeDao.update(entity);
	}
	@MyAnnotation(methodNames = "redact")
	public int deleteById(Serializable id) {
			return this.fortifyTypeDao.deleteById(id);
	}
	@MyAnnotation(methodNames = "redact")
	public int delete(Serializable[] ids) {
			return this.fortifyTypeDao.delete(ids);
	}

	public List<FortifyType> findAll() {
		List<FortifyType> fortifyType = this.fortifyTypeDao.findAll();
		if(fortifyType==null){
			fortifyType = new ArrayList<FortifyType>();
		}
		return fortifyType;
	}

	public void findPageBean(PageBean<FortifyType> pageBean) {
		// 获得总记录数
		Integer totalCount = this.fortifyTypeDao.findCount(pageBean);
		// 设置入分页对象
		if (totalCount != null) {
			pageBean.setTotalCount(totalCount);
		}
		if (pageBean.getCurrentPage() < 1) {
			pageBean.setCurrentPage(1);
		}

		if (pageBean.getCurrentPage() > pageBean.getTotalPage()) {
			pageBean.setCurrentPage(pageBean.getTotalPage());
		}
		pageBean.setFirstPage((pageBean.getCurrentPage()-1)*pageBean.getPageSize());
		// 获得分页数据
		List<FortifyType> datas = this.fortifyTypeDao.findByPage(pageBean);

		pageBean.setDatas(datas);

	}

}
