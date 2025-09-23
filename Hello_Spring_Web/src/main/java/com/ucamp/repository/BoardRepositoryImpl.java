package com.ucamp.repository;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.ucamp.entity.BoardDTO;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class BoardRepositoryImpl implements BoardRepository {

	private final JdbcTemplate jdbcTemplate;

	@Override
	public BoardDTO findBoardByNo(Long no) {
	    String query = "SELECT * FROM BOARD WHERE NO = ?";
	    return jdbcTemplate.queryForObject(query,
	            (rs, rowNum) -> new BoardDTO(rs.getLong("NO"), rs.getString("WRITER"), rs.getString("CONTENT")), no);
	}


}
