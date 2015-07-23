package com.ktds.dao;

import java.util.List;
import com.ktds.vo.BoardVO;

public interface DBLoaderDAO {
	
	/**
	 * ListŸ������ �����͸� �ҷ��´�.
	 * @return <�Խù� ����Ʈ>
	 */
	public List<BoardVO> getMyData();
	/**
	 * �Խù� Id�� �ش��ϴ� ���� �ҷ��´�.
	 * @param boardId
	 * @return
	 */
	public BoardVO getDataFromId(String boardId);
}
