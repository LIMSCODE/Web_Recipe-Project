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





public List<REVIEWBOARDDTO> RselectAll();

public void Rinsert(REVIEWBOARDDTO dto);

public REVIEWBOARDDTO RselectOne(int reviewboardno); 

public int Rdelete(int reviewboardno);

public int RmultiDelete(String[] seq);

public void Rrboard_update(REVIEWBOARDDTO dto);



public int RupdateReadcount(int readcount, int reviewboardno);

public int RupdateComment(int reviewboardno);


public void RuploadFile(HashMap<String, Object> hm);


public List<uploadFileDTO> RgetFileList(int reviewboardno);






public List<REVIEWBOARDDTO> RlistRboard(Criteria cri);


public int RlistCount();


public List<REVIEWBOARDDTO> Rorderbyreadcount(Criteria cri);

public List<REVIEWBOARDDTO> Rorderbycommentcount(Criteria bs);





public List<REVIEWBOARDDTO> RlistSearch(SearchCriteria bs);



public int RcountSearch(SearchCriteria bs);


public List<REVIEWBOARDDTO> Rsearchorderbyreadcount(SearchCriteria cri);

public List<REVIEWBOARDDTO> Rsearchorderbycommentcount(SearchCriteria bs);







public int RboardHit(int reviewboardno);


public int RlikeCheck(Map<String, Object> m);


public int RlikeCount(int reviewboardno);

public void RinsertBoardLike(RBOARDLIKEDTO dto);

public void RdeleteBoardLike(RBOARDLIKEDTO dto);






public List<REVIEWBOARDDTO> Rmadeby(String id);


}
