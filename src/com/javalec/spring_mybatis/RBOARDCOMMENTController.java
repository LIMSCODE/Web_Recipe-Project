package com.javalec.spring_mybatis;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FilenameUtils;
import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.javalec.spring_mybatis.dao.RBOARDCOMMENTDAO;
import com.javalec.spring_mybatis.dao.RBOARDDAO;
import com.javalec.spring_mybatis.dao.REVIEWBOARDCOMMENTDAO;
import com.javalec.spring_mybatis.dao.REVIEWBOARDDAO;
import com.javalec.spring_mybatis.dto.MEMBERDTO;
import com.javalec.spring_mybatis.dto.RBOARDCOMMENTDTO;
import com.javalec.spring_mybatis.dto.RBOARDDTO;
import com.javalec.spring_mybatis.dto.REVIEWBOARDCOMMENTDTO;
import com.javalec.spring_mybatis.dto.uploadFileDTO;
import com.kubg.utils.UploadFileUtils;

@Controller
public class RBOARDCOMMENTController {

	private static final Logger logger = LoggerFactory.getLogger(RBOARDCOMMENTController.class);

	@Autowired
	private SqlSession sqlSession;

	@RequestMapping("/commentwrite")
	public String commentwrite(HttpSession session, HttpServletRequest request, Model model,
			RedirectAttributes redirectAttributes) {
		RBOARDCOMMENTDAO dao = sqlSession.getMapper(RBOARDCOMMENTDAO.class);
		RBOARDCOMMENTDTO dto = new RBOARDCOMMENTDTO();
		
		int boardno = Integer.parseInt(request.getParameter("boardno"));

		String commentwriter = request.getParameter("commentwriter");
		String commentcontent = request.getParameter("commentcontent");
		

		MEMBERDTO dto2 = (MEMBERDTO) session.getAttribute("login");
		model.addAttribute("dto2", dto2);

		String memberImg = dto2.getMemberImg();
		
		dao.insert(boardno, commentwriter, commentcontent, memberImg);
		
		
		  //댓글수 업데이트
		RBOARDDAO dao1 = sqlSession.getMapper(RBOARDDAO.class);
		dao1.updateComment(boardno);

		
	      //redirect시 돌아갈 boardno
		redirectAttributes.addAttribute("boardno", boardno);

		return "redirect:rboard_detail";
	}
	
	@RequestMapping("/rboard_detail_commentupdateform")
	public String rboard_detail_commentupdateform( HttpSession session ,HttpServletRequest request, Model model) {
		
        //특정 게시글
		RBOARDDAO dao = sqlSession.getMapper(RBOARDDAO.class);  // xml에서 selectOne쿼리가져와 실행하기 위함

		
		int boardno = Integer.parseInt(request.getParameter("boardno"));
		
		model.addAttribute("dto", dao.selectOne(boardno));  // 게시판 하나 가져온 결과를 모델에 포함시
    	model.addAttribute("commentlist", dao.AllList(boardno));  // 댓글목록 불러오는걸 rboard_detail에서 해봄.

		
		MEMBERDTO dto2 = (MEMBERDTO) session.getAttribute("login"); // 세션에 담은 로그인정보 가져옴

		model.addAttribute("dto2", dto2);

	      // 첨부된 사진 출력
		List<uploadFileDTO> uploadFileList = dao.getFileList(boardno);
		model.addAttribute("uploadFileList", uploadFileList);
	      //조회수
		model.addAttribute("readcount",dao.boardHit(boardno));
		

		
		
	      //특정 댓글 수정하는 창
		RBOARDCOMMENTDAO dao1 = sqlSession.getMapper(RBOARDCOMMENTDAO.class); // xml에서 selectOne쿼리가져와 실행하기 위함

		int commentno = Integer.parseInt(request.getParameter("commentno"));
		System.out.println(commentno); // 가져와짐.
		
		model.addAttribute("dto1", dao1.selectComment(commentno));  

		 // 가져온 결과를 모델에 포함시

		
		  //원래 작성된 글의 정보를 updateform페이지에 띄운다.
		return "/rboard_detail_commentupdateform";
	
	}
	
	
	
	

	@RequestMapping("/rboard_comment_update")
	public String rboardupdate(@RequestParam("commentno") int commentno,@RequestParam("boardno") int boardno,RedirectAttributes redirectAttributes,
			HttpServletRequest request, Model model, MultipartFile file, HttpSession session,
			MultipartHttpServletRequest mhsq) throws IOException, Exception {
		
		
		RBOARDCOMMENTDAO dao = sqlSession.getMapper(RBOARDCOMMENTDAO.class);

	      // 폼태그값들 전달

		String commentcontent = request.getParameter("commentcontenta");
		
		System.out.println(commentcontent); //바뀐내용
		
		
		
		 // 로그인컨트롤러에서 setAttribute로 세션에 저장한 login객체를 dto로 불러와 화면에 뿌리자.
    	MEMBERDTO memberdto = (MEMBERDTO) session.getAttribute("login");
		
		
		RBOARDCOMMENTDTO dto = new RBOARDCOMMENTDTO();
		

		dto.setCommentno(commentno);
		dto.setCommentwriter(memberdto.getId());
		dto.setMemberImg(memberdto.getMemberImg());
		dto.setCommentcontent(commentcontent);

		
	      //수정
		dao.rboard_comment_update(dto);


	      // 로그인세션가져오기(위로 옮김)
	      //뷰에 로그인세션 뿌림
		model.addAttribute("memberdto", memberdto);
		
		
	      //redirect시 돌아갈 boardno
		redirectAttributes.addAttribute("boardno", boardno);
	
		
		return "redirect:rboard_detail";  // redirect는 정보포함해서 보냄.
	}
	

	@RequestMapping("/rboard_comment_delete")
	public String rboarddelete(@RequestParam("boardno") int boardno,@RequestParam("commentno") int commentno,RedirectAttributes redirectAttributes,
			HttpServletRequest request, Model model, HttpSession session) throws IOException, Exception {
		
		
		RBOARDCOMMENTDAO dao = sqlSession.getMapper(RBOARDCOMMENTDAO.class);


		dao.rboard_comment_delete(commentno);

		
		MEMBERDTO memberdto = (MEMBERDTO) session.getAttribute("login");
		
		
		model.addAttribute("memberdto", memberdto);
		
		
		redirectAttributes.addAttribute("boardno", boardno);
	
		
		return "redirect:rboard_detail";
	}
	
	
	
	//댓글
	
	@RequestMapping("/reviewcommentwrite")
	public String reviewcommentwrite(HttpSession session, HttpServletRequest request, Model model,
			RedirectAttributes redirectAttributes) {
		REVIEWBOARDCOMMENTDAO dao = sqlSession.getMapper(REVIEWBOARDCOMMENTDAO.class);
		
		int reviewboardno = Integer.parseInt(request.getParameter("reviewboardno"));

		String commentwriter = request.getParameter("commentwriter");
		String commentcontent = request.getParameter("commentcontent");
		

		MEMBERDTO dto2 = (MEMBERDTO) session.getAttribute("login"); 
		model.addAttribute("dto2", dto2);

		String memberImg = dto2.getMemberImg();
		
		dao.Rinsert(reviewboardno, commentwriter, commentcontent, memberImg);
		
		
	
		REVIEWBOARDDAO dao1 = sqlSession.getMapper(REVIEWBOARDDAO.class);
		dao1.RupdateComment(reviewboardno);


		redirectAttributes.addAttribute("reviewboardno", reviewboardno);

		return "redirect:reviewboard_detail";
	}
	
	@RequestMapping("/reviewboard_detail_commentupdateform")
	public String reviewboard_detail_commentupdateform( HttpSession session ,HttpServletRequest request, Model model) {
		

		REVIEWBOARDDAO dao = sqlSession.getMapper(REVIEWBOARDDAO.class); 

		
		int reviewboardno = Integer.parseInt(request.getParameter("reviewboardno"));
		
		model.addAttribute("dto", dao.RselectOne(reviewboardno)); 
		model.addAttribute("commentlist", dao.RAllList(reviewboardno)); 
		
		
		MEMBERDTO dto2 = (MEMBERDTO) session.getAttribute("login"); 
		model.addAttribute("dto2", dto2);

	
		List<uploadFileDTO> uploadFileList = dao.RgetFileList(reviewboardno);
		model.addAttribute("uploadFileList", uploadFileList);
			

		model.addAttribute("readcount",dao.RboardHit(reviewboardno));
		

		
		

		REVIEWBOARDCOMMENTDAO dao1 = sqlSession.getMapper(REVIEWBOARDCOMMENTDAO.class); 

		int commentno = Integer.parseInt(request.getParameter("commentno"));
		System.out.println(commentno); 
		
		model.addAttribute("dto1", dao1.RselectComment(commentno));
	
		

		return "/reviewboard_detail_commentupdateform";
	
	}
	
	
	
	

	@RequestMapping("/reviewboard_comment_update")
	public String reviewboardupdate(@RequestParam("commentno") int commentno,@RequestParam("reviewboardno") int reviewboardno,RedirectAttributes redirectAttributes,
			HttpServletRequest request, Model model, MultipartFile file, HttpSession session,
			MultipartHttpServletRequest mhsq) throws IOException, Exception {
		
		
		REVIEWBOARDCOMMENTDAO dao = sqlSession.getMapper(REVIEWBOARDCOMMENTDAO.class);

	

		String commentcontent = request.getParameter("commentcontenta");
		
		System.out.println(commentcontent);
		
		
		
		MEMBERDTO memberdto = (MEMBERDTO) session.getAttribute("login");
		
		
		REVIEWBOARDCOMMENTDTO dto = new REVIEWBOARDCOMMENTDTO();
		

		dto.setCommentno(commentno);
		dto.setCommentwriter(memberdto.getId());
		dto.setMemberImg(memberdto.getMemberImg());
		dto.setCommentcontent(commentcontent);

		
	
		dao.Rrboard_comment_update(dto);


		
		model.addAttribute("memberdto", memberdto);
		
	
		redirectAttributes.addAttribute("reviewboardno", reviewboardno);
	
		
		return "redirect:reviewboard_detail";
	}
	
	
	@RequestMapping("/reviewboard_comment_delete")
	public String reviewboarddelete(@RequestParam("reviewboardno") int reviewboardno,@RequestParam("commentno") int commentno,RedirectAttributes redirectAttributes,
			HttpServletRequest request, Model model, HttpSession session) throws IOException, Exception {
		
		
		REVIEWBOARDCOMMENTDAO dao = sqlSession.getMapper(REVIEWBOARDCOMMENTDAO.class);


		dao.Rrboard_comment_delete(commentno);

		
		MEMBERDTO memberdto = (MEMBERDTO) session.getAttribute("login");
		
	
		model.addAttribute("memberdto", memberdto);
		
		
		redirectAttributes.addAttribute("reviewboardno", reviewboardno);
	
		
		return "redirect:reviewboard_detail"; 
	}
	

}
