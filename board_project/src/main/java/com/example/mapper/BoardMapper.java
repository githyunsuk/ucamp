package com.example.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.entity.BoardEntity;

@Mapper
public interface BoardMapper {

	public List<BoardEntity> selectAllBoard();
}
