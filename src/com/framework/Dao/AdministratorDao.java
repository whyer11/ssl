package com.framework.Dao;

import java.util.List;

import com.lyq.model.all.Administrator;

public class AdministratorDao extends StandardEntityDAO<Administrator>{
	
	public Administrator attemptLogin(String username,String password) {
		List<Administrator> listaAdministrators=selectAll();
		
		for (Administrator administrator : listaAdministrators) {
			
			if (null!=username&&null!=password&&username.equals(administrator.getRealName())&&password.equals(administrator.getPassword())) {
				System.out.println(administrator.getRealName()+",,,,"+administrator.getPassword());
				return administrator;
				
			}
			
		}
		return null;
		
		
		
	}

}
