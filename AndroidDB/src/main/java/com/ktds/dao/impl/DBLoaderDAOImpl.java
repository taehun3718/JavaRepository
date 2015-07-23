package com.ktds.dao.impl;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.ktds.dao.DBLoaderDAO;
import com.ktds.vo.BoardVO;

public class DBLoaderDAOImpl extends SqlSessionDaoSupport implements DBLoaderDAO{

	@Override
	public List<BoardVO> getMyData() {
		List<BoardVO> boardList = getSqlSession().selectList("boardDAO.getBoardList");
		return boardList;
	}
	
	@Override
	public BoardVO getDataFromId(String boardId) {
		BoardVO boardVO = getSqlSession().selectOne("boardDAO.getDataFromId", boardId);
		
		return boardVO;
	}
	
}
