package com.bobo.service;

import java.util.List;

import com.bobo.entity.Mailto;

public interface MailService {
	//发送一封邮件
	public void sendMail(String email,String emailtitle, String emailMsg);
	//插入一条预约邮件数据
	public String addMailto(Mailto mailto);
	//更新一条预约邮件数据
	public String upMailtoMailto(Mailto mailto);
	//查询全部
	public List<Mailto> queryEmilAll();
	//
	public List<Mailto> queryEmiltime(String currentDate);
}
