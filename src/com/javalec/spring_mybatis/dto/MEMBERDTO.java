package com.javalec.spring_mybatis.dto;

//CREATE TABLE MEMBER(
//MEMBERNO NUMBER PRIMARY KEY,
//ID VARCHAR2(50) NOT NULL,
//PW VARCHAR2(50) NOT NULL,
//NAME VARCHAR2(50) NOT NULL,
//EMAIL VARCHAR2(100) NOT NULL,
//PHONE VARCHAR2(20) NOT NULL,
//POINT NUMBER,
//ROLE VARCHAR(50) NOT NULL,
//ENABLED VARCHAR(3) NOT NULL,

//CONSTRAINT UQ_ID UNIQUE(ID),
//CONSTRAINT UQ_NAME UNIQUE(NAME),
//CONSTRAINT UQ_EMAIL UNIQUE(EMAIL),
//CONSTRAINT UQ_PHONE UNIQUE(PHONE),
//CONSTRAINT CHK_ENABLED CHECK(ENABLED IN('Y', 'N'))
//);
public class MEMBERDTO {
	
	private int memberno;
	private String id;
	private String pw;
	private String name;
	private String email;
	private String phone;
	private int point;
	private String role;
	private String enabled;
	private String memberImg;
	private String memberThumbImg;
	
	
	
	public MEMBERDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public MEMBERDTO(int memberno, String id, String pw, String name, String email, String phone, int point,
			String role, String enabled) {
		super();
		this.memberno = memberno;
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.point = point;
		this.role = role;
		this.enabled = enabled;
	}
	
	
	public int getMemberno() {
		return memberno;
	}
	public void setMemberno(int memberno) {
		this.memberno = memberno;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public int getPoint() {
		return point;
	}
	public void setPoint(int point) {
		this.point = point;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getEnabled() {
		return enabled;
	}
	public void setEnabled(String enabled) {
		this.enabled = enabled;
	}
	
	
	
	
	
	public String getMemberImg() {
		return memberImg;
	}
	public void setMemberImg(String memberImg) {
		this.memberImg = memberImg;
	}
	public String getMemberThumbImg() {
		return memberThumbImg;
	}
	public void setMemberThumbImg(String memberThumbImg) {
		this.memberThumbImg = memberThumbImg;
	}

	
	
}
