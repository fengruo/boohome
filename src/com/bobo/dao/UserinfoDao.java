package com.bobo.dao;

import java.util.List;

import com.bobo.entity.UserInfo;


public interface UserinfoDao {
	//查询全部
	public List<UserInfo> queryUserinfo();
	//按分页查询
	public List<UserInfo> queryUserinfo(Integer page,Integer rows);
	//查询总条数
	public Integer queryUserinfoRows();
	//新增以及修改用户
	public String rowSave(UserInfo userInfo);
	//删除
	public String rowDel(UserInfo userInfo);
	
}
