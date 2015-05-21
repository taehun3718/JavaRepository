package com.ktds.christof.bbs.vo;

import java.util.UUID;

import org.springframework.web.multipart.MultipartFile;

public class BoardVO {
	private int id;
	
	private String subject;
	private String content;
	
	private String realfileNameOne;
	private String realfileNameTwo;
	private String uuIdNameOne;
	private String uuIdNameTwo;
	
	private MultipartFile fileOne;
	private MultipartFile fileTwo;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getRealfileNameOne() {
		return realfileNameOne;
	}
	public void setRealfileNameOne(String realfileNameOne) {
		setUuIdNameOne(UUID.randomUUID().toString());
		this.realfileNameOne = realfileNameOne;
	}
	public String getRealfileNameTwo() {
		return realfileNameTwo;
	}
	public void setRealfileNameTwo(String realfileNameTwo) {
		setUuIdNameTwo(UUID.randomUUID().toString());
		this.realfileNameTwo = realfileNameTwo;
	}
	public String getUuIdNameOne() {
		return uuIdNameOne;
	}
	public void setUuIdNameOne(String uuIdNameOne) {
		this.uuIdNameOne = uuIdNameOne;
	}
	public String getUuIdNameTwo() {
		return uuIdNameTwo;
	}
	public void setUuIdNameTwo(String uuIdNameTwo) {
		this.uuIdNameTwo = uuIdNameTwo;
	}
	public MultipartFile getFileOne() {
		return fileOne;
	}
	public void setFileOne(MultipartFile fileOne) {
		setRealfileNameOne(fileOne.getOriginalFilename());
		this.fileOne = fileOne;
	}
	public MultipartFile getFileTwo() {
		return fileTwo;
	}
	public void setFileTwo(MultipartFile fileTwo) {
		setRealfileNameTwo(fileTwo.getOriginalFilename());
		this.fileTwo = fileTwo;
	}
	
}
