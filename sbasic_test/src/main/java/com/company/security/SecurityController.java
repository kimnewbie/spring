package com.company.security;

import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@RequestMapping("/security/*")

public class SecurityController {
	@GetMapping("/all")
	public String all() {
		log.info("..........................SecurityController all");
		return "security/all";
	}

	@GetMapping("/member")
	public String member() {
		log.info("..........................SecurityController member");
		return "security/member";
	}
	
	@GetMapping("/admin")
	public String admin() {
		log.info("..........................SecurityController admin");
		return "security/admin";
	}
	
	@GetMapping("/mylogin")
	public String mylogin() {
		log.info("..........................SecurityController admin");
		return "security/login";
	}

	@GetMapping("/accessError")
	public String accessError(AuthenticationSuccessHandler auth, Model model) {
		model.addAttribute("msg","Access Denied");
		return "security/accessError";
	}
}
