package com.teste.RESTService.dataobject;

import com.teste.RESTService.entity.Account;

public class ReturnMessage {
	
	private String message;
	
	private Account account;
	
	public ReturnMessage(String message, Account account) {
		setMessage(message);
		setAccount(account);
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}
	

}
