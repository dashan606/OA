package com.ssm.OaManager.service.fixedAsset.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ssm.OaManager.dao.fixedAsset.AssetDao;
import com.ssm.OaManager.entity.fixedAsset.Asset;
import com.ssm.OaManager.service.fixedAsset.AssetService;
import com.ssm.OaManager.utils.MyAnnotation;
import com.ssm.OaManager.utils.PageBean;

/**
 * 固定资产业务层实现类
 * 
 * @author Administrator
 * 
 */
@Service
public class AssetServiceImpl implements AssetService {

	@Resource
	private AssetDao assetDao;

	public void setAssetDao(AssetDao assetDao) {
		this.assetDao = assetDao;
	}

	public Asset findById(Serializable id) {
		Asset asset = this.assetDao.findById(id);
		if(asset==null){
			asset = new Asset();
		}
		return asset;
	}
	@MyAnnotation(methodNames = "redact")
	public int insert(Asset entity) {
		return this.assetDao.insert(entity);
	}
	@MyAnnotation(methodNames = "redact")
	public int update(Asset entity) {
		return this.assetDao.update(entity);
	}
	@MyAnnotation(methodNames = "redact")
	public int deleteById(Serializable id) {
			return this.assetDao.deleteById(id);
	}
	@MyAnnotation(methodNames = "redact")
	public int delete(Serializable[] ids) {
			return this.assetDao.delete(ids);
	}

	public List<Asset> findAll() {
		List<Asset> asset = this.assetDao.findAll();
		if(asset==null){
			asset = new ArrayList<Asset>();
		}
		return asset;
	}


	public void findPageBean(PageBean<Asset> pageBean) {
		// 获得总记录数
		Integer totalCount = this.assetDao.findCount(pageBean);
		// 设置入分页对象
		if (totalCount != null) {
			pageBean.setTotalCount(totalCount);
		}
		if (pageBean.getCurrentPage() < 1) {
			pageBean.setCurrentPage(1);
		}

		if (pageBean.getCurrentPage() > pageBean.getTotalPage()&&pageBean.getTotalPage()!=0) {
			pageBean.setCurrentPage(pageBean.getTotalPage());
		}
		pageBean.setFirstPage((pageBean.getCurrentPage()-1)*pageBean.getPageSize());
		// 获得分页数据
		List<Asset> datas = this.assetDao.findByPage(pageBean);

		pageBean.setDatas(datas);

	}

}
