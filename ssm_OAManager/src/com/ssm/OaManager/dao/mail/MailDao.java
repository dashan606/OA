package com.ssm.OaManager.dao.mail;

import java.util.List;

import com.ssm.OaManager.dao.BaseDao;
import com.ssm.OaManager.entity.mail.Mail;

public interface MailDao extends BaseDao<Mail> {
        
	  /**
	   * 查询部分数据
	   */
	   public List<Mail> findPart(Mail mail);
		
}
