package com.ssl.user.tool;

import java.util.Random;
public  class CheckCode {

	 private static Random rd = new Random();
	public static String CheckCode(){
	     String randomCode="";
		for(int i=0;i<6;i++){	    
	     randomCode+=rd.nextInt(10);  		
		}
		return randomCode;
	}
	

}
