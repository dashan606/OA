package com.ssm.OaManager.service.system.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ssm.OaManager.dao.system.MiddleDao;
import com.ssm.OaManager.dao.system.RoleDao;
import com.ssm.OaManager.entity.privilege.Function;
import com.ssm.OaManager.entity.privilege.Middle;
import com.ssm.OaManager.entity.privilege.Role;
import com.ssm.OaManager.service.system.RoleService;
import com.ssm.OaManager.utils.MyAnnotation;
import com.ssm.OaManager.utils.PageBean;

@Service
public class RoleServiceImpl implements RoleService {
	@Resource
	private RoleDao roleDao;
	
	@Resource
	private MiddleDao middleDao;

	public void setRoleDao(RoleDao roleDao) {
		this.roleDao = roleDao;
	}
	
	public void setMiddleDao(MiddleDao middleDao) {
		this.middleDao = middleDao;
	}

	public Role findById(Serializable id) {
		// TODO Auto-generated method stub
		Role role = this.roleDao.findById(id);
		if(role==null){
			role = new Role();
		}
		return role;
	}
	@MyAnnotation(methodNames = "redact")
	public int insert(Role entity,String[] funIds) {
		int num = this.roleDao.insert(entity);
		int maxId = this.roleDao.findByMaxId();
		
		Role role = new Role();
		
		role.setRoleId(maxId);
		
		if (funIds != null) {
			
			for (String funId : funIds) {
				
				Middle middle = new Middle();
				
				Function function = new Function();
				
				function.setFunId(Integer.valueOf(funId));
				
				middle.setRole(role);
				
				middle.setFunction(function);
				
				this.middleDao.insert(middle);
			}
		}
		return num;
	}
	@MyAnnotation(methodNames = "redact")
	public int updateRole(Role entity,String[] funIds) {
		this.middleDao.deleteByRoleId(new Serializable[] { entity.getRoleId() });
		
		if(funIds!=null){
			
			for (String funId : funIds) {
				
				Middle middle = new Middle();
				
				Function function = new Function();
				
				function.setFunId(Integer.valueOf(funId));
				
				middle.setRole(entity);
				
				middle.setFunction(function);
				
				this.middleDao.insert(middle);
			}
		}
		return this.roleDao.update(entity);
	}
	@MyAnnotation(methodNames = "redact")
	public int deleteById(Serializable id) {
		Serializable[] ids = new Serializable[]{ id };
		
		this.middleDao.deleteByRoleId(ids);
		
		return this.roleDao.deleteById(id);
	}
	@MyAnnotation(methodNames = "redact")
	public int delete(Serializable[] ids) {
		// TODO Auto-generated method stub
		return this.roleDao.delete(ids);
	}

	public List<Role> findAll() {
		// TODO Auto-generated method stub
		List<Role> role = this.roleDao.findAll();
		if(role==null){
			role = new ArrayList<Role>();
		}
		return role;
	}

	public void findPageBean(PageBean<Role> pageBean) {
		// TODO Auto-generated method stub
		// 获得总记录数
		Integer totalCount = this.roleDao.findCount(pageBean);
		// 设置入分页对象
		if(totalCount != null){
			pageBean.setTotalCount(totalCount);
		}
		//设置当前页
		if (pageBean.getCurrentPage() < 1) {
			pageBean.setCurrentPage(1);
		}
		//判断当前页
		if (pageBean.getCurrentPage() > pageBean.getTotalPage()) {
			pageBean.setCurrentPage(pageBean.getTotalPage());
		}
		pageBean.setFirstPage((pageBean.getCurrentPage()-1)*pageBean.getPageSize());
		
		// 获得分页数据
		List<Role> datas = this.roleDao.findByPage(pageBean);

		pageBean.setDatas(datas);
	}
}
