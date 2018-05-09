package com.ssm.OaManager.service.hrm.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ssm.OaManager.dao.hrm.EvectionDao;
import com.ssm.OaManager.entity.hrm.Evection;
import com.ssm.OaManager.service.hrm.EvectionService;
import com.ssm.OaManager.utils.MyAnnotation;

@Service
public class EvectionServiceImpl implements EvectionService {
    @Resource
	private EvectionDao evectionDao;
	
    @MyAnnotation(methodNames = "redact")
	public int deleteById(Integer id) {
		return evectionDao.deleteById(id);
	}
    
	public List<Evection> findAll() {
		return evectionDao.findAll();
	}
	public Evection findById(Integer id) {
		return evectionDao.findById(id);
	}
    @MyAnnotation(methodNames = "redact")
	public int insert(Evection entity) {
		return evectionDao.insert(entity);
	}
    
    @MyAnnotation(methodNames = "redact")
	public int update(Evection entity) {
		return evectionDao.update(entity);
	}

}
