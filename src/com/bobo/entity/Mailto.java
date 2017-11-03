package com.bobo.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.servlet.http.HttpSessionActivationListener;
import javax.servlet.http.HttpSessionEvent;
@Entity(name="t_mailto")
public class Mailto implements HttpSessionActivationListener,Serializable{

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	@Id  
    @GeneratedValue 
	private Integer zid;
	private String zemail;
	private Date zdate;
	private Date zsenddate;
	private String zemailtext;
	private Integer zstate;
	private String zemailtitle;
	public Mailto(Integer zid, String zemail, Date zdate, Date zsenddate,
			String zemailtext, Integer zstate, String zemailtitle) {
		super();
		this.zid = zid;
		this.zemail = zemail;
		this.zdate = zdate;
		this.zsenddate = zsenddate;
		this.zemailtext = zemailtext;
		this.zstate = zstate;
		this.zemailtitle = zemailtitle;
	}
	public Mailto() {
	}
	public Integer getZid() {
		return zid;
	}
	public void setZid(Integer zid) {
		this.zid = zid;
	}
	public String getZemail() {
		return zemail;
	}
	public void setZemail(String zemail) {
		this.zemail = zemail;
	}
	public String getZemailtext() {
		return zemailtext;
	}
	public void setZemailtext(String zemailtext) {
		this.zemailtext = zemailtext;
	}
	public String getZemailtitle() {
		return zemailtitle;
	}
	public void setZemailtitle(String zemailtitle) {
		this.zemailtitle = zemailtitle;
	}
	public Date getZdate() {
		return zdate;
	}
	public void setZdate(Date zdate) {
		this.zdate = zdate;
	}
	public Date getZsenddate() {
		return zsenddate;
	}
	public void setZsenddate(Date zsenddate) {
		this.zsenddate = zsenddate;
	}
	public Integer getZstate() {
		return zstate;
	}
	public void setZstate(Integer zstate) {
		this.zstate = zstate;
	}
	@Override
	public void sessionDidActivate(HttpSessionEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println("活化了");
	}
	@Override
	public void sessionWillPassivate(HttpSessionEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println("钝化了");
	}
	
}
