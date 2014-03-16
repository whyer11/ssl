package com.lyq.action.admin;

import java.util.UUID;  

import com.framework.Dao.AreaDao;
import com.framework.Dao.StoreDao;
import com.lyq.model.all.Area;
import com.lyq.model.all.Store;
  
/** 
 * UUID生成器，以UUID的策略生成一个长度为32的随即字符串。 
 *  
 * @author ZhangShixi 
 */  
public class Test12 {  
  
    /** 
     * 以UUID的策略生成一个长度为32的字符串，在同一时空中具有唯一性。 
     * @return UUID128位长度字符串 
     */  
    public static String getUUIDString() {  
        String id = UUID.randomUUID().toString();  
        id = id.replace("-", "");  
        System.out.println(id);
        return id;  
    }  
    
    
    public static void main(String[] args) {
		AreaDao areaDao=new AreaDao();
		StoreDao storeDao=new StoreDao();
		Store store=storeDao.selectById(74);
		Area area=areaDao.selectById(25);
		System.out.println(area.getAreaStores().size());
		System.out.println(store.getAreaStores().size());
	}
}  