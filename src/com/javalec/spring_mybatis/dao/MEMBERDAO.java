package com.javalec.spring_mybatis.dao;

import org.apache.ibatis.annotations.Param;

import com.javalec.spring_mybatis.dto.MEMBERDTO;
import com.javalec.spring_mybatis.dto.MEMBERNAVERDTO;

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
//);.

public interface MEMBERDAO {
	
//회원가입
//public int insertuser(@Param("id")String id, @Param("pw")String pw, @Param("name")String name,
		//@Param("email")String email, @Param("phone")String phone, 
		//@Param("memberImg")String memberImg ,@Param("memberThumbImg")String memberThumbImg);

	
	

public MEMBERDTO idCheck(String id);


public void insertuser(MEMBERDTO dto);



//로그인 체크
public MEMBERDTO loginCheck(@Param("id")String id);

//네이버


public MEMBERDTO loginChecknaver(@Param("id")String id, @Param("email")String email);
public int insertnaveruser(@Param("id")String id, @Param("name")String name, @Param("email")String email, @Param("memberImg")String memberImg);





}
