package com.ucamp.controller;

import org.springframework.dao.DataAccessException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.ucamp.exception.UpdateFailNotExistException;

@ControllerAdvice
public class EmployeeAdvice {

	@ExceptionHandler(DataAccessException.class)
	public String handleException(DataAccessException e, Model model) {
		System.out.println("error:" + e.getClass());
		model.addAttribute("message", e.getMessage());
		
		return "error";
	}
	
	@ExceptionHandler(UpdateFailNotExistException.class)
	public String handleException(UpdateFailNotExistException e, Model model) {
		System.out.println("Error: " + e.getClass());
		model.addAttribute("message", e.getMessage());
		return "error";
	}
}
