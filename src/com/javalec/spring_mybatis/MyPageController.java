package com.javalec.spring_mybatis;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.javalec.spring_mybatis.dao.MEMBERDAO;
import com.javalec.spring_mybatis.dao.MYPAGEDAO;
import com.javalec.spring_mybatis.dao.RBOARDDAO;
import com.javalec.spring_mybatis.dto.Criteria;
import com.javalec.spring_mybatis.dto.MEMBERDTO;
import com.javalec.spring_mybatis.dto.PageMaker;
import com.javalec.spring_mybatis.dto.RBOARDDTO;
import com.kubg.utils.UploadFileUtils;

/**
 * Handles requests for the application home page.
 */
@Controller
public class MyPageController {
	
	private static final Logger logger = LoggerFactory.getLogger(MyPageController.class);
	
/*	ContentDao dao;*/
	
	@Autowired
	private SqlSession sqlSession;
	
	@Resource(name = "uploadPath")
	private String uploadPath;
	
	@Autowired
	BCryptPasswordEncoder passEncoder;

	
/*	@Autowired
	public void setDao(ContentDao dao) {
		this.dao = dao;
	}*/
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	
	@RequestMapping("/mypage")
	public String mypage(HttpServletRequest request, HttpSession session, Model model) {

		// 로그인컨트롤러에서 setAttribute로 세션에 저장한 login객체를 dto로 불러와 화면에 뿌리자.
        MEMBERDTO dtos = (MEMBERDTO) session.getAttribute("login");
		model.addAttribute("dtos", dtos);

//      String id = request.getParameter("id");  //로그인된아이디일까? (requst는 폼태그 뷰에서 가져올때사용)
//      System.out.println(id); //null값들어감.

		String id = dtos.getId(); // 로그인된아이디이다.
		System.out.println(id);
//      HashMap<String, String> map = new HashMap<String, String>();
//      map.put("id", id); //id를 맵에 담고, id를 매개변수로 매퍼dao으로 보낸다.

		
		
		 // 내가쓴글 전체불러오기, 내아이디로 작성된 글을 화면에 뿌려줌.

		MYPAGEDAO dao = sqlSession.getMapper(MYPAGEDAO.class);
		model.addAttribute("myrboard", dao.MyRBoard(id));
		
	    //내가 좋아요한 글 전체 불러오기
		model.addAttribute("mylike", dao.MyLike(id));

		return "/mypage";
	}
	
	
	@RequestMapping("/mypage_deletemember")
	public String mypage_deletemember(HttpServletRequest request, HttpSession session, Model model) {

		MEMBERDTO dto = (MEMBERDTO) session.getAttribute("login");

		String id = dto.getId(); // 로그인된아이디이다.
		System.out.println(id);
		
		session.invalidate(); // 세션 끊음 (초기화)
		
	      //정보 지움
		MYPAGEDAO dao =  sqlSession.getMapper(MYPAGEDAO.class);
		dao.deletemember(id);

	
		return "/index";
	}
	
	@RequestMapping("/mypage_modify")
	public String mypage_modify(HttpServletRequest request, HttpSession session, Model model) {

		MEMBERDTO dto = (MEMBERDTO) session.getAttribute("login");

		String id = dto.getId(); // 로그인된아이디이다.
		System.out.println(id);

	
		return "/mypage_modify";
	}

	@RequestMapping("/mypage_modify_submit")
	public String mypage_modify(HttpServletRequest request, Model model, MultipartFile file, HttpSession session
			) throws IOException, Exception {
		
		
		 //로그인 세션 불러옴.
		MEMBERDTO dto1 = (MEMBERDTO) session.getAttribute("login");

		String id = dto1.getId();  // 로그인된아이디이다.
		System.out.println(id);
		
		
		MEMBERDAO dao = sqlSession.getMapper(MEMBERDAO.class);

		  // 폼태그값들 전달
		//String pw  = request.getParameter("pw");
		
		String inputPass = request.getParameter("pw");
		String pw = passEncoder.encode(inputPass);

		String name  = request.getParameter("name");
		String email  = request.getParameter("email");
		String phone  = request.getParameter("phone");
	
		
		MEMBERDTO dto = new MEMBERDTO();
		dto.setId(id);  //로그인세션에서 가져온 현재로그인된 아이디. -정보수정할 컨트롤러에 넘겨서 이 아이디의 정보를 수정한다.

		dto.setPw(pw);
		dto.setName(name);
		dto.setEmail(email);
		dto.setPhone(phone);
		
		
		
		String imgUploadPath = uploadPath + File.separator + "imgUpload";
		String ymdPath = UploadFileUtils.calcPath(imgUploadPath);
		String fileName = null;
		
		//복붙했더니 에러나서 손수쳐야함

		
		if(file!=null) {
			fileName= UploadFileUtils.fileUpload(imgUploadPath, file.getOriginalFilename(), file.getBytes(), ymdPath);
			
		}else {
			fileName = uploadPath + File.separator + "images" + File.separator + "none.png";
		}

	    dto.setMemberImg(File.separator + "imgUpload" + ymdPath + File.separator + fileName);
		dto.setMemberThumbImg(File.separator + "imgUpload" + ymdPath + File.separator + "s" + File.separator + "s_" + fileName);
		
		
		
		
		MYPAGEDAO dao1 = sqlSession.getMapper(MYPAGEDAO.class);
		dao1.updatemember(dto);

		return "/mypage_modify";
	}
	
}
	
	
	


