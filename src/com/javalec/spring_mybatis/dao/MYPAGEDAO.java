package com.javalec.spring_mybatis.dao;

import java.util.List;
import org.springframework.stereotype.Repository;

import com.javalec.spring_mybatis.dto.MEMBERDTO;
import com.javalec.spring_mybatis.dto.RBOARDDTO;

@Repository
public interface MYPAGEDAO {

	//내가작성한글
	public List<RBOARDDTO> MyRBoard(String id);
	
	//내가좋아요한 글
	public List<RBOARDDTO> MyLike(String id);
	
	//글작성시 포인트적립
	public int PlusPoint(String id);

	public int PlusPoint1(String id);
	
	//회원정보 수정
	public void updatemember(MEMBERDTO dto);
	
	//회원정보 삭제
    public void deletemember(String id);




}
