package com.javalec.spring_mybatis.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.javalec.spring_mybatis.dto.Criteria;
import com.javalec.spring_mybatis.dto.RBOARDDTO;
import com.javalec.spring_mybatis.dto.RESTAUDTO;
import com.javalec.spring_mybatis.dto.RESTAUSEARCHDTO;

@Repository
public interface RESTAUDAO {
	
	public void restauinsert(RESTAUDTO dto);
	
	public List<RESTAUDTO> restauselect();
	
	
	
	public List<RESTAUDTO> restauselect_0(Map map);
	public List<RESTAUDTO> restauselect_1(Map map);

	public int restauCount(RESTAUSEARCHDTO dto);

	



}
