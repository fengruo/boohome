package com.bobo.dao;

import java.util.List;

import com.bobo.entity.Mailto;

public interface MailDao {
	//插入一条预约邮件数据
	public String insertMailto(Mailto mailto);
	//更新一条预约邮件数据
	public String upMailto(Mailto mailto);
	//根据时间模糊查询出符合条件的emil集合
	public List<Mailto> queryEmiltime(String liketime);
	//查询全部
	public List<Mailto> queryEmilAll();
}
