package com.ssl.user.tool;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.xerces.impl.xpath.regex.Match;

import sun.nio.cs.ext.MacHebrew;

public class CheckUserNameType {
	public static int UserNameType(String type) {
		String emailString = "^\\s*\\w+(?:\\.{0,1}[\\w-]+)*@[a-zA-Z0-9]+(?:[-.][a-zA-Z0-9]+)*\\.[a-zA-Z]+\\s*$";
		String phoneString = "^(1)\\d{10}$";

		Pattern p1 = Pattern.compile(emailString);
		Matcher matcher1=null;
		Matcher matcher2=null;
		
		if(type!=null&&type.length()!=0) 
			 matcher1 = p1.matcher(type);
		
		Pattern p2 = Pattern.compile(phoneString);
		if(type!=null&&type.length()!=0) 
			matcher2 = p2.matcher(type);
		
		if (matcher1!=null&&matcher1.find())
			return 1;// 邮箱

		else if (matcher2!=null&&matcher2.find())
			return 2; // "电话号码";
		else
			return 3; // "昵称";
	}

}
