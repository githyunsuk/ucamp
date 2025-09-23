package com.ucamp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ucamp.entity.BoardDTO;
import com.ucamp.service.BoardServie;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class HelloController {

	private final BoardServie boardService;
	
	/*
	 *  /board -> 1개 글 조회
	 *  /boardList -> 모든 글 조회
	 *  /insert -> 글 입력(입력 폼 등 처리는 자유)
	 *  /delete -> 글 번호를 이용하여 글 삭제
	 *  공통: 모든 처리가 완료되었을 때 빈 페이지가 보이면 안됨.
	 *  반드시 UI를 JSP로 제공합니다.
	 */
	
	@RequestMapping("/index")
	public String getMain() {
		return "index";
	}
	
	@RequestMapping("/board_input")
	public String getBoardInput() {
		
		return "board_input";
	}
	@RequestMapping("/board")
	public String getBoard(@RequestParam("no") Long no, Model model) {
		BoardDTO board = boardService.findBoardByNo(no);
		model.addAttribute("board", board);
		
		return "board";
	}
	
	@RequestMapping("/boardList")
	public String getBoardList(Model model) {
		
		return "boardList";
		
	}
	
}
