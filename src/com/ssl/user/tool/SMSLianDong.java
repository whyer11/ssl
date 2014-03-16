package com.ssl.user.tool;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class SMSLianDong {
	private String userID =   "";
	private String password = "";
	private String mobileNO =  "";
	private String message =  "";
	private String action =  "";
	
	
	public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		this.userID = userID;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getMobileNO() {
		return mobileNO;
	}
	public void setMobileNO(String mobileNO) {
		this.mobileNO = mobileNO;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getAction() {
		return action;
	}
	public void setAction(String action) {
		this.action = action;
	}
	public String sendSMS(String username,String password,String mobile,String act,String message){
		String returnString="";
		
			try {
				String data = "UserID=" + username+ "&PassWord=" +this.EncodePassword(password) 
					+"&mobile="+mobile+"&action=" + act+"&message="
						+ URLEncoder.encode(message, "GBK");
				// Send data
				URL url = new URL("http://www.72dns.com/smsadmin/Sms_Api.aspx");
				URLConnection conn = url.openConnection();
				conn.setDoOutput(true);
				OutputStreamWriter wr = new OutputStreamWriter(
						conn.getOutputStream());
				wr.write(data);
				wr.flush();
				// Get the response
				BufferedReader rd = new BufferedReader(new InputStreamReader(
						conn.getInputStream()));
				String line;
				while ((line = rd.readLine()) != null) {
					returnString += line;
				}
				wr.close();
				rd.close();
			} catch (NoSuchAlgorithmException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	
		
		return returnString;
		
	}
	public String EncodePassword(String password)
			throws NoSuchAlgorithmException {
		String result = "";
		MessageDigest md = MessageDigest.getInstance("MD5");
		md.reset();
		byte[] hash = md.digest(password.getBytes());
		for (int i = 0; i < hash.length; i++) {
			int itemp = hash[i] & 0xFF;
			if (itemp < 16)
				result += "0";
			result += Integer.toString(itemp, 16).toUpperCase();
		}
		return result;
	}
	public  String CheckSendState(String code) {
		if(code!=null&&code.length()!=0){
		switch (new Integer(code.substring(5, 8))) {
		case 200:
			return "短信发送成功";
		case 210:
			return "短信发送成功";
		case 400:
			return "用户传入参数错误";
		case 401:
			return "短信发送失败";
		case 402:
			return "发送的短信内容字数数多于500字符请检查";
		case 403:
			return "用户验证错误";
		case 404:
			return "用户禁止登入";
		case 406:
			return "剩余可发送的少于输入的电话号码数量";
		case 500:
			return "Server Handle Error(服务器处理错误)";
		default:
			return "未知错误";
		}
		}else return "未知错误";

	}
	
	public String sendSMS(String username,String password,String[] mobiles,String act,String message){
		String mobile="";
		for(int i=0;i<mobiles.length;i++){
			mobile+=","+mobiles[i];
			
		}
		return this.sendSMS(username, password, mobile, act, message);
	}
	
	
	
	public static void main(String[] args) {
		
		SMSLianDong sms = new SMSLianDong();
		sms.setAction("SendSms");
		sms.setMessage("测试成功");
		sms.setMobileNO("15827426582,15720807151");
		sms.setPassword("l123454321");
		sms.setUserID("5998");
		String type = sms.sendSMS("5998", "l123454321", "15827426582", "SendSms", "java code test");
		
	}
	

}
