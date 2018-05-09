package com.ssm.OaManager.service.system.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ssm.OaManager.dao.system.FunctionDao;
import com.ssm.OaManager.dao.system.MiddleDao;
import com.ssm.OaManager.entity.privilege.Function;
import com.ssm.OaManager.service.system.FunctionService;
import com.ssm.OaManager.utils.MyAnnotation;
import com.ssm.OaManager.utils.PageBean;

@Service
public class FunctionServiceImpl implements FunctionService {
	@Resource
	private FunctionDao functionDao;
	
	@Resource
	private MiddleDao middleDao;

	public void setFunctionDao(FunctionDao functionDao) {
		this.functionDao = functionDao;
	}
	
	public void setMiddleDao(MiddleDao middleDao) {
		this.middleDao = middleDao;
	}

	public Function findById(Serializable id) {
		// TODO Auto-generated method stub
		Function function  = this.functionDao.findById(id);
		if(function==null){
			function = new Function();
		}
		return function;
	}
	@MyAnnotation(methodNames = "redact")
	public int insert(Function entity) {
		// TODO Auto-generated method stub
		return this.functionDao.insert(entity);
	}
	@MyAnnotation(methodNames = "redact")
	public int update(Function entity) {
		// TODO Auto-generated method stub
		return this.functionDao.update(entity);
	}
	@MyAnnotation(methodNames = "redact")
	public int deleteById(Serializable id) {
		this.middleDao.deleteByFunId(new Serializable[] { id });
		
		return this.functionDao.deleteById(id);
	}
	@MyAnnotation(methodNames = "redact")
	public int delete(Serializable[] ids) {
		// TODO Auto-generated method stub
		return this.functionDao.delete(ids);
	}

	public List<Function> findAll() {
		// TODO Auto-generated method stub\
		List<Function> function = this.functionDao.findAll();
		if(function==null){
			function = new ArrayList<Function>();
		}
		return function;
	}

	public void findPageBean(PageBean<Function> pageBean) {
		// TODO Auto-generated method stub
		//获得记录数
		Integer totalCount = this.functionDao.findCount(pageBean);
		//设置入分页对象
		if(totalCount != null){
			pageBean.setTotalCount(totalCount);
		}
		//设置当前页
		if(pageBean.getCurrentPage() < 1){
			pageBean.setCurrentPage(1);
		}
		//判断当前页
		if(pageBean.getCurrentPage() > pageBean.getTotalPage()){
			pageBean.setCurrentPage(pageBean.getTotalPage());
		}
		
		pageBean.setFirstPage((pageBean.getCurrentPage()-1)*pageBean.getPageSize());
		// 获得分页数据
		List<Function> datas = this.functionDao.findByPage(pageBean);

		pageBean.setDatas(datas);

	}

	public int findFunction(Function entity) {
		return this.functionDao.update(entity);
	}

}
