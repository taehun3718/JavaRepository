package com.ktds.service;

import java.util.List;

import com.ktds.vo.BoardVO;

public interface DBLoaderService {
	public List<BoardVO> getMyData();
	public BoardVO getDataFromId(String boardId);
}
