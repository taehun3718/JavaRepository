package com.ktds.christof.bbs.dao;

import java.util.List;

import com.ktds.christof.bbs.vo.BoardVO;

public interface BoardDAO {

	public boolean writeArticle(BoardVO boardVO);
	public List<BoardVO> articleList();
	public BoardVO articleDetailById(String id);
}
