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


	

	
	  // rboard 들어갔을때
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

		
	      //검색한 결과를 페이징한다.

		List<RBOARDDTO> searchList = dao.listSearch(bs);
		model.addAttribute("searchList", searchList); 
		

		  //페이징
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(bs);
		pageMaker.setTotalCount(dao.countSearch(bs));
		
		System.out.println(dao.countSearch(bs));   //媛��닔異쒕젰
		model.addAttribute("pageMaker", pageMaker);
		
	     //페이징유지
		model.addAttribute("scri", bs); 
		

		return "/listSearchsendmail";
	}
	
	
	   //rboard 진입시 조회수높은순서 정렬 컨트롤러 만듬
	@RequestMapping(value = "/listSearchreadcount", method = RequestMethod.GET)
	public String orderbyreadcount(@ModelAttribute("scri") SearchCriteria cri, HttpSession session, HttpServletRequest request, HttpServletResponse response, Model model)
			throws Exception {
		logger.info("orderbyreadcount");
		RBOARDDAO dao = sqlSession.getMapper(RBOARDDAO.class);

		
	      //조회수높은순 정렬
		List<RBOARDDTO> searchList = dao.orderbyreadcount(cri);
		model.addAttribute("searchList", searchList);

		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(dao.listCount());
		model.addAttribute("pageMaker", pageMaker);
		
	      //페이징 유지
		model.addAttribute("scri", cri);

		return  "/listSearchreadcount";
	}
	
	
	
	
	   // 검색 - 해당조건으로 찾기 눌렀을때

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
		
	
		
		
		System.out.println(foodList); //[빵류]
		System.out.println(countryList);  //[빵류]
		System.out.println(timeList);  //[빵류]
	
		System.out.println(SearchWord);
		System.out.println(SearchType);
		
		
		System.out.println(Arrays.toString(foodList));  //[빵류]
		System.out.println(Arrays.toString(countryList)); //[빵류]
		System.out.println(Arrays.toString(timeList));  //[빵류]
		
	
		
	      //forward시킨다.
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
		model.addAttribute("searchList", searchList); //다음뷰에 dto를 뿌림.
		

	      //페이징
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(bs);
		pageMaker.setTotalCount(dao.countSearch(bs));
		
		System.out.println(dao.countSearch(bs));   //갯수 셈
		model.addAttribute("pageMaker", pageMaker);
		
	      //페이징유지
		model.addAttribute("scri", bs); 

		
		return "/listSearchsendmail2";
	}
	
	
	

	
	   // rboard 들어갔을때
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
		
	
		
	      //검색한 결과를 페이징한다.

		List<RBOARDDTO> searchList = dao.listSearch(bs);
		model.addAttribute("searchList", searchList);  //�떎�쓬酉곗뿉 dto瑜� 肉뚮┝.
		

	      //페이징
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(bs);
		pageMaker.setTotalCount(dao.countSearch(bs));
		
		System.out.println(dao.countSearch(bs));   //媛��닔異쒕젰
		model.addAttribute("pageMaker", pageMaker);
		
	      //페이징유지
		model.addAttribute("scri", bs); 
		

		return "/listSearchsendmail2";
	}

	
	
	
	
	
	
	
	
	   //검색시  조회수높은순서 정렬 컨트롤러 만듬
	@ResponseBody
	@RequestMapping(value = "/listSearchreadcount123", method = RequestMethod.GET)
	public String searchorderbyreadcount(@ModelAttribute("scri") SearchCriteria cri, HttpSession session, HttpServletRequest request, HttpServletResponse response, Model model)
			throws Exception {
		logger.info("寃��깋議곌굔�뿉 ���븯�뿬 議고쉶�닔 �젙�젹");
		
		
		RBOARDDAO dao = sqlSession.getMapper(RBOARDDAO.class);
		
		
		   //ajax로 값받으면 Object로 받아와져서, null인지 등등 확인하기가 불리하다.
		//따라서 검색시 세션에 저장한 값을 사용한다.

		String[] foodList1= (String[]) session.getAttribute("foodList");
		String[] countryList1 = (String[]) session.getAttribute("countryList");
		String[] timeList1 = (String[]) session.getAttribute("timeList");
		String SearchType1 = (String) session.getAttribute("SearchType");
		String SearchWord1 = (String) session.getAttribute("SearchWord");
		
		
		System.out.println(foodList1); //주소값으로 뜸.

				
				
		   // 검색 선택값을 bs (dto)에 넣음
				SearchCriteria bs = new SearchCriteria();
				
				bs.setFoodList(foodList1);
				bs.setCountryList(countryList1);
				bs.setTimeList(timeList1);
				bs.setSearchType(SearchType1);
				bs.setSearchWord(SearchWord1);

				
				
		         //받아와서 저장한 bs값으로 쿼리문돌림.
				List<RBOARDDTO> searchList = dao.searchorderbyreadcount(bs);
				model.addAttribute("searchList", searchList);
			

			
				PageMaker pageMaker = new PageMaker();
				pageMaker.setCri(bs);
				pageMaker.setTotalCount(dao.countSearch(bs));
				model.addAttribute("pageMaker", pageMaker);
				
				
			     //페이징 유지
				model.addAttribute("scri", cri);
				
				
				  //forward시킨다.
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
		logger.info("정렬 결과");

	
		
		   // 주소창에 뜬 검색 선택값을 bs (dto)에 넣음
		SearchCriteria bs = new SearchCriteria();

		
	
		String[] foodList = (String[]) session.getAttribute("foodList2");
		String[] countryList = (String[]) session.getAttribute("countryList2");
		String[] timeList = (String[]) session.getAttribute("timeList2");
		String SearchType = (String) session.getAttribute("SearchType2");
		String SearchWord = (String) session.getAttribute("SearchWord2");
		
		
		System.out.println(Arrays.toString(foodList));  //[빵류]
		System.out.println(Arrays.toString(countryList));  
		System.out.println(Arrays.toString(timeList));  
		
		
		
		bs.setFoodList(foodList);
		bs.setCountryList(countryList);
		bs.setTimeList(timeList);
		bs.setSearchType(SearchType);
		bs.setSearchWord(SearchWord);
		
		RBOARDDAO dao = sqlSession.getMapper(RBOARDDAO.class);
		
		

		 //받아와서 저장한 bs값으로 쿼리문돌림.
		List<RBOARDDTO> searchList = dao.searchorderbyreadcount(bs);
		model.addAttribute("searchList", searchList);
	

	
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(bs);
		pageMaker.setTotalCount(dao.countSearch(bs));
		model.addAttribute("pageMaker", pageMaker);
		
		//페이징 유지
		model.addAttribute("scri", cri);

		
		return "/listSearchsendmail3";   //여기서 조회수별 정렬 누름. -->ajax로 전송

	}
	

	
	
	
	@ResponseBody
	@RequestMapping(value = "/listSearchpopup123", method = RequestMethod.GET)
	public String listSearchpopup123(@RequestParam(value="chks123[]") List<String> chks, HttpSession session, HttpServletRequest request, HttpServletResponse response, Model model)
			throws Exception {
		logger.info("ajax");
		
		  //뷰에서 chks123[]로 ajax 데이터 전송함.
		
		 //ajax를 받는 컨트롤러
		System.out.println(chks);  //[52, 51] 로 게시글번호 넘겨받음. 
		
		  //여기서 rboarddto에 저장시켜야함.
		
		model.addAttribute("chks", chks);

		return "/listSearchpopup";
	}
	
	

	@RequestMapping(value = "/listSearchpopup", method = RequestMethod.GET)
	public String listSearchpopup(HttpSession session, HttpServletRequest request, HttpServletResponse response, Model model)
			throws Exception {
		
		logger.info("listSearchpopup");
		
		  //선택한 chk값이 주소창에?로 연결됨.
	      //주소값으로 넘겨진부분 받아줌.

		String[] array = request.getParameterValues("chk");
		
		List boardnoarray = new ArrayList();

		if( array !=  null){
		     for( int i =0 ; i < array.length ; i ++){
		       System.out.println( array[i]  );  // 52   51 이렇게 뜸.

		       //out.println("<br>=>"+ arrayStr[i]  );
		       
		       boardnoarray.add(array[i]);

		     }
		     
		     System.out.println(boardnoarray);   //[52,51] 저장됨

		     
		     model.addAttribute("boardnoarray", boardnoarray);
		     
		     PrintWriter out = response.getWriter();
		       
		       out.println( "<p>" + array[0] +"<p>");
		       
		     

		}  //52, 51 이렇게 뜸.

		  //팝업창 띄움.

		return "/listSearchpopup";
	}
	


	@RequestMapping(value = "/finalsendemail")
	public String finalsendemail( 
			
			 //메일보내기
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
	 
	      messageHelper.setFrom(setfrom);  // 보내는사람 생략하거나 하면 정상작동을 안함

	      messageHelper.setTo(sendemail);    // 받는사람 이메일

	      messageHelper.setSubject(sendtitle);  // 메일제목은 생략이 가능하다

	      messageHelper.setText(sendcontent);  // 메일 내용
	     
	      mailSender.send(message);
	    } catch(Exception e){
	      System.out.println(e);
	    }
	    

	    //메일이 다 보내진 후,  listSearchsendemail에 있던 정부들 다시 띄우자.
		logger.info("get list search");
		RBOARDDAO dao = sqlSession.getMapper(RBOARDDAO.class);

		// 검색
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
		String[] seq = request.getParameterValues("chk"); 
		// name이 chk인 태그는 value값이 각각의 boardno이고, 배열seq에넣음

		if (seq == null || seq.length == 0) {
			model.addAttribute("msg", "�븯�굹�씠�긽 �꽑�깮�븯�꽭�슂");
		} else {
			RBOARDDAO dao = sqlSession.getMapper(RBOARDDAO.class);

			int res = dao.multiDelete(seq); // 지우는거 성공하면 1씩증가

			if (res == seq.length) {
				model.addAttribute("msg", "�궘�젣�꽦怨�");
			} else {
				model.addAttribute("msg", "�궘�젣�떎�뙣");
			}
		}

		return "redirect:listSearch";
	}

	
	
	   //세부내용
	@RequestMapping("/rboard_detail")
	public String rboard_detail(@ModelAttribute("scri") SearchCriteria cri, @RequestParam("boardno") int boardno, HttpSession session, HttpServletRequest request,
			Model model) {

		RBOARDDAO dao = sqlSession.getMapper(RBOARDDAO.class); 
		// xml에서 selectOne쿼리가져와 실행하기 위함

		model.addAttribute("dto", dao.selectOne(boardno)); // 게시판 하나 가져온 결과를 모델에 포함시

		model.addAttribute("commentlist", dao.AllList(boardno)); // 댓글목록 불러오는걸 rboard_detail에서 해봄.

		
		MEMBERDTO dto2 = (MEMBERDTO) session.getAttribute("login");  // 세션에 담은 로그인정보 가져옴
		model.addAttribute("dto2", dto2);

		 // 첨부된 사진 출력
		List<uploadFileDTO> uploadFileList = dao.getFileList(boardno);
		model.addAttribute("uploadFileList", uploadFileList);
		
		
		//조회수
		model.addAttribute("readcount",dao.boardHit(boardno));
		
		  //페이징 유지  	
		model.addAttribute("scri", cri); 

		return "/rboard_detail";

	}
	
	
	
    //글쓰는 폼
	@RequestMapping("/rboard_writeform")
	public String rboard_writeform(HttpSession session, Model model) {

		MEMBERDTO dto2 = (MEMBERDTO) session.getAttribute("login"); // 세션에 담은 로그인정보 가져옴

		model.addAttribute("dto2", dto2);

		return "/rboard_writeform";
	}
	
	  //글쓰기버튼 누름
	@RequestMapping("/rboard_write")
	public String write(HttpServletRequest request, Model model, MultipartFile file, HttpSession session,
			MultipartHttpServletRequest mhsq) throws IOException, Exception {
		RBOARDDAO dao = sqlSession.getMapper(RBOARDDAO.class);

	      // 폼태그값들 전달
		String title = request.getParameter("title");
		String memberid = request.getParameter("memberid");
		String memberImg = request.getParameter("memberImg");
		String content = request.getParameter("contenta");

		String foodkind = request.getParameter("foodkind");
		String countrykind = request.getParameter("countrykind");
		String timekind = request.getParameter("timekind");

		String majormat = request.getParameter("majormat");
		String minormat = request.getParameter("minormat");

		
		  // 로그인컨트롤러에서 setAttribute로 세션에 저장한 login객체를 dto로 불러와 화면에 뿌리자.
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

	      // kuzuro 썸네일첨부

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
	      // 썸네일까지 같이 작성
		dao.insert(dto); 

		
		
	     // 파일등록 2번째방법. (멀티) 출처: https://devofhwb.tistory.com/17 [이든의 생활코딩]
		  // 저장경로 생성, 파일 여기에 저장되는것까지 확인.
		String realFolder = "C:\\Users\\Jey\\Desktop\\resources\\imgUpload";

		File dir = new File(realFolder);
		if (!dir.isDirectory()) {
			dir.mkdirs();
		}

		  // 넘어온 파일을 리스트로 저장
		List<MultipartFile> mf = mhsq.getFiles("uploadFile"); // type="file" �쓽 �뙆�씪誘명꽣紐낆쑝濡� �뙆�씪�쓣 媛��졇�삩�떎.
		// MultipartServletRequest mhsq

		if (mf.size() == 1 && mf.get(0).getOriginalFilename().equals("")) {

		} else {
			for (int i = 0; i < mf.size(); i++) {
				 // 파일 중복명 처리
				String genId = UUID.randomUUID().toString();
			     // 본래 파일명
				String originalfileName = mf.get(i).getOriginalFilename();

				String saveFileName = genId + "." + FilenameUtils.getExtension(originalfileName);
				 // 저장되는 파일 이름

				String savePath = realFolder + saveFileName; /// 저장 될 파일 경로

				long fileSize = mf.get(i).getSize(); // 파일 사이즈

				mf.get(i).transferTo(new File(savePath));  // 파일 저장하고 DB에 등록까지 확인됨.

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

	      // 로그인세션가져오기(위로 옮김)
	      //뷰에 로그인세션 뿌림

		model.addAttribute("memberdto", memberdto);
		
		
		String id = memberdto.getId(); // 로그인된아이디
		System.out.println(id);

		MYPAGEDAO mypagedao = sqlSession.getMapper(MYPAGEDAO.class);
		// 글작성시 포인트 +10
		mypagedao.PlusPoint1(id);

		return "redirect:listSearchsendmail";
	}
	
	
	//수정양식
	@RequestMapping("/updateform")
	public String updateform(@ModelAttribute("scri") SearchCriteria cri,HttpServletRequest request, Model model) {
		RBOARDDAO dao = sqlSession.getMapper(RBOARDDAO.class); // xml에서 selectOne쿼리가져와 실행하기 위함

		int boardno = Integer.parseInt(request.getParameter("boardno"));
		System.out.println(boardno); // 가져와짐.
		model.addAttribute("dto", dao.selectOne(boardno)); // 가져온 결과를 모델에 포함시

		 //원래 작성된 글의 정보를 updateform페이지에 띄운다.
	      
	      //페이징 유지

        model.addAttribute("scri", cri); 
		

		return "rboard_updateform";
	}
	
    //수정완료
	@RequestMapping("/rboard_update")
	public String rboardupdate(@ModelAttribute("scri") SearchCriteria scri, @RequestParam("boardno") int boardno, HttpServletRequest request, Model model, MultipartFile file, HttpSession session,
			MultipartHttpServletRequest mhsq, RedirectAttributes rttr) throws IOException, Exception {
		RBOARDDAO dao = sqlSession.getMapper(RBOARDDAO.class);

		 // 폼태그값들 전달
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
		
		 // 로그인컨트롤러에서 setAttribute로 세션에 저장한 login객체를 dto로 불러와 화면에 뿌리자.
        MEMBERDTO memberdto = (MEMBERDTO) session.getAttribute("login");
		
		System.out.println(title);  //바뀐제목
	
		
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

		  // kuzuro 썸네일첨부

	       // 새로운 파일이 등록되었는지 확인

		 if(file.getOriginalFilename() != null && file.getOriginalFilename() != "") {
			 // 기존 파일을 삭제
		  new File(uploadPath + request.getParameter("gdsImg")).delete();
		  new File(uploadPath + request.getParameter("gdsThumbImg")).delete();
		  
		  // 새로 첨부한 파일을 등록
		  String imgUploadPath = uploadPath + File.separator + "imgUpload";
		  String ymdPath = UploadFileUtils.calcPath(imgUploadPath);
		  String fileName = UploadFileUtils.fileUpload(imgUploadPath, file.getOriginalFilename(), file.getBytes(), ymdPath);
		  
		  dto.setGdsImg(File.separator + "imgUpload" + ymdPath + File.separator + fileName);
		  dto.setGdsThumbImg(File.separator + "imgUpload" + ymdPath + File.separator + "s" + File.separator + "s_" + fileName);
		  
		 } else {  // 새로운 파일이 등록되지 않았다면
		        // 기존 이미지를 그대로 사용

		  dto.setGdsImg(request.getParameter("gdsImg"));
		  dto.setGdsThumbImg(request.getParameter("gdsThumbImg"));
		  
		 }
		
		
		 //수정

		dao.rboard_update(dto);

		
		
		  // 파일등록 2번째방법. (멀티) 출처: https://devofhwb.tistory.com/17 [이든의 생활코딩]

	      // 저장경로 생성, 파일 여기에 저장되는것까지 확인.

		String realFolder = "C:\\Users\\Jey\\Desktop\\resources\\imgUpload";

		File dir = new File(realFolder);
		if (!dir.isDirectory()) {
			dir.mkdirs();
		}

		  // 넘어온 파일을 리스트로 저장

		List<MultipartFile> mf = mhsq.getFiles("uploadFile"); // type="file" �쓽 �뙆�씪誘명꽣紐낆쑝濡� �뙆�씪�쓣 媛��졇�삩�떎.
		// MultipartServletRequest mhsq

		if (mf.size() == 1 && mf.get(0).getOriginalFilename().equals("")) {

		} else {
			for (int i = 0; i < mf.size(); i++) {
				 // 파일 중복명 처리
				String genId = UUID.randomUUID().toString();
				 // 본래 파일명
				String originalfileName = mf.get(i).getOriginalFilename();
				String saveFileName = genId + "." + FilenameUtils.getExtension(originalfileName);
				 // 저장되는 파일 이름

				String savePath = realFolder + saveFileName; // 저장 될 파일 경로

				long fileSize = mf.get(i).getSize(); // 파일 사이즈

				mf.get(i).transferTo(new File(savePath)); // 파일 저장하고 DB에 등록까지 확인됨.

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

		// 로그인세션가져오기(위로 옮김)
	    //뷰에 로그인세션 뿌림

		model.addAttribute("memberdto", memberdto);
		
		model.addAttribute("scri", scri);
		
		
		//페이징 유지
		rttr.addAttribute("page", scri.getPage());
		rttr.addAttribute("perPageNum", scri.getPerPageNum());
		
		rttr.addAttribute("foodList", scri.getFoodList());
		rttr.addAttribute("countryList", scri.getCountryList());
		rttr.addAttribute("timeList", scri.getTimeList());
		
		rttr.addAttribute("searchType", scri.getSearchType());
		rttr.addAttribute("searchWord", scri.getSearchWord());
		
		return "redirect:listSearchsendmail"; // redirect는 정보포함해서 보냄.
	}

	
	//삭제하기
	@RequestMapping("/rboarddelete")
	public String delete(RedirectAttributes rttr, @ModelAttribute("scri") SearchCriteria scri,  @RequestParam("boardno") int boardno, HttpServletRequest request, Model model) {

		RBOARDDAO dao = sqlSession.getMapper(RBOARDDAO.class);

		model.addAttribute("dto", dao.selectOne(boardno));
		dao.delete(boardno);
		
		
		 //페이징 유지
		rttr.addAttribute("page", scri.getPage());
		rttr.addAttribute("perPageNum", scri.getPerPageNum());
		

		rttr.addAttribute("foodList", scri.getFoodList());
		rttr.addAttribute("countryList", scri.getCountryList());
		rttr.addAttribute("timeList", scri.getTimeList());

		rttr.addAttribute("searchType", scri.getSearchType());
		rttr.addAttribute("searchWord", scri.getSearchWord());
		
		
		return "redirect:listSearchsendmail";
	}

	 // 기타 페이지 이동
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
		
		System.out.println("좋아요");
		
		MEMBERDTO dto = (MEMBERDTO) session.getAttribute("login");
		String id = dto.getId(); // 로그인된아이디이다.
		
		System.out.println(id);
		
		
		 //맵에 ajax에서 받아온 게시글번호와 아이디를 넣어줌.
		Map<String, Object> m = new HashMap<String, Object>();
		m.put("boardno", request.getParameter("boardno"));
		m.put("id", request.getParameter("id"));
		
		RBOARDDAO dao = sqlSession.getMapper(RBOARDDAO.class);
		
		 //동일 게시글, 아이디로 좋아요한게 있는지 확인한다.
		int result =dao.likeCheck(m);
		
		
		RBOARDLIKEDTO dto1= new RBOARDLIKEDTO();
		dto1.setBoardno(boardno);
		dto1.setLikememberid(id);
		
		if(result>0) {
			dao.deleteBoardLike(dto1);
		}else {
			dao.insertBoardLike(dto1);
		}
		
		
		//좋아요 개수 세기
	      //프린트라이터로 게시글별 좋아요수를 count로 뷰로 보냄.

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
		
		
	    //좋아요 개수 세기
	      //프린트라이터로 게시글별 좋아요수를 count로 뷰로 보냄.

		PrintWriter out = response.getWriter();
			
				int count = dao.likeCount(boardno);

				out.println(count);
				out.close();
		
		return "/listSearch";
	}
	
	
	@RequestMapping("/popup")
	public String popup(@RequestParam("madebyid") String madebyid, HttpServletRequest request, HttpSession session, Model model) {

		 //뷰에서 넘긴 아이디를 받아옴.
		System.out.println(madebyid);

		RBOARDDTO dto = new RBOARDDTO();
		
	    //특정 아이디로 작성된 글을 화면에 뿌려줌.
		RBOARDDAO dao = sqlSession.getMapper(RBOARDDAO.class);
		
		model.addAttribute("madeby", dao.madeby(madebyid));
		
	
		
		 /*현재 로그인 세션
	      // 로그인컨트롤러에서 setAttribute로 세션에 저장한 login객체를 dto로 불러와 화면에 뿌리자.
        MEMBERDTO dto1 = (MEMBERDTO) session.getAttribute("login");
		model.addAttribute("dto1", dto1);

		String id = dto1.getId();  // 로그인된아이디이다.
		System.out.println(id);*/
	

		return "/popup";
	}
	
	
	//후기 게시판
	
	
	
	
	@RequestMapping(value = "/reviewboard_a", method = RequestMethod.GET)
	public String listSearchsendmailreview(@ModelAttribute("scri") SearchCriteria bs, HttpSession session, HttpServletRequest request, HttpServletResponse response, Model model)
			throws Exception {
		logger.info("rboardreview");
		REVIEWBOARDDAO dao = sqlSession.getMapper(REVIEWBOARDDAO.class);



		List<REVIEWBOARDDTO> searchList = dao.RlistSearch(bs);
		model.addAttribute("searchList", searchList);  //�떎�쓬酉곗뿉 dto瑜� 肉뚮┝.
		

		
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(bs);
		pageMaker.setTotalCount(dao.RcountSearch(bs));
		
		System.out.println(dao.RcountSearch(bs));  
		model.addAttribute("pageMaker", pageMaker);
		
	
		model.addAttribute("scri", bs); 
		

		return "/reviewboard_a";
	}
	
	
	
	


	@RequestMapping("/reviewboard_detail")
	public String reviewboard_detail(@ModelAttribute("scri") SearchCriteria cri, @RequestParam("reviewboardno") int reviewboardno, HttpSession session, HttpServletRequest request,
			Model model) {

		REVIEWBOARDDAO dao = sqlSession.getMapper(REVIEWBOARDDAO.class); 

		model.addAttribute("dto", dao.RselectOne(reviewboardno)); 
		model.addAttribute("commentlist", dao.RAllList(reviewboardno)); 
		
		
		MEMBERDTO dto2 = (MEMBERDTO) session.getAttribute("login"); 
		model.addAttribute("dto2", dto2);

	
		List<uploadFileDTO> uploadFileList = dao.RgetFileList(reviewboardno);
		model.addAttribute("uploadFileList", uploadFileList);
		
	
		model.addAttribute("readcount",dao.RboardHit(reviewboardno));
		
	
		model.addAttribute("scri", cri); 

		return "/reviewboard_detail";

	}
	
	
	

	@RequestMapping("/reviewboard_writeform")
	public String reviewboard_writeform(@RequestParam("boardno") int boardno, HttpSession session, Model model) {

		MEMBERDTO dto2 = (MEMBERDTO) session.getAttribute("login"); 
		model.addAttribute("dto2", dto2);
		
		System.out.println(boardno);
		model.addAttribute("boardno", boardno);

		return "/reviewboard_writeform";
	}
	

	@RequestMapping("/reviewboard_write")
	public String reviewboard_write(@RequestParam("boardno") int boardno, HttpServletRequest request, Model model, MultipartFile file, HttpSession session,
			MultipartHttpServletRequest mhsq) throws IOException, Exception {
		REVIEWBOARDDAO dao = sqlSession.getMapper(REVIEWBOARDDAO.class);


		
		
		String title = request.getParameter("title");
		String memberid = request.getParameter("memberid");
		String memberImg = request.getParameter("memberImg");
		String content = request.getParameter("contenta");

		String foodkind = request.getParameter("foodkind");
		String countrykind = request.getParameter("countrykind");
		String timekind = request.getParameter("timekind");

		String majormat = request.getParameter("majormat");
		String minormat = request.getParameter("minormat");

		
		
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
	
		dao.Rinsert(dto); 

		
		
	
		String realFolder = "C:\\Users\\Jey\\Desktop\\resources\\imgUpload";

		File dir = new File(realFolder);
		if (!dir.isDirectory()) {
			dir.mkdirs();
		}

		
		List<MultipartFile> mf = mhsq.getFiles("uploadFile"); 
		// MultipartServletRequest mhsq

		if (mf.size() == 1 && mf.get(0).getOriginalFilename().equals("")) {

		} else {
			for (int i = 0; i < mf.size(); i++) {
			
				String genId = UUID.randomUUID().toString();
				
				String originalfileName = mf.get(i).getOriginalFilename();

				String saveFileName = genId + "." + FilenameUtils.getExtension(originalfileName);
			

				String savePath = realFolder + saveFileName; 

				long fileSize = mf.get(i).getSize(); 

				mf.get(i).transferTo(new File(savePath)); 
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

		
		model.addAttribute("memberdto", memberdto);
		
		
		String id = memberdto.getId(); 
		System.out.println(id);

		MYPAGEDAO mypagedao = sqlSession.getMapper(MYPAGEDAO.class);
	
		mypagedao.PlusPoint1(id);

		return "redirect:reviewboard_a";
	}
	
	
 
	@RequestMapping("/reviewboard_updateform")
	public String reviewboard_updateform(@ModelAttribute("scri") SearchCriteria cri,HttpServletRequest request, Model model) {
		REVIEWBOARDDAO dao = sqlSession.getMapper(REVIEWBOARDDAO.class); 

		int REVIEWBOARDNO = Integer.parseInt(request.getParameter("reviewboardno"));
		System.out.println(REVIEWBOARDNO); 
		model.addAttribute("dto", dao.RselectOne(REVIEWBOARDNO));
		
		
        model.addAttribute("scri", cri); 
		

		return "reviewboard_updateform";
	}
	
   
	@RequestMapping("/reviewboard_update")
	public String reviewboard_update(@ModelAttribute("scri") SearchCriteria scri, @RequestParam("reviewboardno") int REVIEWBOARDNO, HttpServletRequest request, Model model, MultipartFile file, HttpSession session,
			MultipartHttpServletRequest mhsq, RedirectAttributes rttr) throws IOException, Exception {
		REVIEWBOARDDAO dao = sqlSession.getMapper(REVIEWBOARDDAO.class);

		
		String title = request.getParameter("title");
		String memberid = request.getParameter("memberid");
		String memberImg = request.getParameter("memberImg");
		String content = request.getParameter("contenta");

		String foodkind = request.getParameter("foodkind");
		String countrykind = request.getParameter("countrykind");
		String timekind = request.getParameter("timekind");

		String majormat = request.getParameter("majormat");
		String minormat = request.getParameter("minormat");

		
		MEMBERDTO memberdto = (MEMBERDTO) session.getAttribute("login");
		
		System.out.println(title); 
	
		
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

		
		 if(file.getOriginalFilename() != null && file.getOriginalFilename() != "") {
		
		  new File(uploadPath + request.getParameter("gdsImg")).delete();
		  new File(uploadPath + request.getParameter("gdsThumbImg")).delete();
		  
		  
		  String imgUploadPath = uploadPath + File.separator + "imgUpload";
		  String ymdPath = UploadFileUtils.calcPath(imgUploadPath);
		  String fileName = UploadFileUtils.fileUpload(imgUploadPath, file.getOriginalFilename(), file.getBytes(), ymdPath);
		  
		  dto.setGdsImg(File.separator + "imgUpload" + ymdPath + File.separator + fileName);
		  dto.setGdsThumbImg(File.separator + "imgUpload" + ymdPath + File.separator + "s" + File.separator + "s_" + fileName);
		  
		 } else { 
		  dto.setGdsImg(request.getParameter("gdsImg"));
		  dto.setGdsThumbImg(request.getParameter("gdsThumbImg"));
		  
		 }
		
		
	
		dao.Rrboard_update(dto);

		
		
		
		String realFolder = "C:\\Users\\Jey\\Desktop\\resources\\imgUpload";

		File dir = new File(realFolder);
		if (!dir.isDirectory()) {
			dir.mkdirs();
		}

		
		List<MultipartFile> mf = mhsq.getFiles("uploadFile"); 

		if (mf.size() == 1 && mf.get(0).getOriginalFilename().equals("")) {

		} else {
			for (int i = 0; i < mf.size(); i++) {
				
				String genId = UUID.randomUUID().toString();
				
				String originalfileName = mf.get(i).getOriginalFilename();

				String saveFileName = genId + "." + FilenameUtils.getExtension(originalfileName);
			

				String savePath = realFolder + saveFileName; 

				long fileSize = mf.get(i).getSize(); 

				mf.get(i).transferTo(new File(savePath)); 
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

		
		model.addAttribute("memberdto", memberdto);
		
		model.addAttribute("scri", scri);
		
		
		
		rttr.addAttribute("page", scri.getPage());
		rttr.addAttribute("perPageNum", scri.getPerPageNum());
		
		rttr.addAttribute("foodList", scri.getFoodList());
		rttr.addAttribute("countryList", scri.getCountryList());
		rttr.addAttribute("timeList", scri.getTimeList());
		
		rttr.addAttribute("searchType", scri.getSearchType());
		rttr.addAttribute("searchWord", scri.getSearchWord());
		
		return "redirect:reviewboard_a"; // redirect�뒗 �젙蹂댄룷�븿�빐�꽌 蹂대깂.
	}

	
	
	@RequestMapping("/reviewboard_delete")
	public String reviewboard_delete(RedirectAttributes rttr, @ModelAttribute("scri") SearchCriteria scri,  @RequestParam("reviewboardno") int REVIEWBOARDNO, HttpServletRequest request, Model model) {

		REVIEWBOARDDAO dao = sqlSession.getMapper(REVIEWBOARDDAO.class);

		model.addAttribute("dto", dao.RselectOne(REVIEWBOARDNO));
		dao.Rdelete(REVIEWBOARDNO);
		
		
	
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
