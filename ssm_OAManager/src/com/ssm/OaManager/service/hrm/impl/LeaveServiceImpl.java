package com.ssm.OaManager.service.hrm.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ssm.OaManager.dao.hrm.LeaveDao;
import com.ssm.OaManager.entity.hrm.Leave;
import com.ssm.OaManager.service.hrm.LeaveService;
import com.ssm.OaManager.utils.MyAnnotation;

@Service
public class LeaveServiceImpl implements LeaveService {
    @Resource
    private LeaveDao leaveDao;
    
    @MyAnnotation(methodNames = "redact")
	public int deleteById(Integer id) {
		return leaveDao.deleteById(id);
	}

	public List<Leave> findAll() {
		return leaveDao.findAll();
	}
	public Leave findById(Integer id) {
		return leaveDao.findById(id);
	}
    @MyAnnotation(methodNames = "redact")
	public int insert(Leave entity) {
		return leaveDao.insert(entity);
	}
    @MyAnnotation(methodNames = "redact")
	public int update(Leave entity) {
		return leaveDao.update(entity);
	}

}
