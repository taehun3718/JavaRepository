package com.ktds.christof.bbs.service;

import javax.servlet.http.HttpServletRequest;

import com.ktds.christof.bbs.vo.BoardListVO;
import com.ktds.christof.bbs.vo.BoardVO;

public interface BoardService {

	public boolean writeArticle(BoardVO boardVO);
	public BoardVO articleDetailById(String id);
	BoardListVO articleList(HttpServletRequest request);
}
