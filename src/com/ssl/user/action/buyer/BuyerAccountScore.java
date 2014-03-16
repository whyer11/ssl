package com.ssl.user.action.buyer;

import java.io.PrintWriter;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.alipay.config.AlipayConfig;
import com.alipay.config.AlipaySubmitOrder;
import com.framework.Dao.CustomerDao;
import com.lyq.model.all.Customer;
import com.opensymphony.xwork2.ActionSupport;

public class BuyerAccountScore extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3288103234921053696L;
	private Integer customerId;
	private Integer score;
	private Integer scoreRmb;
	private Integer paytype;
	/*
	 * 卖家账号,订单号和订单名称,金额，订单描述
	 */
	private String WIDseller_email;
	private String WIDout_trade_no;
	private String WIDsubject;
	private String WIDtotal_fee;
	private String WIDbody;
	// 商品展示地址，可选。
	private String WIDshow_url;
	private String SHtmlText;

	public void setSHtmlText(String sHtmlText) {
		SHtmlText = sHtmlText;
	}

	public String getSHtmlText() {
		return SHtmlText;
	}

	public void setPaytype(Integer paytype) {
		this.paytype = paytype;
	}

	public Integer getPaytype() {
		return paytype;
	}

	public void setScoreRmb(Integer scoreRmb) {
		this.scoreRmb = scoreRmb;
	}

	public Integer getScoreRmb() {
		return scoreRmb;
	}

	public void setScore(Integer score) {
		this.score = score;
	}

	public Integer getScore() {
		return score;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	public Integer getCustomerId() {
		return customerId;
	}

	/*
	 * 我的积分
	 */
	public String myscore() throws Exception {
		// TODO Auto-generated method stub

		CustomerDao customerDao = new CustomerDao();
		Customer customer;

		HttpSession session = (HttpSession) ServletActionContext.getRequest()
				.getSession();
		System.out.println(session + "11222");
		if (session != null && session.getAttribute("login_username") != null) {

			customer = customerDao.findByUserName((String) session
					.getAttribute("login_username"));
			customerId = customer.getCustomerId();
			score = customer.getScore();
			return "myscore";
		}
		System.out.println("mysssssssssss:"
				+ session.getAttribute("login_username"));

		return INPUT;
	}

	/*
	 * 充值积分
	 */
	public String chargeScore() throws Exception {

		return SUCCESS;

	}

	public String payForScore() throws Exception {
		System.out.println("paytype:" + paytype);
		System.out.println("WIDtotal_fee:" + WIDtotal_fee);
		if (paytype == null || WIDtotal_fee == null || paytype <= 0
				|| Integer.valueOf(WIDtotal_fee) <= 0) {
			return INPUT;
		}

		WIDout_trade_no = "1";
		WIDsubject = "2";
		if (paytype == 1) {
			System.out.println("alipay_score");
			AlipaySubmitOrder aso = new AlipaySubmitOrder();
			aso.setOut_trade_no(WIDout_trade_no);
			aso.setSubject(WIDsubject);
			aso.setTotal_fee(WIDtotal_fee);
			/*
			 * aso.setBody aso.setShow_url
			 */
			PrintWriter out = ServletActionContext.getResponse().getWriter();
			// SHtmlText = aso.getsHtmlText();
			// WIDbody = aso.getsHtmlText();
			SHtmlText = aso.getsHtmlText();
			System.out.println("sH:" + SHtmlText);
			// WHtmlText = aso.getsHtmlText();
			return "alipay_score";
		}

		/*
		 * 扩展到其他支付方式
		 */
		return null;
	}

	public String getWIDseller_email() {
		return WIDseller_email;
	}

	public void setWIDseller_email(String wIDseller_email) {
		WIDseller_email = AlipayConfig.alipayAccount;
	}

	public String getWIDout_trade_no() {
		return WIDout_trade_no;
	}

	public void setWIDout_trade_no(String wIDout_trade_no) {
		WIDout_trade_no = wIDout_trade_no;
	}

	public String getWIDsubject() {
		return WIDsubject;
	}

	public void setWIDsubject(String wIDsubject) {
		WIDsubject = wIDsubject;
	}

	public String getWIDtotal_fee() {
		return WIDtotal_fee;
	}

	public void setWIDtotal_fee(String wIDtotal_fee) {
		WIDtotal_fee = wIDtotal_fee;
	}

	public String getWIDbody() {
		return WIDbody;
	}

	public void setWIDbody(String wIDbody) {

		WIDbody = wIDbody;
	}

	public String getWIDshow_url() {
		return WIDshow_url;
	}

	public void setWIDshow_url(String wIDshow_url) {
		WIDshow_url = wIDshow_url;
	}
}
