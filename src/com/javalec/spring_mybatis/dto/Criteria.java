package com.javalec.spring_mybatis.dto;


//Criteria는 rNum의 제한값과 현재 페이지, 페이지에 출력되는 게시물 숫자를 제어합니다.
public class Criteria {
	private int page;  //현재페이지
	private int perPageNum; //페이지에 출력되는게시물
	//페이지별 글들의 시작~끝 넘버 (1페이지면 rowStart = 1, rowEnd = 15)
	private int rowStart;
	private int rowEnd;

	
	public Criteria() {
		this.page = 1;
		this.perPageNum = 12;
	}


	public int getPage() {
		return page;
	}
	
	public void setPage(int page) {
		if (page <= 0) {
			this.page = 1;
			return;
		}
		this.page = page;
	}

	public int getPerPageNum() {
		return this.perPageNum;
	}
	
	public void setPerPageNum(int perPageNum) {
		if (perPageNum <= 0 || perPageNum > 120) {
			this.perPageNum = 12;
			return;
		}
		this.perPageNum = perPageNum;
	}


	public int getPageStart() {
		return (this.page - 1) * perPageNum;
	}


	
//페이지별 글들의 시작~끝 넘버 (1페이지면 rowStart = 1, rowEnd = 15)
	public int getRowStart() {
		rowStart = ((page - 1) * perPageNum) + 1;
		return rowStart;
	}

	public int getRowEnd() {
		rowEnd = rowStart + perPageNum - 1;
		return rowEnd;
	}

	@Override
	public String toString() {
		return "Criteria [page=" + page + ", perPageNum=" + perPageNum + "" + ", rowStart=" + getRowStart()
				+ ", rowEnd=" + getRowEnd() + "]";
	}

}
