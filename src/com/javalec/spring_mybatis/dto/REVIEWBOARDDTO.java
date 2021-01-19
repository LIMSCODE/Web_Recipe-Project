package com.javalec.spring_mybatis.dto;

import java.util.Date;

public class REVIEWBOARDDTO{

	
	private int reviewboardno;
	private int rboardno;
	private String title;
	private String memberid;


	private String content;
	private Date reg_date;
	private int readcount;
	private String gdsImg;
	private String gdsThumbImg;


	
	private String foodkind;
	private String countrykind;
	private String timekind;
	private String[] foodList;
	private String[] countryList;
	private String[] timeList;
	
	private String majormat;
	private String minormat;

	
	private String SearchType;
	private String SearchWord;
	
	private int commentcount;
	
	private String memberImg;

	public REVIEWBOARDDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public REVIEWBOARDDTO(int reviewboardno, int rboardno, String title, String memberid, String content, Date reg_date,
			int readcount, String gdsImg, String gdsThumbImg, String foodkind, String countrykind, String timekind,
			String[] foodList, String[] countryList, String[] timeList, String majormat, String minormat,
			String searchType, String searchWord, int commentcount, String memberImg) {
		super();
		this.reviewboardno = reviewboardno;
		this.rboardno = rboardno;
		this.title = title;
		this.memberid = memberid;
		this.content = content;
		this.reg_date = reg_date;
		this.readcount = readcount;
		this.gdsImg = gdsImg;
		this.gdsThumbImg = gdsThumbImg;
		this.foodkind = foodkind;
		this.countrykind = countrykind;
		this.timekind = timekind;
		this.foodList = foodList;
		this.countryList = countryList;
		this.timeList = timeList;
		this.majormat = majormat;
		this.minormat = minormat;
		this.SearchType = searchType;
		this.SearchWord = searchWord;
		this.commentcount = commentcount;
		this.memberImg = memberImg;
	}

	
	
	public int getReviewboardno() {
		return reviewboardno;
	}

	public void setReviewboardno(int reviewboardno) {
		this.reviewboardno = reviewboardno;
	}

	public int getRboardno() {
		return rboardno;
	}

	public void setRboardno(int rboardno) {
		this.rboardno = rboardno;
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

	public int getCommentcount() {
		return commentcount;
	}

	public void setCommentcount(int commentcount) {
		this.commentcount = commentcount;
	}

	public String getMemberImg() {
		return memberImg;
	}

	public void setMemberImg(String memberImg) {
		this.memberImg = memberImg;
	}
	
	
	

	
}
