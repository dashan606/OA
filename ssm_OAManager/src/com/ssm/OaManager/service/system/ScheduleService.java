package com.ssm.OaManager.service.system;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.ssm.OaManager.entity.Schedule;
/**
 * 用户业务层实接口
 * @author Administrator
 *
 */
public interface ScheduleService {

	/**只查询一个，常用于修改*/
	public Schedule findById(Serializable id);	

	/**
	 * 插入，用实体作为参数
	 * @param entity
	 */
	public int insert(Schedule entity);
	
	/**
	 * 修改，用实体作为参数
	 * @param entity
	 */
	public int update(Schedule entity);	

	/**
	 * 按id删除，删除一条；支持整数型和字符串类型ID
	 * @param entity
	 */
	public int deleteById(Serializable id);	

	/**
	 * 查询全部
	 * @param entity
	 */
	public List<Schedule> findAll();

	/**
	 * 条件查询全部
	 * @param map
	 * @return
	 */
	public List<Schedule> findByUserAll(Map<String,Object> map);
	
}
