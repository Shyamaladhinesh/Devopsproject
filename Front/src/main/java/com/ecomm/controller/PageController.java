package com.ecomm.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

	@Controller
	public class PageController 
	{
		
			@RequestMapping(value="/login")
			public String showLogin()
			{
				return "Login";
			}
			
			@RequestMapping(value="/head")
			public String showHead()
			{
				return "Head";
			}
			
			@RequestMapping(value="/register")
			public String showRegister()
			{
				return "Register";
			}
			
			@RequestMapping(value="/aboutus")
			public String showaboutus()
			{
				return "AboutUs";
			}
			
			@RequestMapping(value="/editProduct")
			public String showEditpro()
			{
				return "EditProduct";
			}
			
			@RequestMapping(value="/UpdateCategory")
			public String showUpdatecat()
			{
				return "UpdateCategory";
			}
			
			
			@RequestMapping(value="/totalproductdispaly")
			public String showtotal()
			{
				return "TotalProductDisplay";
			}
				
			
	}				
