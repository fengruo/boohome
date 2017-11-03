package com.bobo.service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.bobo.dao.MailDao;
import com.bobo.dao.UserinfoDao;
import com.bobo.entity.Mailto;
import com.bobo.service.MailService;
import com.bobo.service.UsualStrService;
import com.bobo.utils.MailUtils;
@Service //业务逻辑处理层 注解，规范  
@Scope("prototype")
public class MailServiceImpl implements MailService {
	@Autowired
	private MailDao mailDao;
	@Autowired
	private UsualStrService usualStrService;
	@Override
	public void sendMail(String email,String emailtitle, String emailMsg) {
		try {
			MailUtils.sendMail(email, emailtitle,   emailMsg);
		} catch (AddressException e) {
			e.printStackTrace();
		} catch (MessagingException e) {
			e.printStackTrace();
		}
	}

	@Override
	public String addMailto(Mailto mailto) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
	    Date date = null;
		try {
			date = sdf.parse(usualStrService.getDateFormatAll());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
		mailto.setZstate(0);
		mailto.setZsenddate(date);
		mailto.setZemailtitle(usualStrService.replaceStringByData(mailto.getZemailtitle()));
		mailto.setZemailtext(usualStrService.replaceStringByData(mailto.getZemailtext()));
		String flag=mailDao.insertMailto(mailto);
		if(flag==null||flag.length()==0){
			return "addfail";
		}
		return "addsuccess";
	}
	@Override
	public List<Mailto> queryEmilAll() {
		return mailDao.queryEmilAll();
	}
	@Override
	public List<Mailto> queryEmiltime(String currentDate) {
		List<Mailto> mailtoList=mailDao.queryEmiltime(currentDate);
		return mailtoList;
	}
	@Override
	public String upMailtoMailto(Mailto mailto) {
		// TODO Auto-generated method stub
		return mailDao.upMailto(mailto);
	}

	public MailDao getMailDao() {
		return mailDao;
	}

	public void setMailDao(MailDao mailDao) {
		this.mailDao = mailDao;
	}

	public UsualStrService getUsualStrService() {
		return usualStrService;
	}

	public void setUsualStrService(UsualStrService usualStrService) {
		this.usualStrService = usualStrService;
	}

	
	

	
	
}
