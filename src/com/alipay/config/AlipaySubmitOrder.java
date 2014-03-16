package com.alipay.config;

import java.util.HashMap;
import java.util.Map;

import com.alipay.util.AlipaySubmit;

public class AlipaySubmitOrder {
	String payment_type = "1";
	// 必填，不能修改
	// 服务器异步通知页面路径
	String notify_url = "http://www.xxx.com/apitaobao/notify_url.jsp";
	// 需http://格式的完整路径，不能加?id=123这类自定义参数
	// 页面跳转同步通知页面路径
	String return_url = "http://www.xxx.com/apitaobao/return_url.jsp";
	// 需http://格式的完整路径，不能加?id=123这类自定义参数，不能写成http://localhost/
	// 卖家支付宝帐户
	String seller_email=AlipayConfig.alipayAccount;
	// 必填
	// 商户订单号
	String out_trade_no;
	// 商户网站订单系统中唯一订单号，必填
	// 订单名称
	String subject;
	// 必填
	// 付款金额
	String total_fee;
	// 必填
	// 订单描述
	String body;
	// 商品展示地址
	String show_url;
	// 需以http://开头的完整路径，例如：http://www.xxx.com/myorder.html
	// 防钓鱼时间戳
	String anti_phishing_key = "";
	// 若要使用请调用类文件submit中的query_timestamp函数
	// 客户端的IP地址
	String exter_invoke_ip = "";
	// 非局域网的外网IP地址，如：221.0.0.1
	// //建立请求
	private String sHtmlText;

	public String getPayment_type() {
		return payment_type;
	}

	public void setPayment_type(String payment_type) {
		this.payment_type = payment_type;
	}

	public String getNotify_url() {
		return notify_url;
	}

	public void setNotify_url(String notify_url) {
		this.notify_url = notify_url;
	}

	public String getReturn_url() {
		return return_url;
	}

	public void setReturn_url(String return_url) {
		this.return_url = return_url;
	}

	public String getSeller_email() {
		return seller_email;
	}

	public void setSeller_email(String seller_email) {
		this.seller_email = seller_email;
	}

	public String getOut_trade_no() {
		return out_trade_no;
	}

	public void setOut_trade_no(String out_trade_no) {
		this.out_trade_no = out_trade_no;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getTotal_fee() {
		return total_fee;
	}

	public void setTotal_fee(String total_fee) {
		this.total_fee = total_fee;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public String getShow_url() {
		return show_url;
	}

	public void setShow_url(String show_url) {
		this.show_url = show_url;
	}

	public String getAnti_phishing_key() {
		return anti_phishing_key;
	}

	public void setAnti_phishing_key(String anti_phishing_key) {
		this.anti_phishing_key = anti_phishing_key;
	}

	public String getExter_invoke_ip() {
		return exter_invoke_ip;
	}

	public void setExter_invoke_ip(String exter_invoke_ip) {
		this.exter_invoke_ip = exter_invoke_ip;
	}

	public String getsHtmlText() {
		Map<String, String> sParaTemp = new HashMap<String, String>();
		sParaTemp.put("service", "create_direct_pay_by_user");
		sParaTemp.put("partner", AlipayConfig.partner);
		sParaTemp.put("_input_charset", AlipayConfig.input_charset);
		sParaTemp.put("payment_type", payment_type);
		sParaTemp.put("notify_url", notify_url);
		sParaTemp.put("return_url", return_url);
		sParaTemp.put("seller_email", seller_email);
		sParaTemp.put("out_trade_no", out_trade_no);
		sParaTemp.put("subject", subject);
		sParaTemp.put("total_fee", total_fee);
		sParaTemp.put("body", body);
		sParaTemp.put("show_url", show_url);
		sParaTemp.put("anti_phishing_key", anti_phishing_key);
		sParaTemp.put("exter_invoke_ip", exter_invoke_ip);
		sHtmlText = AlipaySubmit.buildRequest(sParaTemp, "get", "确认");
		return sHtmlText;
	}

}
