package com.spring.controller;




import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.dto.BoardDTO;
import com.spring.service.BoardService;


@Controller
@RequestMapping("/board")
public class BoardController {
	
	// TODO : log4j 의존성 제거하고 사용해야함
	
	@Autowired
	BoardService boardService;
	
	@RequestMapping("/")
	public String index(ModelMap modelMap) {
		modelMap.put("boardList", boardService.getBoardList());
		return "board/index";
	}
	
	@RequestMapping("/write")
	public String write(ModelMap modelMap) {
		return "board/write";
	}
	
	@RequestMapping("/view")
	public String view(Long id, ModelMap modelMap) {
		boardService.updateBoardHit(id);
		modelMap.put("boardOne", boardService.getBoardOne(id));
		return "board/view";
	}
	
	@RequestMapping("/edit")
	public String edit(Long id, ModelMap modelMap) {
		modelMap.put("boardOne", boardService.getBoardOne(id));
		return "board/edit";
	}
	
	@RequestMapping("/put")
	public void put(HttpServletResponse res, BoardDTO boardDTO) throws IOException {
		// TODO : 요청 ajax로 바꿔야 함, 예외처리 JS 쪽에서 처리
		if ( !StringUtils.isEmpty(boardDTO.getTitle()) && !StringUtils.isEmpty(boardDTO.getContent()) ) {
			boardService.putBoard(boardDTO);
		}
		res.sendRedirect("/board/");
	}
	
	@RequestMapping("/update")
	public void update(HttpServletResponse res, BoardDTO boardDTO) throws IOException {
		// TODO : 요청 ajax로 바꿔야 함, 예외처리 JS 쪽에서 처리
		if ( !StringUtils.isEmpty(boardDTO.getTitle()) && !StringUtils.isEmpty(boardDTO.getContent()) ) {
			boardService.updateBoard(boardDTO);
		}
		res.sendRedirect("/board/");
	} 
	
	@RequestMapping("/delete")
	public void delete(HttpServletResponse res, Long id) throws IOException {
		// TODO : 예외처리 JS 쪽에서 처리
		if ( id > 0 ) {
			boardService.deleteBoard(id);
		}
		res.sendRedirect("/board/");
	}
	
	
}
