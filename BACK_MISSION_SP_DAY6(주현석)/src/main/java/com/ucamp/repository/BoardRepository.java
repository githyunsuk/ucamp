package com.ucamp.repository;

import java.util.List;

import com.ucamp.entity.BoardDTO;

public interface BoardRepository {

	public int insertBoard(BoardDTO board);
	public int deleteBoard(Long No);
	public BoardDTO findBoardByNo(Long No);
	public List<BoardDTO> findAllBoard();
}
