package org.springmvcdemo.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HelloWorldController {

	private static Logger LOG = Logger.getLogger(HelloWorldController.class);
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String helloWorld(ModelMap model) {
		model.addAttribute("message", "Welcome");
		LOG.info("Inside welcome method..."+model);
		// Spring uses InternalResourceViewResolver and return back index.jsp
		return "index";
	}

	@RequestMapping(value = "/{name}", method = RequestMethod.GET)
	public String helloWorldName(@PathVariable String name, ModelMap model) {
		LOG.info("Inside welcome method..."+model);
		model.addAttribute("message", "Welcome " + name);
		return "index";
	}
}
