package com.javalec.spring_mybatis.dto;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

public class PageMaker {
//totalCount : 게시물의 총 갯수
//	startPage : 현제 페이지의 시작 번호 (1, 11, 21 등등)
//	endPage : 현제 페이지의 끝 번호 (15, 20, 30 등등)
//	prev : 이전 페이지로 이동하는 링크의 존재 여부
//	next : 다음 페이지로 이동하는 링크의 존재 여부
	private int totalCount;
	private int startPage;
	private int endPage;
	private boolean prev;
	private boolean next;

	private int displayPageNum = 12;

	private Criteria cri;

	public void setCri(Criteria cri) {
		this.cri = cri;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
		calcData();
	}

	public int getTotalCount() {
		return totalCount;
	}

	public int getStartPage() {
		return startPage;
	}

	public int getEndPage() {
		return endPage;
	}

	public boolean isPrev() {
		return prev;
	}

	public boolean isNext() {
		return next;
	}

	public int getDisplayPageNum() {
		return displayPageNum;
	}

	public Criteria getCri() {
		return cri;
	}

	private void calcData() {
		//startPage 
		endPage = (int) (Math.ceil(cri.getPage() / (double) displayPageNum) * displayPageNum);
		startPage = endPage - displayPageNum +1;

		int tempEndPage = (int) (Math.ceil(totalCount / (double) cri.getPerPageNum()));
		if (endPage > tempEndPage) {
			endPage = tempEndPage;
		}
		//이전, 다음 생성여부 (true, false)
		prev = (startPage== 1 ? false:true);
		next = endPage * cri.getPerPageNum() >= totalCount ? false : true;
	}

	
//주소 만드는거
	public String makeQuery(int page) {
		UriComponents uriComponents = UriComponentsBuilder.newInstance().queryParam("page", page)
				.queryParam("perPageNum", cri.getPerPageNum()).build();

		return uriComponents.toUriString();
	}
	

	
	public String makeSearch(int page)
	{
	  
	 UriComponents uriComponents =
	UriComponentsBuilder.newInstance()
	.queryParam("page", page)
	.queryParam("perPageNum", cri.getPerPageNum())
	 .queryParam("searchType", ((SearchCriteria)cri).getSearchType())
	 .queryParam("searchWord", encoding(((SearchCriteria)cri).getSearchWord()))
	.build(); 
	 return uriComponents.toUriString();  
	}

	private String encoding(String keyword) {
	 if(keyword == null || keyword.trim().length() == 0)
	 { return ""; }
	 
	 try {
	  return URLEncoder.encode(keyword, "UTF-8");
	 } catch(UnsupportedEncodingException e)
	 { return ""; }
	}


}
