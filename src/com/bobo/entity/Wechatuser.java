package com.bobo.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.servlet.http.HttpSessionActivationListener;
import javax.servlet.http.HttpSessionEvent;

@Entity(name="t_wechatuser")
public class Wechatuser implements HttpSessionActivationListener,Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id  
    @GeneratedValue 
	private Integer zid;
	// 用户标识
	private String openid;
	// 用户昵称
	private String nickname;
	// 性别（1是男性，2是女性，0是未知）
	private int sex;
	// 国家
	private String country;
	// 省份
	private String province;
	// 城市
	private String city;
	// 用户头像链接
	private String imgurl;
	
	private String email;
	
	public Wechatuser() {
	}

	public Wechatuser(Integer zid, String openid, String nickname, int sex,
			String country, String province, String city, String imgurl,
			String email) {
		super();
		this.zid = zid;
		this.openid = openid;
		this.nickname = nickname;
		this.sex = sex;
		this.country = country;
		this.province = province;
		this.city = city;
		this.imgurl = imgurl;
		this.email = email;
	}

	public Integer getZid() {
		return zid;
	}

	public void setZid(Integer zid) {
		this.zid = zid;
	}

	public String getOpenid() {
		return openid;
	}

	public void setOpenid(String openid) {
		this.openid = openid;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public int getSex() {
		return sex;
	}

	public void setSex(int sex) {
		this.sex = sex;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getImgurl() {
		return imgurl;
	}

	public void setImgurl(String imgurl) {
		this.imgurl = imgurl;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public void sessionDidActivate(HttpSessionEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void sessionWillPassivate(HttpSessionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
}
