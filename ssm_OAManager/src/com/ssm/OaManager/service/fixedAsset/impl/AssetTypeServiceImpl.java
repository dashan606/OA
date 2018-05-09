package com.ssm.OaManager.service.fixedAsset.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ssm.OaManager.dao.fixedAsset.AssetTypeDao;
import com.ssm.OaManager.entity.fixedAsset.AssetType;
import com.ssm.OaManager.service.fixedAsset.AssetTypeService;
import com.ssm.OaManager.utils.MyAnnotation;
import com.ssm.OaManager.utils.PageBean;

/**
 * 资产类别业务层实现类
 * 
 * @author Administrator
 * 
 */
@Service
public class AssetTypeServiceImpl implements AssetTypeService {

	@Resource
	private AssetTypeDao assetTypeDao;
	
	public void setAssetTypeDao(AssetTypeDao assetTypeDao) {
		this.assetTypeDao = assetTypeDao;
	}

	public AssetType findById(Serializable id) {
		AssetType assetType =  this.assetTypeDao.findById(id);
		if(assetType==null){
			assetType = new AssetType();
		}
		return assetType;
	}
	@MyAnnotation(methodNames = "redact")
	public int insert(AssetType entity) {
		return this.assetTypeDao.insert(entity);
	}
	@MyAnnotation(methodNames = "redact")
	public int update(AssetType entity) {
		return this.assetTypeDao.update(entity);
	}
	@MyAnnotation(methodNames = "redact")
	public int deleteById(Serializable id) {
			return this.assetTypeDao.deleteById(id);
	}
	@MyAnnotation(methodNames = "redact")
	public int delete(Serializable[] ids) {
			return this.assetTypeDao.delete(ids);
	}

	public List<AssetType> findAll() {
		 List<AssetType> assetType =  this.assetTypeDao.findAll();
		if(assetType==null){
			assetType = new  ArrayList<AssetType>();
		}
		return assetType;
	}


	public void findPageBean(PageBean<AssetType> pageBean) {
		// 获得总记录数
		Integer totalCount = this.assetTypeDao.findCount(pageBean);
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
		List<AssetType> datas = this.assetTypeDao.findByPage(pageBean);

		pageBean.setDatas(datas);

	}

}
