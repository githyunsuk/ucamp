package com.ucamp.service;

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

}
