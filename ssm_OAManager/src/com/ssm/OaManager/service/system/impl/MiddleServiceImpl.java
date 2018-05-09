package com.ssm.OaManager.service.system.impl;

import java.io.Serializable;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ssm.OaManager.dao.system.MiddleDao;
import com.ssm.OaManager.entity.privilege.Middle;
import com.ssm.OaManager.service.system.MiddleService;
import com.ssm.OaManager.utils.MyAnnotation;
@Service
public class MiddleServiceImpl implements MiddleService {
	@Resource
	private MiddleDao middleDao;
	@MyAnnotation(methodNames = "redact")
	public int insert(Middle entity) {
		// TODO Auto-generated method stub
		return this.middleDao.insert(entity);
	}
	
	public Middle findByRoleId(Serializable id) {
		// TODO Auto-generated method stub
		return this.middleDao.findByRoleId(id);
	}
	
	public Middle findByFunId(Serializable id) {
		// TODO Auto-generated method stub
		return this.middleDao.findByFunId(id);
	}
	@MyAnnotation(methodNames = "redact")
	public int deleteByRoleId(Serializable[] ids) {
		// TODO Auto-generated method stub
		return this.middleDao.deleteByRoleId(ids);
	}
	@MyAnnotation(methodNames = "redact")
	public int deleteByFunId(Serializable[] ids) {
		// TODO Auto-generated method stub
		return this.middleDao.deleteByFunId(ids);
	}

	public List<Middle> findAll() {
		// TODO Auto-generated method stub
		return this.middleDao.findAll();
	}

}
