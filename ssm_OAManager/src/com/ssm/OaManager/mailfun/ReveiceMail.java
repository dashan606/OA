package com.ssm.OaManager.mailfun;

import java.util.Properties;

import javax.mail.Folder;
import javax.mail.MessagingException;
import javax.mail.NoSuchProviderException;
import javax.mail.Session;
import javax.mail.Store;

import com.ssm.OaManager.entity.mail.UserAuthenticator;
import com.ssm.OaManager.utils.MailUtil;

public class ReveiceMail {
       
	private Session session = null;
	private Store store = null;
	private Folder folder = null;
	
	
	//连接POP3服务器
	public Folder connectPOP3(UserAuthenticator userAuth,String keyword) throws MessagingException{
		 
	    //获得POP3服务
		Properties props = MailUtil.getProps(userAuth.getMailAddr(),"POP3");
		//创建服务环境
		Session session =Session.getInstance(props);
		session.setDebug(true);
		
		// 利用Session对象获得Store对象，并连接pop3服务器  
		if(userAuth.getMailAddr().split("@")[1].startsWith("163")){
		 store = session.getStore("pop3");	
		}
		if(userAuth.getMailAddr().split("@")[1].startsWith("qq")){
		 store = session.getStore();	
		}   
        store.connect(userAuth.getMailAddr(),userAuth.getMailPass());
        
        Folder folder = null;
		
        // 获得邮箱内的邮件夹Folder对象，以"读-写"打开  
        folder = store.getFolder("INBOX");  
        
        return folder;
	}
	
	
	
	//关闭收件箱
	public void closeStore() throws MessagingException{
		
		if(store != null){
         
		    store.close();
	      }
}
	
	
}
