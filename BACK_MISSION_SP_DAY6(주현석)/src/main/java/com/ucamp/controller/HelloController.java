package com.ucamp.controller;

import java.util.List;

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
	 * /board -> 1개 글 조회 /boardList -> 모든 글 조회 /insert -> 글 입력(입력 폼 등 처리는 자유)
	 * /delete -> 글 번호를 이용하여 글 삭제 공통: 모든 처리가 완료되었을 때 빈 페이지가 보이면 안됨. 반드시 UI를 JSP로
	 * 제공합니다.
	 */

	@RequestMapping("/")
	public String getRoot() {
		return "index";
	}
	
	@RequestMapping("/index")
	public String getMain() {
		return "index";
	}

	@RequestMapping("/boardOne")
	public String getBoard(@RequestParam(value = "no", required = false) Long no, Model model) {

		if (no != null) {
			BoardDTO board = boardService.findBoardByNo(no);
			model.addAttribute("board", board);
		}

		return "boardOne";
	}

	@RequestMapping("/boardList")
	public String getBoardList(Model model) {

		List<BoardDTO> boardList = boardService.findAllBoard();
		model.addAttribute("boardList", boardList);

		return "boardList";

	}

	@RequestMapping("/insert")
	public String getInsert() {

		return "insert";
	}

	@RequestMapping("/insertProc")
	public String getInsertProc(@RequestParam("no") Long no, @RequestParam("writer") String writer,
			@RequestParam("content") String content, Model model) {

		String msg = "success";

		BoardDTO board = new BoardDTO(no, writer, content);
		boolean flag = boardService.insertBoard(board);

		if (flag == true) {
			model.addAttribute("msg", msg);
		} else {
			msg = "fail";
			model.addAttribute("msg", msg);
		}

		return "insert";
	}
	
	@RequestMapping("/delete")
	public String getDelete() {
		
		return "delete";
	}
	
	@RequestMapping("/deleteProc")
	public String getDeleteProc(@RequestParam("no") Long no, Model model) {
		
		String msg = "success";
		
		boolean flag = boardService.deleteBoard(no);
		
		if (flag == true) {
			model.addAttribute("msg", msg);
		} else {
			msg = "fail";
			model.addAttribute("msg", msg);
		}
		
		return "delete";
	}

}
