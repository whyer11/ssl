package com.lyq.util1;

import java.util.Random;

public final class StringUtil
{
	public static boolean isNullOrEmpty(String p_string)
	{
		return p_string == null || p_string.trim() == "";
	}
	
	public static boolean notNullOrEmpty(String p_string)
	{
		return !isNullOrEmpty(p_string);
	}
	
	public static String getCheckCode() {
		Random rd = new Random();
		String randomCode = "";
		for (int i = 0; i < 6; i++) {
			randomCode += rd.nextInt(10);
		}
		return randomCode;
	}
}
