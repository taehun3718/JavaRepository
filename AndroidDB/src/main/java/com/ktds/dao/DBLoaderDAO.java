package com.ktds.dao;

import java.util.List;
import com.ktds.vo.BoardVO;

public interface DBLoaderDAO {
	
	/**
	 * List타입으로 데이터를 불러온다.
	 * @return <게시물 리스트>
	 */
	public List<BoardVO> getMyData();
	/**
	 * 게시물 Id만 해당하는 것을 불러온다.
	 * @param boardId
	 * @return
	 */
	public BoardVO getDataFromId(String boardId);
}
