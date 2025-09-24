package com.ucamp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpSession;

@Controller
public class MainController {

	@RequestMapping("/")
	public String main() {
		return "index";
	}
	
	@PostMapping("/login")
	public String getLogin(@RequestParam("id") String id, @RequestParam("pw") String pw, HttpSession session, Model model){
		
		if("Admin".equals(id) && "Admin".equals(pw)) {
			return "manager";
		}
		
		session.setAttribute("id", id);
		model.addAttribute("msg", false);
		return "loginfail";
	}
	
	@RequestMapping("/logout")
	public String getLogout(HttpSession session) {
		if(session != null) {
			session.invalidate();
		}
		
		return "index";
	}
	
}
