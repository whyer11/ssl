package com.lyq.action.admin;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;


public class test1 {

	
	    public static void main(String args[])
	    {
	        JSONObject jsonObj0  = new JSONObject();
	        JSONObject jsonObj  = new JSONObject();
	        JSONObject jsonObj2  = new JSONObject();
	        JSONObject jsonObj3  = new JSONObject();
	        JSONArray jsonArray = new JSONArray();
	        
	        //创建jsonObj0
	        jsonObj0.put("name0", "zhangsan");
	        jsonObj0.put("sex1", "female");
	        System.out.println("jsonObj0:"+jsonObj0);
	        
	        //创建jsonObj1
	        jsonObj.put("name", "xuwei");
	        jsonObj.put("sex", "male");
	        System.out.println("jsonObj:"+jsonObj);
	    
	        //创建jsonObj2，包含两个条目，条目内容分别为jsonObj0，jsonObj1
	        jsonObj2.put("item0", jsonObj0);
	        jsonObj2.put("item1", jsonObj);
	        System.out.println("jsonObj2:"+jsonObj2);
	        
	        //创建jsonObj3，只有一个条目，内容为jsonObj2
	        jsonObj3.element("j3", jsonObj2);
	        System.out.println("jsonObj3:"+jsonObj3);
	    
	        //往JSONArray中添加JSONObject对象。发现JSONArray跟JSONObject的区别就是JSONArray比JSONObject多中括号[]
	        jsonArray.add(jsonObj);
	        System.out.println("jsonArray:"+jsonArray);
	        
	        JSONObject jsonObj4  = new JSONObject();
	        jsonObj4.element("weather", jsonArray);
	        System.out.println("jsonObj4:"+jsonObj4);
	    }
	}

