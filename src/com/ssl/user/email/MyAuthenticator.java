package com.ssl.user.email;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;

/**
 * 进行验证
 * 
 * @author Administrator
 * 
 */

public class MyAuthenticator extends Authenticator {

	private String username;
	private String password;

	public MyAuthenticator() {

	}

	public MyAuthenticator(String username, String password) {

		this.username = username;
		this.password = password;

	}

	@Override
	protected PasswordAuthentication getPasswordAuthentication() {

		return new PasswordAuthentication(username, password);
	}

}
