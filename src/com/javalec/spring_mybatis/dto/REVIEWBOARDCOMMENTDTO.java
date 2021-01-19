package com.javalec.spring_mybatis.dto;

import java.util.Date;


public class REVIEWBOARDCOMMENTDTO {
	
	private int commentno;
	private int reviewboardno;
	private String commentcontent;
	private String commentwriter;
	private Date commentdate;
	private String memberImg;
	
	
	
	public REVIEWBOARDCOMMENTDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public REVIEWBOARDCOMMENTDTO(int commentno, int reviewboardno, String commentcontent, String commentwriter,
			Date commentdate) {
		super();
		this.commentno = commentno;
		this.reviewboardno = reviewboardno;
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
	

	public String getMemberImg() {
		return memberImg;
	}
	public void setMemberImg(String memberImg) {
		this.memberImg = memberImg;
	}
	
	public int getReviewboardno() {
		return reviewboardno;
	}
	public void setReviewboardno(int reviewboardno) {
		this.reviewboardno = reviewboardno;
	}
	

}
