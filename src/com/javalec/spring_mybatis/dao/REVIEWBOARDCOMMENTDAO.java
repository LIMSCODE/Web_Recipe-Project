package com.javalec.spring_mybatis.dao;

import com.javalec.spring_mybatis.dto.RBOARDCOMMENTDTO;
import com.javalec.spring_mybatis.dto.RBOARDDTO;
import com.javalec.spring_mybatis.dto.REVIEWBOARDCOMMENTDTO;

public interface REVIEWBOARDCOMMENTDAO {
	

	public int Rinsert(int reviewboardno, String commentwriter, String commentcontent, String memberImg);

	public REVIEWBOARDCOMMENTDTO RselectComment(int commentno);

	public void Rrboard_comment_update(REVIEWBOARDCOMMENTDTO dto);

	public void Rrboard_comment_delete(int commentno);

}
