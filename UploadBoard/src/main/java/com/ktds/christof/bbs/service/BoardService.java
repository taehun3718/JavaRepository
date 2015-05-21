package com.ktds.christof.bbs.service;

import java.util.List;

import com.ktds.christof.bbs.vo.BoardVO;

public interface BoardService {

	public boolean writeArticle(BoardVO boardVO);
	public List<BoardVO> articleList();
	public BoardVO articleDetailById(String id);
}
