package com.ssm.OaManager.dao.system.impl.official;

import org.springframework.stereotype.Repository;

import com.ssm.OaManager.dao.impl.BaseDaoImpl;
import com.ssm.OaManager.dao.system.official.TestDao;
import com.ssm.OaManager.entity.Test;

@Repository
public class TestDaoImpl extends BaseDaoImpl<Test> implements TestDao {

	public void add(Test t) {
		this.getSqlSession().insert(Test.class.getName()+".insert", t);
	}

	public Test findById(Test t) {
		return this.getSqlSession().selectOne(Test.class.getName()+".findById", t);
	}

}
