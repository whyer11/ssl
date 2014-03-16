package com.ssl.user;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.framework.Dao.DAOQuery;
import com.framework.Dao.StandardEntityDAO;
import com.lyq.model.all.Administrator;

public class AdministratorDao extends StandardEntityDAO<Administrator> {
	
	/** 验证管理员登陆
	 * 
	 * @param userName
	 * @param password
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public Administrator login(String userName ,String password){
	DAOQuery  dq  = new DAOQuery();
	dq.set_whereClause(" realName=:userName and password=:password");
	Map  map =new  HashMap<String , Object>();
	map.put("userName", userName);
	map.put("password", password);
	dq.set_parameters(map);
	List<Administrator> la  = select(dq);
	if(la!=null&&la.size()==1) return la.get(0);
	else return null;
		}
	
	/**
	 * 查到所有的管理员
	 * @return
	 */
	public List<Administrator> findAll(){
		return selectAll();

		}

}