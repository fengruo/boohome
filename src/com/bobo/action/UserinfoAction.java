 package com.bobo.action;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;


import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;


import com.bobo.entity.UserInfo;
import com.bobo.entity.PageInfo;
import com.bobo.service.UserinfoActionService;
import com.bobo.service.UsualStrService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

//@Controller("myNewsAction")  
@Controller               //默认就是类的首字母小写
@Scope("prototype") 
public class UserinfoAction extends ActionSupport implements ModelDriven<UserInfo>{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Autowired
	private UserinfoActionService userinfoActionService;
	@Autowired
	private UsualStrService usualStrService;
	private InputStream textStream;
	private UserInfo userInfo;
	public String toLoginAction() {
		
		return userinfoActionService.toLogin();
	}
	//查询所有信息
	public String queryUserinfoAll(){
		try {
			HttpServletRequest request = ServletActionContext.getRequest();
			int page=Integer.parseInt(usualStrService.checkRequestStr(request, "page"));
			int rows=Integer.parseInt(usualStrService.checkRequestStr(request, "rows"));
			//System.out.println(page+"***"+rows);
			List<UserInfo> userinfoList=userinfoActionService.queryUserinfo(page, rows);
			//total   
			int total=userinfoActionService.queryUserinfoRows();
			PageInfo userPageInfo=new PageInfo();
			userPageInfo.setTotal(total);
			userPageInfo.setPage(page);
			userPageInfo.setRows(userinfoList);
			textStream=new ByteArrayInputStream(new Gson().toJson(userPageInfo).toString().getBytes("utf-8"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return SUCCESS;
	}
	//新增
	public String userAdd(){
		try {
			JsonObject jsonObject=new JsonObject();
			jsonObject.addProperty("success", true);
			if(userInfo.getId()==null||userInfo.getId().equals("")){
				jsonObject.addProperty("message", "添加成功");
			}else{
				jsonObject.addProperty("message", "修改成功");
			}
			if(userinfoActionService.rowSave(userInfo)==null){
				jsonObject.addProperty("success", false);
				jsonObject.addProperty("message", "操作失败");
			}
			String json=jsonObject.toString();
			textStream=new ByteArrayInputStream(json.toString().getBytes("utf-8"));
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return SUCCESS;
	}
	//删除一条数据
	public String userDel(){
		try {
			Boolean flag=userinfoActionService.rowDel(userInfo);
			JsonObject jsonObject=new JsonObject();
			if(flag){
				jsonObject.addProperty("success", true);
				jsonObject.addProperty("message", "删除成功");
			}else{
				jsonObject.addProperty("success", false);
				jsonObject.addProperty("message", "操作失败");
			}
			String json=jsonObject.toString();
			textStream=new ByteArrayInputStream(json.toString().getBytes("utf-8"));
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return SUCCESS;
	}
	//*******************************
	public UserinfoActionService getUserinfoActionService() {
		return userinfoActionService;
	}

	public void setUserinfoActionService(UserinfoActionService userinfoActionService) {
		this.userinfoActionService = userinfoActionService;
	}
	public InputStream getTextStream() {
		return textStream;
	}
	public void setTextStream(InputStream textStream) {
		this.textStream = textStream;
	}
	public UsualStrService getUsualStrService() {
		return usualStrService;
	}
	public void setUsualStrService(UsualStrService usualStrService) {
		this.usualStrService = usualStrService;
	}
	@Override
	public UserInfo getModel() {
		// TODO Auto-generated method stub
		userInfo = new UserInfo();
		return userInfo;
	}
	public UserInfo getUserInfo() {
		return userInfo;
	}
	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}
	
	
	
}
