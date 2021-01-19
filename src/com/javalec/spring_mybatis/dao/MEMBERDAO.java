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
//);

public interface MEMBERDAO {
	
//�쉶�썝媛��엯
//public int insertuser(@Param("id")String id, @Param("pw")String pw, @Param("name")String name,
		//@Param("email")String email, @Param("phone")String phone, 
		//@Param("memberImg")String memberImg ,@Param("memberThumbImg")String memberThumbImg);

	
	

public MEMBERDTO idCheck(String id);


public void insertuser(MEMBERDTO dto);



//濡쒓렇�씤
public MEMBERDTO loginCheck(@Param("id")String id);

//�꽕�씠踰꾨줈洹몄씤

//濡쒓렇�씤而⑦듃濡ㅻ윭�뿉�꽌 濡쒓렇�씤�맟�뒗吏� �솗�씤�븯�뿬 硫붿씤�럹�씠吏�濡� 肉뚮┝
public MEMBERDTO loginChecknaver(@Param("id")String id, @Param("email")String email);
public int insertnaveruser(@Param("id")String id, @Param("name")String name, @Param("email")String email, @Param("memberImg")String memberImg);





}
