package com.ktds.christof.bbs.dao.impl;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ktds.christof.bbs.dao.BoardDAO;
import com.ktds.christof.bbs.vo.BoardVO;
import com.ktds.christof.bbs.web.BoardController;

public class BoardDAOImpl extends SqlSessionDaoSupport implements BoardDAO{

	private static Logger logger = LoggerFactory.getLogger(BoardDAOImpl.class);
	
	@Override
	public boolean writeArticle(BoardVO boardVO) {
		logger.info("writeArticle.DAO");
		int insertedCnt = getSqlSession().insert("boardDAO.writeArticle", boardVO);
		return insertedCnt > 0 ? true : false;
	}
	
	@Override
	public List<BoardVO> articleList() {
		List<BoardVO> boardList = getSqlSession().selectList("boardDAO.articleList");
		return boardList;
	}
	
	@Override
	public BoardVO articleDetailById(String id) {
		return getSqlSession().selectOne("boardDAO.articleDetail", id);
	}
}
