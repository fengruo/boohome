package com.bobo.service;

import java.util.List;

import com.bobo.entity.UserInfo;


public interface UserinfoActionService {
	public String toLogin();
	//查询学生信息
	public List<UserInfo> queryUserinfoAll();
	//分页查询学生信息
	public List<UserInfo> queryUserinfo(Integer page,Integer rows);
	//查询学生信息总条数
	public Integer queryUserinfoRows();
	//新增或修改用户
	public String rowSave(UserInfo userInfo);
	//删除用户
	public Boolean rowDel(UserInfo userInfo);
}
