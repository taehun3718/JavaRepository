package com.ktds.christof.bbs.service.impl;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.ktds.christof.bbs.dao.BoardDAO;
import com.ktds.christof.bbs.service.BoardService;
import com.ktds.christof.bbs.vo.BoardVO;
import com.ktds.christof.common.util.FileManager;

public class BoardServiceImpl implements BoardService{

	private BoardDAO boardDAO;
	
	public void setBoardDAO(BoardDAO boardDAO) {
		this.boardDAO = boardDAO;
	}
	@Override
	public boolean writeArticle(BoardVO boardVO) {
		
		MultipartFile fileOne = boardVO.getFileOne();
		MultipartFile fileTwo = boardVO.getFileTwo();
		
		FileManager fileManager 
				= new FileManager(fileOne, fileTwo);
		
		fileManager.transfer(boardVO.getUuIdNameOne()
							, boardVO.getUuIdNameTwo());
		
		return boardDAO.writeArticle(boardVO);
	}
	
	@Override
	public List<BoardVO> articleList() {
		return boardDAO.articleList();
	}
	
	@Override
	public BoardVO articleDetailById(String id) {
		return boardDAO.articleDetailById(id);
	}

}
