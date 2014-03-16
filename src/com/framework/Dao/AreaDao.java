package com.framework.Dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.lyq.model.all.Area;

public class AreaDao extends StandardEntityDAO<Area> {
	
	/**
	 * 查询所有的一级分类
	 * @return
	 */
	public List<Area> getAllFirstLeverArea( ){
		DAOQuery dq = new DAOQuery();
		dq.set_whereClause("parentId=0");
		return select(dq);
		
	}
	
	/**
	 * 查询所有的二级分类
	 * @return
	 */
	public List<Area> getAllSecoundLeverArea()
	{
	List<Area> all =new ArrayList<Area>();
	List<Area> firstLever =getAllFirstLeverArea();
	for(int i=0;i<firstLever.size();i++){
		Area a= firstLever.get(i);
		System.out.println(a.toString());
		 DAOQuery dq1 =new DAOQuery();
		dq1.set_whereClause("parentId="+a.getAreaId());
		all.addAll(select(dq1));
	}
		return all;
	}
	
	/**
	 * 通过上级分类的Id查询下级
	 * @return
	 */
	
	public List<Area> getSubAreaByParenttArea( int parentId ){
		DAOQuery dq =new DAOQuery();
		dq.set_whereClause("parentId="+parentId);
		return select(dq);
	}
	
	
	public Area getSupAreaByArea(Area area){
		
		if(area.getParentId()!=null){
		DAOQuery dq =new DAOQuery();
		dq.set_whereClause("areaId="+area.getParentId());
		return select(dq).get(0);
		}
		else     return null;
		
	}

	

}
