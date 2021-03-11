package com.company.security;
 

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@RequestMapping("/security/*")
public class SecurityController {
	private static final org.slf4j.Logger logger = LoggerFactory.getLogger(SecurityController.class);
	
	/*
	 * security-context.xml *
	<security: intercept-url pattern="/security/all" access="permitAll"/>
	<security: intercept-url pattern="/security/member" access="hasRole('ROLE_MEMBER')"/>
	*/
	@GetMapping("/all")
	public String all() {
		logger.info("..........................all");
		return "home";
	}

	@GetMapping("/member")
	public String member() {
		logger.info("..........................member");
		return "security/member";
	}
	
}
