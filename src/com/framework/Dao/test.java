package com.framework.Dao;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.commons.collections.functors.WhileClosure;
import org.junit.Test;

import com.lyq.action.area.storeAction;
import com.lyq.action.product.productAction;
import com.lyq.model.all.Area;
import com.lyq.model.all.AreaStore;
import com.lyq.model.all.Product;
import com.lyq.model.all.Store;

public class test {
	List<AreaStore> listareastore;

	// private static final List<AreaStore> listareastore = null;
	@Test
	public void test() {

		areaStoreDao areaStore = new areaStoreDao();
		StoreDao storedao=new StoreDao();
		StoreDao storedaodao=new StoreDao();
		AreaDao areadao = new AreaDao();
		List<AreaStore> listareaStores;
		List<Area> listAreas;
		DAOQuery daoQuery = new DAOQuery();
		List<Product> products;
	   Store  store=new Store();
	   store=storedao.selectById(77);  
	   System.out.println(store.getProducts());
	   Iterator<Product> iter= store.getProducts().iterator();
	   System.out.println(iter.next().getName());
	}

	private Set<AreaStore> filter(List<AreaStore> listareastore) {
		Set<AreaStore> setareaStores = new HashSet<AreaStore>();
		Iterator<AreaStore> iter = listareastore.iterator();
		while (iter.hasNext()) {
			setareaStores.add(iter.next());
		}
		return setareaStores;
	}

}
