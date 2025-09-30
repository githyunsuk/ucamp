package com.ucamp.controller;

import org.springframework.dao.DataAccessException;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.ucamp.exception.LoginFailException;

@ControllerAdvice
public class ExceptionAdvice {

	@ExceptionHandler(LoginFailException.class)
	public String handleException(LoginFailException e, Model model) {
		
		e.printStackTrace();
		model.addAttribute("msg", e.getMessage());
		
		return "index";
	}
	@ExceptionHandler(DataAccessException.class)
	public String handleException(DataAccessException e, Model model) {
		
		e.printStackTrace();
		
		model.addAttribute("msg", e.getMessage());
		
		return "fail";
	}
	
	@ExceptionHandler(Exception.class)
	public String handleException(Exception e, Model model) {
		
		e.printStackTrace();
		
		model.addAttribute("msg", e.getMessage());
		
		return "fail";
	}
}
