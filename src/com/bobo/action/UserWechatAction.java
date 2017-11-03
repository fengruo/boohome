package com.bobo.action;

import java.io.InputStream;
import java.io.Serializable;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionActivationListener;
import javax.servlet.http.HttpSessionEvent;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.bobo.entity.Mailto;
import com.bobo.pojo.SNSUserInfo;
import com.bobo.pojo.WeixinOauth2Token;
import com.bobo.service.UserinfoActionService;
import com.bobo.service.UsualStrService;
import com.bobo.utils.AdvancedUtil;
import com.opensymphony.xwork2.ActionSupport;
@Controller               //默认就是类的首字母小写  
@Scope("prototype") 
public class UserWechatAction extends ActionSupport {

	/**
	 * 微信用户信息录入
	 */
	private static final long serialVersionUID = 1L;
	private InputStream textStream;
	@Autowired
	private UserinfoActionService userinfoActionService;
	@Autowired
	private UsualStrService usualStrService;
	/*//=====================================================
	private String APPSECRET="fb0096140d503f8d014f671d706156b7";
	private String APPID="wx5b347fe4bd7a2398";
	//用户获取网页授权信息
	public String getwechatuserinfo(){
		try{
			HttpServletRequest request = ServletActionContext.getRequest();
			String code = request.getParameter("code");
			//分方向认证
			//int state =Integer.parseInt(request.getParameter("state"));
			System.out.println(code);
			// 用户同意授权
			if (!"authdeny".equals(code)) {
				// 获取网页授权access_token,应用的appid和appsecret
				WeixinOauth2Token weixinOauth2Token = AdvancedUtil.getOauth2AccessToken(APPID, APPSECRET, code);
				// 网页授权接口访问凭证
				String accessToken = weixinOauth2Token.getAccessToken();
				// 用户标识
				String openId = weixinOauth2Token.getOpenId();
				 //获取用户信息
				SNSUserInfo snsUserInfo = AdvancedUtil.getSNSUserInfo(accessToken,openId);
				//插入用户记录
				HttpSession session=request.getSession();
				session.setAttribute("snsUserInfo", snsUserInfo);
				
				
				
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return "Oauth2AccessTokenSUCCESS";
	}*/
	
	//=====================================================
	public InputStream getTextStream() {
		return textStream;
	}
	public void setTextStream(InputStream textStream) {
		this.textStream = textStream;
	}

	public UserinfoActionService getUserinfoActionService() {
		return userinfoActionService;
	}

	public void setUserinfoActionService(UserinfoActionService userinfoActionService) {
		this.userinfoActionService = userinfoActionService;
	}

	public UsualStrService getUsualStrService() {
		return usualStrService;
	}

	public void setUsualStrService(UsualStrService usualStrService) {
		this.usualStrService = usualStrService;
	}
	
	
}
