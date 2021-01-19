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
		

		MEMBERDTO dto2 = (MEMBERDTO) session.getAttribute("login"); // �꽭�뀡�뿉 �떞�� 濡쒓렇�씤�젙蹂� 媛��졇�샂
		model.addAttribute("dto2", dto2);

		String memberImg = dto2.getMemberImg();
		
		dao.insert(boardno, commentwriter, commentcontent, memberImg);
		
		
		//�뙎湲��닔 �뾽�뜲�씠�듃
		RBOARDDAO dao1 = sqlSession.getMapper(RBOARDDAO.class);
		dao1.updateComment(boardno);

		
		//redirect�떆 �룎�븘媛� boardno
		redirectAttributes.addAttribute("boardno", boardno);

		return "redirect:rboard_detail";
	}
	
	@RequestMapping("/rboard_detail_commentupdateform")
	public String rboard_detail_commentupdateform( HttpSession session ,HttpServletRequest request, Model model) {
		
        //�듅�젙 寃뚯떆湲�
		RBOARDDAO dao = sqlSession.getMapper(RBOARDDAO.class); // xml�뿉�꽌 selectOne荑쇰━媛��졇�� �떎�뻾�븯湲� �쐞�븿

		
		int boardno = Integer.parseInt(request.getParameter("boardno"));
		
		model.addAttribute("dto", dao.selectOne(boardno)); // 寃뚯떆�뙋 �븯�굹 媛��졇�삩 寃곌낵瑜� 紐⑤뜽�뿉 �룷�븿�떆
		model.addAttribute("commentlist", dao.AllList(boardno)); // �뙎湲�紐⑸줉 遺덈윭�삤�뒗嫄� rboard_detail�뿉�꽌 �빐遊�.
		
		
		MEMBERDTO dto2 = (MEMBERDTO) session.getAttribute("login"); // �꽭�뀡�뿉 �떞�� 濡쒓렇�씤�젙蹂� 媛��졇�샂
		model.addAttribute("dto2", dto2);

		// 泥⑤��맂 �궗吏� 異쒕젰
		List<uploadFileDTO> uploadFileList = dao.getFileList(boardno);
		model.addAttribute("uploadFileList", uploadFileList);
			
		//議고쉶�닔
		model.addAttribute("readcount",dao.boardHit(boardno));
		

		
		
		//�듅�젙 �뙎湲� �닔�젙�븯�뒗 李�
		RBOARDCOMMENTDAO dao1 = sqlSession.getMapper(RBOARDCOMMENTDAO.class); // xml�뿉�꽌 selectOne荑쇰━媛��졇�� �떎�뻾�븯湲� �쐞�븿

		int commentno = Integer.parseInt(request.getParameter("commentno"));
		System.out.println(commentno); // 媛��졇��吏�.
		
		model.addAttribute("dto1", dao1.selectComment(commentno)); // 媛��졇�삩 寃곌낵瑜� 紐⑤뜽�뿉 �룷�븿�떆
		
		//�썝�옒 �옉�꽦�맂 湲��쓽 �젙蹂대�� updateform�럹�씠吏��뿉 �쓣�슫�떎.
		

		return "/rboard_detail_commentupdateform";
	
	}
	
	
	
	

	@RequestMapping("/rboard_comment_update")
	public String rboardupdate(@RequestParam("commentno") int commentno,@RequestParam("boardno") int boardno,RedirectAttributes redirectAttributes,
			HttpServletRequest request, Model model, MultipartFile file, HttpSession session,
			MultipartHttpServletRequest mhsq) throws IOException, Exception {
		
		
		RBOARDCOMMENTDAO dao = sqlSession.getMapper(RBOARDCOMMENTDAO.class);

		// �뤌�깭洹멸컪�뱾 �쟾�떖

		String commentcontent = request.getParameter("commentcontenta");
		
		System.out.println(commentcontent); //諛붾�먮궡�슜
		
		
		
		// 濡쒓렇�씤而⑦듃濡ㅻ윭�뿉�꽌 setAttribute濡� �꽭�뀡�뿉 ���옣�븳 login媛앹껜瑜� dto濡� 遺덈윭�� �솕硫댁뿉 肉뚮━�옄.
		MEMBERDTO memberdto = (MEMBERDTO) session.getAttribute("login");
		
		
		RBOARDCOMMENTDTO dto = new RBOARDCOMMENTDTO();
		

		dto.setCommentno(commentno);
		dto.setCommentwriter(memberdto.getId());
		dto.setMemberImg(memberdto.getMemberImg());
		dto.setCommentcontent(commentcontent);

		
		//�닔�젙
		dao.rboard_comment_update(dto);


		// 濡쒓렇�씤�꽭�뀡媛��졇�삤湲�(�쐞濡� �삷源�)
		//酉곗뿉 濡쒓렇�씤�꽭�뀡 肉뚮┝
		model.addAttribute("memberdto", memberdto);
		
		
		//redirect�떆 �룎�븘媛� boardno
		redirectAttributes.addAttribute("boardno", boardno);
	
		
		return "redirect:rboard_detail"; // redirect�뒗 �젙蹂댄룷�븿�빐�꽌 蹂대깂.
	}
	

	@RequestMapping("/rboard_comment_delete")
	public String rboarddelete(@RequestParam("boardno") int boardno,@RequestParam("commentno") int commentno,RedirectAttributes redirectAttributes,
			HttpServletRequest request, Model model, HttpSession session) throws IOException, Exception {
		
		
		RBOARDCOMMENTDAO dao = sqlSession.getMapper(RBOARDCOMMENTDAO.class);

		//�닔�젙
		dao.rboard_comment_delete(commentno);

		
		// 濡쒓렇�씤而⑦듃濡ㅻ윭�뿉�꽌 setAttribute濡� �꽭�뀡�뿉 ���옣�븳 login媛앹껜瑜� dto濡� 遺덈윭�� �솕硫댁뿉 肉뚮━�옄.
		MEMBERDTO memberdto = (MEMBERDTO) session.getAttribute("login");
		
		// 濡쒓렇�씤�꽭�뀡媛��졇�삤湲�(�쐞濡� �삷源�)
		//酉곗뿉 濡쒓렇�씤�꽭�뀡 肉뚮┝
		model.addAttribute("memberdto", memberdto);
		
		
		//redirect�떆 �룎�븘媛� boardno
		redirectAttributes.addAttribute("boardno", boardno);
	
		
		return "redirect:rboard_detail"; // redirect�뒗 �젙蹂댄룷�븿�빐�꽌 蹂대깂.
	}
	
	
	
	//댓글
	
	@RequestMapping("/reviewcommentwrite")
	public String reviewcommentwrite(HttpSession session, HttpServletRequest request, Model model,
			RedirectAttributes redirectAttributes) {
		REVIEWBOARDCOMMENTDAO dao = sqlSession.getMapper(REVIEWBOARDCOMMENTDAO.class);
		
		int reviewboardno = Integer.parseInt(request.getParameter("reviewboardno"));

		String commentwriter = request.getParameter("commentwriter");
		String commentcontent = request.getParameter("commentcontent");
		

		MEMBERDTO dto2 = (MEMBERDTO) session.getAttribute("login"); // �꽭�뀡�뿉 �떞�� 濡쒓렇�씤�젙蹂� 媛��졇�샂
		model.addAttribute("dto2", dto2);

		String memberImg = dto2.getMemberImg();
		
		dao.Rinsert(reviewboardno, commentwriter, commentcontent, memberImg);
		
		
		//�뙎湲��닔 �뾽�뜲�씠�듃
		REVIEWBOARDDAO dao1 = sqlSession.getMapper(REVIEWBOARDDAO.class);
		dao1.RupdateComment(reviewboardno);

		
		//redirect�떆 �룎�븘媛� boardno
		redirectAttributes.addAttribute("reviewboardno", reviewboardno);

		return "redirect:reviewboard_detail";
	}
	
	@RequestMapping("/reviewboard_detail_commentupdateform")
	public String reviewboard_detail_commentupdateform( HttpSession session ,HttpServletRequest request, Model model) {
		
        //�듅�젙 寃뚯떆湲�
		REVIEWBOARDDAO dao = sqlSession.getMapper(REVIEWBOARDDAO.class); // xml�뿉�꽌 selectOne荑쇰━媛��졇�� �떎�뻾�븯湲� �쐞�븿

		
		int reviewboardno = Integer.parseInt(request.getParameter("reviewboardno"));
		
		model.addAttribute("dto", dao.RselectOne(reviewboardno)); // 寃뚯떆�뙋 �븯�굹 媛��졇�삩 寃곌낵瑜� 紐⑤뜽�뿉 �룷�븿�떆
		model.addAttribute("commentlist", dao.RAllList(reviewboardno)); // �뙎湲�紐⑸줉 遺덈윭�삤�뒗嫄� rboard_detail�뿉�꽌 �빐遊�.
		
		
		MEMBERDTO dto2 = (MEMBERDTO) session.getAttribute("login"); // �꽭�뀡�뿉 �떞�� 濡쒓렇�씤�젙蹂� 媛��졇�샂
		model.addAttribute("dto2", dto2);

		// 泥⑤��맂 �궗吏� 異쒕젰
		List<uploadFileDTO> uploadFileList = dao.RgetFileList(reviewboardno);
		model.addAttribute("uploadFileList", uploadFileList);
			
		//議고쉶�닔
		model.addAttribute("readcount",dao.RboardHit(reviewboardno));
		

		
		
		//�듅�젙 �뙎湲� �닔�젙�븯�뒗 李�
		REVIEWBOARDCOMMENTDAO dao1 = sqlSession.getMapper(REVIEWBOARDCOMMENTDAO.class); // xml�뿉�꽌 selectOne荑쇰━媛��졇�� �떎�뻾�븯湲� �쐞�븿

		int commentno = Integer.parseInt(request.getParameter("commentno"));
		System.out.println(commentno); // 媛��졇��吏�.
		
		model.addAttribute("dto1", dao1.RselectComment(commentno)); // 媛��졇�삩 寃곌낵瑜� 紐⑤뜽�뿉 �룷�븿�떆
		
		//�썝�옒 �옉�꽦�맂 湲��쓽 �젙蹂대�� updateform�럹�씠吏��뿉 �쓣�슫�떎.
		

		return "/reviewboard_detail_commentupdateform";
	
	}
	
	
	
	

	@RequestMapping("/reviewboard_comment_update")
	public String reviewboardupdate(@RequestParam("commentno") int commentno,@RequestParam("reviewboardno") int reviewboardno,RedirectAttributes redirectAttributes,
			HttpServletRequest request, Model model, MultipartFile file, HttpSession session,
			MultipartHttpServletRequest mhsq) throws IOException, Exception {
		
		
		REVIEWBOARDCOMMENTDAO dao = sqlSession.getMapper(REVIEWBOARDCOMMENTDAO.class);

		// �뤌�깭洹멸컪�뱾 �쟾�떖

		String commentcontent = request.getParameter("commentcontenta");
		
		System.out.println(commentcontent); //諛붾�먮궡�슜
		
		
		
		// 濡쒓렇�씤而⑦듃濡ㅻ윭�뿉�꽌 setAttribute濡� �꽭�뀡�뿉 ���옣�븳 login媛앹껜瑜� dto濡� 遺덈윭�� �솕硫댁뿉 肉뚮━�옄.
		MEMBERDTO memberdto = (MEMBERDTO) session.getAttribute("login");
		
		
		REVIEWBOARDCOMMENTDTO dto = new REVIEWBOARDCOMMENTDTO();
		

		dto.setCommentno(commentno);
		dto.setCommentwriter(memberdto.getId());
		dto.setMemberImg(memberdto.getMemberImg());
		dto.setCommentcontent(commentcontent);

		
		//�닔�젙
		dao.Rrboard_comment_update(dto);


		// 濡쒓렇�씤�꽭�뀡媛��졇�삤湲�(�쐞濡� �삷源�)
		//酉곗뿉 濡쒓렇�씤�꽭�뀡 肉뚮┝
		model.addAttribute("memberdto", memberdto);
		
		
		//redirect�떆 �룎�븘媛� boardno
		redirectAttributes.addAttribute("reviewboardno", reviewboardno);
	
		
		return "redirect:reviewboard_detail"; // redirect�뒗 �젙蹂댄룷�븿�빐�꽌 蹂대깂.
	}
	
	
	@RequestMapping("/reviewboard_comment_delete")
	public String reviewboarddelete(@RequestParam("reviewboardno") int reviewboardno,@RequestParam("commentno") int commentno,RedirectAttributes redirectAttributes,
			HttpServletRequest request, Model model, HttpSession session) throws IOException, Exception {
		
		
		REVIEWBOARDCOMMENTDAO dao = sqlSession.getMapper(REVIEWBOARDCOMMENTDAO.class);

		//�닔�젙
		dao.Rrboard_comment_delete(commentno);

		
		// 濡쒓렇�씤而⑦듃濡ㅻ윭�뿉�꽌 setAttribute濡� �꽭�뀡�뿉 ���옣�븳 login媛앹껜瑜� dto濡� 遺덈윭�� �솕硫댁뿉 肉뚮━�옄.
		MEMBERDTO memberdto = (MEMBERDTO) session.getAttribute("login");
		
		// 濡쒓렇�씤�꽭�뀡媛��졇�삤湲�(�쐞濡� �삷源�)
		//酉곗뿉 濡쒓렇�씤�꽭�뀡 肉뚮┝
		model.addAttribute("memberdto", memberdto);
		
		
		//redirect�떆 �룎�븘媛� boardno
		redirectAttributes.addAttribute("reviewboardno", reviewboardno);
	
		
		return "redirect:reviewboard_detail"; // redirect�뒗 �젙蹂댄룷�븿�빐�꽌 蹂대깂.
	}
	

}
