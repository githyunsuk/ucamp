package com.example.controller;

import org.springframework.dao.DataAccessException;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.example.exception.LoginException;
import com.example.exception.RegisterException;

@ControllerAdvice
public class ExceptionController {

	@ExceptionHandler(LoginException.class)
	public String handeldException(LoginException e, Model model) {

		model.addAttribute("msg", e.getMessage());

		return "error";
	}
	
	@ExceptionHandler(RegisterException.class)
	public String handleException(RegisterException e, Model model) {
		model.addAttribute("msg", e.getMessage());

		return "error";
		
	}

	@ExceptionHandler(DataAccessException.class)
	public String handleException(DataAccessException e, Model model) {

		model.addAttribute("msg", e.getMessage());

		return "error";
	}
	
	@ExceptionHandler(Exception.class)
	public String handleException(Exception e, Model model) {
		
		model.addAttribute("msg", e.getMessage());
		
		return "error";
	}
}
