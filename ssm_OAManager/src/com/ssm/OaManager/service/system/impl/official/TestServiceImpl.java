package com.ssm.OaManager.service.system.impl.official;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ssm.OaManager.dao.system.official.TestDao;
import com.ssm.OaManager.entity.Test;
import com.ssm.OaManager.service.system.official.TestService;
import com.ssm.OaManager.utils.MyAnnotation;

@Service
public class TestServiceImpl implements TestService {

	@Resource
	private TestDao testDao;
	@MyAnnotation(methodNames = "redact")
	public void add(Test t) {
		testDao.add(t);
	}
	public Test findById(Test t) {
		return testDao.findById(t);
	}
}
