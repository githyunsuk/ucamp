package com.ucamp.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class DefaultController {
	
	@RequestMapping("/")
	public String orderMainWithParam(@RequestParam(required = false) String no, Model model) {
		List<String> nameList = Arrays.asList(new String[] {"홍길동", "김길동"});
		model.addAttribute("nameList", nameList);
		log.debug("/ -> called(): index.jsp 실행됨 "+no);
		return "index";
	}	
}
