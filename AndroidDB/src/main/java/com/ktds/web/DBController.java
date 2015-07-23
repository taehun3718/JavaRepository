package com.ktds.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ktds.service.DBLoaderService;
import com.ktds.vo.BoardVO;

@Controller
public class DBController {
	
	private DBLoaderService dbLoaderService;
	
	public void setDbLoaderService(DBLoaderService dbLoaderService) {
		this.dbLoaderService = dbLoaderService;
	}
	
	/**
	 * 전체 리스트를 가져올 때 사용한다.
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/JSONService/getData")
	public List<BoardVO> getData() {		
		List<BoardVO> myDataList = dbLoaderService.getMyData();
		return myDataList;
	}
	
	@ResponseBody
	@RequestMapping("/JSONService/getDataByMap")
	public Map<String, BoardVO> getDataByMap() {		
		List<BoardVO> myDataList = dbLoaderService.getMyData();
		
		Map map = new HashMap<String, BoardVO>();
		map.put("board", myDataList);
		return map;
	}
	
	/**
	 * 한개의 게시물 정보를 가져올 때 사용한다.
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/JSONService/getDataFromId")
	public BoardVO getDataFromId(HttpServletRequest request) {
		
		String boardId = request.getParameter("id");
		if(boardId==null)
			boardId = "-1";
		
		BoardVO boardVO = dbLoaderService.getDataFromId(boardId);
		return boardVO;
	}
	
	@ResponseBody
	@RequestMapping("/JSONService/getDataFromIdofMap")
	public Map<String, BoardVO> getDataFromIdofMap(HttpServletRequest request) {
		
		String boardId = request.getParameter("id");
		if(boardId==null)
			boardId = "-1";
		
		BoardVO boardVO = dbLoaderService.getDataFromId(boardId);
		
		Map map = new HashMap<String, BoardVO>();
		map.put("board", boardVO);
		return map;
	}
}
