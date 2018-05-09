package com.ssm.OaManager.mailfun.mail;

import java.io.Serializable;
import java.util.List;

import com.ssm.OaManager.entity.mail.Mail;
import com.ssm.OaManager.utils.PageBean;

public interface MailService {
        
	/**带条件分页查询，条件可以为null，既没有条件；返回list对象集合*/
	public List<Mail> findByPage(PageBean<Mail> pageBean);	
	
	/**只查询一个，常用于修改*/
	public Mail findById(Serializable id);	
	
	/**
	 * 插入，用实体作为参数
	 * @param entity
	 */
	public int insert(Mail entity);
	
	/**
	 * 修改，用实体作为参数
	 * @param entity
	 */
	public int update(Mail entity);	
	
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
	public List<Mail> findAll();
	
	/**
	 * 查询记录数
	 * @param entity
	 */
	public int findCount(PageBean<Mail> pageBean);
	
	
	  /**
	   * 查询部分数据
	   */
	   public List<Mail> findPart(Mail mail);
}
