package com.company.security;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import lombok.extern.log4j.Log4j;

@Log4j
public class LoginSuccessHandler implements AuthenticationSuccessHandler {

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication auth)
			throws IOException, ServletException {

		log.warn("............... LoginSuccessHandler : Login Success");

		List<String> roleNames = new ArrayList<>();
		auth.getAuthorities().forEach(authority -> {
			roleNames.add(authority.getAuthority());
		});

		log.warn("............... LoginSuccessHandler : ROLE NAMES: " + roleNames);

		if (roleNames.contains("ROLE_ADMIN")) { response.sendRedirect(request.getContextPath() + "/security/admin"); return; }
		if (roleNames.contains("ROLE_MEMBER")) { response.sendRedirect( request.getContextPath() +"/security/member"); return; }

		response.sendRedirect("/");
	}
}


