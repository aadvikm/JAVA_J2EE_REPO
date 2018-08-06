package org.springpractice.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springpractice.domain.User;

@Controller
public class LoginController {
private static Logger LOG = Logger.getLogger(LoginController.class);
	
	@RequestMapping(value="/", method= RequestMethod.GET)
	public String indexPage(){
		LOG.info("Inside index page...");
		return "locPage";
	}
	
	@RequestMapping(value="/login", method= RequestMethod.POST)
	public ModelAndView loginAuthentication(HttpServletRequest request, HttpServletResponse response){
		LOG.info("Inside login authentication...");
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, PUT, DELETE");
		response.setHeader("Access-Control-Max-Age", "3600");
		response.setHeader("Access-Control-Allow-Headers", "Content-Type, x-requested-with, authorization, ACCESS_TOKEN, TIME_OF_CALL");
		try{
			String username =request.getParameter("username");
			String password =request.getParameter("password");
			boolean authentication=false;
			if(username.equalsIgnoreCase("Brindha") && password.equalsIgnoreCase("Brindha")){
				authentication=true;
			}
			else if(username.equalsIgnoreCase("Aadvik") && password.equalsIgnoreCase("Aadvik")){
				authentication=true;
			}
			else if(username.equalsIgnoreCase("Muthu") && password.equalsIgnoreCase("Muthu")){
				authentication=true;
			}	
			if(authentication){
				HttpSession session=request.getSession();
				User user = new User(username);
				session.setAttribute("user", user);//putting user in session
				ModelAndView mav = new ModelAndView();
				mav.addObject("user", user);
				response.setHeader("Allow", "GET, OPTIONS, POST");
				LOG.info("returing locPage...");
				return mav;
			}
			else{
				LOG.info("returing error page...");
				ModelAndView mav = new ModelAndView("loginFail");
				return mav;
			}
		}
		catch(Exception exception){
			LOG.error("Error occurred in login method", exception);
			ModelAndView mav = new ModelAndView("errorPage");//As of now, no error page is created, but needs to be created to display error msg
			return mav;
		}
		
	}
}
