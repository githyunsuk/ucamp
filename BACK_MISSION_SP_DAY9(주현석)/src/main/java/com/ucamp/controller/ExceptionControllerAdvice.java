package com.ucamp.controller;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionControllerAdvice {

	@ExceptionHandler(DataIntegrityViolationException.class)
	public String handleException(DataIntegrityViolationException e) {
		
		return "아이디가 틀립니다... ㅠ"; 
	}
	
	@ExceptionHandler(NullPointerException.class)
	public String handleException(NullPointerException e) {
		
		return "해당 품목이 존재하지 않습니다....ㅠ";
	}
}
