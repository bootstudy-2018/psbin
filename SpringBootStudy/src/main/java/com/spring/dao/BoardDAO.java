package com.spring.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.dto.BoardDTO;

@Repository
public class BoardDAO {

	@Autowired
	SqlSession sqlSession;
	
	/**********/
	/* SELETE */
	/**********/
	
	public List<BoardDTO> getBoardList() {
		return sqlSession.selectList("board-sql.getBoardList");
	}
	
	public BoardDTO getBoardOne(Long id) {
		return sqlSession.selectOne("board-sql.getBoardOne", id);
	}
	
	/**********/
	/* INSERT */
	/**********/
	
	public void putBoard(BoardDTO boardDTO) {
		sqlSession.insert("board-sql.putBoard", boardDTO);
	}
	
	/**********/
	/* UPDATE */
	/**********/
	
	public void updateBoardHit(Long id) {
		sqlSession.update("board-sql.updateBoardHit", id);
	}
	
	public void updateBoard(BoardDTO boardDTO) {
		sqlSession.update("board-sql.updateBoard", boardDTO);
	}
	
	/**********/
	/* DELETE */
	/**********/
	
	public void deleteBoard(Long id) {
		sqlSession.delete("board-sql.deleteBoard", id);
	}
	
}
