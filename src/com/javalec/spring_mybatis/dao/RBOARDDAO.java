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

public List<RBOARDDTO> listPage(Criteria cri);




//글전부가져오기
public List<RBOARDDTO> selectAll();
//글작성
public void insert(RBOARDDTO dto);
//글 자세히보기
public RBOARDDTO selectOne(int boardno); 
//글삭제
public int delete(int boardno);
//다중삭제
public int multiDelete(String[] seq);
//글수정
public void rboard_update(RBOARDDTO dto);


//조회수수정
public int updateReadcount(int readcount, int boardno);
//댓글수 수정
public int updateComment(int boardno);

//내용에 잇는 사진 파일업로드
public void uploadFile(HashMap<String, Object> hm);

//내용에 있는 사진파일 가져오기
public List<uploadFileDTO> getFileList(int boardno);





//rboard 글 가져오기
public List<RBOARDDTO> listRboard(Criteria cri);

//글 개수
public int listCount();

//조회수정렬
public List<RBOARDDTO> orderbyreadcount(Criteria cri);



//글 가져오기
public List<RBOARDDTO> listSearch(SearchCriteria bs);


//검색한 글 개수
public int countSearch(SearchCriteria bs);

//검색결과 조회수별 정렬
public List<RBOARDDTO> searchorderbyreadcount(SearchCriteria cri);




//조회수
public int boardHit(int boardno);

//좋아요여부 확인
public int likeCheck(Map<String, Object> m);

//좋아요개수
public int likeCount(int boardno);

public void insertBoardLike(RBOARDLIKEDTO dto);

public void deleteBoardLike(RBOARDLIKEDTO dto);






//특정아이디가 작성한 글
public List<RBOARDDTO> madeby(String id);


}
