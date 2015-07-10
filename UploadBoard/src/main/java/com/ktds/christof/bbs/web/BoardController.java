package com.ktds.christof.bbs.web;

import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.ktds.christof.bbs.service.BoardService;
import com.ktds.christof.bbs.vo.BoardListVO;
import com.ktds.christof.bbs.vo.BoardVO;
import com.ktds.christof.bbs.vo.ResultVO;
import com.ktds.christof.common.util.AjaxUtil;
import com.ktds.christof.common.util.FileManager;

@Controller
public class BoardController {
	
	private static Logger logger = LoggerFactory.getLogger(BoardController.class);	
	private BoardService boardService;
	
	public BoardService getBoardService() {
		return boardService;
	}

	public void setBoardService(BoardService boardService) {
		this.boardService = boardService;
	}
	
	@RequestMapping("/doWrite")
	public ModelAndView doWrite(BoardVO boardVO) {
		logger.info("doWrite()");
		boardService.writeArticle(boardVO);
		ModelAndView view = new ModelAndView();
		view.setViewName("redirect:/board");
		return view;
	}
	
	@RequestMapping("/board")
	public ModelAndView uploadFile(HttpServletRequest request) {
		logger.info("call uploadFile()");
		BoardListVO boardList = boardService.articleList(request);
		
		ModelAndView view = new ModelAndView();
		view.setViewName("index");
		view.addObject("boardList", boardList);
		
		return view;
	}
	
	@RequestMapping("/board/download/{id}/{fileId}")
	public void fileDownload(@PathVariable String id
							, @PathVariable String fileId
							, HttpServletRequest requset
							, HttpServletResponse response) {
		BoardVO fileInfo = boardService.articleDetailById(id);
		downloadFile(fileId, requset, response, fileInfo);
	}

	private void downloadFile(String fileId, HttpServletRequest requset,
			HttpServletResponse response, BoardVO fileInfo) {
		
		File downloadFile = null;
		downloadFile = getFile(fileId, fileInfo, downloadFile);
		
		//서버로부터 파일을 다운 받는 실제 메소드
		download_To_LocalFile(fileId, requset, response, fileInfo, downloadFile);
	}

	private void download_To_LocalFile(String fileId
									, HttpServletRequest requset
									, HttpServletResponse response
									, BoardVO fileInfo
									, File downloadFile) {
		try {
				
			if ( downloadFile == null ) {
				response.sendError(HttpServletResponse.SC_NOT_FOUND);
				return;
			}
			
			response.setContentType("applicaton/download; charset=utf-8");
			response.setContentLength((int)downloadFile.length());
			
			// 사용자의 브라우저 종류를 가져온다
			String userAgent = requset.getHeader("User-Agent");
			boolean isMsie = userAgent.indexOf("MSIE") > -1;
			
			String fileName = null;
			
			if ( isMsie ) {
				if(fileId.equals("0")){
					fileName = URLEncoder.encode(fileInfo.getRealfileNameOne(), "UTF-8");
				}
				if(fileId.equals("1")){
					fileName = URLEncoder.encode(fileInfo.getRealfileNameTwo(), "UTF-8");
				}
			}
			
			else {
				if(fileId.equals("0")){
					fileName = new String(fileInfo.getRealfileNameOne().getBytes("UTF-8"), "ISO-8859-1");
				}
				if(fileId.equals("1")){
					fileName = new String(fileInfo.getRealfileNameTwo().getBytes("UTF-8"), "ISO-8859-1");
				}
				
			}
			
			response.setHeader("Content-Disposition", "attachment; filename=\"" + fileName + "\";");
			response.setHeader("Content-Transfer-Encoding", "binary");
			
			OutputStream out = response.getOutputStream();
			FileInputStream fis = null;
			
			try { 
				fis = new FileInputStream(downloadFile);
				FileCopyUtils.copy(fis, out);
				out.flush();
			}
			
			finally {
				if ( fis != null ) {
					fis.close();
				}
				if ( out != null ) {
					out.close();
				}
			}
		}
		
		catch(Exception e) {
			throw new RuntimeException(e.getMessage(), e);
		}
	}

	private File getFile(String fileId
						, BoardVO fileInfo
						, File downloadFile) {
		
		//첫 번째 파일인지? 두 번째 파일인지 확인하여 그 경로의 파일을 가져옴. 
		if(fileId.equals("0")){
			downloadFile = new File(FileManager.FileDir.DESTINATION_DIRECTORY +  FileManager.FileDir.MKDIR + "//" + fileInfo.getUuIdNameOne() );
		}
		if(fileId.equals("1")){
			downloadFile = new File(FileManager.FileDir.DESTINATION_DIRECTORY +  FileManager.FileDir.MKDIR + "//" + fileInfo.getUuIdNameTwo() );
		}
		
		return downloadFile;
	}
	
	@RequestMapping("/append")
	public ModelAndView append() {
		return new ModelAndView("Ajax/form");
	}
	
	@ResponseBody
	@RequestMapping("/getResponseBodyPage")
	public ResultVO getResponseBodyPage() {
		return new ResultVO(true, "is Successed message");
	}
	
	@RequestMapping("/getPageAjax")
	public void getAjaxPage(HttpServletResponse response) {
		
		
		response.setCharacterEncoding("UTF-8");
		
		AjaxUtil.sendResponseResource(BoardController.class
									, response
									, "getForm.jsp");
		//AjaxUtil.sendResponse(response, false+"잘못된 내용");
		//
		
	}
}
