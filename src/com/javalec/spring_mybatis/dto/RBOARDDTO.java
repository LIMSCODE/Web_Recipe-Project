package com.javalec.spring_mybatis.dto;

import java.util.Date;

public class RBOARDDTO{
//	 CREATE TABLE RBOARD(
//			BOARDNO NUMBER PRIMARY KEY,
//			TITLE VARCHAR2(2000) NOT NULL,
//			MEMBERID VARCHAR2(100) NOT NULL,
//			CONTENT VARCHAR2(4000) NOT NULL,
//			REG_DATE DATE NOT NULL,
//			READCOUNT NUMBER
//			);
	
	private int boardno;
	private String title;
	private String memberid;
	private String memberImg;
	
	public String getMemberImg() {
		return memberImg;
	}
	public void setMemberImg(String memberImg) {
		this.memberImg = memberImg;
	}

	private String content;
	private Date reg_date;
	private int readcount;
	private String gdsImg;
	private String gdsThumbImg;

	private String majormat;
	private String minormat;
	private int commentcount;
	
	
	public int getCommentcount() {
		return commentcount;
	}
	public void setCommentcount(int commentcount) {
		this.commentcount = commentcount;
	}

	private String foodkind;
	private String countrykind;
	private String timekind;
	private String[] foodList;
	private String[] countryList;
	private String[] timeList;
	
	private String SearchType;
	private String SearchWord;
	
	 	
	
	public String[] getFoodList() {
		return foodList;
	}
	public void setFoodList(String[] foodList) {
		this.foodList = foodList;
	}
	public String[] getCountryList() {
		return countryList;
	}
	public void setCountryList(String[] countryList) {
		this.countryList = countryList;
	}
	public String[] getTimeList() {
		return timeList;
	}
	public void setTimeList(String[] timeList) {
		this.timeList = timeList;
	}


	
	public String getSearchType() {
		return SearchType;
	}
	public void setSearchType(String searchType) {
		SearchType = searchType;
	}
	public String getSearchWord() {
		return SearchWord;
	}
	public void setSearchWord(String searchWord) {
		SearchWord = searchWord;
	}
	
	
	public String getFoodkind() {
		return foodkind;
	}
	public void setFoodkind(String foodkind) {
		this.foodkind = foodkind;
	}
	public String getCountrykind() {
		return countrykind;
	}
	public void setCountrykind(String countrykind) {
		this.countrykind = countrykind;
	}
	public String getTimekind() {
		return timekind;
	}
	public void setTimekind(String timekind) {
		this.timekind = timekind;
	}
	
	
	public String getMajormat() {
		return majormat;
	}
	public void setMajormat(String majormat) {
		this.majormat = majormat;
	}
	public String getMinormat() {
		return minormat;
	}
	public void setMinormat(String minormat) {
		this.minormat = minormat;
	}
	
	
	
	//생성자에는 gdsimg추가안해도되나??
	public String getGdsImg() {
		return gdsImg;
	}
	public void setGdsImg(String gdsImg) {
		this.gdsImg = gdsImg;
	}

	public String getGdsThumbImg() {
		return gdsThumbImg;
	}
	public void setGdsThumbImg(String gdsThumbImg) {
		this.gdsThumbImg = gdsThumbImg;
	}



	public RBOARDDTO() {
		super();
	}

	public RBOARDDTO(int boardno, String title, String memberid, String content) {
		super();
		this.boardno = boardno;
		this.title = title;
		this.memberid = memberid;
		this.content = content;
	
	}
	

	public RBOARDDTO(int boardno, String title, String memberid, String content, Date reg_date, int readcount) {
		super();
		this.boardno = boardno;
		this.title = title;
		this.memberid = memberid;
		this.content = content;
		this.reg_date = reg_date;
		this.readcount = readcount;
	}

	public int getBoardno() {
		return boardno;
	}

	public void setBoardno(int boardno) {
		this.boardno = boardno;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getMemberid() {
		return memberid;
	}

	public void setMemberid(String memberid) {
		this.memberid = memberid;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getReg_date() {
		return reg_date;
	}

	public void setReg_date(Date reg_date) {
		this.reg_date = reg_date;
	}

	public int getReadcount() {
		return readcount;
	}

	public void setReadcount(int readcount) {
		this.readcount = readcount;
	}

	
}
