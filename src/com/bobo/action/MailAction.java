package com.bobo.action;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.bobo.dao.MailDao;
import com.bobo.entity.Mailto;
import com.bobo.service.MailService;
import com.bobo.service.UsualStrService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.opensymphony.xwork2.ActionSupport;

@Controller               //默认就是类的首字母小写
@Scope("prototype") 
public class MailAction extends ActionSupport{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Autowired
	private UsualStrService usualStrService;
	@Autowired
	private MailService mailService;
	private Mailto mailto;
	private InputStream textStream;
	public UsualStrService getUsualStrService() {
		return usualStrService;
	}
	public void setUsualStrService(UsualStrService usualStrService) {
		this.usualStrService = usualStrService;
	}
	public MailService getMailService() {
		return mailService;
	}
	public void setMailService(MailService mailService) {
		this.mailService = mailService;
	}
	public String testFun(){
		//email 接收地址 sendMailUrl 发送者邮箱emailtitle 摘要     emailMsg内容 
		//mailService.sendMail("1223424265@qq.com","可爱的你","可爱的你可爱的你可爱的你可爱的你可爱的你");
		try{
			Gson gson = new GsonBuilder().create();
	        String json=gson.toJson(mailService.queryEmilAll());
			/*SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");
			String currentDate = format.format(new Date());
			//2、发邮件
			List<Mailto> mailtoList=mailDao.queryEmiltime(currentDate);
			 String json=gson.toJson(mailtoList);*/
	        //System.out.println(json);
			textStream=new ByteArrayInputStream(json.toString().getBytes("utf-8"));
	} catch (Exception e) {
		e.printStackTrace();
	}
	return SUCCESS;
	}
	public String addEmailto(){
		return mailService.addMailto(mailto);
	}
	public Mailto getMailto() {
		return mailto;
	}
	public void setMailto(Mailto mailto) {
		this.mailto = mailto;
	}
	public InputStream getTextStream() {
		return textStream;
	}
	public void setTextStream(InputStream textStream) {
		this.textStream = textStream;
	}
	
}
