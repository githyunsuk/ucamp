package com.ucamp.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ucamp.entity.BoardDTO;
import com.ucamp.repository.BoardRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardServie {

	private final BoardRepository boardRepository;
	
	@Override
	public BoardDTO findBoardByNo(Long no) {
		return boardRepository.findBoardByNo(no);
	}

	@Override
	public boolean insertBoard(BoardDTO board) {
		if(boardRepository.insertBoard(board) > 0) {
			return true;
		}
		
		return false;
	}

	@Override
	public boolean deleteBoard(Long No) {
		if(boardRepository.deleteBoard(No) > 0) {
			return true;
		}
		
		return false;
	}

	@Override
	public List<BoardDTO> findAllBoard() {
		return boardRepository.findAllBoard();
	}

}
