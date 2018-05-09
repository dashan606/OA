package com.ssm.OaManager.dao.system;

import java.util.List;
import java.util.Map;

import com.ssm.OaManager.dao.BaseDao;
import com.ssm.OaManager.entity.Schedule;

public interface ScheduleDao extends BaseDao<Schedule> {

	/**
	 * 条件查询全部
	 * @param map
	 * @return
	 */
	public List<Schedule> findByUserAll(Map<String,Object> map);

}
