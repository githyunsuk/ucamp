package com.example.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.entity.BoardEntity;
import com.example.mapper.BoardMapper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BoardService {

	private final BoardMapper boardMapper;
	
	public List<BoardEntity> selectAllBoard(){
		
		return boardMapper.selectAllBoard();
	}
}
