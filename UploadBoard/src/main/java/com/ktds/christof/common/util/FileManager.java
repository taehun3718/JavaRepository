package com.ktds.christof.common.util;

import java.io.File;
import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

public class FileManager {
	
	public interface FileDir {
		public String DESTINATION_DIRECTORY = "D:\\";
		public String MKDIR = "postPicture";

	}

	private MultipartFile fileOne;
	private MultipartFile fileTwo;
	/**
	 * 파일을 초기화한다. 디렉토리가 없으면 디렉토리를 생성한다.
	 * @param fileOne
	 * @param fileTwo
	 */
	public FileManager(MultipartFile fileOne
					, MultipartFile fileTwo) {
		this.fileOne = fileOne;
		this.fileTwo = fileTwo;

		File destFileDir = new File(FileDir.DESTINATION_DIRECTORY
				+ FileDir.MKDIR);

		if (!destFileDir.exists()) {
			destFileDir.mkdirs();
		}
	}
	/**
	 * 지정된 디렉토리에 파일을 전송한다. 파일 전송에 성공한 수를 리턴한다.
	 * @param fileNameOne
	 * @param fileNameTwo
	 * @return 파일 전송 성공 횟수
	 */
	public int transfer(String fileNameOne, String fileNameTwo) {

		int transferCnt = 0;
		File destFile = new File(FileDir.DESTINATION_DIRECTORY + FileDir.MKDIR
				, fileNameOne);

		if (fileOne != null) {

			transferCnt++;
			try {
				fileOne.transferTo(destFile);
			} catch (IllegalStateException | IOException e) {
				throw new RuntimeException(e.getMessage(), e);
			}
		}

		destFile = new File(FileDir.DESTINATION_DIRECTORY + FileDir.MKDIR
				, fileNameTwo);

		if (fileTwo != null) {
			transferCnt++;
			try {
				fileTwo.transferTo(destFile);
			} catch (IllegalStateException | IOException e) {
				throw new RuntimeException(e.getMessage(), e);
			}
		}
		
		return transferCnt;
	}
}
