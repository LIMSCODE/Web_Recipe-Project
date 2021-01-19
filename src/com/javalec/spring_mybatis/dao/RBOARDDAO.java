package com.javalec.spring_mybatis.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;


import com.javalec.spring_mybatis.dto.Criteria;
import com.javalec.spring_mybatis.dto.RBOARDCOMMENTDTO;
import com.javalec.spring_mybatis.dto.RBOARDDTO;
import com.javalec.spring_mybatis.dto.RBOARDLIKEDTO;
import com.javalec.spring_mybatis.dto.REVIEWBOARDDTO;
import com.javalec.spring_mybatis.dto.SearchCriteria;
import com.javalec.spring_mybatis.dto.uploadFileDTO;


@Repository
public interface RBOARDDAO {



public List<RBOARDCOMMENTDTO> AllList(int boardno);
//紐⑸줉+�럹�씠吏�
public List<RBOARDDTO> listPage(Criteria cri);


//select�뒗 xml�뿉�꽌 resulttype�쓣 getter,setter留뚮뱺 DTO濡쒖꽕�젙�븯怨� (諛섑솚�삎)
//insert update delete�뒗 parameterType �쑝濡� DTO瑜� �꽕�젙�븳�떎. 


//�쟾泥댁꽑�깮
public List<RBOARDDTO> selectAll();
//湲��옉�꽦
public void insert(RBOARDDTO dto);
//�긽�꽭蹂닿린
public RBOARDDTO selectOne(int boardno); 
//�궘�젣
public int delete(int boardno);
//�쟾泥댁궘�젣
public int multiDelete(String[] seq);
//�닔�젙
public void rboard_update(RBOARDDTO dto);


//議고쉶�닔 �뾽�뜲�씠�듃
public int updateReadcount(int readcount, int boardno);
//�뙎湲��닔 �뾽�뜲�씠�듃
public int updateComment(int boardno);

//�뙆�씪�뾽濡쒕뱶
public void uploadFile(HashMap<String, Object> hm);

//board_detail�뿉�꽌 �뾽濡쒕뱶�맂 �뙆�씪 蹂닿린
public List<uploadFileDTO> getFileList(int boardno);





//rboard吏꾩엯
public List<RBOARDDTO> listRboard(Criteria cri);

//寃뚯떆臾� 珥� 媛��닔
public int listCount();

//議고쉶�닔 �넂���닚 �젙�젹
public List<RBOARDDTO> orderbyreadcount(Criteria cri);
//�뙎湲��닔 留롮��닚 �젙�젹
public List<RBOARDDTO> orderbycommentcount(Criteria bs);




//寃��깋 議곌굔�뿉 留욊쾶
public List<RBOARDDTO> listSearch(SearchCriteria bs);


//寃��깋�븳 寃뚯떆臾� 珥� 媛��닔
public int countSearch(SearchCriteria bs);

//議고쉶�닔 �넂���닚 �젙�젹
public List<RBOARDDTO> searchorderbyreadcount(SearchCriteria cri);
//�뙎湲��닔 留롮��닚 �젙�젹
public List<RBOARDDTO> searchorderbycommentcount(SearchCriteria bs);






//議고쉶�닔
public int boardHit(int boardno);

//醫뗭븘�슂
public int likeCheck(Map<String, Object> m);

//醫뗭븘�슂 媛쒖닔
public int likeCount(int boardno);

public void insertBoardLike(RBOARDLIKEDTO dto);

public void deleteBoardLike(RBOARDLIKEDTO dto);






//�듅�젙 �븘�씠�뵒濡� �옉�꽦�맂 湲�
public List<RBOARDDTO> madeby(String id);


}
