package com.ssm.OaManager.service.system.impl.accessory;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ssm.OaManager.dao.system.accessory.ReimburseDao;
import com.ssm.OaManager.entity.accessory.Reimburse;
import com.ssm.OaManager.service.system.accessory.ReimburseService;
import com.ssm.OaManager.utils.MyAnnotation;
import com.ssm.OaManager.utils.PageBean;

/**
 * 报销业务层
 * @author Administrator
 *
 */
@Service
public class ReimburseServiceImpl implements ReimburseService {

	private ReimburseDao reimburseDao;

	@Resource
	public void setReimburseDao(ReimburseDao reimburseDao) {
		this.reimburseDao = reimburseDao;
	}

	/**
	 * 获取所有记录数
	 * @return
	 */
	public List<Reimburse> findAll() {
		List<Reimburse> reimburse = reimburseDao.findAll();
		if(reimburse==null){
			reimburse = new ArrayList<Reimburse>();
		}
		return reimburse;
	}
	/**
	 * 分页查询
	 * @param pageBean
	 * @return
	 */
	public List<Reimburse> findByPage(PageBean<Reimburse> pageBean) {
		List<Reimburse> reimburse = reimburseDao.findByPage(pageBean);
		if(reimburse==null){
			reimburse = new ArrayList<Reimburse>();
		}
		return reimburse;
	}

	/**
	 * 添加
	 * @param reimburse
	 */
	@MyAnnotation(methodNames = "buildWord")
	public Integer add(Reimburse reimburse) {
		reimburseDao.insertAndGetId(reimburse);
		
		return 1;
	}

	/**
	 * 查找
	 * @param reimburse
	 * @return
	 */
	public Reimburse findByReimburse(Reimburse reimburse) {
		Reimburse reimburse1 = reimburseDao.findByReimburse(reimburse);
		if(reimburse1==null){
			reimburse1 =  new Reimburse();
		}
		return reimburse;
	}
	
	
}
