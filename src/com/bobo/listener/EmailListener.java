package com.bobo.listener;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.bobo.dao.MailDao;
import com.bobo.entity.Mailto;
import com.bobo.service.MailService;
import com.bobo.service.UsualStrService;
import com.bobo.utils.MailUtils;
@Service //业务逻辑处理层 注解，规范  
@Scope("prototype")
public class EmailListener implements ServletContextListener{
	@Autowired
	private MailService mailService;
	@Autowired
	private UsualStrService usualStrService;
	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		//当web应用启动 开启任务调动---功能在用户的生日当前发送邮件
				//开启一个定时器
				Timer timer = new Timer();
				timer.scheduleAtFixedRate(new TimerTask() {
					@Override
					public void run() {
						// 为当前的符合条件的用户发邮件
						//1、获得这分钟内需要发送邮件的人
						//获得今天的日期
						SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");
						String currentDate = format.format(new Date());
						//2、发邮件
						List<Mailto> mailtoList=mailService.queryEmiltime(currentDate);
						if(mailtoList!=null&&mailtoList.size()>0){
							for (Mailto mailto : mailtoList) {
								try {
									mailto.setZid(mailto.getZid());
									mailto.setZstate(1);
									mailService.upMailtoMailto(mailto);
									MailUtils.sendMail(mailto.getZemail(), mailto.getZemailtitle(), mailto.getZemailtext());
								} catch (AddressException e) {
									e.printStackTrace();
								} catch (MessagingException e) {
									e.printStackTrace();
								}
							}
						}else{
							System.out.println("现在没有邮件发送");
						}
					}
				},1000, 1000*60);
				//实际开发中起始时间是一个固定的时间
	}


	public MailService getMailService() {
		return mailService;
	}

	public void setMailService(MailService mailService) {
		this.mailService = mailService;
	}

	public UsualStrService getUsualStrService() {
		return usualStrService;
	}

	public void setUsualStrService(UsualStrService usualStrService) {
		this.usualStrService = usualStrService;
	}
	
}
