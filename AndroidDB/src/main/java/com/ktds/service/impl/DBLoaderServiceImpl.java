package com.ktds.service.impl;

import java.util.List;

import com.ktds.dao.DBLoaderDAO;
import com.ktds.service.DBLoaderService;
import com.ktds.vo.BoardVO;

public class DBLoaderServiceImpl implements DBLoaderService {

	private DBLoaderDAO dbLoaderDAO;
	
	public void setDbLoaderDAO(DBLoaderDAO dbLoaderDAO) {
		this.dbLoaderDAO = dbLoaderDAO;
	}

	@Override
	public List<BoardVO> getMyData() {
		return dbLoaderDAO.getMyData();
	}
	
	@Override
	public BoardVO getDataFromId(String boardId) {
		return dbLoaderDAO.getDataFromId(boardId);
	}

}
