package com.company.exception;

import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.NoHandlerFoundException;

import lombok.extern.log4j.Log4j;

@ControllerAdvice
@Log4j
public class ExceptionAdvice {
	//500에러
	@ExceptionHandler(Exception.class)
	public String exception(Exception ex, Model model) {
		log.error("...................Exception");
		model.addAttribute("exception", ex);
		log.error("...................model" + model);
		return "error500";
	}
	//404에러
	@ExceptionHandler(NoHandlerFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public String exception(NoHandlerFoundException ex) {
		return "error404";
	}
}
