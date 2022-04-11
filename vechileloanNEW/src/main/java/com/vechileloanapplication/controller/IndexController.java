package com.vechileloanapplication.controller;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class IndexController{
	@RequestMapping("/")
	public String index() {
//		ModelAndView mv =new ModelAndView();
//		mv.setViewName("index.jsp");
		return "index";

		
	}
	
	
//	@RequestMapping("/style")
//	public String style() {
//		return "style";
//	}
	@RequestMapping("/user")
	public String user() {
		return "user";
	}
	
	@RequestMapping("/userlogin")
	public String userlogin() {
		return "userlogin";
	}
	
	@RequestMapping("/userdetails")
	public String userdetails() {
		return "userdetails";
	}
	
	@RequestMapping("/userregister")
	public String userregister() {
		return "userregister";
	}
	
	@RequestMapping("/admin")
	public String admin() {
		return "admin";
	}
	
	@RequestMapping("/adminlogin")
	public String adminlogin() {
		return "adminlogin";
	}
	@RequestMapping("/adminreg")
	public String admin_register() {
		return "adminreg";
	}
	
	@RequestMapping("/userhome")
	public String userhome() {
		return "userhome";
	}
	
	
	
	
	
}