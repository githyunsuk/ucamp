package com.ucamp.repository;

import java.sql.SQLException;
import java.util.List;

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

	@Override
	public int insertBoard(BoardDTO board){
		String query = "insert into board values(?, ?, ?)";
		int row = jdbcTemplate.update(query, board.getNo(), board.getWriter(), board.getContent());
		return row;
	}

	@Override
	public int deleteBoard(Long No){
		String query = "delete from board where no = ?";
		int row = jdbcTemplate.update(query, No);
		
		return row;
	}

	@Override
	public List<BoardDTO> findAllBoard(){
		String query = "select * from board";
		return jdbcTemplate.query(query, (rs, rowNum) -> new BoardDTO(rs.getLong("NO"), rs.getString("WRITER"), rs.getString("CONTENT")));
	}


}
