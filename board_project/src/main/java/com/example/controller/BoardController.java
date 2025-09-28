package com.example.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.entity.BoardEntity;
import com.example.service.BoardService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class BoardController {

	private final BoardService boardService;
	
	//게시판 메인 페이지로 이동
	@RequestMapping("/board")
	public String board(Model model) {
		
		List<BoardEntity> list = boardService.selectAllBoard();
		
		model.addAttribute("list", list);
		return "board";
	}
	
	//글 작성 페이지로 이동
	@RequestMapping("/writeForm")
	public void writeForm() {
		
	}
}
