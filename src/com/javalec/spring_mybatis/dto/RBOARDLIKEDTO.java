package com.javalec.spring_mybatis.dto;

import java.util.Date;


public class RBOARDLIKEDTO {

	private int boardno;
	private String likememberid;
	
	
	public int getBoardno() {
		return boardno;
	}
	public void setBoardno(int boardno) {
		this.boardno = boardno;
	}
	public String getLikememberid() {
		return likememberid;
	}
	public void setLikememberid(String likememberid) {
		this.likememberid = likememberid;
	}

}
