package com.ssm.OaManager.service.fixedAsset.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ssm.OaManager.dao.fixedAsset.AssetMaintainDao;
import com.ssm.OaManager.dao.fixedAsset.MaintainTypeDao;
import com.ssm.OaManager.entity.fixedAsset.AssetMaintain;
import com.ssm.OaManager.entity.fixedAsset.MaintainType;
import com.ssm.OaManager.service.fixedAsset.MaintainTypeService;
import com.ssm.OaManager.utils.MyAnnotation;
import com.ssm.OaManager.utils.PageBean;

/**
 * 维护类型业务层实现类
 * 
 * @author Administrator
 * 
 */
@Service
public class MaintainTypeServiceImpl implements MaintainTypeService {

	@Resource
	private MaintainTypeDao maintainTypeDao;

	@Resource
	private AssetMaintainDao assetMaintainDao;

	public void setAssetMaintainDao(AssetMaintainDao assetMaintainDao) {
		this.assetMaintainDao = assetMaintainDao;
	}

	public void setMaintainTypeDao(MaintainTypeDao maintainTypeDao) {
		this.maintainTypeDao = maintainTypeDao;
	}

	public MaintainType findById(Serializable id) {
		MaintainType maintainType =this.maintainTypeDao.findById(id);
		if(maintainType==null){
			maintainType= new MaintainType();
		}
		return maintainType;
	}
	@MyAnnotation(methodNames = "redact")
	public int insert(MaintainType entity) {
		return this.maintainTypeDao.insert(entity);
	}
	@MyAnnotation(methodNames = "redact")
	public int update(MaintainType entity) {
		return this.maintainTypeDao.update(entity);
	}
	@MyAnnotation(methodNames = "redact")
	public int deleteById(Serializable id) {
			List<AssetMaintain> params = assetMaintainDao.findBymaintaintypeId(id);
			int num = -2;
			if(params.isEmpty()){
				num = this.maintainTypeDao.deleteById(id);
			}
			return  num;
	}
	@MyAnnotation(methodNames = "redact")
	public int delete(Serializable[] ids) {
			return this.maintainTypeDao.delete(ids);
	}

	public List<MaintainType> findAll() {
		List<MaintainType> maintainType =this.maintainTypeDao.findAll();
		if(maintainType==null){
			maintainType= new ArrayList<MaintainType>();
		}
		return maintainType;
	}
	
	public void findPageBean(PageBean<MaintainType> pageBean) {
		// 获得总记录数
		Integer totalCount = this.maintainTypeDao.findCount(pageBean);
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
		List<MaintainType> datas = this.maintainTypeDao.findByPage(pageBean);

		pageBean.setDatas(datas);

	}

}
