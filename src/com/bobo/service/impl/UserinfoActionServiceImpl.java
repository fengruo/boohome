package com.bobo.service.impl;

import java.util.List;

import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.bobo.dao.UserinfoDao;
import com.bobo.entity.UserInfo;
import com.bobo.service.UserinfoActionService;

//@Service("userinfoActionService") //jdk注解  
@Service //业务逻辑处理层 注解，规范  
@Scope("prototype")
public class UserinfoActionServiceImpl implements UserinfoActionService {
	//@Qualifier("userinfoDao")  
	//@Resource(name="userinfoDao")   
	@Autowired
	private UserinfoDao userinfoDao;
	public String toLogin() {
		return "toLoginSuccess";
	}
	@Transactional(readOnly=true) 
	public List<UserInfo> queryUserinfoAll() {
		return userinfoDao.queryUserinfo();
	}
	
	public UserinfoDao getUserinfoDao() {
		return userinfoDao;
	}
	public void setUserinfoDao(UserinfoDao userinfoDao) {
		this.userinfoDao = userinfoDao;
	}
	@Transactional(readOnly=true) 
	public List<UserInfo> queryUserinfo(Integer page, Integer rows) {
		return userinfoDao.queryUserinfo(page,rows);
	}
	@Transactional(readOnly=true) 
	public Integer queryUserinfoRows() {
		return userinfoDao.queryUserinfoRows();
	}
	@Override
	public String rowSave(UserInfo userInfo) {
		return userinfoDao.rowSave(userInfo);
	}
	@Override
	public Boolean rowDel(UserInfo userInfo) {
		System.out.println(userInfo.getAccount());
		if(userInfo.getId()==null||userInfo.getId().equals("")){
			return false;
		}else{
			try{
				String flag=userinfoDao.rowDel(userInfo);
				if(flag.equals("success")&&flag!=null){
					return true;
				}else{
					return false;
				}
			}catch(Exception e){
				return false;
			}
		}
	}

	
}
