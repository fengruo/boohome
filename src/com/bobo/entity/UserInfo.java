package com.bobo.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.servlet.http.HttpSessionActivationListener;
import javax.servlet.http.HttpSessionEvent;

import java.io.Serializable;



/**
 * UserInfo entity. @author MyEclipse Persistence Tools
 */
@Entity(name="t_user")
public class UserInfo implements HttpSessionActivationListener,Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */
	@Id  
    @GeneratedValue 
	private Integer id;
	private String account;
	private String password;
	private String pic;
	private String nameTrue;
	private String sex;
	private Date birthday;
	private String idCard;
	private String tel;
	private String college;
	private String grade;
	private String specialy;
	private String classes;
	private String role;

	// Constructors

	/** default constructor */
	public UserInfo() {
	}

	/** full constructor */
	public UserInfo(String account, String password, String pic,
			String nameTrue, String sex, Date birthday, String idCard,
			String tel, String college, String grade, String specialy,
			String classes, String role) {
		this.account = account;
		this.password = password;
		this.pic = pic;
		this.nameTrue = nameTrue;
		this.sex = sex;
		this.birthday = birthday;
		this.idCard = idCard;
		this.tel = tel;
		this.college = college;
		this.grade = grade;
		this.specialy = specialy;
		this.classes = classes;
		this.role = role;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAccount() {
		return this.account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPic() {
		return this.pic;
	}

	public void setPic(String pic) {
		this.pic = pic;
	}

	public String getNameTrue() {
		return this.nameTrue;
	}

	public void setNameTrue(String nameTrue) {
		this.nameTrue = nameTrue;
	}

	public String getSex() {
		return this.sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public Date getBirthday() {
		return this.birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getIdCard() {
		return this.idCard;
	}

	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}

	public String getTel() {
		return this.tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getCollege() {
		return this.college;
	}

	public void setCollege(String college) {
		this.college = college;
	}

	public String getGrade() {
		return this.grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public String getSpecialy() {
		return this.specialy;
	}

	public void setSpecialy(String specialy) {
		this.specialy = specialy;
	}

	public String getClasses() {
		return this.classes;
	}

	public void setClasses(String classes) {
		this.classes = classes;
	}

	public String getRole() {
		return this.role;
	}

	public void setRole(String role) {
		this.role = role;
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