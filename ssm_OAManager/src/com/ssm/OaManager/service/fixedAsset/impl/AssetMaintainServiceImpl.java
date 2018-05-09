package com.ssm.OaManager.service.fixedAsset.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ssm.OaManager.dao.fixedAsset.AssetMaintainDao;
import com.ssm.OaManager.entity.fixedAsset.AssetMaintain;
import com.ssm.OaManager.service.fixedAsset.AssetMaintainService;
import com.ssm.OaManager.utils.MyAnnotation;
import com.ssm.OaManager.utils.PageBean;

/**
 * 固定资产维护业务层实现类
 * 
 * @author Administrator
 * 
 */
@Service
public class AssetMaintainServiceImpl implements AssetMaintainService {

	@Resource
	private AssetMaintainDao assetMaintainDao;


	public void setAssetMaintainDao(AssetMaintainDao assetMaintainDao) {
		this.assetMaintainDao = assetMaintainDao;
	}
	@MyAnnotation(methodNames = "redact")
	public int insert(AssetMaintain entity) {
		return this.assetMaintainDao.insert(entity);
	}
	@MyAnnotation(methodNames = "redact")
	public int update(AssetMaintain entity) {
		return this.assetMaintainDao.update(entity);
	}
	@MyAnnotation(methodNames = "redact")
	public int deleteById(Serializable id) {
			return this.assetMaintainDao.deleteById(id);
	}
	@MyAnnotation(methodNames = "redact")
	public int delete(Serializable[] ids) {
			return this.assetMaintainDao.delete(ids);
	}

	public List<AssetMaintain> findAll() {
		List<AssetMaintain>  assetMaintain = this.assetMaintainDao.findAll();
		if(assetMaintain==null){
			assetMaintain = new ArrayList<AssetMaintain>();
		}
		return assetMaintain;
	}

	public void findPageBean(PageBean<AssetMaintain> pageBean) {
		// 获得总记录数
		Integer totalCount = this.assetMaintainDao.findCount(pageBean);
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
		List<AssetMaintain> datas = this.assetMaintainDao.findByPage(pageBean);

		pageBean.setDatas(datas);

	}

	public AssetMaintain findById(Serializable id) {
		AssetMaintain  assetMaintain = this.assetMaintainDao.findById(id);
		if(assetMaintain==null){
			assetMaintain = new AssetMaintain();
		}
		return assetMaintain;
	}

}
