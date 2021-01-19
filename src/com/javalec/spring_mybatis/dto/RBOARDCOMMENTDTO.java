package com.javalec.spring_mybatis.dto;

import java.util.Date;

//CREATE TABLE RBOARDCOMMENT(
//COMMENTNO NUMBER PRIMARY KEY,
//RBOARDNO NUMBER NOT NULL,
//COMMENTCONTENT VARCHAR2(4000) NOT NULL,
//COMMENTWRITER VARCHAR2(50) NOT NULL,
//COMMENTDATE DATE
//);

//CREATE TABLE RBOARDCOMMENT(
//COMMENTNO NUMBER PRIMARY KEY,
//BOARDNO NUMBER NOT NULL,
//COMMENTWRITER VARCHAR2(50) NOT NULL,
//COMMENTCONTENT VARCHAR2(4000) NOT NULL,
//COMMENTDATE DATE,
//CONSTRAINT FK_NO FOREIGN KEY(BOARDNO) REFERENCES RBOARD(BOARDNO)
//);

public class RBOARDCOMMENTDTO {
	
	private int commentno;
	private int boardno;
	private String commentcontent;
	private String commentwriter;
	private Date commentdate;
	private String memberImg;
	
	
	public String getMemberImg() {
		return memberImg;
	}
	public void setMemberImg(String memberImg) {
		this.memberImg = memberImg;
	}
	
	
	
	public RBOARDCOMMENTDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public RBOARDCOMMENTDTO(int commentno, int rboardno, String commentcontent, String commentwriter,
			Date commentdate) {
		super();
		this.commentno = commentno;
		this.boardno = rboardno;
		this.commentcontent = commentcontent;
		this.commentwriter = commentwriter;
		this.commentdate = commentdate;
	}
	
	
	public int getCommentno() {
		return commentno;
	}
	public void setCommentno(int commentno) {
		this.commentno = commentno;
	}
	public int getBoardno() {
		return boardno;
	}
	public void setBoardno(int rboardno) {
		this.boardno = rboardno;
	}
	public String getCommentcontent() {
		return commentcontent;
	}
	public void setCommentcontent(String commentcontent) {
		this.commentcontent = commentcontent;
	}
	public String getCommentwriter() {
		return commentwriter;
	}
	public void setCommentwriter(String commentwriter) {
		this.commentwriter = commentwriter;
	}
	public Date getCommentdate() {
		return commentdate;
	}
	public void setCommentdate(Date commentdate) {
		this.commentdate = commentdate;
	}
	
	

}
