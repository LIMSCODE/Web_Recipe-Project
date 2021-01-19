package com.javalec.spring_mybatis;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Array;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FilenameUtils;
import org.apache.ibatis.session.SqlSession;
import org.json.JSONArray;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.javalec.spring_mybatis.dao.MEMBERDAO;
import com.javalec.spring_mybatis.dao.MYPAGEDAO;
import com.javalec.spring_mybatis.dao.RBOARDCOMMENTDAO;
import com.javalec.spring_mybatis.dao.RBOARDDAO;
import com.javalec.spring_mybatis.dao.RESTAUDAO;
import com.javalec.spring_mybatis.dao.REVIEWBOARDDAO;
import com.javalec.spring_mybatis.dto.Criteria;
import com.javalec.spring_mybatis.dto.MEMBERDTO;
import com.javalec.spring_mybatis.dto.PageMaker;
import com.javalec.spring_mybatis.dto.RBOARDDTO;
import com.javalec.spring_mybatis.dto.RBOARDLIKEDTO;
import com.javalec.spring_mybatis.dto.RESTAUDTO;
import com.javalec.spring_mybatis.dto.REVIEWBOARDDTO;
import com.javalec.spring_mybatis.dto.SearchCriteria;
import com.javalec.spring_mybatis.dto.uploadFileDTO;
import com.kubg.utils.UploadFileUtils;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	/* ContentDao dao; */

	@Autowired
	private SqlSession sqlSession;

	@Resource(name = "uploadPath")
	private String uploadPath;
	
	 @Autowired
	  private JavaMailSender mailSender;
	 

	/*
	 * @Autowired public void setDao(ContentDao dao) { this.dao = dao; }
	 */

	/**
	 * Simply selects the home view to render by returning its name.
	 */

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);

		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);

		String formattedDate = dateFormat.format(date);
		model.addAttribute("serverTime", formattedDate);

		return "home";
	}


	

	
	// rboard �뱾�뼱媛붿쓣�븣
	@RequestMapping(value = "/listSearchsendmail", method = RequestMethod.GET)
	public String listSearchsendmail(@ModelAttribute("scri") SearchCriteria bs, HttpSession session, HttpServletRequest request, HttpServletResponse response, Model model)
			throws Exception {
		logger.info("rboard");
		RBOARDDAO dao = sqlSession.getMapper(RBOARDDAO.class);

		
//		String[] foodList;
//		String[] countryList;
//		String[] timeList;
//		String SearchType;
//		String SearchWord;
//		
//	
//			foodList =(String[]) session.getAttribute("foodList");
//	
//			countryList =(String[]) session.getAttribute("countryList");
//		
//			timeList =(String[]) session.getAttribute("timeList");
//		
//			SearchType = (String) session.getAttribute("SearchType");
//			
//			SearchWord = (String) session.getAttribute("SearchWord");
//
//		

		
		//寃��깋�븳 寃곌낵瑜� �럹�씠吏뺥븳�떎.

		List<RBOARDDTO> searchList = dao.listSearch(bs);
		model.addAttribute("searchList", searchList);  //�떎�쓬酉곗뿉 dto瑜� 肉뚮┝.
		

		//�럹�씠吏�
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(bs);
		pageMaker.setTotalCount(dao.countSearch(bs));
		
		System.out.println(dao.countSearch(bs));   //媛��닔異쒕젰
		model.addAttribute("pageMaker", pageMaker);
		
		//�럹�씠吏뺤쑀吏�
		model.addAttribute("scri", bs); 
		

		return "/listSearchsendmail";
	}
	
	
	//rboard 吏꾩엯�떆 議고쉶�닔�넂���닚�꽌 �젙�젹 而⑦듃濡ㅻ윭 留뚮벉
	@RequestMapping(value = "/listSearchreadcount", method = RequestMethod.GET)
	public String orderbyreadcount(@ModelAttribute("scri") SearchCriteria cri, HttpSession session, HttpServletRequest request, HttpServletResponse response, Model model)
			throws Exception {
		logger.info("orderbyreadcount");
		RBOARDDAO dao = sqlSession.getMapper(RBOARDDAO.class);

		
		//議고쉶�닔�넂���닚 �젙�젹
		List<RBOARDDTO> searchList = dao.orderbyreadcount(cri);
		model.addAttribute("searchList", searchList);

		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(dao.listCount());
		model.addAttribute("pageMaker", pageMaker);
		
		//�럹�씠吏� �쑀吏�
		model.addAttribute("scri", cri);

		return  "/listSearchreadcount";
	}
	
	
	
	
	// 寃��깋 - �빐�떦議곌굔�쑝濡� 李얘린 �닃���쓣�븣

	@RequestMapping(value = "/listSearchsendmail123", method = RequestMethod.GET)
	public String listSearchsendmail123(@ModelAttribute("scri") SearchCriteria bs,RedirectAttributes rttr, HttpSession session, HttpServletRequest request, HttpServletResponse response, Model model)
			throws Exception {
		logger.info("寃��깋踰꾪듉 �늻由�");
		RBOARDDAO dao = sqlSession.getMapper(RBOARDDAO.class);

		
		
		String[] foodList;
		String[] countryList;
		String[] timeList;
		String SearchType;
		String SearchWord;
		
		foodList = request.getParameterValues("foodkind");
		countryList = request.getParameterValues("countrykind");
		timeList = request.getParameterValues("timekind");
		
		SearchType = (String) session.getAttribute("SearchType");
		SearchWord = (String) session.getAttribute("SearchWord");
		
	
		
		
		System.out.println(foodList);  //[鍮듬쪟]
		System.out.println(countryList);  //[鍮듬쪟]
		System.out.println(timeList);  //[鍮듬쪟]
	
		System.out.println(SearchWord);
		System.out.println(SearchType);
		
		
		System.out.println(Arrays.toString(foodList));  //[鍮듬쪟]
		System.out.println(Arrays.toString(countryList));  //[鍮듬쪟]
		System.out.println(Arrays.toString(timeList));  //[鍮듬쪟]
		
	
		
		//forward�떆�궓�떎.
		session.setAttribute("foodList",foodList);  
		session.setAttribute("countryList",countryList); 
		session.setAttribute("timeList",timeList); 
		session.setAttribute("SearchType",SearchType); 
		session.setAttribute("SearchWord",SearchWord); 
		
		

		bs.setFoodList(foodList);
		bs.setCountryList(countryList);
		bs.setTimeList(timeList);
		bs.setSearchType(SearchType);
		bs.setSearchWord(SearchWord);

		

		List<RBOARDDTO> searchList = dao.listSearch(bs);
		model.addAttribute("searchList", searchList);  //�떎�쓬酉곗뿉 dto瑜� 肉뚮┝.
		

		//�럹�씠吏�
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(bs);
		pageMaker.setTotalCount(dao.countSearch(bs));
		
		System.out.println(dao.countSearch(bs));  //媛��닔 �뀍
		model.addAttribute("pageMaker", pageMaker);
		
		//�럹�씠吏뺤쑀吏�
		model.addAttribute("scri", bs); 

		
		return "/listSearchsendmail2";
	}
	
	
	

	
	// rboard �뱾�뼱媛붿쓣�븣
	@RequestMapping(value = "/listSearchsendmail2", method = RequestMethod.GET)
	public String listSearchsendmail2(@ModelAttribute("scri") SearchCriteria bs, HttpSession session, HttpServletRequest request, HttpServletResponse response, Model model)
			throws Exception {
		logger.info("rboard");
		RBOARDDAO dao = sqlSession.getMapper(RBOARDDAO.class);

		
		String[] foodList;
		String[] countryList;
		String[] timeList;
		String SearchType;
		String SearchWord;
//		
//	
			foodList =(String[]) session.getAttribute("foodList");
	
			countryList =(String[]) session.getAttribute("countryList");
		
			timeList =(String[]) session.getAttribute("timeList");
		
			SearchType = (String) session.getAttribute("SearchType");
			
			SearchWord = (String) session.getAttribute("SearchWord");
//
//		

//
//		String[] foodList = request.getParameterValues("foodkind");
//		String[] countryList = request.getParameterValues("countrykind");
//		String[] timeList = request.getParameterValues("timekind");
//		String SearchType = request.getParameter("SearchType");
//		String SearchWord = request.getParameter("SearchWord");

		bs.setFoodList(foodList);
		bs.setCountryList(countryList);
		bs.setTimeList(timeList);
		bs.setSearchType(SearchType);
		bs.setSearchWord(SearchWord);
		
		System.out.println(foodList); //二쇱냼媛믪쑝濡� �쑙
		
	
		
		//寃��깋�븳 寃곌낵瑜� �럹�씠吏뺥븳�떎.

		List<RBOARDDTO> searchList = dao.listSearch(bs);
		model.addAttribute("searchList", searchList);  //�떎�쓬酉곗뿉 dto瑜� 肉뚮┝.
		

		//�럹�씠吏�
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(bs);
		pageMaker.setTotalCount(dao.countSearch(bs));
		
		System.out.println(dao.countSearch(bs));   //媛��닔異쒕젰
		model.addAttribute("pageMaker", pageMaker);
		
		//�럹�씠吏뺤쑀吏�
		model.addAttribute("scri", bs); 
		

		return "/listSearchsendmail2";
	}

	
	
	
	
	
	
	
	
	//寃��깋�떆  議고쉶�닔�넂���닚�꽌 �젙�젹 而⑦듃濡ㅻ윭 留뚮벉
	@ResponseBody
	@RequestMapping(value = "/listSearchreadcount123", method = RequestMethod.GET)
	public String searchorderbyreadcount(@ModelAttribute("scri") SearchCriteria cri, HttpSession session, HttpServletRequest request, HttpServletResponse response, Model model)
			throws Exception {
		logger.info("寃��깋議곌굔�뿉 ���븯�뿬 議고쉶�닔 �젙�젹");
		
		
		RBOARDDAO dao = sqlSession.getMapper(RBOARDDAO.class);
		
		
		//ajax濡� 媛믩컺�쑝硫� Object濡� 諛쏆븘���졇�꽌, null�씤吏� �벑�벑 �솗�씤�븯湲곌� 遺덈━�븯�떎.
		//�뵲�씪�꽌 寃��깋�떆 �꽭�뀡�뿉 ���옣�븳 媛믪쓣 �궗�슜�븳�떎.
		
		String[] foodList1= (String[]) session.getAttribute("foodList");
		String[] countryList1 = (String[]) session.getAttribute("countryList");
		String[] timeList1 = (String[]) session.getAttribute("timeList");
		String SearchType1 = (String) session.getAttribute("SearchType");
		String SearchWord1 = (String) session.getAttribute("SearchWord");
		
		
		System.out.println(foodList1); //二쇱냼媛믪쑝濡� �쑙.

				
				
				  // 寃��깋 �꽑�깮媛믪쓣 bs (dto)�뿉 �꽔�쓬
				SearchCriteria bs = new SearchCriteria();
				
				bs.setFoodList(foodList1);
				bs.setCountryList(countryList1);
				bs.setTimeList(timeList1);
				bs.setSearchType(SearchType1);
				bs.setSearchWord(SearchWord1);

				
				
				//諛쏆븘���꽌 ���옣�븳 bs媛믪쑝濡� 荑쇰━臾몃룎由�.
				List<RBOARDDTO> searchList = dao.searchorderbyreadcount(bs);
				model.addAttribute("searchList", searchList);
			

			
				PageMaker pageMaker = new PageMaker();
				pageMaker.setCri(bs);
				pageMaker.setTotalCount(dao.countSearch(bs));
				model.addAttribute("pageMaker", pageMaker);
				
				
				//�럹�씠吏� �쑀吏�
				model.addAttribute("scri", cri);
				
				
				//forward�떆�궓�떎.
				session.setAttribute("foodList2",foodList1);  
				session.setAttribute("countryList2",countryList1); 
				session.setAttribute("timeList2",timeList1); 
				session.setAttribute("SearchType2",SearchType1); 
				session.setAttribute("SearchWord2",SearchWord1); 
				
				
				

		return  "forward:listSearchsendmail3";
	}
	
	@RequestMapping(value = "/listSearchsendmail3", method = RequestMethod.GET)
	public String listSearchsendmail3(@ModelAttribute("scri") SearchCriteria cri, HttpSession session, HttpServletRequest request, HttpServletResponse response, Model model)
			throws Exception {
		logger.info("�젙�젹 寃곌낵");

	
		
		// 二쇱냼李쎌뿉 �쑍 寃��깋 �꽑�깮媛믪쓣 bs (dto)�뿉 �꽔�쓬
		SearchCriteria bs = new SearchCriteria();

		
	
		String[] foodList = (String[]) session.getAttribute("foodList2");
		String[] countryList = (String[]) session.getAttribute("countryList2");
		String[] timeList = (String[]) session.getAttribute("timeList2");
		String SearchType = (String) session.getAttribute("SearchType2");
		String SearchWord = (String) session.getAttribute("SearchWord2");
		
		
		System.out.println(Arrays.toString(foodList));  //[鍮듬쪟]
		System.out.println(Arrays.toString(countryList));  
		System.out.println(Arrays.toString(timeList));  
		
		
		
		bs.setFoodList(foodList);
		bs.setCountryList(countryList);
		bs.setTimeList(timeList);
		bs.setSearchType(SearchType);
		bs.setSearchWord(SearchWord);
		
		RBOARDDAO dao = sqlSession.getMapper(RBOARDDAO.class);
		
		

		//諛쏆븘���꽌 ���옣�븳 bs媛믪쑝濡� 荑쇰━臾몃룎由�.
		List<RBOARDDTO> searchList = dao.searchorderbyreadcount(bs);
		model.addAttribute("searchList", searchList);
	

	
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(bs);
		pageMaker.setTotalCount(dao.countSearch(bs));
		model.addAttribute("pageMaker", pageMaker);
		
		//�럹�씠吏� �쑀吏�
		model.addAttribute("scri", cri);

		
		return "/listSearchsendmail3";   //�뿬湲곗꽌 議고쉶�닔蹂� �젙�젹 �늻由�. -->ajax濡� �쟾�넚
	}
	

	
	
	
	@ResponseBody
	@RequestMapping(value = "/listSearchpopup123", method = RequestMethod.GET)
	public String listSearchpopup123(@RequestParam(value="chks123[]") List<String> chks, HttpSession session, HttpServletRequest request, HttpServletResponse response, Model model)
			throws Exception {
		logger.info("ajax");
		
		//酉곗뿉�꽌 chks123[]濡� ajax �뜲�씠�꽣 �쟾�넚�븿.
		
		
        //ajax瑜� 諛쏅뒗 而⑦듃濡ㅻ윭
		System.out.println(chks); //[52, 51] 濡� 寃뚯떆湲�踰덊샇 �꽆寃⑤컺�쓬. 
		
		//�뿬湲곗꽌 rboarddto�뿉 ���옣�떆耳쒖빞�븿.
		
		model.addAttribute("chks", chks);

		return "/listSearchpopup";
	}
	
	

	@RequestMapping(value = "/listSearchpopup", method = RequestMethod.GET)
	public String listSearchpopup(HttpSession session, HttpServletRequest request, HttpServletResponse response, Model model)
			throws Exception {
		
		logger.info("listSearchpopup");
		
		//�꽑�깮�븳 chk媛믪씠 二쇱냼李쎌뿉?濡� �뿰寃곕맖.
		//二쇱냼媛믪쑝濡� �꽆寃⑥쭊遺�遺� 諛쏆븘以�.
		String[] array = request.getParameterValues("chk");
		
		List boardnoarray = new ArrayList();

		if( array !=  null){
		     for( int i =0 ; i < array.length ; i ++){
		       System.out.println( array[i]  ); // 52   51 �씠�젃寃� �쑙.
		       //out.println("<br>=>"+ arrayStr[i]  );
		       
		       boardnoarray.add(array[i]);

		     }
		     
		     System.out.println(boardnoarray);  //[52,51] ���옣�맖
		     
		     model.addAttribute("boardnoarray", boardnoarray);
		     
		     PrintWriter out = response.getWriter();
		       
		       out.println( "<p>" + array[0] +"<p>");
		       
		     

		}   //52, 51 �씠�젃寃� �쑙.

		//�뙘�뾽李� �쓣��.

		return "/listSearchpopup";
	}
	


	@RequestMapping(value = "/finalsendemail")
	public String finalsendemail( 
			
	   //硫붿씪蹂대궡湲�
			@RequestParam("sendemail") String sendemail,
			@RequestParam("sendtitle") String sendtitle,
			@RequestParam("sendcontent") String sendcontent,
			@ModelAttribute("scri") SearchCriteria cri, HttpSession session, HttpServletRequest request, HttpServletResponse response, Model model)
			throws Exception {
		logger.info("finalsendemail");

	
		
	    String setfrom = "listSearchsendmail@gmail.com";         



	    try {
	      MimeMessage message = mailSender.createMimeMessage();
	      
	      
	      MimeMessageHelper messageHelper 
	                        = new MimeMessageHelper(message, true, "UTF-8");
	 
	      messageHelper.setFrom(setfrom);  // 蹂대궡�뒗�궗�엺 �깮�왂�븯嫄곕굹 �븯硫� �젙�긽�옉�룞�쓣 �븞�븿
	      messageHelper.setTo(sendemail);     // 諛쏅뒗�궗�엺 �씠硫붿씪
	      messageHelper.setSubject(sendtitle); // 硫붿씪�젣紐⑹� �깮�왂�씠 媛��뒫�븯�떎
	      messageHelper.setText(sendcontent);  // 硫붿씪 �궡�슜
	     
	      mailSender.send(message);
	    } catch(Exception e){
	      System.out.println(e);
	    }
	    

	    //硫붿씪�씠 �떎 蹂대궡吏� �썑,  listSearchsendemail�뿉 �엳�뜕 �젙遺��뱾 �떎�떆 �쓣�슦�옄.
		logger.info("get list search");
		RBOARDDAO dao = sqlSession.getMapper(RBOARDDAO.class);

		// 寃��깋
		SearchCriteria bs = new SearchCriteria();

		String[] foodList = request.getParameterValues("foodkind");
		String[] countryList = request.getParameterValues("countrykind");
		String[] timeList = request.getParameterValues("timekind");
		String SearchType = request.getParameter("SearchType");
		String SearchWord = request.getParameter("SearchWord");

		bs.setFoodList(foodList);
		bs.setCountryList(countryList);
		bs.setTimeList(timeList);
		bs.setSearchType(SearchType);
		bs.setSearchWord(SearchWord);

		List<RBOARDDTO> searchList = dao.listSearch(bs);
		model.addAttribute("searchList", searchList);
		

	
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(dao.listCount());
		model.addAttribute("pageMaker", pageMaker);


		return "/listSearchsendmail";
	}

	
	
	@RequestMapping("/muldel")
	public String muldel(HttpServletRequest request, HttpSession session, Model model) {
		String[] seq = request.getParameterValues("chk"); // name�씠 chk�씤 �깭洹몃뒗 value媛믪씠 媛곴컖�쓽 boardno�씠怨�, 諛곗뿴seq�뿉�꽔�쓬

		if (seq == null || seq.length == 0) {
			model.addAttribute("msg", "�븯�굹�씠�긽 �꽑�깮�븯�꽭�슂");
		} else {
			RBOARDDAO dao = sqlSession.getMapper(RBOARDDAO.class);

			int res = dao.multiDelete(seq); // 吏��슦�뒗嫄� �꽦怨듯븯硫� 1�뵫利앷�

			if (res == seq.length) {
				model.addAttribute("msg", "�궘�젣�꽦怨�");
			} else {
				model.addAttribute("msg", "�궘�젣�떎�뙣");
			}
		}

		return "redirect:listSearch";
	}

	
	
	//�꽭遺��궡�슜
	@RequestMapping("/rboard_detail")
	public String rboard_detail(@ModelAttribute("scri") SearchCriteria cri, @RequestParam("boardno") int boardno, HttpSession session, HttpServletRequest request,
			Model model) {

		RBOARDDAO dao = sqlSession.getMapper(RBOARDDAO.class); // xml�뿉�꽌 selectOne荑쇰━媛��졇�� �떎�뻾�븯湲� �쐞�븿

		model.addAttribute("dto", dao.selectOne(boardno)); // 寃뚯떆�뙋 �븯�굹 媛��졇�삩 寃곌낵瑜� 紐⑤뜽�뿉 �룷�븿�떆
		model.addAttribute("commentlist", dao.AllList(boardno)); // �뙎湲�紐⑸줉 遺덈윭�삤�뒗嫄� rboard_detail�뿉�꽌 �빐遊�.
		
		
		MEMBERDTO dto2 = (MEMBERDTO) session.getAttribute("login"); // �꽭�뀡�뿉 �떞�� 濡쒓렇�씤�젙蹂� 媛��졇�샂
		model.addAttribute("dto2", dto2);

		// 泥⑤��맂 �궗吏� 異쒕젰
		List<uploadFileDTO> uploadFileList = dao.getFileList(boardno);
		model.addAttribute("uploadFileList", uploadFileList);
		
		
		//議고쉶�닔
		model.addAttribute("readcount",dao.boardHit(boardno));
		
		//�럹�씠吏� �쑀吏�		
		model.addAttribute("scri", cri); 

		return "/rboard_detail";

	}
	
	
	
    //湲��벐�뒗 �뤌
	@RequestMapping("/rboard_writeform")
	public String rboard_writeform(HttpSession session, Model model) {

		MEMBERDTO dto2 = (MEMBERDTO) session.getAttribute("login"); // �꽭�뀡�뿉 �떞�� 濡쒓렇�씤�젙蹂� 媛��졇�샂
		model.addAttribute("dto2", dto2);

		return "/rboard_writeform";
	}
	
    //湲��벐湲곕쾭�듉 �늻由�
	@RequestMapping("/rboard_write")
	public String write(HttpServletRequest request, Model model, MultipartFile file, HttpSession session,
			MultipartHttpServletRequest mhsq) throws IOException, Exception {
		RBOARDDAO dao = sqlSession.getMapper(RBOARDDAO.class);

		// �뤌�깭洹멸컪�뱾 �쟾�떖
		String title = request.getParameter("title");
		String memberid = request.getParameter("memberid");
		String memberImg = request.getParameter("memberImg");
		String content = request.getParameter("contenta");

		String foodkind = request.getParameter("foodkind");
		String countrykind = request.getParameter("countrykind");
		String timekind = request.getParameter("timekind");

		String majormat = request.getParameter("majormat");
		String minormat = request.getParameter("minormat");

		
		// 濡쒓렇�씤而⑦듃濡ㅻ윭�뿉�꽌 setAttribute濡� �꽭�뀡�뿉 ���옣�븳 login媛앹껜瑜� dto濡� 遺덈윭�� �솕硫댁뿉 肉뚮━�옄.
		MEMBERDTO memberdto = (MEMBERDTO) session.getAttribute("login");
	
		
		RBOARDDTO dto = new RBOARDDTO();

		dto.setTitle(title);
		dto.setMemberid(memberid);
		dto.setMemberImg(memberdto.getMemberImg());
		dto.setContent(content);

		dto.setFoodkind(foodkind);
		dto.setCountrykind(countrykind);
		dto.setTimekind(timekind);

		dto.setMajormat(majormat);
		dto.setMinormat(minormat);

		// kuzuro �뜽�꽕�씪泥⑤�

		String imgUploadPath = uploadPath + File.separator + "imgUpload";
		String ymdPath = UploadFileUtils.calcPath(imgUploadPath);
		String fileName = null;

		if (file.getOriginalFilename() != null && file.getOriginalFilename() != "") {
			fileName = UploadFileUtils.fileUpload(imgUploadPath, file.getOriginalFilename(), file.getBytes(), ymdPath);
			
			dto.setGdsImg(File.separator + "imgUpload" + ymdPath + File.separator + fileName);
			dto.setGdsThumbImg(
					File.separator + "imgUpload" + ymdPath + File.separator + "s" + File.separator + "s_" + fileName);

			
			
		} else {
			fileName =  File.separator + "images" + File.separator + "none.png";
		
		    dto.setGdsImg(fileName);
		    dto.setGdsThumbImg(fileName);
		
		}
		// �뜽�꽕�씪源뚯� 媛숈씠 �옉�꽦
		dao.insert(dto); // �썝�옒�뾾�뿀�쓬

		
		
		// �뙆�씪�벑濡� 2踰덉㎏諛⑸쾿. (硫��떚) 異쒖쿂: https://devofhwb.tistory.com/17 [�씠�뱺�쓽 �깮�솢肄붾뵫]

		// ���옣寃쎈줈 �깮�꽦, �뙆�씪 �뿬湲곗뿉 ���옣�릺�뒗寃껉퉴吏� �솗�씤.
		String realFolder = "/var/lib/tomcat8/webapps/resources/imgUpload";

		File dir = new File(realFolder);
		if (!dir.isDirectory()) {
			dir.mkdirs();
		}

		// �꽆�뼱�삩 �뙆�씪�쓣 由ъ뒪�듃濡� ���옣
		List<MultipartFile> mf = mhsq.getFiles("uploadFile"); // type="file" �쓽 �뙆�씪誘명꽣紐낆쑝濡� �뙆�씪�쓣 媛��졇�삩�떎.
		// MultipartServletRequest mhsq

		if (mf.size() == 1 && mf.get(0).getOriginalFilename().equals("")) {

		} else {
			for (int i = 0; i < mf.size(); i++) {
				// �뙆�씪 以묐났紐� 泥섎━
				String genId = UUID.randomUUID().toString();
				// 蹂몃옒 �뙆�씪紐�
				String originalfileName = mf.get(i).getOriginalFilename();

				String saveFileName = genId + "." + FilenameUtils.getExtension(originalfileName);
				// ���옣�릺�뒗 �뙆�씪 �씠由�

				String savePath = realFolder + saveFileName; // ���옣 �맆 �뙆�씪 寃쎈줈

				long fileSize = mf.get(i).getSize(); // �뙆�씪 �궗�씠利�

				mf.get(i).transferTo(new File(savePath)); // �뙆�씪 ���옣�븯怨� DB�뿉 �벑濡앷퉴吏� �솗�씤�맖.

				// int boardno = Integer.parseInt(request.getParameter("boardno"));
				// System.out.println(boardno);

				HashMap<String, Object> hm = new HashMap<String, Object>();
				hm.put("originalfileName", originalfileName);
				hm.put("saveFileName", saveFileName);
				hm.put("fileSize", fileSize);
				// hm.put("boardno", boardno);

				dao.uploadFile(hm);

			}
		}

		// 濡쒓렇�씤�꽭�뀡媛��졇�삤湲�(�쐞濡� �삷源�)
		//酉곗뿉 濡쒓렇�씤�꽭�뀡 肉뚮┝
		model.addAttribute("memberdto", memberdto);
		
		
		String id = memberdto.getId(); // 濡쒓렇�씤�맂�븘�씠�뵒
		System.out.println(id);

		MYPAGEDAO mypagedao = sqlSession.getMapper(MYPAGEDAO.class);
		// 湲��옉�꽦�떆 �룷�씤�듃 +10
		mypagedao.PlusPoint1(id);

		return "redirect:listSearchsendmail";
	}
	
	
    //�닔�젙�뼇�떇
	@RequestMapping("/updateform")
	public String updateform(@ModelAttribute("scri") SearchCriteria cri,HttpServletRequest request, Model model) {
		RBOARDDAO dao = sqlSession.getMapper(RBOARDDAO.class); // xml�뿉�꽌 selectOne荑쇰━媛��졇�� �떎�뻾�븯湲� �쐞�븿

		int boardno = Integer.parseInt(request.getParameter("boardno"));
		System.out.println(boardno); // 媛��졇��吏�.
		model.addAttribute("dto", dao.selectOne(boardno)); // 媛��졇�삩 寃곌낵瑜� 紐⑤뜽�뿉 �룷�븿�떆
		
		//�썝�옒 �옉�꽦�맂 湲��쓽 �젙蹂대�� updateform�럹�씠吏��뿉 �쓣�슫�떎.
		
		//�럹�씠吏� �쑀吏�
        model.addAttribute("scri", cri); 
		

		return "rboard_updateform";
	}
	
    //�닔�젙�셿猷�
	@RequestMapping("/rboard_update")
	public String rboardupdate(@ModelAttribute("scri") SearchCriteria scri, @RequestParam("boardno") int boardno, HttpServletRequest request, Model model, MultipartFile file, HttpSession session,
			MultipartHttpServletRequest mhsq, RedirectAttributes rttr) throws IOException, Exception {
		RBOARDDAO dao = sqlSession.getMapper(RBOARDDAO.class);

		// �뤌�깭洹멸컪�뱾 �쟾�떖
		String title = request.getParameter("title");
		String memberid = request.getParameter("memberid");
		String memberImg = request.getParameter("memberImg");
		String content = request.getParameter("contenta");

		String foodkind = request.getParameter("foodkind");
		String countrykind = request.getParameter("countrykind");
		String timekind = request.getParameter("timekind");

		String majormat = request.getParameter("majormat");
		String minormat = request.getParameter("minormat");

		System.out.println(foodkind);
		System.out.println(countrykind);
		System.out.println(timekind);
		
		// 濡쒓렇�씤而⑦듃濡ㅻ윭�뿉�꽌 setAttribute濡� �꽭�뀡�뿉 ���옣�븳 login媛앹껜瑜� dto濡� 遺덈윭�� �솕硫댁뿉 肉뚮━�옄.
		MEMBERDTO memberdto = (MEMBERDTO) session.getAttribute("login");
		
		System.out.println(title); //諛붾�먯젣紐�
	
		
		RBOARDDTO dto = new RBOARDDTO();
		
		dto.setBoardno(boardno);

		dto.setTitle(title);
		dto.setMemberid(memberdto.getId());
		dto.setMemberImg(memberdto.getMemberImg());
		dto.setContent(content);

		dto.setFoodkind(foodkind);
		dto.setCountrykind(countrykind);
		dto.setTimekind(timekind);

		dto.setMajormat(majormat);
		dto.setMinormat(minormat);

		// kuzuro �뜽�꽕�씪泥⑤�

		 // �깉濡쒖슫 �뙆�씪�씠 �벑濡앸릺�뿀�뒗吏� �솗�씤
		 if(file.getOriginalFilename() != null && file.getOriginalFilename() != "") {
		  // 湲곗〈 �뙆�씪�쓣 �궘�젣
		  new File(uploadPath + request.getParameter("gdsImg")).delete();
		  new File(uploadPath + request.getParameter("gdsThumbImg")).delete();
		  
		  // �깉濡� 泥⑤��븳 �뙆�씪�쓣 �벑濡�
		  String imgUploadPath = uploadPath + File.separator + "imgUpload";
		  String ymdPath = UploadFileUtils.calcPath(imgUploadPath);
		  String fileName = UploadFileUtils.fileUpload(imgUploadPath, file.getOriginalFilename(), file.getBytes(), ymdPath);
		  
		  dto.setGdsImg(File.separator + "imgUpload" + ymdPath + File.separator + fileName);
		  dto.setGdsThumbImg(File.separator + "imgUpload" + ymdPath + File.separator + "s" + File.separator + "s_" + fileName);
		  
		 } else {  // �깉濡쒖슫 �뙆�씪�씠 �벑濡앸릺吏� �븡�븯�떎硫�
		  // 湲곗〈 �씠誘몄�瑜� 洹몃�濡� �궗�슜
		  dto.setGdsImg(request.getParameter("gdsImg"));
		  dto.setGdsThumbImg(request.getParameter("gdsThumbImg"));
		  
		 }
		
		
		//�닔�젙
		dao.rboard_update(dto);

		
		
		// �뙆�씪�벑濡� 2踰덉㎏諛⑸쾿. (硫��떚) 異쒖쿂: https://devofhwb.tistory.com/17 [�씠�뱺�쓽 �깮�솢肄붾뵫]

		// ���옣寃쎈줈 �깮�꽦, �뙆�씪 �뿬湲곗뿉 ���옣�릺�뒗寃껉퉴吏� �솗�씤.
		String realFolder = "/var/lib/tomcat8/webapps/resources/imgUpload";

		File dir = new File(realFolder);
		if (!dir.isDirectory()) {
			dir.mkdirs();
		}

		// �꽆�뼱�삩 �뙆�씪�쓣 由ъ뒪�듃濡� ���옣
		List<MultipartFile> mf = mhsq.getFiles("uploadFile"); // type="file" �쓽 �뙆�씪誘명꽣紐낆쑝濡� �뙆�씪�쓣 媛��졇�삩�떎.
		// MultipartServletRequest mhsq

		if (mf.size() == 1 && mf.get(0).getOriginalFilename().equals("")) {

		} else {
			for (int i = 0; i < mf.size(); i++) {
				// �뙆�씪 以묐났紐� 泥섎━
				String genId = UUID.randomUUID().toString();
				// 蹂몃옒 �뙆�씪紐�
				String originalfileName = mf.get(i).getOriginalFilename();

				String saveFileName = genId + "." + FilenameUtils.getExtension(originalfileName);
				// ���옣�릺�뒗 �뙆�씪 �씠由�

				String savePath = realFolder + saveFileName; // ���옣 �맆 �뙆�씪 寃쎈줈

				long fileSize = mf.get(i).getSize(); // �뙆�씪 �궗�씠利�

				mf.get(i).transferTo(new File(savePath)); // �뙆�씪 ���옣�븯怨� DB�뿉 �벑濡앷퉴吏� �솗�씤�맖.

				// int boardno = Integer.parseInt(request.getParameter("boardno"));
				// System.out.println(boardno);

				HashMap<String, Object> hm = new HashMap<String, Object>();
				hm.put("originalfileName", originalfileName);
				hm.put("saveFileName", saveFileName);
				hm.put("fileSize", fileSize);
				// hm.put("boardno", boardno);

				dao.uploadFile(hm);

			}
		}

		// 濡쒓렇�씤�꽭�뀡媛��졇�삤湲�(�쐞濡� �삷源�)
		//酉곗뿉 濡쒓렇�씤�꽭�뀡 肉뚮┝
		model.addAttribute("memberdto", memberdto);
		
		model.addAttribute("scri", scri);
		
		
		//�럹�씠吏� �쑀吏�
		rttr.addAttribute("page", scri.getPage());
		rttr.addAttribute("perPageNum", scri.getPerPageNum());
		
		rttr.addAttribute("foodList", scri.getFoodList());
		rttr.addAttribute("countryList", scri.getCountryList());
		rttr.addAttribute("timeList", scri.getTimeList());
		
		rttr.addAttribute("searchType", scri.getSearchType());
		rttr.addAttribute("searchWord", scri.getSearchWord());
		
		return "redirect:listSearchsendmail"; // redirect�뒗 �젙蹂댄룷�븿�빐�꽌 蹂대깂.
	}

	
	//�궘�젣�븯湲�
	@RequestMapping("/rboarddelete")
	public String delete(RedirectAttributes rttr, @ModelAttribute("scri") SearchCriteria scri,  @RequestParam("boardno") int boardno, HttpServletRequest request, Model model) {

		RBOARDDAO dao = sqlSession.getMapper(RBOARDDAO.class);

		model.addAttribute("dto", dao.selectOne(boardno));
		dao.delete(boardno);
		
		
		//�럹�씠吏� �쑀吏�
		rttr.addAttribute("page", scri.getPage());
		rttr.addAttribute("perPageNum", scri.getPerPageNum());
		

		rttr.addAttribute("foodList", scri.getFoodList());
		rttr.addAttribute("countryList", scri.getCountryList());
		rttr.addAttribute("timeList", scri.getTimeList());

		rttr.addAttribute("searchType", scri.getSearchType());
		rttr.addAttribute("searchWord", scri.getSearchWord());
		
		
		return "redirect:listSearchsendmail";
	}

	// 湲고� �럹�씠吏� �씠�룞
	@RequestMapping("/loginform")
	public String login() {

		return "/loginform";
	}

	@RequestMapping("/registform")
	public String regist_form() {

		return "/registform";
	}

	
	@RequestMapping("/BoardLike")
	@ResponseBody
	public String BoardLike(@RequestParam("boardno") int boardno, HttpServletRequest request,HttpServletResponse response, HttpSession session) throws IOException {
		
		System.out.println("醫뗭븘�슂");
		
		MEMBERDTO dto = (MEMBERDTO) session.getAttribute("login");
		String id = dto.getId(); // 濡쒓렇�씤�맂�븘�씠�뵒�씠�떎.
		
		System.out.println(id);
		
		
		//留듭뿉 ajax�뿉�꽌 諛쏆븘�삩 寃뚯떆湲�踰덊샇�� �븘�씠�뵒瑜� �꽔�뼱以�.
		Map<String, Object> m = new HashMap<String, Object>();
		m.put("boardno", request.getParameter("boardno"));
		m.put("id", request.getParameter("id"));
		
		RBOARDDAO dao = sqlSession.getMapper(RBOARDDAO.class);
		
		//�룞�씪 寃뚯떆湲�, �븘�씠�뵒濡� 醫뗭븘�슂�븳寃� �엳�뒗吏� �솗�씤�븳�떎.
		int result =dao.likeCheck(m);
		
		
		RBOARDLIKEDTO dto1= new RBOARDLIKEDTO();
		dto1.setBoardno(boardno);
		dto1.setLikememberid(id);
		
		if(result>0) {
			dao.deleteBoardLike(dto1);
		}else {
			dao.insertBoardLike(dto1);
		}
		
		
		//醫뗭븘�슂 媛쒖닔 �꽭湲�
		//�봽由고듃�씪�씠�꽣濡� 寃뚯떆湲�蹂� 醫뗭븘�슂�닔瑜� count濡� 酉곕줈 蹂대깂.
		PrintWriter out = response.getWriter();
			
				int count = dao.likeCount(boardno);

				out.println(count);
				out.close();
		
		
		return "/listSearch";
	}
	
	
	@RequestMapping("/likeCount")
	public String likeCount(HttpServletRequest request, HttpServletResponse response) throws IOException {

		int boardno = Integer.parseInt(request.getParameter("boardno"));
		RBOARDDAO dao = sqlSession.getMapper(RBOARDDAO.class);
		
		
		//醫뗭븘�슂 媛쒖닔 �꽭湲�
		//�봽由고듃�씪�씠�꽣濡� 寃뚯떆湲�蹂� 醫뗭븘�슂�닔瑜� count濡� 酉곕줈 蹂대깂.
		PrintWriter out = response.getWriter();
			
				int count = dao.likeCount(boardno);

				out.println(count);
				out.close();
		
		return "/listSearch";
	}
	
	
	@RequestMapping("/popup")
	public String popup(@RequestParam("madebyid") String madebyid, HttpServletRequest request, HttpSession session, Model model) {

		//酉곗뿉�꽌 �꽆湲� �븘�씠�뵒瑜� 諛쏆븘�샂.
		System.out.println(madebyid);

		RBOARDDTO dto = new RBOARDDTO();
		
		//�듅�젙 �븘�씠�뵒濡� �옉�꽦�맂 湲��쓣 �솕硫댁뿉 肉뚮젮以�.
		RBOARDDAO dao = sqlSession.getMapper(RBOARDDAO.class);
		
		model.addAttribute("madeby", dao.madeby(madebyid));
		
	
		
		/*�쁽�옱 濡쒓렇�씤 �꽭�뀡
		// 濡쒓렇�씤而⑦듃濡ㅻ윭�뿉�꽌 setAttribute濡� �꽭�뀡�뿉 ���옣�븳 login媛앹껜瑜� dto濡� 遺덈윭�� �솕硫댁뿉 肉뚮━�옄.
		MEMBERDTO dto1 = (MEMBERDTO) session.getAttribute("login");
		model.addAttribute("dto1", dto1);

		String id = dto1.getId(); // 濡쒓렇�씤�맂�븘�씠�뵒�씠�떎.
		System.out.println(id);*/
	

		return "/popup";
	}
	
	
	//후기 게시판
	
	
	// rboard �뱾�뼱媛붿쓣�븣
	@RequestMapping(value = "/reviewboard_a", method = RequestMethod.GET)
	public String listSearchsendmailreview(@ModelAttribute("scri") SearchCriteria bs, HttpSession session, HttpServletRequest request, HttpServletResponse response, Model model)
			throws Exception {
		logger.info("rboardreview");
		REVIEWBOARDDAO dao = sqlSession.getMapper(REVIEWBOARDDAO.class);


		//寃��깋�븳 寃곌낵瑜� �럹�씠吏뺥븳�떎.

		List<REVIEWBOARDDTO> searchList = dao.RlistSearch(bs);
		model.addAttribute("searchList", searchList);  //�떎�쓬酉곗뿉 dto瑜� 肉뚮┝.
		

		//�럹�씠吏�
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(bs);
		pageMaker.setTotalCount(dao.RcountSearch(bs));
		
		System.out.println(dao.RcountSearch(bs));   //媛��닔異쒕젰
		model.addAttribute("pageMaker", pageMaker);
		
		//�럹�씠吏뺤쑀吏�
		model.addAttribute("scri", bs); 
		

		return "/reviewboard_a";
	}
	
	
	
	

	//�꽭遺��궡�슜
	@RequestMapping("/reviewboard_detail")
	public String reviewboard_detail(@ModelAttribute("scri") SearchCriteria cri, @RequestParam("reviewboardno") int reviewboardno, HttpSession session, HttpServletRequest request,
			Model model) {

		REVIEWBOARDDAO dao = sqlSession.getMapper(REVIEWBOARDDAO.class); // xml�뿉�꽌 selectOne荑쇰━媛��졇�� �떎�뻾�븯湲� �쐞�븿

		model.addAttribute("dto", dao.RselectOne(reviewboardno)); // 寃뚯떆�뙋 �븯�굹 媛��졇�삩 寃곌낵瑜� 紐⑤뜽�뿉 �룷�븿�떆
		model.addAttribute("commentlist", dao.RAllList(reviewboardno)); // �뙎湲�紐⑸줉 遺덈윭�삤�뒗嫄� rboard_detail�뿉�꽌 �빐遊�.
		
		
		MEMBERDTO dto2 = (MEMBERDTO) session.getAttribute("login"); // �꽭�뀡�뿉 �떞�� 濡쒓렇�씤�젙蹂� 媛��졇�샂
		model.addAttribute("dto2", dto2);

		// 泥⑤��맂 �궗吏� 異쒕젰
		List<uploadFileDTO> uploadFileList = dao.RgetFileList(reviewboardno);
		model.addAttribute("uploadFileList", uploadFileList);
		
		
		//議고쉶�닔
		model.addAttribute("readcount",dao.RboardHit(reviewboardno));
		
		//�럹�씠吏� �쑀吏�		
		model.addAttribute("scri", cri); 

		return "/reviewboard_detail";

	}
	
	
	
    //湲��벐�뒗 �뤌
	@RequestMapping("/reviewboard_writeform")
	public String reviewboard_writeform(@RequestParam("boardno") int boardno, HttpSession session, Model model) {

		MEMBERDTO dto2 = (MEMBERDTO) session.getAttribute("login"); // �꽭�뀡�뿉 �떞�� 濡쒓렇�씤�젙蹂� 媛��졇�샂
		model.addAttribute("dto2", dto2);
		
		System.out.println(boardno);
		model.addAttribute("boardno", boardno);

		return "/reviewboard_writeform";
	}
	
    //湲��벐湲곕쾭�듉 �늻由�
	@RequestMapping("/reviewboard_write")
	public String reviewboard_write(@RequestParam("boardno") int boardno, HttpServletRequest request, Model model, MultipartFile file, HttpSession session,
			MultipartHttpServletRequest mhsq) throws IOException, Exception {
		REVIEWBOARDDAO dao = sqlSession.getMapper(REVIEWBOARDDAO.class);


		
		// �뤌�깭洹멸컪�뱾 �쟾�떖
		String title = request.getParameter("title");
		String memberid = request.getParameter("memberid");
		String memberImg = request.getParameter("memberImg");
		String content = request.getParameter("contenta");

		String foodkind = request.getParameter("foodkind");
		String countrykind = request.getParameter("countrykind");
		String timekind = request.getParameter("timekind");

		String majormat = request.getParameter("majormat");
		String minormat = request.getParameter("minormat");

		
		// 濡쒓렇�씤而⑦듃濡ㅻ윭�뿉�꽌 setAttribute濡� �꽭�뀡�뿉 ���옣�븳 login媛앹껜瑜� dto濡� 遺덈윭�� �솕硫댁뿉 肉뚮━�옄.
		MEMBERDTO memberdto = (MEMBERDTO) session.getAttribute("login");
	
		
		REVIEWBOARDDTO dto = new REVIEWBOARDDTO();
		
		dto.setRboardno(boardno);

		dto.setTitle(title);
		dto.setMemberid(memberid);
		dto.setMemberImg(memberdto.getMemberImg());
		dto.setContent(content);

		dto.setFoodkind(foodkind);
		dto.setCountrykind(countrykind);
		dto.setTimekind(timekind);

		dto.setMajormat(majormat);
		dto.setMinormat(minormat);

		// kuzuro �뜽�꽕�씪泥⑤�

		String imgUploadPath = uploadPath + File.separator + "imgUpload";
		String ymdPath = UploadFileUtils.calcPath(imgUploadPath);
		String fileName = null;

		if (file.getOriginalFilename() != null && file.getOriginalFilename() != "") {
			fileName = UploadFileUtils.fileUpload(imgUploadPath, file.getOriginalFilename(), file.getBytes(), ymdPath);
			
			dto.setGdsImg(File.separator + "imgUpload" + ymdPath + File.separator + fileName);
			dto.setGdsThumbImg(
					File.separator + "imgUpload" + ymdPath + File.separator + "s" + File.separator + "s_" + fileName);

			
			
		} else {
			fileName =  File.separator + "images" + File.separator + "none.png";
		
		    dto.setGdsImg(fileName);
		    dto.setGdsThumbImg(fileName);
		
		}
		// �뜽�꽕�씪源뚯� 媛숈씠 �옉�꽦
		dao.Rinsert(dto); // �썝�옒�뾾�뿀�쓬

		
		
		// �뙆�씪�벑濡� 2踰덉㎏諛⑸쾿. (硫��떚) 異쒖쿂: https://devofhwb.tistory.com/17 [�씠�뱺�쓽 �깮�솢肄붾뵫]

		// ���옣寃쎈줈 �깮�꽦, �뙆�씪 �뿬湲곗뿉 ���옣�릺�뒗寃껉퉴吏� �솗�씤.
		String realFolder = "/var/lib/tomcat8/webapps/resources/imgUpload";

		File dir = new File(realFolder);
		if (!dir.isDirectory()) {
			dir.mkdirs();
		}

		// �꽆�뼱�삩 �뙆�씪�쓣 由ъ뒪�듃濡� ���옣
		List<MultipartFile> mf = mhsq.getFiles("uploadFile"); // type="file" �쓽 �뙆�씪誘명꽣紐낆쑝濡� �뙆�씪�쓣 媛��졇�삩�떎.
		// MultipartServletRequest mhsq

		if (mf.size() == 1 && mf.get(0).getOriginalFilename().equals("")) {

		} else {
			for (int i = 0; i < mf.size(); i++) {
				// �뙆�씪 以묐났紐� 泥섎━
				String genId = UUID.randomUUID().toString();
				// 蹂몃옒 �뙆�씪紐�
				String originalfileName = mf.get(i).getOriginalFilename();

				String saveFileName = genId + "." + FilenameUtils.getExtension(originalfileName);
				// ���옣�릺�뒗 �뙆�씪 �씠由�

				String savePath = realFolder + saveFileName; // ���옣 �맆 �뙆�씪 寃쎈줈

				long fileSize = mf.get(i).getSize(); // �뙆�씪 �궗�씠利�

				mf.get(i).transferTo(new File(savePath)); // �뙆�씪 ���옣�븯怨� DB�뿉 �벑濡앷퉴吏� �솗�씤�맖.

				// int boardno = Integer.parseInt(request.getParameter("boardno"));
				// System.out.println(boardno);

				HashMap<String, Object> hm = new HashMap<String, Object>();
				hm.put("originalfileName", originalfileName);
				hm.put("saveFileName", saveFileName);
				hm.put("fileSize", fileSize);
				// hm.put("boardno", boardno);

				dao.RuploadFile(hm);

			}
		}

		// 濡쒓렇�씤�꽭�뀡媛��졇�삤湲�(�쐞濡� �삷源�)
		//酉곗뿉 濡쒓렇�씤�꽭�뀡 肉뚮┝
		model.addAttribute("memberdto", memberdto);
		
		
		String id = memberdto.getId(); // 濡쒓렇�씤�맂�븘�씠�뵒
		System.out.println(id);

		MYPAGEDAO mypagedao = sqlSession.getMapper(MYPAGEDAO.class);
		// 湲��옉�꽦�떆 �룷�씤�듃 +10
		mypagedao.PlusPoint1(id);

		return "redirect:reviewboard_a";
	}
	
	
    //�닔�젙�뼇�떇
	@RequestMapping("/reviewboard_updateform")
	public String reviewboard_updateform(@ModelAttribute("scri") SearchCriteria cri,HttpServletRequest request, Model model) {
		REVIEWBOARDDAO dao = sqlSession.getMapper(REVIEWBOARDDAO.class); // xml�뿉�꽌 selectOne荑쇰━媛��졇�� �떎�뻾�븯湲� �쐞�븿

		int REVIEWBOARDNO = Integer.parseInt(request.getParameter("reviewboardno"));
		System.out.println(REVIEWBOARDNO); // 媛��졇��吏�.
		model.addAttribute("dto", dao.RselectOne(REVIEWBOARDNO)); // 媛��졇�삩 寃곌낵瑜� 紐⑤뜽�뿉 �룷�븿�떆
		
		//�썝�옒 �옉�꽦�맂 湲��쓽 �젙蹂대�� updateform�럹�씠吏��뿉 �쓣�슫�떎.
		
		//�럹�씠吏� �쑀吏�
        model.addAttribute("scri", cri); 
		

		return "reviewboard_updateform";
	}
	
    //�닔�젙�셿猷�
	@RequestMapping("/reviewboard_update")
	public String reviewboard_update(@ModelAttribute("scri") SearchCriteria scri, @RequestParam("reviewboardno") int REVIEWBOARDNO, HttpServletRequest request, Model model, MultipartFile file, HttpSession session,
			MultipartHttpServletRequest mhsq, RedirectAttributes rttr) throws IOException, Exception {
		REVIEWBOARDDAO dao = sqlSession.getMapper(REVIEWBOARDDAO.class);

		// �뤌�깭洹멸컪�뱾 �쟾�떖
		String title = request.getParameter("title");
		String memberid = request.getParameter("memberid");
		String memberImg = request.getParameter("memberImg");
		String content = request.getParameter("contenta");

		String foodkind = request.getParameter("foodkind");
		String countrykind = request.getParameter("countrykind");
		String timekind = request.getParameter("timekind");

		String majormat = request.getParameter("majormat");
		String minormat = request.getParameter("minormat");

		
		// 濡쒓렇�씤而⑦듃濡ㅻ윭�뿉�꽌 setAttribute濡� �꽭�뀡�뿉 ���옣�븳 login媛앹껜瑜� dto濡� 遺덈윭�� �솕硫댁뿉 肉뚮━�옄.
		MEMBERDTO memberdto = (MEMBERDTO) session.getAttribute("login");
		
		System.out.println(title); //諛붾�먯젣紐�
	
		
		REVIEWBOARDDTO dto = new REVIEWBOARDDTO();
		
		dto.setReviewboardno(REVIEWBOARDNO);

		dto.setTitle(title);
		dto.setMemberid(memberdto.getId());
		dto.setMemberImg(memberdto.getMemberImg());
		dto.setContent(content);

		dto.setFoodkind(foodkind);
		dto.setCountrykind(countrykind);
		dto.setTimekind(timekind);

		dto.setMajormat(majormat);
		dto.setMinormat(minormat);

		// kuzuro �뜽�꽕�씪泥⑤�

		 // �깉濡쒖슫 �뙆�씪�씠 �벑濡앸릺�뿀�뒗吏� �솗�씤
		 if(file.getOriginalFilename() != null && file.getOriginalFilename() != "") {
		  // 湲곗〈 �뙆�씪�쓣 �궘�젣
		  new File(uploadPath + request.getParameter("gdsImg")).delete();
		  new File(uploadPath + request.getParameter("gdsThumbImg")).delete();
		  
		  // �깉濡� 泥⑤��븳 �뙆�씪�쓣 �벑濡�
		  String imgUploadPath = uploadPath + File.separator + "imgUpload";
		  String ymdPath = UploadFileUtils.calcPath(imgUploadPath);
		  String fileName = UploadFileUtils.fileUpload(imgUploadPath, file.getOriginalFilename(), file.getBytes(), ymdPath);
		  
		  dto.setGdsImg(File.separator + "imgUpload" + ymdPath + File.separator + fileName);
		  dto.setGdsThumbImg(File.separator + "imgUpload" + ymdPath + File.separator + "s" + File.separator + "s_" + fileName);
		  
		 } else {  // �깉濡쒖슫 �뙆�씪�씠 �벑濡앸릺吏� �븡�븯�떎硫�
		  // 湲곗〈 �씠誘몄�瑜� 洹몃�濡� �궗�슜
		  dto.setGdsImg(request.getParameter("gdsImg"));
		  dto.setGdsThumbImg(request.getParameter("gdsThumbImg"));
		  
		 }
		
		
		//�닔�젙
		dao.Rrboard_update(dto);

		
		
		// �뙆�씪�벑濡� 2踰덉㎏諛⑸쾿. (硫��떚) 異쒖쿂: https://devofhwb.tistory.com/17 [�씠�뱺�쓽 �깮�솢肄붾뵫]

		// ���옣寃쎈줈 �깮�꽦, �뙆�씪 �뿬湲곗뿉 ���옣�릺�뒗寃껉퉴吏� �솗�씤.
		String realFolder = "/var/lib/tomcat8/webapps/resources/imgUpload";

		File dir = new File(realFolder);
		if (!dir.isDirectory()) {
			dir.mkdirs();
		}

		// �꽆�뼱�삩 �뙆�씪�쓣 由ъ뒪�듃濡� ���옣
		List<MultipartFile> mf = mhsq.getFiles("uploadFile"); // type="file" �쓽 �뙆�씪誘명꽣紐낆쑝濡� �뙆�씪�쓣 媛��졇�삩�떎.
		// MultipartServletRequest mhsq

		if (mf.size() == 1 && mf.get(0).getOriginalFilename().equals("")) {

		} else {
			for (int i = 0; i < mf.size(); i++) {
				// �뙆�씪 以묐났紐� 泥섎━
				String genId = UUID.randomUUID().toString();
				// 蹂몃옒 �뙆�씪紐�
				String originalfileName = mf.get(i).getOriginalFilename();

				String saveFileName = genId + "." + FilenameUtils.getExtension(originalfileName);
				// ���옣�릺�뒗 �뙆�씪 �씠由�

				String savePath = realFolder + saveFileName; // ���옣 �맆 �뙆�씪 寃쎈줈

				long fileSize = mf.get(i).getSize(); // �뙆�씪 �궗�씠利�

				mf.get(i).transferTo(new File(savePath)); // �뙆�씪 ���옣�븯怨� DB�뿉 �벑濡앷퉴吏� �솗�씤�맖.

				// int boardno = Integer.parseInt(request.getParameter("boardno"));
				// System.out.println(boardno);

				HashMap<String, Object> hm = new HashMap<String, Object>();
				hm.put("originalfileName", originalfileName);
				hm.put("saveFileName", saveFileName);
				hm.put("fileSize", fileSize);
				// hm.put("boardno", boardno);

				dao.RuploadFile(hm);

			}
		}

		// 濡쒓렇�씤�꽭�뀡媛��졇�삤湲�(�쐞濡� �삷源�)
		//酉곗뿉 濡쒓렇�씤�꽭�뀡 肉뚮┝
		model.addAttribute("memberdto", memberdto);
		
		model.addAttribute("scri", scri);
		
		
		//�럹�씠吏� �쑀吏�
		rttr.addAttribute("page", scri.getPage());
		rttr.addAttribute("perPageNum", scri.getPerPageNum());
		
		rttr.addAttribute("foodList", scri.getFoodList());
		rttr.addAttribute("countryList", scri.getCountryList());
		rttr.addAttribute("timeList", scri.getTimeList());
		
		rttr.addAttribute("searchType", scri.getSearchType());
		rttr.addAttribute("searchWord", scri.getSearchWord());
		
		return "redirect:reviewboard_a"; // redirect�뒗 �젙蹂댄룷�븿�빐�꽌 蹂대깂.
	}

	
	//�궘�젣�븯湲�
	@RequestMapping("/reviewboard_delete")
	public String reviewboard_delete(RedirectAttributes rttr, @ModelAttribute("scri") SearchCriteria scri,  @RequestParam("reviewboardno") int REVIEWBOARDNO, HttpServletRequest request, Model model) {

		REVIEWBOARDDAO dao = sqlSession.getMapper(REVIEWBOARDDAO.class);

		model.addAttribute("dto", dao.RselectOne(REVIEWBOARDNO));
		dao.Rdelete(REVIEWBOARDNO);
		
		
		//�럹�씠吏� �쑀吏�
		rttr.addAttribute("page", scri.getPage());
		rttr.addAttribute("perPageNum", scri.getPerPageNum());
		

		rttr.addAttribute("foodList", scri.getFoodList());
		rttr.addAttribute("countryList", scri.getCountryList());
		rttr.addAttribute("timeList", scri.getTimeList());

		rttr.addAttribute("searchType", scri.getSearchType());
		rttr.addAttribute("searchWord", scri.getSearchWord());
		
		
		return "redirect:reviewboard_a";
	}

	
	
	
	

}
