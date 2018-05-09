package com.ssm.OaManager.dao.system;

import java.io.Serializable;
import java.util.List;

import com.ssm.OaManager.dao.BaseDao;
import com.ssm.OaManager.entity.RuMiddle;
import com.ssm.OaManager.entity.User;

public interface UserDao extends BaseDao<User> {
	
			/**
			 * 根据账号密码查询一条记录
			 * @param userName
			 * @param userPass
			 * @return
			 */
			public User findByNp(User user);
			
			/**
			 * 根据激活码查询用户
			 * @param code
			 * @return
			 */
			public  User findByCode(String code);
			
			/**
			 * 根据邮箱查询用户
			 * @param code
			 * @return
			 */
			public  User findByEmail(User user);
			
			/**
			 * 注册用户
			 * @param code
			 * @return
			 */
			public  void insertUser(User user);
			
			/**
			 * 添加中间表数据
			 * @param ruMiddle
			 */
			public void inserRuMiddle(RuMiddle ruMiddle);

			/**
			 * 按id删除，删除一条；支持整数型和字符串类型ID
			 * @param entity
			 */
			public int deleteByUserId(Serializable id);	
			
			/**
			 * 根据部门查询用户
			 * @param code
			 * @return
			 */
			public  List<User> findByDeptId(User user);
}
