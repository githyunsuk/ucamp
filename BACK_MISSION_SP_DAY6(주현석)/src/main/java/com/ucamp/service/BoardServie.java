package com.ucamp.service;

import java.util.List;

import com.ucamp.entity.BoardDTO;

public interface BoardServie {

	public boolean insertBoard(BoardDTO board);
	public boolean deleteBoard(Long No);
	public BoardDTO findBoardByNo(Long No);
	public List<BoardDTO> findAllBoard();
	
}
