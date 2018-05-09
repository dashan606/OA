package com.ssm.OaManager.dao.mail.impl;

import java.io.Serializable;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.ssm.OaManager.dao.impl.BaseDaoImpl;
import com.ssm.OaManager.dao.mail.MailDao;
import com.ssm.OaManager.entity.User;
import com.ssm.OaManager.entity.mail.Mail;
import com.ssm.OaManager.utils.PageBean;

@Repository
public class MailDaoImpl extends BaseDaoImpl<Mail> implements MailDao {

	        //利用默认构造方法初始化命名空间
			public MailDaoImpl() {
				super.setNs(Mail.class.getName());
			}
    
			
			
			//查询部分数据
			public List<Mail> findPart(Mail mail) {
				List<Mail> list = null;
				list=this.getSqlSession().selectList(Mail.class.getName()+".findPart",mail);
				return list;
			}
}
