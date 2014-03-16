package com.framework.Dao;

import static org.junit.Assert.*;

import java.util.Iterator;
import java.util.List;

import org.junit.Test;
import org.omg.CORBA.PRIVATE_MEMBER;

import com.lyq.model.all.Category;
import com.lyq.model.all.Product;









public class test2 {

	@Test
	public final void test() {
		List<Product> products;
        ProductDao _product = new ProductDao();
		DAOQuery _DaoQuery = new DAOQuery();
		_DaoQuery.set_pageIndex(0);
		_DaoQuery.set_pageSize(4);
		_DaoQuery.set_orderByString("createTime");
		products = _product.select(_DaoQuery);
		System.out.println(products.get(0).getPictures());
		String[] str=products.get(0).getPictures().split(",");
		products.get(0).setImageLinkArray(products.get(0).getPictures().split(","));
	
		
		
		for (Product product : products) {
			
			product.setImageLinkArray(product.getPictures().split(","));
			System.out.println(product.getImageLinkArray()[1]);
			System.out.println(product.getImageLinkArray()[2]);
	
		}
	//	System.out.println(products.get(0).getImageLinkArray()[0]);
		
		
	 /*   Iterator<Product> iter=products.iterator();
	    while(iter.hasNext()){
	        iter.next().setImageLinkArray(iter.next().getPictures().split(","));
	        
	       // iter.next().setPictures(iter.next().getImageLinkArray()[1]);
	        
	    }
	    */
	 //  System.out.println(products.get(0).getImageLinkArray()[0]);
	
	}

}
