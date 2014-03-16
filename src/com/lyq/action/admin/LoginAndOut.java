package com.lyq.action.admin;

import java.util.Map;

import javax.mail.Session;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.apache.struts2.ServletActionContext;

import com.framework.Dao.AdministratorDao;
import com.lyq.admin.interceptor.LoginInterceptor;
import com.lyq.model.all.Administrator;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class LoginAndOut extends ActionSupport {
	private AdministratorDao administratorDao;
	private String username;
	private String password;
	private HttpServletResponse response;
	private HttpServletRequest request;
	private Map session;
	private Map cookies;
	private String goingToURL;

	public void setSession(Map session) {
		this.session = session;
	}

	public Map getSession() {
		return session;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		return SUCCESS;
	}

	public String login() throws Exception {
		ActionContext actionContext = ActionContext.getContext();
		session = actionContext.getSession();
		System.out.println(username + "," + password);
		System.out.println("abcs");
		administratorDao = new AdministratorDao();
		Administrator administrator = administratorDao.attemptLogin(username,
				password);
//		System.out.println("admin:"+administrator.getRealName());
		System.out.println("回车可见1");
		if (administrator != null&&administrator.getRealName().equals(username)&&administrator.getPassword().equals(password)) {
			System.out.println("abcnotnull");
			System.out.println("回车可见2");
			session.put(LoginInterceptor.USER_SESSION_KEY, administrator);
			return SUCCESS;
			// session.put(LoginInterceptor.USER_SESSION_KEY, administrator);
		} else {
			return INPUT;
		}

		// String goingToURL = (String) session
		// .get(LoginInterceptor.GOING_TO_URL_KEY);
		// System.out.println("goingToURL:" + goingToURL);
		// if (StringUtils.isNotBlank(goingToURL)) {
		// setGoingToURL(goingToURL);
		// session.remove(LoginInterceptor.GOING_TO_URL_KEY);
		// } else {
		// setGoingToURL("index.action");
		// }
		// System.out.println("success");

	}

	public String logout() throws Exception{
		ActionContext actionContext = ActionContext.getContext();
		username="";
		password="";
		session = actionContext.getSession();
		session.clear();
		if (session != null) {
			session.remove(LoginInterceptor.USER_SESSION_KEY);
			
			System.out.println("session in LoginAndOut:"+session);
			
		}		
		
		response=ServletActionContext.getResponse();
		
		response.setHeader("Pragma","No-cache"); 
		response.setHeader("Cache-Control","no-cache"); 
		response.setHeader("Cache-Control", "no-store"); 
		response.setDateHeader("Expires", 0); 
		
		response.sendRedirect("/admin/login.html");

		return INPUT;
	}

	public HttpServletResponse getResponse() {
		return response;
	}

	public void setResponse(HttpServletResponse response) {
		this.response = response;
	}

	public HttpServletRequest getRequest() {
		return request;
	}

	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}

	public Map getCookies() {
		return cookies;
	}

	public void setCookies(Map cookies) {
		this.cookies = cookies;
	}

}
