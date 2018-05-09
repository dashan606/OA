package com.ssm.OaManager.service.system;

import java.io.Serializable;
import java.util.List;

import com.ssm.OaManager.entity.RuMiddle;
import com.ssm.OaManager.entity.User;
import com.ssm.OaManager.utils.PageBean;
/**
 * 用户业务层实接口
 * @author Administrator
 *
 */
public interface UserService {
	
	/**只查询一个，常用于修改*/
	public User findById(Serializable id);	

	/**
	 * 插入，用实体作为参数
	 * @param entity
	 */
	public int insert(User entity);

	/**
	 * 注册用户
	 * @param code
	 * @return
	 */
	public  void insertUser(User user);
	
	/**
	 * 修改，用实体作为参数
	 * @param entity
	 */
	public int updateUser(User entity);	

	/**
	 * 按id删除，删除一条；支持整数型和字符串类型ID
	 * @param entity
	 */
	public int deleteById(Serializable id);	

	/**
	 * 批量删除；支持整数型和字符串类型ID
	 * @param entity
	 */
	public int delete(Serializable[] ids);			

	/**
	 * 查询全部
	 * @param entity
	 */
	public List<User> findAll();

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
	 * 根据邮箱查找用户
	 * 重置密码
	 * @param email
	 * @return
	 */
	public User findByEmail(User user);

	/**
	 * 设置分页对象属性
	 * @param pageBeapageBeann 分页对象
	 */
	public void findPageBean(PageBean<User> pageBean);
	
	/**
	 * 注册
	 * @param user
	 */
	public int save(User user);
	
	/**
	 * 添加中间表数据
	 * @param ruMiddle
	 */
	public int inserRuMiddle(RuMiddle ruMiddle,String[] roleIds);
	
	/**
	 * 根据部门查询用户
	 * @param code
	 * @return
	 */
	public  List<User> findByDeptId(User user);
}
