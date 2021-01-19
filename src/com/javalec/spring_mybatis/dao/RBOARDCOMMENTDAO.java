package com.javalec.spring_mybatis.dao;

import com.javalec.spring_mybatis.dto.RBOARDCOMMENTDTO;
import com.javalec.spring_mybatis.dto.RBOARDDTO;

public interface RBOARDCOMMENTDAO {
	

	public int insert(int boardno, String commentwriter, String commentcontent, String memberImg);

	public RBOARDCOMMENTDTO selectComment(int commentno);

	public void rboard_comment_update(RBOARDCOMMENTDTO dto);


	public void rboard_comment_delete(int commentno);

}
