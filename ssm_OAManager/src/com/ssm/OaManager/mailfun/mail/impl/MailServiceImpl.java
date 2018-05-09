package com.ssm.OaManager.mailfun.mail.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ssm.OaManager.dao.mail.MailDao;
import com.ssm.OaManager.entity.mail.Mail;
import com.ssm.OaManager.mailfun.mail.MailService;
import com.ssm.OaManager.utils.MyAnnotation;
import com.ssm.OaManager.utils.PageBean;

@Service
public class MailServiceImpl implements MailService {
	
	@Resource
	private MailDao dao;
	public List<Mail> findByPage(PageBean<Mail> pageBean) {
		List<Mail> mail =dao.findByPage(pageBean);
		if(mail==null){
			mail = new ArrayList<Mail>();
		}
		return mail;
		// TODO Auto-generated method stub
	}
	public Mail findById(Serializable id) {
		Mail mail =dao.findById(id);
		if(mail==null){
			mail = new Mail();
		}
		return mail;
		// TODO Auto-generated method stub
	}
	@MyAnnotation(methodNames = "redact")
	public int insert(Mail entity) {
		// TODO Auto-generated method stub
		return dao.insert(entity);
	}
	@MyAnnotation(methodNames = "redact")
	public int update(Mail entity) {
		// TODO Auto-generated method stub
		return dao.update(entity);
	}
	@MyAnnotation(methodNames = "redact")
	public int deleteById(Serializable id) {
		// TODO Auto-generated method stub
		return dao.deleteById(id);
	}
	@MyAnnotation(methodNames = "redact")
	public int delete(Serializable[] ids) {
		// TODO Auto-generated method stub
		return dao.delete(ids);
	}
	public List<Mail> findAll() {
		List<Mail> mail =dao.findAll();
		if(mail==null){
			mail = new ArrayList<Mail>();
		}
		return mail;
	}
	public int findCount(PageBean<Mail> pageBean) {
		// TODO Auto-generated method stub
		return dao.findCount(pageBean);
	}
	public List<Mail> findPart(Mail mail) {
		List<Mail> mail1 =dao.findPart(mail);
		if(mail1==null){
			mail1 = new ArrayList<Mail>();
		}
		return mail1;
	}

}
