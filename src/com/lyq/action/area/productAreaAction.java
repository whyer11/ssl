package com.lyq.action.area;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.framework.Dao.AreaDao;
import com.framework.Dao.DAOQuery;
import com.lyq.model.all.Area;
import com.lyq.model.all.AreaStore;

public class productAreaAction {
   



	private Integer areaId;
	private Integer parentId;
	private String name;
	private Set stores = new HashSet(0);
	private Set customers = new HashSet(0);
	private Set addresses = new HashSet(0);
	private Set products = new HashSet(0);
	private AreaDao areadao;
	private Area area;
	private List<Area> arealist;
	private Integer  touareaId;
	
 public Integer getTouareaId() {
		return touareaId;
	}



	public void setTouareaId(Integer touareaId) {
		this.touareaId = touareaId;
	}



public Integer getAreaId() {
		return areaId;
	}



	public void setAreaId(Integer areaId) {
		this.areaId = areaId;
	}



	public Integer getParentId() {
		return parentId;
	}



	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public Set getStores() {
		return stores;
	}



	public void setStores(Set stores) {
		this.stores = stores;
	}



	public Set getCustomers() {
		return customers;
	}



	public void setCustomers(Set customers) {
		this.customers = customers;
	}



	public Set getAddresses() {
		return addresses;
	}



	public void setAddresses(Set addresses) {
		this.addresses = addresses;
	}



	public Set getProducts() {
		return products;
	}



	public void setProducts(Set products) {
		this.products = products;
	}


	

public String getAllArea() {
	  areadao=new AreaDao();
	 DAOQuery daoquery=new DAOQuery();
	 daoquery.set_whereClause("parentId=1");
	 arealist=areadao.select(daoquery);
	return "areaList";
}
public String getAllAreashouye() {
	  areadao=new AreaDao();
	 DAOQuery daoquery=new DAOQuery();
	 daoquery.set_whereClause("parentId=1");
	 arealist=areadao.select(daoquery);
	return "getAllAreashouye";
}

public String  getStore() {
	areadao=new AreaDao();
	DAOQuery daoQuery=new DAOQuery();
	daoQuery.set_whereClause("parentId="+this.touareaId);
	arealist=areadao.select(daoQuery);
	return  "storeList";
	
}


public String getSecondArea(){
	areadao=new AreaDao();
	DAOQuery daoQuery=new DAOQuery();
	daoQuery.set_whereClause("parentId="+this.areaId);
	arealist=areadao.select(daoQuery);
	return "areaList1";
}


public AreaDao getAreadao() {
	return areadao;
}



public void setAreadao(AreaDao areadao) {
	this.areadao = areadao;
}



public Area getArea() {
	return area;
}



public void setArea(Area area) {
	this.area = area;
}



public List<Area> getArealist() {
	return arealist;
}



public void setArealist(List<Area> arealist) {
	this.arealist = arealist;
}
	

}
