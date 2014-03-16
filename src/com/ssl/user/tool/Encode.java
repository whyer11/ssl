package com.ssl.user.tool;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Encode {

	private String password;
	private int salt;
	private String inputString;
	

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	

	public int getSalt() {
		return salt;
	}

	public void setSalt(int salt) {
		this.salt = salt;
	}

	public String getInputString() {
		return inputString;
	}

	public void setInputString(String inputString) {
		this.inputString = inputString;
	}

	/*
	 * 辅助加密数组，十进制对应十六进制
	 */
	private final static String[] bth = { "0", "1", "2", "3", "4", "5", "6",
			"7", "8", "9", "a", "b", "c", "d", "e", "f" };

	/**
	 * 二进制对应十六进制
	 * 
	 * @param b
	 * @return
	 */
	@SuppressWarnings("unused")
	private static String byteArrayToHexString(byte[] b) {
		StringBuffer resultSb = new StringBuffer();
		for (int i = 0; i < b.length; i++) {
			resultSb.append(byteToHexString(b[i]));
		}
		return resultSb.toString();
	}

	/**
	 * 将二进制的字节转化为十六进制
	 * 
	 * @param b
	 * @return
	 */
	private static String byteToHexString(byte b) {
		int n = b;
		if (n < 0)
			n = 256 + n;
		int d1 = n / 16;
		int d2 = n % 16;
		return bth[d1] + bth[d2];
	}

	/**
	 * 加salt进行密码的加密 第一个值为原密码 ，第二个值为salt
	 */
	public String encodeByMD5(String password, int salt) {
		try {byte[] temp=null;
			String resultString="";
			
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(new Integer(salt).toString().getBytes());
			if(password!=null&&password.length()!=0){
				temp = md.digest(password.getBytes());
			 resultString = byteArrayToHexString(temp);
			 return resultString.toUpperCase();
			}else return null;
			
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public boolean authenticatePassword(String password, String inputString) {
		if (password.equals(encodeByMD5(inputString, salt)))
			return true;
		else
			return false;
	}

}
