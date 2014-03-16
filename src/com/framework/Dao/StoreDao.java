package com.framework.Dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.lyq.model.all.AreaStore;
import com.lyq.model.all.Store;

public class StoreDao extends StandardEntityDAO<Store>{
	
	
	public List<Store> findAll(int pageNumber,int pageSize,String areaId){
		DAOQuery daoQuery= new DAOQuery();
		List<AreaStore> lasd=new ArrayList<AreaStore>();
		areaStoreDao asd= new areaStoreDao();	
		daoQuery.set_pageIndex(pageNumber-1);
		daoQuery.set_pageSize(pageSize);
		
		
		if(areaId!=null){
			
			
		String whereString ="areaId in ("+areaId+")";
		daoQuery.set_whereClause(whereString);
		lasd= asd.select(daoQuery);
		System.out.println("-------"+lasd.size());
		
		
		}else {
			lasd=asd.select(daoQuery);
		}
		
		List<Store> ls=new ArrayList<Store>();	
		for(AreaStore as:lasd) ls.add(as.getStore());
		return ls;		
	
	}
	
	public List<Store> findAll(String areaId){
		DAOQuery daoQuery= new DAOQuery();
		areaStoreDao asd= new areaStoreDao();
		List<AreaStore> lasd= new ArrayList<AreaStore>();
		if(areaId!=null){
		String whereString ="areaId="+areaId;
		daoQuery.set_whereClause(whereString);
		 lasd= asd.select(daoQuery);
		 }
		else {
			 lasd=asd.selectAll();
		 }
		
		List<Store> ls= new ArrayList<Store>();	
		for(AreaStore as:lasd) ls.add(as.getStore());	
		return ls;		
	}
	
	public List<Store> findAll(){
		StoreDao storeDao = new StoreDao();
		return storeDao.selectAll();	
	}
	
	public List<Store> selectById(String[] ids){
		
		String str=ids[0];
		for(int i=1;i<ids.length;i++) str+=","+ids[i];
		
		DAOQuery daoqQuery =new DAOQuery();
		
		String whereClause="storeId in ("+str+")";
		daoqQuery.set_whereClause(whereClause);
			
		return select(daoqQuery);
		
		
		
	}
	
	
	

}
