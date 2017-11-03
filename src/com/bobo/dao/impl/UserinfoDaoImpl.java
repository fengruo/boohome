package com.bobo.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import com.bobo.dao.UserinfoDao;
import com.bobo.entity.UserInfo;

//@Repository("userinfoDao") //jdk注解  
@Repository  //sql访问层注解，规范  
@Scope("prototype")
public class UserinfoDaoImpl implements UserinfoDao {
	@Autowired
	private SessionFactory sessionFactory;
	public List<UserInfo> queryUserinfo() {
			Session session = sessionFactory.openSession();  
	        String hql = "from UserInfo";  
	        Query query = session.createQuery(hql);  
	        @SuppressWarnings("unchecked")
			List<UserInfo> userInfoList = query.list();
	        session.close();
	        return userInfoList;  
	}
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	@Override
	public List<UserInfo> queryUserinfo(Integer page, Integer rows) {
		Session session = sessionFactory.openSession();  
        String hql = "from UserInfo";  
        Query query = session.createQuery(hql);  
        query.setMaxResults(rows); 
        query.setFirstResult((page-1)*rows);
        @SuppressWarnings("unchecked")
		List<UserInfo> userInfoList = query.list();
        session.close();
        return userInfoList;  
	}
	@Override
	public Integer queryUserinfoRows() {
		Session session = sessionFactory.openSession();  
        String hql = "from UserInfo";  
        Query query = session.createQuery(hql);  
        @SuppressWarnings("unchecked")
		List<UserInfo> userInfoList = query.list();
        session.close();
        return userInfoList.size();
	}
	@Override
	public String rowSave(UserInfo userInfo) {
			try{
				String id="";
				Session session = sessionFactory.openSession();
				session.beginTransaction();
				if(userInfo.getId()==null||userInfo.getId().equals("")){
					id=session.save(userInfo).toString();
				}else{
					session.update(userInfo);
				}
				session.getTransaction().commit();
		        session.close();
				return id;
			}catch(HibernateException e){
				return null;
			}
	}
	@Override
	public String rowDel(UserInfo userInfo) {
		
			String id="success";
			Session session = sessionFactory.openSession();
			session.beginTransaction();
			try{
				if(userInfo.getId()!=null||!userInfo.getId().equals("")){
					session.delete(userInfo);
				}
			}catch(HibernateException e){
				return null;
			}
			session.getTransaction().commit();
	        session.close();
			return id;
		
	}
	
	
	

}
