package com.ssl.user.tool;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javassist.bytecode.ByteArray;

public class SMSend {
	private String userID = "";
	private String password = "";
	private String mobileNO = "";
	private String message = "";
	private String action = "";
	private String url = "";
	private String sMethod = "";

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

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
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

	public String lastMessage() throws NoSuchAlgorithmException {
		@SuppressWarnings("deprecation")
		String messagetemp = URLEncoder.encode(message);
		return url + "UserID=" + userID + "&PassWord="
				+ EncodePassword(password) + "&mobile=" + mobileNO
				+ "&message=" + messagetemp + "&action=" + action;

	}

	public String sendMessage() throws NoSuchAlgorithmException, IOException {
		URL url = new URL(lastMessage());
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		Reader reader = new InputStreamReader(new BufferedInputStream(
				url.openStream()));
		int c;
		StringBuilder sb = new StringBuilder();

		while ((c = reader.read()) != -1) {
			sb.append((char) c);
		}
		reader.close();
		return sb.toString();
	}

	public static String CheckSendState(String code) {
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

	public static void main(String[] args) throws NoSuchAlgorithmException,
			IOException {
		SMSend sms = new SMSend();
		sms.setAction("SendSms");
		sms.setMessage(URLEncoder.encode("我用了好几个工具给你发过短信，我也不知道是哪一个啊，你收到了给我点提示啊<联动天下>", "GBK"));
		sms.setMobileNO("16107515240");
		sms.setPassword("l123454321");
		sms.setUserID("5998");
		sms.setUrl("http://www.72dns.com/smsadmin/Sms_Api.aspx?");
		String type = sms.sendMessage();
		System.out.println(sms.CheckSendState(type));
	}

}
