package com.bobo.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import com.bobo.dao.MailDao;
import com.bobo.entity.Mailto;
import com.bobo.service.UsualStrService;
@Repository  //sql访问层注解，规范  
@Scope("prototype")
public class MailDaoImpl implements MailDao {
	@Autowired
	private SessionFactory sessionFactory;
	@Autowired
	private UsualStrService usualStrService;
	
	
	//插入一条预约邮件数据
	@Override
	public String insertMailto(Mailto mailto) {
		Session session = sessionFactory.openSession();  
		Integer zid=(Integer)session.save(mailto);
        session.close();
        if(zid>0){
        	return "success";
        }
		return null;
	}
	@Override
	public List<Mailto> queryEmiltime(String liketime) {
		Session session = sessionFactory.openSession(); 
		String hql="from Mailto AS t WHERE t.zdate LIKE :param";
		Query query=session.createQuery(hql);
		query.setString("param", "%" + liketime + "%");
		@SuppressWarnings({ "unchecked" })
		List<Mailto> mailtolist=query.list();
		session.close();
		return mailtolist;
	}
	
	@Override
	public String upMailto(Mailto mailto) {
		Session session=sessionFactory.openSession();
        //org.hibernate.Query 
        //session.update(mailto);
        Query q=session.createQuery("update Mailto t set t.zstate=1 where t.zid="+mailto.getZid());
        q.executeUpdate();
		session.close();
		return null;
	}
	//*******************************************
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public UsualStrService getUsualStrService() {
		return usualStrService;
	}

	public void setUsualStrService(UsualStrService usualStrService) {
		this.usualStrService = usualStrService;
	}
	@Override
	public List<Mailto> queryEmilAll() {
		Session session = sessionFactory.openSession(); 
		String hql="from Mailto";
		Query query=session.createQuery(hql);
		@SuppressWarnings({ "unchecked" })
		List<Mailto> mailtolist=query.list();
		session.close();
		return mailtolist;
	}
	

	

	
	
}
