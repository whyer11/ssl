package com.ssl.user.action.sms;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Date;
//中国数据接口
public class SMS {

	public String sendSMS(String username, String password,String mobile,String act, String message) {

		String returnString = "";
		try {
			// Construct data

			SimpleDateFormat sdf = new SimpleDateFormat("YYYYmmddHHMMss");
			String time = sdf.format(new Date());
			String pamd5 = this.EncodePassword(password);
			String encodeString = username + pamd5 + act + time;
			String checkSum = this.EncodePassword(encodeString);

			String data = "u_name=" + username+ "&act=" + act + "&checkTime=" + time
					+ "&checkSum=" + checkSum  +"&mobile="+mobile+"&content="
					+ URLEncoder.encode(message, "GBK");
			// Send data
			URL url = new URL("http://sms.55hl.net/api/index.php");
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
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		return returnString;

	}

	public String EncodePassword(String password) {
		MessageDigest messageDigest = null;

		try {
			messageDigest = MessageDigest.getInstance("MD5");

			messageDigest.reset();

			messageDigest.update(password.getBytes("UTF-8"));
		} catch (NoSuchAlgorithmException e) {
			System.out.println("NoSuchAlgorithmException caught!");
			System.exit(-1);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}

		byte[] byteArray = messageDigest.digest();

		StringBuffer md5StrBuff = new StringBuffer();

		for (int i = 0; i < byteArray.length; i++) {
			if (Integer.toHexString(0xFF & byteArray[i]).length() == 1)
				md5StrBuff.append("0").append(
						Integer.toHexString(0xFF & byteArray[i]));
			else
				md5StrBuff.append(Integer.toHexString(0xFF & byteArray[i]));
		}

		return md5StrBuff.toString();
	}
	
	public String mobileArrayToMobile(String[] mobiles){
		
		String st="";
		for(int i=0;i<mobiles.length;i++){
			st+=","+mobiles[i];
			
		}
		return st;
	}
	
	
	public String sendSMS(String username, String password,String[] mobiles,String act, String message){	
		return this.sendSMS(username, password, this.mobileArrayToMobile(mobiles), act, message);
	}
	
	

	public static void main(String[] args) {
		SMS sms = new SMS();

		String t = sms.sendSMS("fengshao001", "l123454321", "15827426582",
				"smssend", "我用了好几个工具给你发过短信，我也不知道是哪一个啊，你收到了给我点提示啊<中国数据>");

		System.out.println(t);
	}

}
