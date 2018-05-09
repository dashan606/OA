package com.ssm.OaManager.dao.system.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.ssm.OaManager.dao.impl.BaseDaoImpl;
import com.ssm.OaManager.dao.system.ScheduleDao;
import com.ssm.OaManager.entity.Schedule;

@Repository
public class ScheduleDaoImpl extends BaseDaoImpl<Schedule> implements
		ScheduleDao {

	public ScheduleDaoImpl() {
		super.setNs(Schedule.class.getName());
	}

	public List<Schedule> findByUserAll(Map<String, Object> map) {
		List<Schedule> oList = this.getSqlSession().selectList(
				Schedule.class.getName() + ".findByUserAll", map);
		return oList;
	}

}
