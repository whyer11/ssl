package com.lyq.productserialization;

import java.util.List;








import net.sf.json.JSONArray;
import net.sf.json.JSONException;
import net.sf.json.JSONObject;

import com.lyq.model.all.Product;



public class PostJSONSerializer
{
	
	
	
	
	public static JSONObject toSimpleObject(Product p_product){
		if(p_product == null){
			return null;
		}
		JSONObject json = new JSONObject();
		try{
			json.put("name", p_product.getName());
			 String num=p_product.getPrice().toString();
			  int index = num.indexOf(".");
			   // 截取并转换这个数的整数部分
			   String intOnly = num.substring(0, index);
			 
			   // 截取并转换这个数的小数部分
			   String smallOnly = num.substring(index + 1,index+2);
			 
			   String newS = intOnly+"."+smallOnly;	
		
			json.put("price",newS);
			json.put("imageLink", p_product.getImageLinkArray()[1]);
			json.put("description", p_product.getDescription());
			json.put("productId", p_product.getProductId());
		}
		catch (JSONException e)
		{
			return null;
		}
		return json;
	}
	
	
	public static JSONArray tosimpleArray(List<Product> p_products){
		if(p_products == null){
			return null;
		}
		JSONArray array = new JSONArray();
		for (Product product : p_products) {
			array.add(toSimpleObject(product));
		}
		return array;
		
	}
	
	


}
