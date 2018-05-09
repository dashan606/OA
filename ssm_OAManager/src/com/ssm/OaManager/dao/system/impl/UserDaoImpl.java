package com.ssm.OaManager.dao.system.impl;

import java.io.Serializable;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.ssm.OaManager.dao.impl.BaseDaoImpl;
import com.ssm.OaManager.dao.system.UserDao;
import com.ssm.OaManager.entity.RuMiddle;
import com.ssm.OaManager.entity.User;

/**
 * 用户dao层实现类
 * 
 * @author Administrator
 * 
 */
@Repository
public class UserDaoImpl extends BaseDaoImpl<User> implements UserDao {

	// 利用默认构造方法初始化命名空间
	public UserDaoImpl() {
		super.setNs(User.class.getName());
	}

	public User findByNp(User user) {
		return this.getSqlSession().selectOne(
				User.class.getName() + ".findByNp", user);
	}

	public User findByCode(String code) {
		List<User> users = this.getSqlSession().selectList(
				User.class.getName() + ".findByCode", code);
		if (users != null && users.size() > 0) {
			return users.get(0);
		}
		return null;
	}

	public User findByEmail(User user) {
		return this.getSqlSession().selectOne(
				User.class.getName() + ".findByEmail", user);
	}

	public void insertUser(User user) {
		this.getSqlSession().insert(User.class.getName()+".insertUser",user);
	}

	public void inserRuMiddle(RuMiddle ruMiddle) {
		this.getSqlSession().insert(User.class.getName()+".inserRuMiddle",ruMiddle);
	}

	public int deleteByUserId(Serializable id) {
		return 	this.getSqlSession().delete(User.class.getName()+".deleteByUserId", id);
	}

	public  List<User> findByDeptId(User user) {
		 List<User> users=  this.getSqlSession().selectList(
					User.class.getName() + ".findByDeptId", user);
		return users;
	}

}
