package com.struts2practice.action;

import org.apache.log4j.Logger;

import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport{

	private static Logger LOG = Logger.getLogger(LoginAction.class);
	
	public String execute(){
		LOG.info("Inside index page...");
		return "success";
	}
	
}
