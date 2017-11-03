package com.bobo.service.impl;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.MessageDigest;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;



import com.bobo.service.UsualStrService;



@Service //业务逻辑处理层 注解，规范  
@Scope("prototype")
public class UsualStrServiceImpl implements UsualStrService {
	// *************************常用的一些方法************************************************************
	//取日期文件名
	public String getNameByDate(){
		Date date = new Date();
		int year = date.getYear();
		int month = date.getMonth();
		int day = date.getDay();
		int hour = date.getHours();
		int minu = date.getMinutes();
		int second = date.getSeconds();
		int min = date.getMinutes();
		String tempStr = String.valueOf(year) + String.valueOf(month)
				+ String.valueOf(day) + String.valueOf(hour)
				+ String.valueOf(minu) + String.valueOf(second)
				+ String.valueOf(min);
		return tempStr;
	}
	// 接收对象并检查对象
	 
	public String checkRequestStr(HttpServletRequest request, String str) {
		String temp = request.getParameter(str) == null ? "" : (request
				.getParameter(str).trim());
		return temp;
	}
	//得时间格式
	 
	public String getDateFormat(String fm){
		SimpleDateFormat sdf=new SimpleDateFormat(fm);
		return sdf.format(new Date());
	}
	public String getWeekInfoCn(String date){
		int week = -1;
		String temp="";
		try{
			SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd");
			Date d=dateFormat.parse(date);		
			Calendar calendar=Calendar.getInstance();
			calendar.setTime(d);
			week=calendar.get(Calendar.DAY_OF_WEEK);
			int t=week-1;
			if(t==1){
				temp="一";
			}else if(t==2){
				temp="二";
			}else if(t==3){
				temp="三";
			}else if(t==4){
				temp="四";
			}else if(t==5){
				temp="五";
			}else if(t==6){
				temp="六";
			}else if(t==0){
				temp="日";
			}
			temp="星期"+temp;
		}catch(Exception e){
			e.printStackTrace();
		}
		return temp;
	}
	//得时间格式完整
	public String getDateFormatAll(){
		String fm = "yyyy-MM-dd HH:mm:ss";
		SimpleDateFormat sdf=new SimpleDateFormat(fm);
		return sdf.format(new Date());
	}
	
	// 调用MD5： Java代码
	public String encryptMD5(String password) {
		InputStream is = new ByteArrayInputStream(password.getBytes());
		String res = this.getMD5(is);
		return res;
	}
	//判断是否为实数
	 
	public boolean isNumeric(String str){ 
	    Pattern pattern = Pattern.compile("^(-?\\d+)(\\.\\d+)?$"); 
	    return pattern.matcher(str).matches();    
	}
	//格式化字符串
	 
	public String formatStr(String str,int ln){
		int ca=ln-str.length();
		String temp="";//8*0+str
		for(int i=0;i<ca;i++){
			temp=temp+"0";
		}
		return temp+str;
	}
	//判断对象是否为NULL
	 
	public String isNull(Object obj){
		String str="";
		if(obj==null){
			str="";
		}else{
			str=(obj.toString()).trim();
		}
		return str;
	}
	//根据传来文本，取对应长度，其余用省略号
	 
	public String getLongStr(String str,int ln){
		if (str==null) return "";
		if(str.length()>ln)
			str=str.substring(0,ln)+"...";
		return str;
	}
	//去，号
	public String getDHstr(String resouse){
		if(resouse != null && resouse.length()>0){
			if(resouse.substring(resouse.length()-1,resouse.length()).equals(","))
				resouse=resouse.substring(0,resouse.length()-1);
		}
		return resouse;
	}
	//去除文本里HTML代码
	 
	public String removeTagFromText(String content) {
		Pattern p = null;
		Matcher m = null;
		String value = null;
		// 去掉<>标签
		p = Pattern.compile("(<[^>]*>)");
		m = p.matcher(content);
		String temp = content;
		while (m.find()) {
			value = m.group(0);
			temp = temp.replace(value, "");		
		}
		return temp;
	}
	//上传文件
	 
	public void copy(File src, File dst,int SIZE) {
		try {
			InputStream in = null;
			OutputStream out = null;
			try {
				in = new BufferedInputStream(new FileInputStream(src), SIZE);
				out = new BufferedOutputStream(new FileOutputStream(dst), SIZE);
				byte[] buffer = new byte[SIZE];
				while (in.read(buffer) > 0) {
					out.write(buffer);
				}
			} finally {
				if (null != in) {
					in.close();
				}
				if (null != out) {
					out.close();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * MD5
	 * 
	 * @param fis
	 * @return String
	 */
	private String getMD5(InputStream fis) {

		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			byte[] buffer = new byte[2048];
			int length = -1;
			while ((length = fis.read(buffer)) != -1) {
				md.update(buffer, 0, length);
			}
			return bytesToString(md.digest());
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		} finally {
			try {
				fis.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
	}
	/**
	 * 字节2字符串
	 * 
	 * @param data
	 * @return String
	 */
	private static String bytesToString(byte[] data) {
		char hexDigits[] = { '9', '8', '7', '6', '5', '4', '3', '2', '1', '0',
				'a', 'b', 'c', 'd', 'e', 'f' };
		char[] temp = new char[data.length * 2];
		for (int i = 0; i < data.length; i++) {
			byte b = data[i];
			temp[i * 2] = hexDigits[b >>> 4 & 0x0f];
			temp[i * 2 + 1] = hexDigits[b & 0x0f];
		}
		return new String(temp);
	}
	//判断是一年的第几周，星期几
	public int getWeekInfo(String date){
		int week = -1;
		try{
			SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd");
			Date d=dateFormat.parse(date);		
			Calendar calendar=Calendar.getInstance();
			calendar.setTime(d);
			week=calendar.get(Calendar.DAY_OF_WEEK);
		}catch(Exception e){
			e.printStackTrace();
		}
		return week-1;
	}
	//通过字典代码，取中文字典  value:缓存中的字典值 ；vl:字典代码
	public String getZDvalue(List<String[]> diclist,String vl){
		String value="";
		for(String[] ss:diclist){
			if(ss[0].equals(vl)){
				value=ss[1];
				break;
			}
		}
		return value;
	}
	//在指定的日期基础上,增加指定的月
	public String addMonthByDate(Date a,int month){
		Calendar   c   =   Calendar.getInstance();//获得一个日历的实例 
        SimpleDateFormat   sdf   =   new   SimpleDateFormat( "yyyy-MM-dd "); 
        c.setTime(a);//设置日历时间 
        c.add(Calendar.MONTH,month);//在日历的月份上增加6个月 
        return sdf.format(c.getTime());
	}

	
	private static String formatDate(String borndate){
	    int byear =Integer.parseInt(borndate.substring(0,4));
	    int bmon = Integer.parseInt(borndate.substring(4,6));
	    int bday = Integer.parseInt(borndate.substring(6));
        if(byear<1900||byear>2200){
            return "-4";
        }
	    if(bmon>=1&&bmon<=12){
	        if(bday>=1&&bday<=31){
	           // if(((!((byear%4==0&&byear%100!=0)||(byear%400==0)))&&bmon==2&&bday>29)){
	            if (((byear%4==0&&byear%100!=0)||(byear%400==0))){
	                if(bmon==2&&bday>29){
	                return "-52";
	                }
	                
	            }else
	                
	                
	            if(bmon==2&&bday>=29){
	                return "-52";
	            }else if((bmon==4||bmon==6||bmon==9||bmon==11)&&bday>=31){
	                return "-53";
	            }
	        }else{
	            return "-51";
	        }
	    }else{
	        return "-5";
	    }
	    return "0";
	    
	}
	
	//插入数据库前，进行数据替换
		public String replaceStringByData(String str){
			if(str==null || "".equals(str)){
				return "";
			}
			str=str.replace("'", "''");
			str=str.replace("\\", "\\\\");  
			return str.trim();
		}
		public String crsSql(HttpServletRequest request, String str){
			String temp = request.getParameter(str) == null ? "" : (request.getParameter(str).trim());
			temp=this.replaceStringByData(temp);
			return temp;
		}
		
			
	
		//====获取客户端IP
	     public  String getIpAddr(HttpServletRequest request)  {
	           String ip  =  request.getHeader( " x-forwarded-for " );
	            if (ip  ==   null   ||  ip.length()  ==   0   ||   " unknown " .equalsIgnoreCase(ip))  {
	               ip  =  request.getHeader( " Proxy-Client-IP " );
	           } 
	            if (ip  ==   null   ||  ip.length()  ==   0   ||   " unknown " .equalsIgnoreCase(ip))  {
	               ip  =  request.getHeader( " WL-Proxy-Client-IP " );
	           } 
	            if (ip  ==   null   ||  ip.length()  ==   0   ||   " unknown " .equalsIgnoreCase(ip))  {
	              ip  =  request.getRemoteAddr();
	          } 
	           return  ip;
	      }
	     public int getmyfloat(String str){
				int tt=0;
				try{
				if(str==null || "null".equals(str) || "".equals(str)){
					tt=0;
				}else{
					Float ft=Float.parseFloat(str);
					tt=ft.intValue();
				}
				}catch(Exception e){
					e.printStackTrace();
					tt=0;
				}
				return tt;
			}
	   //产生两个数之间的随机数
	 	public double getRandom(int begin,int end){
	 		double random = Math.random();
	 		return random*(end - begin)+begin;
	 	}

	
}