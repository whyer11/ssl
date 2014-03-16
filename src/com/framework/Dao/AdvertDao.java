package com.framework.Dao;

import java.util.List;

import com.lyq.model.all.Advert;

public class AdvertDao extends StandardEntityDAO<Advert>{
	
   public List<Advert> findAll(int pageSize,int pageNumber){
	   DAOQuery daoQuery = new DAOQuery();
	   daoQuery.set_pageIndex(pageNumber-1);
	   daoQuery.set_pageSize(pageSize);
		return select(daoQuery);
	     
   }
    
   public List<Advert> findAll(){   
	   return selectAll();
   }

}
