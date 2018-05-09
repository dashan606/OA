package com.ssm.OaManager.service.system.impl.accessory;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ssm.OaManager.dao.system.accessory.ReimTypeDao;
import com.ssm.OaManager.entity.accessory.ReimType;
import com.ssm.OaManager.service.system.accessory.ReimTypeService;

/**
 * 报销类型业务层
 * @author Administrator
 *
 */
@Service
public class ReimTypeServiceImpl implements ReimTypeService {

	private ReimTypeDao reimTypeDao;

	@Resource
	public void setReimTypeDaoo(ReimTypeDao reimTypeDaoo) {
		this.reimTypeDao = reimTypeDaoo;
	}

	/**
	 * 查询所有记录数
	 * @return
	 */
	public List<ReimType> findAll() {
		List<ReimType> reimType = reimTypeDao.findAll();
		if(reimType==null){
			reimType = new ArrayList<ReimType>();
		}
		return reimType;
	}
	
	
}
