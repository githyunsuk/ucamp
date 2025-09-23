package com.ucamp.repository;

import com.ucamp.entity.BoardDTO;

public interface BoardRepository {

	public BoardDTO findBoardByNo(Long No);
}
