package com.javalec.spring_mybatis.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.javalec.spring_mybatis.dto.MEMBERDTO;
import com.javalec.spring_mybatis.dto.RBOARDDTO;
import com.javalec.spring_mybatis.dto.REVIEWBOARDDTO;
import com.javalec.spring_mybatis.dto.SearchCriteria;
import com.javalec.spring_mybatis.dto.SearchCriteria2;


public interface MAINDAO {
	
	//음식종류별 최신글
	public List<RBOARDDTO> mainlatest0( );
	public List<RBOARDDTO> mainlatest1( );
	public List<RBOARDDTO> mainlatest2( );
	public List<RBOARDDTO> mainlatest3( );
	public List<RBOARDDTO> mainlatest4( );
	public List<RBOARDDTO> mainlatest5( );
	
	//멤버랭킹
	public List<MEMBERDTO> ranking();
	public List<MEMBERDTO> ranking1();
	public List<MEMBERDTO> ranking2();

	public List<RBOARDDTO> listSearch2(SearchCriteria2 bs);

	public List<RBOARDDTO> orderbyreadcount(SearchCriteria2 bs);

	public int listCount();
	public List<REVIEWBOARDDTO> reviews();

	
	



}
