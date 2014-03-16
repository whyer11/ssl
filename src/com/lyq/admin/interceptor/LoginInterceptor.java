package com.lyq.admin.interceptor;

import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.apache.struts2.StrutsStatics;

import com.framework.Dao.AdministratorDao;
import com.lyq.model.all.Administrator;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class LoginInterceptor extends AbstractInterceptor {
	public static final String USER_SESSION_KEY = "fallow.session.user";
	public static final String COOKIE_REMEMBERME_KEY = "fallow.cookie.rememberme";
	public static final String GOING_TO_URL_KEY = "GOING_TO";
	private AdministratorDao administratorDao;

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {

		ActionContext actionContext = invocation.getInvocationContext();
		Map session = actionContext.getSession();
		Administrator administrator = (Administrator) session
				.get(USER_SESSION_KEY);
//		System.out.println(administrator.getRealName()+",");
//		if (administrator!=null) {
//			session.put(LoginInterceptor.USER_SESSION_KEY, administrator);
//		}
		System.out.println("LoginInterceptor"+session);
		if (administrator != null&&administrator.getRealName()!=null) {
			System.out.println("成功");
			return invocation.invoke();
		} else {
			System.out.println("失败");
			return "admin_login";
		}

	}
	// TODO Auto-generated method stub
	// ActionContext actionContext = invocation.getInvocationContext();
	// HttpServletRequest request = (HttpServletRequest) actionContext
	// .get(StrutsStatics.HTTP_REQUEST);
	// Map session = actionContext.getSession();
	//
	// if (session != null && session.get(USER_SESSION_KEY) != null) {
	// return invocation.invoke();
	// }
	// Cookie[] cookies = request.getCookies();
	// if (cookies != null) {
	// for (Cookie cookie : cookies) {
	// if (COOKIE_REMEMBERME_KEY.equals(cookie.getName())) {
	// String value = cookie.getValue();
	// if (StringUtils.isNotBlank(value)) {
	// String[] split = value.split("==");
	// String userName = split[0];
	// String password = split[1];
	// try {
	// Administrator administrator = administratorDao
	// .attemptLogin(userName, password);
	//
	// session.put(USER_SESSION_KEY, administrator);
	//
	// } catch (Exception e) {
	// setGoingToURL(session, invocation);
	// return "login";
	// // TODO: handle exception
	// }
	//
	// } else {
	// setGoingToURL(session, invocation);
	// return "login";
	// }
	// return invocation.invoke();
	// }
	// }
	// }
	// setGoingToURL(session, invocation);
	// return "login";
	// }
	//
	// private void setGoingToURL(Map session, ActionInvocation invocation) {
	// String url = "";
	// String namespace = invocation.getProxy().getNamespace();
	// if (StringUtils.isNotBlank(namespace) && !namespace.equals("/")) {
	// url = url + namespace;
	// }
	// String actionName = invocation.getProxy().getActionName();
	// if (StringUtils.isNotBlank(actionName)) {
	// url = url + "/" + actionName + ".action";
	// }
	// session.put(GOING_TO_URL_KEY, url);
	// }
	//
	// public AdministratorDao getAdministratorDao() {
	// return administratorDao;
	// }
	//
	// public void setAdministratorDao(AdministratorDao administratorDao) {
	// this.administratorDao = administratorDao;
	// }

}
