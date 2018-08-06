package org.springlessons.loginapp.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {
	
	private static Logger LOG = Logger.getLogger(LoginController.class);
	
	@RequestMapping(value="/", method= RequestMethod.GET)
	public String loginPage(){
		return "login";
	}
	
	@RequestMapping(value="/login", method= RequestMethod.POST)
	public ModelAndView loginAuthentication(HttpServletRequest request, HttpServletResponse response){
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
				ModelAndView mav = new ModelAndView("homepage");
				mav.addObject("user", user);
				return mav;
			}
			else{
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
