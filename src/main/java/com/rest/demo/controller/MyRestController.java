package com.rest.demo.controller;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.PageContext;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class MyRestController {

	@GetMapping("/hello")
	public String sayHello(HttpServletRequest request, HttpServletResponse response) {
		//System.out.println(request.getContextPath());
		//System.out.println(PageContext.REQUEST);
		return "hello rest of world";
	}
}
