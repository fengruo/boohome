package com.bobo.listener;

import javax.servlet.ServletContextEvent;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.WebApplicationContextUtils;

public class ContextLoaderListenerOverWrite extends ContextLoaderListener{
	//private BirthdayListener birthdayListener;  
   // private EmailListener emailListener; 
	public void contextInitialized(ServletContextEvent event) {  
        super.contextInitialized(event);  
        ApplicationContext applicationContext = WebApplicationContextUtils.getWebApplicationContext(event.getServletContext());  
        //获取bean  
       // emailListener = (EmailListener) applicationContext.getBean("emailListener");  
      //  birthdayListener = (BirthdayListener) applicationContext.getBean("birthdayListener");   
        /* 
         具体地业务代码 
         */  
      //  emailListener.contextInitialized(event);
       // birthdayListener.contextInitialized(event);
    }  
}
