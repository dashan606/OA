package com.ssm.OaManager.service.hrm.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ssm.OaManager.dao.hrm.EmployeeDao;
import com.ssm.OaManager.dao.hrm.PositionDao;
import com.ssm.OaManager.entity.hrm.Employee;
import com.ssm.OaManager.entity.hrm.Position;
import com.ssm.OaManager.service.hrm.PositionService;
import com.ssm.OaManager.utils.MyAnnotation;
import com.ssm.OaManager.utils.PageBean;


@Service
public class PositionServiceImpl implements PositionService {

	@Resource
	private PositionDao positiondao;
	
	@Resource
	private EmployeeDao employeeDao;
	//分页查询所有
	public List<Position> findAll() {
		return this.positiondao.findAll();
	}

	//修改
	@MyAnnotation(methodNames = "redact")
	public int updateById(Position position) {
		
		return this.positiondao.update(position);
	}

	// 删除
	@MyAnnotation(methodNames = "redact")
	public int deleteById(int id) {
		Position pos = new Position();
		pos.setPosId(id);
		List<Employee> emps =employeeDao.findAllByPos(pos);
		int num = -2;
		if(emps.isEmpty()){
			num = this.positiondao.deleteById(id);
		}
		return num;
	}

	//添加一条记录
	@MyAnnotation(methodNames = "redact")
	public int insert(Position entity) {

		return this.positiondao.insert(entity);
		}

	//设置分页对象属性
	public void findPageBean(PageBean<Position> pageBean) { 
		Integer totalCount = positiondao.findCount(pageBean);
		pageBean.setCurrentPage(totalCount);//封装总记录数
		
		//设置分页对象
		if (totalCount != null) {
			pageBean.setTotalCount(totalCount);
		}
		if (pageBean.getCurrentPage() < 1) {
			pageBean.setCurrentPage(1);
		}

		if (pageBean.getCurrentPage() > pageBean.getTotalPage()) {
			pageBean.setCurrentPage(pageBean.getTotalPage());
		}
		pageBean.setFirstPage((pageBean.getCurrentPage()-1)*pageBean.getPageSize());
		// 获得分页数据
		List<Position> datas = this.positiondao.findByPage(pageBean);

		pageBean.setDatas(datas);
		
	}
	public Position findById(int id) {
		return this.positiondao.findById(id);
	}


	

}
