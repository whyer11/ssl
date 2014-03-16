package com.framework.Dao;

import java.util.HashMap;
import java.util.List;

import com.lyq.model.all.Customer;

public class CustomerDao extends StandardEntityDAO<Customer> {
	
	/**
	 * 通过用户名查询用户信息
	 * @param username
	 * @return
	 */

	public Customer findByUserName(String username){
		DAOQuery dq = new DAOQuery();
		dq.set_whereClause("userName=:username");
		HashMap<String, Object> map =new HashMap<String, Object>();
		map.put("username", username);
		dq.set_parameters(map);
		List<Customer> c =  select(dq);
		if(c.size()==1) return c.get(0);
		else return null;
		
	}
	/**
	 * 通过邮箱查询用户信息
	 *
	 * @param mobile
	 * @return
	 */
	
	public Customer findByEmail(String email){
		DAOQuery dq = new DAOQuery();
		dq.set_whereClause("email=:email");
		HashMap<String, Object> map =new HashMap<String, Object>();
		map.put("email", email);
		dq.set_parameters(map);
		List<Customer> c =  select(dq);
		if(c.size()==1) return c.get(0);
		else return null;
	}
	
	/*
	 * 通过电话查询用户
	 */
	
	
	public Customer  findByMobile(String mobile){
		DAOQuery dq = new DAOQuery();
		dq.set_whereClause("mobile=:mobile");
		HashMap<String, Object> map =new HashMap<String, Object>();
		map.put("mobile", mobile);
		dq.set_parameters(map);
		List<Customer> c =  select(dq);
		if(c.size()==1) return c.get(0);
		else return null;
	}
	

	public boolean updateCustomer(Customer c){
		try {
			update(c);
			return true ;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    return  false;
	}
	
	public List<Customer> findALL(String sexIndex,int areaId){
		DAOQuery daoQuery = new DAOQuery();
		String whereString ="";
		if(sexIndex!=null){
			
			if(sexIndex.equals("男")){
				whereString="sex=男";
			}
			else if(sexIndex.equals("女")){
				whereString="sex=女";
			}
		}
		if(areaId!=0){			
			if(whereString!=null&&whereString.length()!=0){
				whereString+="AND areaId="+areaId;
			}
			else whereString+="areaId="+areaId;	
			
		}
		daoQuery.set_whereClause(whereString);
		return select(daoQuery);
	}
	public List<Customer> findAll(int pageSize,int pageNumber,String sexIndex,int areaId){
		   DAOQuery daoQuery = new DAOQuery();
		   daoQuery.set_pageIndex(pageNumber-1);
		   daoQuery.set_pageSize(pageSize);
			String whereString ="";
			if(sexIndex!=null){
				
				if(sexIndex.equals("男")){
					whereString="sex=男";
				}
				else if(sexIndex.equals("女")){
					whereString="sex=女";
				}
			}
			if(areaId!=0){			
				if(whereString!=null&&whereString.length()!=0){
					whereString+="AND areaId="+areaId;
				}
				else whereString+="areaId="+areaId;	
				
			}
			daoQuery.set_whereClause(whereString);
			return select(daoQuery);
	}
	
	
	public List<Customer> findById(String[] ids){
		String str=ids[0];
		for(int i=1;i<ids.length;i++) str+=","+ids[i];
		
		DAOQuery daoqQuery =new DAOQuery();
		
		String whereClause="customerId in ("+str+")";
		daoqQuery.set_whereClause(whereClause);
			
		return select(daoqQuery);	
	}


}
