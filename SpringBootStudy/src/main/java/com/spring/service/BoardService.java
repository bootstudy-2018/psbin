package com.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.dao.BoardDAO;
import com.spring.dto.BoardDTO;

@Service
public class BoardService {

	@Autowired
	BoardDAO boardDAO;
	
	/**********/
	/* SELETE */
	/**********/
	
	public List<BoardDTO> getBoardList() {
		return boardDAO.getBoardList();
	}

	public BoardDTO getBoardOne(Long id) {
		return boardDAO.getBoardOne(id);
	}
	
	/**********/
	/* INSERT */
	/**********/
	
	public void putBoard(BoardDTO boardDTO) {
		boardDAO.putBoard(boardDTO);
	}
	
	/**********/
	/* UPDATE */
	/**********/
	
	public void updateBoardHit(Long id) {
		boardDAO.updateBoardHit(id);
	}
	
	public void updateBoard(BoardDTO boardDTO) {
		boardDAO.updateBoard(boardDTO);
	}
	
	/**********/
	/* DELETE */
	/**********/
	
	public void deleteBoard(Long id) {
		boardDAO.deleteBoard(id);
	}
	
}
