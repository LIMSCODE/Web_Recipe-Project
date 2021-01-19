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
public interface REVIEWBOARDDAO {



public List<RBOARDCOMMENTDTO> RAllList(int reviewboardno);


//select?Š” xml?—?„œ resulttype?„ getter,setterë§Œë“  DTOë¡œì„¤? •?•˜ê³? (ë°˜í™˜?˜•)
//insert update delete?Š” parameterType ?œ¼ë¡? DTOë¥? ?„¤? •?•œ?‹¤. 


//? „ì²´ì„ ?ƒ
public List<REVIEWBOARDDTO> RselectAll();
//ê¸??‘?„±
public void Rinsert(REVIEWBOARDDTO dto);
//?ƒ?„¸ë³´ê¸°
public REVIEWBOARDDTO RselectOne(int reviewboardno); 
//?‚­? œ
public int Rdelete(int reviewboardno);
//? „ì²´ì‚­? œ
public int RmultiDelete(String[] seq);
//?ˆ˜? •

public void Rrboard_update(REVIEWBOARDDTO dto);


//ì¡°íšŒ?ˆ˜ ?—…?°?´?Š¸
public int RupdateReadcount(int readcount, int reviewboardno);
//?Œ“ê¸??ˆ˜ ?—…?°?´?Š¸
public int RupdateComment(int reviewboardno);

//?ŒŒ?¼?—…ë¡œë“œ
public void RuploadFile(HashMap<String, Object> hm);

//board_detail?—?„œ ?—…ë¡œë“œ?œ ?ŒŒ?¼ ë³´ê¸°
public List<uploadFileDTO> RgetFileList(int reviewboardno);





//rboardì§„ì…
public List<REVIEWBOARDDTO> RlistRboard(Criteria cri);

//ê²Œì‹œë¬? ì´? ê°??ˆ˜
public int RlistCount();

//ì¡°íšŒ?ˆ˜ ?†’???ˆœ ? •? ¬
public List<REVIEWBOARDDTO> Rorderbyreadcount(Criteria cri);
//?Œ“ê¸??ˆ˜ ë§ì??ˆœ ? •? ¬
public List<REVIEWBOARDDTO> Rorderbycommentcount(Criteria bs);




//ê²??ƒ‰ ì¡°ê±´?— ë§ê²Œ
public List<REVIEWBOARDDTO> RlistSearch(SearchCriteria bs);


//ê²??ƒ‰?•œ ê²Œì‹œë¬? ì´? ê°??ˆ˜
public int RcountSearch(SearchCriteria bs);

//ì¡°íšŒ?ˆ˜ ?†’???ˆœ ? •? ¬
public List<REVIEWBOARDDTO> Rsearchorderbyreadcount(SearchCriteria cri);
//?Œ“ê¸??ˆ˜ ë§ì??ˆœ ? •? ¬
public List<REVIEWBOARDDTO> Rsearchorderbycommentcount(SearchCriteria bs);






//ì¡°íšŒ?ˆ˜
public int RboardHit(int reviewboardno);

//ì¢‹ì•„?š”
public int RlikeCheck(Map<String, Object> m);

//ì¢‹ì•„?š” ê°œìˆ˜
public int RlikeCount(int reviewboardno);

public void RinsertBoardLike(RBOARDLIKEDTO dto);

public void RdeleteBoardLike(RBOARDLIKEDTO dto);






//?Š¹? • ?•„?´?””ë¡? ?‘?„±?œ ê¸?
public List<REVIEWBOARDDTO> Rmadeby(String id);


}
