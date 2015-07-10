package com.ktds.christof.bbs.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;

import com.ktds.christof.bbs.dao.BoardDAO;
import com.ktds.christof.bbs.service.BoardService;
import com.ktds.christof.bbs.vo.BoardListVO;
import com.ktds.christof.bbs.vo.BoardSearchVO;
import com.ktds.christof.bbs.vo.BoardVO;
import com.ktds.christof.common.util.FileManager;
import com.ktds.christof.common.util.Paging;

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
	public BoardListVO articleList(HttpServletRequest request) {
		
		int count = this.boardDAO.getArticleCount();
		Paging paging = new Paging();
		paging.setPageNumber(request.getParameter("pageNo"));
		
		BoardSearchVO boardSearchVO = new BoardSearchVO();
		boardSearchVO.setPaging(paging);
		
		List<BoardVO> list = boardDAO.articleList(boardSearchVO);
		
		Paging tmpPaging = boardSearchVO.getPaging();
		tmpPaging.setTotalArticleCount(count);
		
		BoardListVO boardListVO = new BoardListVO();
		
		if(count > 0) {
			boardListVO.setBoardList(list);
		}
		else {
			boardListVO.setBoardList(new ArrayList<BoardVO>());
		}
		
		boardListVO.setPaging(tmpPaging);
		boardListVO.setBoardList(list);
		
		return boardListVO;
	}
	
	@Override
	public BoardVO articleDetailById(String id) {
		return boardDAO.articleDetailById(id);
	}

}
