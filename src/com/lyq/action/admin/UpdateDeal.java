package com.lyq.action.admin;

import java.io.PrintWriter;
import java.io.Writer;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.framework.Dao.AdministratorDao;
import com.framework.Dao.DAOQuery;
import com.framework.Dao.ProductDao;
import com.framework.Dao.SlidesDao;
import com.lyq.admin.interceptor.LoginInterceptor;
import com.lyq.model.all.Administrator;
import com.lyq.model.all.Slides;
import com.lyq.util1.DateUtil;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class UpdateDeal extends ActionSupport {

	Slides slides;
	SlidesDao slidesDao;
	List<Slides> slidesLists;
	String spicname;
	String spicUrl;
	String surl;
	Integer pageCount;
	Integer pageIndex;
	HttpServletRequest request = ServletActionContext.getRequest();
	HttpServletResponse response = ServletActionContext.getResponse();
	String searchClause;
	String selectValue;
	boolean unDeleted;
	boolean hasDeleted;
	boolean hasdisplayed;
	Timestamp screateTime;
	Integer slideId;
	Integer scount;
	private String oldpasswd;
	private String newpasswd;
	private String renewpasswd;
	Map session;
	
	public void setSession(Map session) {
		this.session = session;
	}
	public Map getSession() {
		return session;
	}
	public void setScreateTime(Timestamp screateTime) {
		this.screateTime = screateTime;
	}

	public Timestamp getScreateTime() {
		return screateTime;
	}

	public void setScount(Integer scount) {
		this.scount = scount;
	}

	public Integer getScount() {
		return scount;
	}

	public void setSlideId(Integer slideId) {
		this.slideId = slideId;
	}

	public Integer getSlideId() {
		return slideId;
	}

	public String getSpicname() {
		return spicname;
	}

	public void setSpicname(String spicname) {
		this.spicname = spicname;
	}

	public String getSpicUrl() {
		return spicUrl;
	}

	public void setSpicUrl(String spicUrl) {
		this.spicUrl = spicUrl;
	}

	public String getSurl() {
		return surl;
	}

	public void setSurl(String surl) {
		this.surl = surl;
	}

	public void setSlides(Slides slides) {
		this.slides = slides;
	}

	public Slides getSlides() {
		return slides;
	}

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		slides = new Slides();
		return SUCCESS;
	}

	public String slidesAdd() throws Exception {
		slides = new Slides();
		return "slidesAdd";
	}

	public String slidesModified() throws Exception {
		slidesDao = new SlidesDao();

		System.out.println(slideId + "abd");
		if (slideId == null) {
			Date date = new Date();
			screateTime = Timestamp.valueOf(DateUtil.formatDate(date));
			slides = new Slides();
			slides.setPicUrl(spicUrl);
			slides.setUrl(surl);
			slides.setPicname(spicname);
			slides.setCreateTime(screateTime);
			slides.setState(false);
			slides.setDeleted(false);
			slidesDao.save(slides);
		} else {
			slides = slidesDao.selectById(slideId);
			slides.setPicUrl(spicUrl);
			slides.setUrl(surl);
			slides.setPicname(spicname);
			slides.setState(false);
			slides.setDeleted(false);
			slidesDao.update(slides);
		}

		System.out.println("slides:" + slides.getSlideId());
		return slidesList();
	}

	public String slidesShow() {

		slideId = Integer.valueOf(ServletActionContext.getRequest()
				.getParameter("showsId"));
		slidesDao = new SlidesDao();
		slides = slidesDao.selectById(slideId);

		return "slides_show";
	}

	public String slidesList() throws Exception {
		try {
			slidesDao = new SlidesDao();
			DAOQuery daoQuery = new DAOQuery();
			Integer rowCount = -1;
			Integer storeId = -1;
			Integer pageSize = 8;
			String showsIdString = request.getParameter("showsId");
			if (searchClause != null && searchClause != "") {
				searchClause = new String(searchClause.getBytes("iso-8859-1"),
						"utf-8");
				System.out.println("searchCluasePage:" + searchClause);
				daoQuery.set_whereClause(" picname like '%" + searchClause
						+ "%'");
				rowCount = slidesDao
						.selectCount("select count(*) from Slides where  picname like '%"
								+ searchClause + "%'");
			}
			// selectValue = request.getParameter("selectValue");
			// if (showsIdString != null && showsIdString != "") {
			// storeId = Integer.valueOf(showsIdString);
			// }
			// if (storeId != -1) {
			// daoQuery.set_whereClause("store.storeId=" + storeId);
			// }

			if (selectValue != null) {
				ActionDealHelper.selectValueMethod(daoQuery, selectValue,
						"price", "createTime", "category", "store");
			}
			String sqlCountString = "select count(*) from Slides where deleted=";
			if (unDeleted) {
				sqlCountString += "false ";
				if (searchClause != null && searchClause != "") {
					sqlCountString += "and picname like '%" + searchClause
							+ "%'";
				}
				daoQuery.set_whereClause(" deleted=false and picname like '%"
						+ searchClause + "%'");
				rowCount = slidesDao.selectCount(sqlCountString);
			}

			if (hasdisplayed) {
				sqlCountString += "true ";
				if (searchClause != null && searchClause != "") {
					sqlCountString += "and picname like '%" + searchClause
							+ "%'";
				}
				daoQuery.set_whereClause(" state=true and picname like '%"
						+ searchClause + "%'");
				rowCount = slidesDao.selectCount(sqlCountString);
			}

			if (hasDeleted) {
				sqlCountString += "true ";
				if (searchClause != null && searchClause != "") {
					sqlCountString += "and picname like '%" + searchClause
							+ "%'";
				}
				System.out.println(sqlCountString);
				daoQuery.set_whereClause(" deleted=true and picname like '%"
						+ searchClause + "%'");
				rowCount = slidesDao.selectCount(sqlCountString);
			}
			if (rowCount == -1) {
				rowCount = slidesDao
						.selectCount("select count(*) from Slides ");
			}
			if (rowCount >= 1) {
				pageCount = (rowCount - 1) / pageSize + 1;
			} else {
				pageCount = 0;
			}
			if (pageIndex == null || pageIndex <= 0) {
				pageIndex = 1;
			}
			if (pageIndex > pageCount) {
				pageIndex = pageCount;
			}
			daoQuery.set_pageIndex(pageIndex - 1);
			daoQuery.set_pageSize(pageSize);
			slidesLists = slidesDao.select(daoQuery);
			return SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/*
	 * 在前端显示，直接调用数据库。
	 */
	public String SlidesDisplay() {
		slidesDao = new SlidesDao();
		DAOQuery daoQuery = new DAOQuery();
		daoQuery.set_whereClause(" state=true ");
		slidesLists = slidesDao.select(daoQuery);

		for (Slides slides : slidesLists) {
			System.out.println("aaaa:" + slides.getUrl());
		}
		return "big_banner";
	}

	/*
	 * 修改事件
	 */
	public String slidesModify() {

		// slideId = Integer.valueOf(request.getParameterslideIdId"));

		slidesDao = new SlidesDao();
		slides = slidesDao.selectById(slideId);

		return "slides_modified";
	}

	/*
	 * 商品查看
	 */
	// public String shows() {
	//
	// productId = Integer.valueOf(ServletActionContext.getRequest()
	// .getParameter("showsId"));
	// productDao = new ProductDao();
	// product = productDao.selectById(productId);
	// return "product_show";
	// }

	/*
	 * 恢复删除的商品
	 */
	public String slidesDeleted() throws Exception {

		slidesDao = new SlidesDao();
		// Integer slidesId = Integer.valueOf(ServletActionContext.getRequest()
		// .getParameter("slidesId"));
		slides = slidesDao.selectById(slideId);
		if (slides.getDeleted() == true) {
			slides.setDeleted(false);
		} else {
			slides.setDeleted(true);
		}
		slidesDao.update(slides);
		return slidesList();
	}

	/*
	 * 显示
	 */
	public String slidesState() throws Exception {
		slidesDao = new SlidesDao();
		// Integer slidesId = Integer.valueOf(ServletActionContext.getRequest()
		// .getParameter("slidesId"));
		slides = slidesDao.selectById(slideId);

		String scountSql = "select count(*) from Slides where state=true";
		scount = slidesDao.selectCount(scountSql);
		if (scount < 7) {
			if (slides.getState() == true) {
				slides.setState(false);
			} else {
				slides.setState(true);
			}
		} else {
			if (slides.getState() == true) {
				slides.setState(false);
			} else {
				System.out.println("无法显示更多");
				// response.setCharacterEncoding("utf-8");
				// PrintWriter out=response.getWriter();
				// out.println("<html><body><div><span>");
				// out.println("无法显示更多</span></div></body></html>");
				// slides.setState(true);
			}
		}

		slidesDao.update(slides);
		return slidesList();
	}

	public String pwd() {

		return "repassword";
	}

	/*
	 * 修改密码
	 */
	public String repwd() {

		if (oldpasswd != null && newpasswd != null && renewpasswd != null
				&& newpasswd.equals(renewpasswd)) {
			AdministratorDao administratorDao = new AdministratorDao();
			ActionContext actionContext = ActionContext.getContext();
			session = actionContext.getSession();
			Administrator administrator = (Administrator) session.get(LoginInterceptor.USER_SESSION_KEY);
//			Administrator administrator = administratorDao.selectById(1);
			if (oldpasswd.equals(administrator.getPassword())) {
				administrator.setPassword(newpasswd);
				administratorDao.update(administrator);
				return "repassword_success";
			}
			else {
				return "repassword";
			}			
		}
		return "repassword";

	}

	public List<Slides> getSlidesLists() {
		return slidesLists;
	}

	public void setSlidesLists(List<Slides> slidesLists) {
		this.slidesLists = slidesLists;
	}

	public Integer getPageCount() {
		return pageCount;
	}

	public void setPageCount(Integer pageCount) {
		this.pageCount = pageCount;
	}

	public Integer getPageIndex() {
		return pageIndex;
	}

	public void setPageIndex(Integer pageIndex) {
		this.pageIndex = pageIndex;
	}

	public HttpServletRequest getRequest() {
		return request;
	}

	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}

	public String getSearchClause() {
		return searchClause;
	}

	public void setSearchClause(String searchClause) {
		this.searchClause = searchClause;
	}

	public String getSelectValue() {
		return selectValue;
	}

	public void setSelectValue(String selectValue) {
		this.selectValue = selectValue;
	}

	public boolean isUnDeleted() {
		return unDeleted;
	}

	public void setUnDeleted(boolean unDeleted) {
		this.unDeleted = unDeleted;
	}

	public boolean isHasDeleted() {
		return hasDeleted;
	}

	public void setHasDeleted(boolean hasDeleted) {
		this.hasDeleted = hasDeleted;
	}

	public boolean isHasdisplayed() {
		return hasdisplayed;
	}

	public void setHasdisplayed(boolean hasdisplayed) {
		this.hasdisplayed = hasdisplayed;
	}

	public String getOldpasswd() {
		return oldpasswd;
	}

	public void setOldpasswd(String oldpasswd) {
		this.oldpasswd = oldpasswd;
	}

	public String getNewpasswd() {
		return newpasswd;
	}

	public void setNewpasswd(String newpasswd) {
		this.newpasswd = newpasswd;
	}

	public String getRenewpasswd() {
		return renewpasswd;
	}

	public void setRenewpasswd(String renewpasswd) {
		this.renewpasswd = renewpasswd;
	}

}
