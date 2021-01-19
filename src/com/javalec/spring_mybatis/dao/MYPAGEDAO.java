package com.javalec.spring_mybatis.dao;

import java.util.List;
import org.springframework.stereotype.Repository;

import com.javalec.spring_mybatis.dto.MEMBERDTO;
import com.javalec.spring_mybatis.dto.RBOARDDTO;

@Repository
public interface MYPAGEDAO {

	//내가쓴글
	public List<RBOARDDTO> MyRBoard(String id);
	
	//내가 좋아요한 글
	public List<RBOARDDTO> MyLike(String id);
	
	//회원가입시 포인트 +100
	public int PlusPoint(String id);
	//글작성시 포인트 +10
	public int PlusPoint1(String id);
	
	//회원정보 수정
	public void updatemember(MEMBERDTO dto);
	
	//회원정보 삭제
    public void deletemember(String id);




}
