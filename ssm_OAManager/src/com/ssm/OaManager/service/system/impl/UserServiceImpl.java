package com.ssm.OaManager.service.system.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ssm.OaManager.dao.system.UserDao;
import com.ssm.OaManager.entity.RuMiddle;
import com.ssm.OaManager.entity.User;
import com.ssm.OaManager.entity.privilege.Role;
import com.ssm.OaManager.service.system.UserService;
import com.ssm.OaManager.utils.MailUitls;
import com.ssm.OaManager.utils.MyAnnotation;
import com.ssm.OaManager.utils.PageBean;
import com.ssm.OaManager.utils.UUIDUtils;

/**
 * 用户业务层实现类
 * 
 * @author Administrator
 * 
 */
@Service
public class UserServiceImpl implements UserService {

	@Resource
	private UserDao userDao;

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	public User findById(Serializable id) {
		User user = this.userDao.findById(id);
		if (user == null) {
			user = new User();
		}
		return user;
	}

	@MyAnnotation(methodNames = "redact")
	public int insert(User entity) {
		return this.userDao.insert(entity);
	}

	@MyAnnotation(methodNames = "redact")
	public int updateUser(User entity) {
		return this.userDao.update(entity);
	}

	@MyAnnotation(methodNames = "redact")
	public int deleteById(Serializable id) {
		return this.userDao.deleteById(id);
	}

	@MyAnnotation(methodNames = "redact")
	public int delete(Serializable[] ids) {
		return this.userDao.delete(ids);
	}

	// 业务层完成用户注册代码:
	@MyAnnotation(methodNames = "redact")
	public int save(User user) {
		// 将数据存入到数据库
		user.setState(0); // 0:代表用户未激活. 1:代表用户已经激活.
		String code = UUIDUtils.getUUID() + UUIDUtils.getUUID();
		user.setCode(code);
		this.userDao.insertUser(user);
		// 默认设置普通用户
		RuMiddle ruMiddle = new RuMiddle();
		ruMiddle.setUser(user);
		Role role = new Role();
		role.setRoleId(2);
		ruMiddle.setRole(role);
		this.userDao.inserRuMiddle(ruMiddle);

		// 发送激活邮件;
		MailUitls mailUitls = new MailUitls();
		mailUitls.sendMail(user.getUserEmail(), code);
		return 1;
	}

	// 根据激活码查询用户

	public User findByCode(String code) {
		return this.userDao.findByCode(code);

	}


	public List<User> findAll() {
		List<User> user = this.userDao.findAll();
		if (user == null) {
			user = new ArrayList<User>();
		}
		return user;
	}


	public User findByEmail(User user) {
		return this.userDao.findByEmail(user);
	}


	public User findByNp(User user) {
		return this.userDao.findByNp(user);
	}


	public void findPageBean(PageBean<User> pageBean) {
		// 获得总记录数
		Integer totalCount = this.userDao.findCount(pageBean);
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
		pageBean.getParaMap().put("firstPage",
				(pageBean.getCurrentPage() - 1) * pageBean.getPageSize());
		pageBean.getParaMap().put("lastPage",
				pageBean.getCurrentPage() * pageBean.getPageSize());

		// 获得分页数据
		List<User> datas = this.userDao.findByPage(pageBean);

		pageBean.setDatas(datas);

	}

	@MyAnnotation(methodNames = "redact")
	public void insertUser(User user) {
		this.userDao.insertUser(user);
	}

	@MyAnnotation(methodNames = "impower")
	public int inserRuMiddle(RuMiddle ruMiddle, String[] roleIds) {
		this.userDao.deleteByUserId(ruMiddle.getUser().getUserId());
		for (String roleId : roleIds) {
			Role role = new Role();
			role.setRoleId(Integer.valueOf(roleId));
			ruMiddle.setRole(role);
			this.userDao.inserRuMiddle(ruMiddle);
		}
		return 1;

	}

	public List<User> findByDeptId(User user) {
		return this.userDao.findByDeptId(user);
	}

}
