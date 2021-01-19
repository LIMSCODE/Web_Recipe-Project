package com.javalec.spring_mybatis.dto;

public class RESTAUSEARCHDTO extends Criteria{
	
	private String admdng;

	private String restaukind;
	
	public RESTAUSEARCHDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getAdmdng() {
		return admdng;
	}

	public void setAdmdng(String admdng) {
		this.admdng = admdng;
	}

	public String getRestaukind() {
		return restaukind;
	}

	public void setRestaukind(String restaukind) {
		this.restaukind = restaukind;
	}
	
	

}
