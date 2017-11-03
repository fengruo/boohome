package com.bobo.listener;

import java.text.SimpleDateFormat;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
@Service //业务逻辑处理层 注解，规范  
@Scope("prototype")
public class BirthdayListener implements ServletContextListener{

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		
	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		//当web应用启动 开启任务调动---功能在用户的生日当前发送邮件
		//开启一个定时器
		Timer timer = new Timer();
		timer.scheduleAtFixedRate(new TimerTask() {
			@Override
			public void run() {
				// 为当前的生日的用户发邮件
				//1、获得今天过生日的人
				//获得今天的日期
				SimpleDateFormat format = new SimpleDateFormat("MM-dd");
				String currentDate = format.format(new Date());
				//2、发邮件
				System.out.println("123");
			}
		},1000, 1000*60*60*24);
		//实际开发中起始时间是一个固定的时间
	}
	
}
