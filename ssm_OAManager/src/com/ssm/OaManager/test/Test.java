package com.ssm.OaManager.test;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ssm.OaManager.entity.Announcement;
import com.ssm.OaManager.service.system.AnnouncementService;

public class Test {

	@org.junit.Test
	public void findgameById() {
		ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
		AnnouncementService service = (AnnouncementService) ac
				.getBean("announcementServiceImpl");
		
		List<Announcement>  announcements = service.findByNewnotice();
		
		for(Announcement announcement:announcements){
			System.out.println(announcement.getAmConten());
		}
	}
} 
