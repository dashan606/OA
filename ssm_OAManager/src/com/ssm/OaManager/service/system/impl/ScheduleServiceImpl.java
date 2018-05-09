package com.ssm.OaManager.service.system.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ssm.OaManager.dao.system.ScheduleDao;
import com.ssm.OaManager.entity.Schedule;
import com.ssm.OaManager.service.system.ScheduleService;
import com.ssm.OaManager.utils.MyAnnotation;

@Service
public class ScheduleServiceImpl implements ScheduleService {
	@Resource
	private ScheduleDao scheduleDao;

	public void setScheduleDao(ScheduleDao scheduleDao) {
		this.scheduleDao = scheduleDao;
	}

	@MyAnnotation(methodNames = "mySchedule")
	public Schedule findById(Serializable id) {
		Schedule schedule = this.scheduleDao.findById(id);
		if (schedule == null) {
			schedule = new Schedule();
		}
		return schedule;
	}

	@MyAnnotation(methodNames = "mySchedule")
	public int insert(Schedule entity) {
		return this.scheduleDao.insert(entity);
	}

	@MyAnnotation(methodNames = "mySchedule")
	public int update(Schedule entity) {
		return this.scheduleDao.update(entity);
	}

	@MyAnnotation(methodNames = "mySchedule")
	public int deleteById(Serializable id) {
		return this.scheduleDao.deleteById(id);
	}

	@MyAnnotation(methodNames = "mySchedule")
	public List<Schedule> findAll() {
		List<Schedule> schedule = this.scheduleDao.findAll();
		if (schedule == null) {
			schedule = new ArrayList<Schedule>();
		}
		return schedule;
	}

	@MyAnnotation(methodNames = "mySchedule")
	public List<Schedule> findByUserAll(Map<String, Object> map) {
		List<Schedule> schedule = this.scheduleDao.findByUserAll(map);
		if (schedule == null) {
			schedule = new ArrayList<Schedule>();
		}
		return schedule;

	}

}
