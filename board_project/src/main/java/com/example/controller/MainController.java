package com.example.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.entity.BoardEntity;
import com.example.entity.UserEntity;
import com.example.service.BoardService;
import com.example.service.UserService;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class MainController {

	private final UserService userService;
	private final BoardService boardService;
	
	//메인페이지
	@RequestMapping("/")
	public String index() {
		
		return "index";
	}
	
	//로그인
	@PostMapping("/login")
	public String getLogin(UserEntity user, HttpSession session, Model model) {
		
		UserEntity loginUser = userService.login(user);
		
		session.setAttribute("loginUser", loginUser);
		
		List<BoardEntity> list = boardService.selectAllBoard();
		model.addAttribute("list", list);
		
		return "board";
	}
	
	//회원가입
	@PostMapping("/register")
	public String getRegister(UserEntity userEntity) {
		
		userService.addUser(userEntity);
		
		return "index";
	}
	
	//로그아웃
	@GetMapping("/logout")
	public String getLogout(HttpSession session) {
		session.invalidate();
		
		return "index";
	}
}
