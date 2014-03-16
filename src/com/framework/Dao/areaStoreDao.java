package com.framework.Dao;

import com.lyq.model.all.AreaStore;
import com.lyq.model.all.Store;

public class areaStoreDao  extends StandardEntityDAO<AreaStore> {
	
	
	/**
	 * 插入店铺的覆盖区域，第一个参数为地区id数组，第二个参数为店铺号
	 * @return
	 */
	public  boolean insertCoverStore(String[] areaIds ,Store store){
		
		AreaDao areaDao = new AreaDao();		
		
		for(int i=0;i<areaIds.length;i++){
			
			AreaStore areaStore = new AreaStore();
			areaStore.setArea(areaDao.selectById(Integer.parseInt(areaIds[i])));
			areaStore.setStore(store);
			save(areaStore);
		}
		
		
		return true;
		
	}
	
	
	

}
