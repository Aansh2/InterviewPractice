package com.websystique.springboot.controller;

import freemarker.cache.TemplateLoader;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AppController {

	@RequestMapping("/index")
	String home(ModelMap modal) {
		modal.addAttribute("title","Spring 4 MVC CRUD Example");
		String path = "index";
 		return path;
	}

	@RequestMapping("/partials/{page}")
	String partialHandler(@PathVariable("page") final String page) {
		return page;
	}

}
