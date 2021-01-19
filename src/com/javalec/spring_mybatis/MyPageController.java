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

		// 濡쒓렇�씤而⑦듃濡ㅻ윭�뿉�꽌 setAttribute濡� �꽭�뀡�뿉 ���옣�븳 login媛앹껜瑜� dto濡� 遺덈윭�� �솕硫댁뿉 肉뚮━�옄.
		MEMBERDTO dtos = (MEMBERDTO) session.getAttribute("login");
		model.addAttribute("dtos", dtos);

//		String id = request.getParameter("id");  //濡쒓렇�씤�맂�븘�씠�뵒�씪源�? (requst�뒗 �뤌�깭洹� 酉곗뿉�꽌 媛��졇�삱�븣�궗�슜)
//		System.out.println(id); //null媛믩뱾�뼱媛�.

		String id = dtos.getId(); // 濡쒓렇�씤�맂�븘�씠�뵒�씠�떎.
		System.out.println(id);
//		HashMap<String, String> map = new HashMap<String, String>();
//		map.put("id", id); //id瑜� 留듭뿉 �떞怨�, id瑜� 留ㅺ컻蹂��닔濡� 留ㅽ띁dao�쑝濡� 蹂대궦�떎.

		
		
		// �궡媛��벖湲� �쟾泥대텋�윭�삤湲�, �궡�븘�씠�뵒濡� �옉�꽦�맂 湲��쓣 �솕硫댁뿉 肉뚮젮以�.
		MYPAGEDAO dao = sqlSession.getMapper(MYPAGEDAO.class);
		model.addAttribute("myrboard", dao.MyRBoard(id));
		
		//�궡媛� 醫뗭븘�슂�븳 湲� �쟾泥� 遺덈윭�삤湲�
		model.addAttribute("mylike", dao.MyLike(id));

		return "/mypage";
	}
	
	
	@RequestMapping("/mypage_deletemember")
	public String mypage_deletemember(HttpServletRequest request, HttpSession session, Model model) {

		MEMBERDTO dto = (MEMBERDTO) session.getAttribute("login");

		String id = dto.getId(); // 濡쒓렇�씤�맂�븘�씠�뵒�씠�떎.
		System.out.println(id);
		
		session.invalidate(); // �꽭�뀡 �걡�쓬 (珥덇린�솕)
		
		//�젙蹂� 吏���
		MYPAGEDAO dao =  sqlSession.getMapper(MYPAGEDAO.class);
		dao.deletemember(id);

	
		return "/index";
	}
	
	@RequestMapping("/mypage_modify")
	public String mypage_modify(HttpServletRequest request, HttpSession session, Model model) {

		MEMBERDTO dto = (MEMBERDTO) session.getAttribute("login");

		String id = dto.getId(); // 濡쒓렇�씤�맂�븘�씠�뵒�씠�떎.
		System.out.println(id);

	
		return "/mypage_modify";
	}

	@RequestMapping("/mypage_modify_submit")
	public String mypage_modify(HttpServletRequest request, Model model, MultipartFile file, HttpSession session
			) throws IOException, Exception {
		
		
		//濡쒓렇�씤 �꽭�뀡 遺덈윭�샂.
		MEMBERDTO dto1 = (MEMBERDTO) session.getAttribute("login");

		String id = dto1.getId(); // 濡쒓렇�씤�맂�븘�씠�뵒�씠�떎.
		System.out.println(id);
		
		
		MEMBERDAO dao = sqlSession.getMapper(MEMBERDAO.class);

		// �뤌�깭洹멸컪�뱾 �쟾�떖
		//String pw  = request.getParameter("pw");
		
		String inputPass = request.getParameter("pw");
		String pw = passEncoder.encode(inputPass);

		String name  = request.getParameter("name");
		String email  = request.getParameter("email");
		String phone  = request.getParameter("phone");
	
		
		MEMBERDTO dto = new MEMBERDTO();
		dto.setId(id);  //濡쒓렇�씤�꽭�뀡�뿉�꽌 媛��졇�삩 �쁽�옱濡쒓렇�씤�맂 �븘�씠�뵒. -�젙蹂댁닔�젙�븷 而⑦듃濡ㅻ윭�뿉 �꽆寃⑥꽌 �씠 �븘�씠�뵒�쓽 �젙蹂대�� �닔�젙�븳�떎.
		dto.setPw(pw);
		dto.setName(name);
		dto.setEmail(email);
		dto.setPhone(phone);
		
		
		
		String imgUploadPath = uploadPath + File.separator + "imgUpload";
		String ymdPath = UploadFileUtils.calcPath(imgUploadPath);
		String fileName = null;
		
		//蹂듬텤�뻽�뜑�땲 �뿉�윭�굹�꽌 �넀�닔爾먯빞�븿
		
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
	
	
	


