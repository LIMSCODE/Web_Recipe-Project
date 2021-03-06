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


	

	
	  // rboard ???????????????
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

		
	      //????????? ????????? ???????????????.

		List<RBOARDDTO> searchList = dao.listSearch(bs);
		model.addAttribute("searchList", searchList); 
		

		  //?????????
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(bs);
		pageMaker.setTotalCount(dao.countSearch(bs));
		
		System.out.println(dao.countSearch(bs));   //?????????????????????
		model.addAttribute("pageMaker", pageMaker);
		
	     //???????????????
		model.addAttribute("scri", bs); 
		

		return "/listSearchsendmail";
	}
	
	
	   //rboard ????????? ????????????????????? ?????? ???????????? ??????
	@RequestMapping(value = "/listSearchreadcount", method = RequestMethod.GET)
	public String orderbyreadcount(@ModelAttribute("scri") SearchCriteria cri, HttpSession session, HttpServletRequest request, HttpServletResponse response, Model model)
			throws Exception {
		logger.info("orderbyreadcount");
		RBOARDDAO dao = sqlSession.getMapper(RBOARDDAO.class);

		
	      //?????????????????? ??????
		List<RBOARDDTO> searchList = dao.orderbyreadcount(cri);
		model.addAttribute("searchList", searchList);

		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(dao.listCount());
		model.addAttribute("pageMaker", pageMaker);
		
	      //????????? ??????
		model.addAttribute("scri", cri);

		return  "/listSearchreadcount";
	}
	
	
	
	
	   // ?????? - ?????????????????? ?????? ????????????

	@RequestMapping(value = "/listSearchsendmail123", method = RequestMethod.GET)
	public String listSearchsendmail123(@ModelAttribute("scri") SearchCriteria bs,RedirectAttributes rttr, HttpSession session, HttpServletRequest request, HttpServletResponse response, Model model)
			throws Exception {
		logger.info("????????????????????? ????????????");
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
		
	
		
		
		System.out.println(foodList); //[??????]
		System.out.println(countryList);  //[??????]
		System.out.println(timeList);  //[??????]
	
		System.out.println(SearchWord);
		System.out.println(SearchType);
		
		
		System.out.println(Arrays.toString(foodList));  //[??????]
		System.out.println(Arrays.toString(countryList)); //[??????]
		System.out.println(Arrays.toString(timeList));  //[??????]
		
	
		
	      //forward?????????.
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
		model.addAttribute("searchList", searchList); //???????????? dto??? ??????.
		

	      //?????????
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(bs);
		pageMaker.setTotalCount(dao.countSearch(bs));
		
		System.out.println(dao.countSearch(bs));   //?????? ???
		model.addAttribute("pageMaker", pageMaker);
		
	      //???????????????
		model.addAttribute("scri", bs); 

		
		return "/listSearchsendmail2";
	}
	
	
	

	
	   // rboard ???????????????
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
		
		System.out.println(foodList); //???????????????????????? ??????
		
	
		
	      //????????? ????????? ???????????????.

		List<RBOARDDTO> searchList = dao.listSearch(bs);
		model.addAttribute("searchList", searchList);  //????????????????????? dto?????? ?????????.
		

	      //?????????
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(bs);
		pageMaker.setTotalCount(dao.countSearch(bs));
		
		System.out.println(dao.countSearch(bs));   //?????????????????????
		model.addAttribute("pageMaker", pageMaker);
		
	      //???????????????
		model.addAttribute("scri", bs); 
		

		return "/listSearchsendmail2";
	}

	
	
	
	
	
	
	
	
	   //?????????  ????????????????????? ?????? ???????????? ??????
	@ResponseBody
	@RequestMapping(value = "/listSearchreadcount123", method = RequestMethod.GET)
	public String searchorderbyreadcount(@ModelAttribute("scri") SearchCriteria cri, HttpSession session, HttpServletRequest request, HttpServletResponse response, Model model)
			throws Exception {
		logger.info("??????????????????????????? ?????????????????? ??????????????? ????????????");
		
		
		RBOARDDAO dao = sqlSession.getMapper(RBOARDDAO.class);
		
		
		   //ajax??? ???????????? Object??? ???????????????, null?????? ?????? ??????????????? ????????????.
		//????????? ????????? ????????? ????????? ?????? ????????????.

		String[] foodList1= (String[]) session.getAttribute("foodList");
		String[] countryList1 = (String[]) session.getAttribute("countryList");
		String[] timeList1 = (String[]) session.getAttribute("timeList");
		String SearchType1 = (String) session.getAttribute("SearchType");
		String SearchWord1 = (String) session.getAttribute("SearchWord");
		
		
		System.out.println(foodList1); //??????????????? ???.

				
				
		   // ?????? ???????????? bs (dto)??? ??????
				SearchCriteria bs = new SearchCriteria();
				
				bs.setFoodList(foodList1);
				bs.setCountryList(countryList1);
				bs.setTimeList(timeList1);
				bs.setSearchType(SearchType1);
				bs.setSearchWord(SearchWord1);

				
				
		         //???????????? ????????? bs????????? ???????????????.
				List<RBOARDDTO> searchList = dao.searchorderbyreadcount(bs);
				model.addAttribute("searchList", searchList);
			

			
				PageMaker pageMaker = new PageMaker();
				pageMaker.setCri(bs);
				pageMaker.setTotalCount(dao.countSearch(bs));
				model.addAttribute("pageMaker", pageMaker);
				
				
			     //????????? ??????
				model.addAttribute("scri", cri);
				
				
				  //forward?????????.
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
		logger.info("?????? ??????");

	
		
		   // ???????????? ??? ?????? ???????????? bs (dto)??? ??????
		SearchCriteria bs = new SearchCriteria();

		
	
		String[] foodList = (String[]) session.getAttribute("foodList2");
		String[] countryList = (String[]) session.getAttribute("countryList2");
		String[] timeList = (String[]) session.getAttribute("timeList2");
		String SearchType = (String) session.getAttribute("SearchType2");
		String SearchWord = (String) session.getAttribute("SearchWord2");
		
		
		System.out.println(Arrays.toString(foodList));  //[??????]
		System.out.println(Arrays.toString(countryList));  
		System.out.println(Arrays.toString(timeList));  
		
		
		
		bs.setFoodList(foodList);
		bs.setCountryList(countryList);
		bs.setTimeList(timeList);
		bs.setSearchType(SearchType);
		bs.setSearchWord(SearchWord);
		
		RBOARDDAO dao = sqlSession.getMapper(RBOARDDAO.class);
		
		

		 //???????????? ????????? bs????????? ???????????????.
		List<RBOARDDTO> searchList = dao.searchorderbyreadcount(bs);
		model.addAttribute("searchList", searchList);
	

	
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(bs);
		pageMaker.setTotalCount(dao.countSearch(bs));
		model.addAttribute("pageMaker", pageMaker);
		
		//????????? ??????
		model.addAttribute("scri", cri);

		
		return "/listSearchsendmail3";   //????????? ???????????? ?????? ??????. -->ajax??? ??????

	}
	

	
	
	
	@ResponseBody
	@RequestMapping(value = "/listSearchpopup123", method = RequestMethod.GET)
	public String listSearchpopup123(@RequestParam(value="chks123[]") List<String> chks, HttpSession session, HttpServletRequest request, HttpServletResponse response, Model model)
			throws Exception {
		logger.info("ajax");
		
		  //????????? chks123[]??? ajax ????????? ?????????.
		
		 //ajax??? ?????? ????????????
		System.out.println(chks);  //[52, 51] ??? ??????????????? ????????????. 
		
		  //????????? rboarddto??? ??????????????????.
		
		model.addAttribute("chks", chks);

		return "/listSearchpopup";
	}
	
	

	@RequestMapping(value = "/listSearchpopup", method = RequestMethod.GET)
	public String listSearchpopup(HttpSession session, HttpServletRequest request, HttpServletResponse response, Model model)
			throws Exception {
		
		logger.info("listSearchpopup");
		
		  //????????? chk?????? ???????????????? ?????????.
	      //??????????????? ??????????????? ?????????.

		String[] array = request.getParameterValues("chk");
		
		List boardnoarray = new ArrayList();

		if( array !=  null){
		     for( int i =0 ; i < array.length ; i ++){
		       System.out.println( array[i]  );  // 52   51 ????????? ???.

		       //out.println("<br>=>"+ arrayStr[i]  );
		       
		       boardnoarray.add(array[i]);

		     }
		     
		     System.out.println(boardnoarray);   //[52,51] ?????????

		     
		     model.addAttribute("boardnoarray", boardnoarray);
		     
		     PrintWriter out = response.getWriter();
		       
		       out.println( "<p>" + array[0] +"<p>");
		       
		     

		}  //52, 51 ????????? ???.

		  //????????? ??????.

		return "/listSearchpopup";
	}
	


	@RequestMapping(value = "/finalsendemail")
	public String finalsendemail( 
			
			 //???????????????
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
	 
	      messageHelper.setFrom(setfrom);  // ??????????????? ??????????????? ?????? ??????????????? ??????

	      messageHelper.setTo(sendemail);    // ???????????? ?????????

	      messageHelper.setSubject(sendtitle);  // ??????????????? ????????? ????????????

	      messageHelper.setText(sendcontent);  // ?????? ??????
	     
	      mailSender.send(message);
	    } catch(Exception e){
	      System.out.println(e);
	    }
	    

	    //????????? ??? ????????? ???,  listSearchsendemail??? ?????? ????????? ?????? ?????????.
		logger.info("get list search");
		RBOARDDAO dao = sqlSession.getMapper(RBOARDDAO.class);

		// ??????
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
		// name??? chk??? ????????? value?????? ????????? boardno??????, ??????seq?????????

		if (seq == null || seq.length == 0) {
			model.addAttribute("msg", "???????????????????????? ??????????????????????????????");
		} else {
			RBOARDDAO dao = sqlSession.getMapper(RBOARDDAO.class);

			int res = dao.multiDelete(seq); // ???????????? ???????????? 1?????????

			if (res == seq.length) {
				model.addAttribute("msg", "????????????????????????");
			} else {
				model.addAttribute("msg", "????????????????????????");
			}
		}

		return "redirect:listSearch";
	}

	
	
	   //????????????
	@RequestMapping("/rboard_detail")
	public String rboard_detail(@ModelAttribute("scri") SearchCriteria cri, @RequestParam("boardno") int boardno, HttpSession session, HttpServletRequest request,
			Model model) {

		RBOARDDAO dao = sqlSession.getMapper(RBOARDDAO.class); 
		// xml?????? selectOne??????????????? ???????????? ??????

		model.addAttribute("dto", dao.selectOne(boardno)); // ????????? ?????? ????????? ????????? ????????? ?????????

		model.addAttribute("commentlist", dao.AllList(boardno)); // ???????????? ??????????????? rboard_detail?????? ??????.

		
		MEMBERDTO dto2 = (MEMBERDTO) session.getAttribute("login");  // ????????? ?????? ??????????????? ?????????
		model.addAttribute("dto2", dto2);

		 // ????????? ?????? ??????
		List<uploadFileDTO> uploadFileList = dao.getFileList(boardno);
		model.addAttribute("uploadFileList", uploadFileList);
		
		
		//?????????
		model.addAttribute("readcount",dao.boardHit(boardno));
		
		  //????????? ??????  	
		model.addAttribute("scri", cri); 

		return "/rboard_detail";

	}
	
	
	
    //????????? ???
	@RequestMapping("/rboard_writeform")
	public String rboard_writeform(HttpSession session, Model model) {

		MEMBERDTO dto2 = (MEMBERDTO) session.getAttribute("login"); // ????????? ?????? ??????????????? ?????????

		model.addAttribute("dto2", dto2);

		return "/rboard_writeform";
	}
	
	  //??????????????? ??????
	@RequestMapping("/rboard_write")
	public String write(HttpServletRequest request, Model model, MultipartFile file, HttpSession session,
			MultipartHttpServletRequest mhsq) throws IOException, Exception {
		RBOARDDAO dao = sqlSession.getMapper(RBOARDDAO.class);

	      // ??????????????? ??????
		String title = request.getParameter("title");
		String memberid = request.getParameter("memberid");
		String memberImg = request.getParameter("memberImg");
		String content = request.getParameter("contenta");

		String foodkind = request.getParameter("foodkind");
		String countrykind = request.getParameter("countrykind");
		String timekind = request.getParameter("timekind");

		String majormat = request.getParameter("majormat");
		String minormat = request.getParameter("minormat");

		
		  // ??????????????????????????? setAttribute??? ????????? ????????? login????????? dto??? ????????? ????????? ?????????.
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

	      // kuzuro ???????????????

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
	      // ??????????????? ?????? ??????
		dao.insert(dto); 

		
		
	     // ???????????? 2????????????. (??????) ??????: https://devofhwb.tistory.com/17 [????????? ????????????]
		  // ???????????? ??????, ?????? ????????? ????????????????????? ??????.
		String realFolder = "C:\\Users\\Jey\\Desktop\\resources\\imgUpload";

		File dir = new File(realFolder);
		if (!dir.isDirectory()) {
			dir.mkdirs();
		}

		  // ????????? ????????? ???????????? ??????
		List<MultipartFile> mf = mhsq.getFiles("uploadFile"); // type="file" ?????? ???????????????????????????????????? ?????????????????? ????????????????????????.
		// MultipartServletRequest mhsq

		if (mf.size() == 1 && mf.get(0).getOriginalFilename().equals("")) {

		} else {
			for (int i = 0; i < mf.size(); i++) {
				 // ?????? ????????? ??????
				String genId = UUID.randomUUID().toString();
			     // ?????? ?????????
				String originalfileName = mf.get(i).getOriginalFilename();

				String saveFileName = genId + "." + FilenameUtils.getExtension(originalfileName);
				 // ???????????? ?????? ??????

				String savePath = realFolder + saveFileName; /// ?????? ??? ?????? ??????

				long fileSize = mf.get(i).getSize(); // ?????? ?????????

				mf.get(i).transferTo(new File(savePath));  // ?????? ???????????? DB??? ???????????? ?????????.

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

	      // ???????????????????????????(?????? ??????)
	      //?????? ??????????????? ??????

		model.addAttribute("memberdto", memberdto);
		
		
		String id = memberdto.getId(); // ?????????????????????
		System.out.println(id);

		MYPAGEDAO mypagedao = sqlSession.getMapper(MYPAGEDAO.class);
		// ???????????? ????????? +10
		mypagedao.PlusPoint1(id);

		return "redirect:listSearchsendmail";
	}
	
	
	//????????????
	@RequestMapping("/updateform")
	public String updateform(@ModelAttribute("scri") SearchCriteria cri,HttpServletRequest request, Model model) {
		RBOARDDAO dao = sqlSession.getMapper(RBOARDDAO.class); // xml?????? selectOne??????????????? ???????????? ??????

		int boardno = Integer.parseInt(request.getParameter("boardno"));
		System.out.println(boardno); // ????????????.
		model.addAttribute("dto", dao.selectOne(boardno)); // ????????? ????????? ????????? ?????????

		 //?????? ????????? ?????? ????????? updateform???????????? ?????????.
	      
	      //????????? ??????

        model.addAttribute("scri", cri); 
		

		return "rboard_updateform";
	}
	
    //????????????
	@RequestMapping("/rboard_update")
	public String rboardupdate(@ModelAttribute("scri") SearchCriteria scri, @RequestParam("boardno") int boardno, HttpServletRequest request, Model model, MultipartFile file, HttpSession session,
			MultipartHttpServletRequest mhsq, RedirectAttributes rttr) throws IOException, Exception {
		RBOARDDAO dao = sqlSession.getMapper(RBOARDDAO.class);

		 // ??????????????? ??????
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
		
		 // ??????????????????????????? setAttribute??? ????????? ????????? login????????? dto??? ????????? ????????? ?????????.
        MEMBERDTO memberdto = (MEMBERDTO) session.getAttribute("login");
		
		System.out.println(title);  //????????????
	
		
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

		  // kuzuro ???????????????

	       // ????????? ????????? ?????????????????? ??????

		 if(file.getOriginalFilename() != null && file.getOriginalFilename() != "") {
			 // ?????? ????????? ??????
		  new File(uploadPath + request.getParameter("gdsImg")).delete();
		  new File(uploadPath + request.getParameter("gdsThumbImg")).delete();
		  
		  // ?????? ????????? ????????? ??????
		  String imgUploadPath = uploadPath + File.separator + "imgUpload";
		  String ymdPath = UploadFileUtils.calcPath(imgUploadPath);
		  String fileName = UploadFileUtils.fileUpload(imgUploadPath, file.getOriginalFilename(), file.getBytes(), ymdPath);
		  
		  dto.setGdsImg(File.separator + "imgUpload" + ymdPath + File.separator + fileName);
		  dto.setGdsThumbImg(File.separator + "imgUpload" + ymdPath + File.separator + "s" + File.separator + "s_" + fileName);
		  
		 } else {  // ????????? ????????? ???????????? ????????????
		        // ?????? ???????????? ????????? ??????

		  dto.setGdsImg(request.getParameter("gdsImg"));
		  dto.setGdsThumbImg(request.getParameter("gdsThumbImg"));
		  
		 }
		
		
		 //??????

		dao.rboard_update(dto);

		
		
		  // ???????????? 2????????????. (??????) ??????: https://devofhwb.tistory.com/17 [????????? ????????????]

	      // ???????????? ??????, ?????? ????????? ????????????????????? ??????.

		String realFolder = "C:\\Users\\Jey\\Desktop\\resources\\imgUpload";

		File dir = new File(realFolder);
		if (!dir.isDirectory()) {
			dir.mkdirs();
		}

		  // ????????? ????????? ???????????? ??????

		List<MultipartFile> mf = mhsq.getFiles("uploadFile"); // type="file" ?????? ???????????????????????????????????? ?????????????????? ????????????????????????.
		// MultipartServletRequest mhsq

		if (mf.size() == 1 && mf.get(0).getOriginalFilename().equals("")) {

		} else {
			for (int i = 0; i < mf.size(); i++) {
				 // ?????? ????????? ??????
				String genId = UUID.randomUUID().toString();
				 // ?????? ?????????
				String originalfileName = mf.get(i).getOriginalFilename();
				String saveFileName = genId + "." + FilenameUtils.getExtension(originalfileName);
				 // ???????????? ?????? ??????

				String savePath = realFolder + saveFileName; // ?????? ??? ?????? ??????

				long fileSize = mf.get(i).getSize(); // ?????? ?????????

				mf.get(i).transferTo(new File(savePath)); // ?????? ???????????? DB??? ???????????? ?????????.

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

		// ???????????????????????????(?????? ??????)
	    //?????? ??????????????? ??????

		model.addAttribute("memberdto", memberdto);
		
		model.addAttribute("scri", scri);
		
		
		//????????? ??????
		rttr.addAttribute("page", scri.getPage());
		rttr.addAttribute("perPageNum", scri.getPerPageNum());
		
		rttr.addAttribute("foodList", scri.getFoodList());
		rttr.addAttribute("countryList", scri.getCountryList());
		rttr.addAttribute("timeList", scri.getTimeList());
		
		rttr.addAttribute("searchType", scri.getSearchType());
		rttr.addAttribute("searchWord", scri.getSearchWord());
		
		return "redirect:listSearchsendmail"; // redirect??? ?????????????????? ??????.
	}

	
	//????????????
	@RequestMapping("/rboarddelete")
	public String delete(RedirectAttributes rttr, @ModelAttribute("scri") SearchCriteria scri,  @RequestParam("boardno") int boardno, HttpServletRequest request, Model model) {

		RBOARDDAO dao = sqlSession.getMapper(RBOARDDAO.class);

		model.addAttribute("dto", dao.selectOne(boardno));
		dao.delete(boardno);
		
		
		 //????????? ??????
		rttr.addAttribute("page", scri.getPage());
		rttr.addAttribute("perPageNum", scri.getPerPageNum());
		

		rttr.addAttribute("foodList", scri.getFoodList());
		rttr.addAttribute("countryList", scri.getCountryList());
		rttr.addAttribute("timeList", scri.getTimeList());

		rttr.addAttribute("searchType", scri.getSearchType());
		rttr.addAttribute("searchWord", scri.getSearchWord());
		
		
		return "redirect:listSearchsendmail";
	}

	 // ?????? ????????? ??????
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
		
		System.out.println("?????????");
		
		MEMBERDTO dto = (MEMBERDTO) session.getAttribute("login");
		String id = dto.getId(); // ???????????????????????????.
		
		System.out.println(id);
		
		
		 //?????? ajax?????? ????????? ?????????????????? ???????????? ?????????.
		Map<String, Object> m = new HashMap<String, Object>();
		m.put("boardno", request.getParameter("boardno"));
		m.put("id", request.getParameter("id"));
		
		RBOARDDAO dao = sqlSession.getMapper(RBOARDDAO.class);
		
		 //?????? ?????????, ???????????? ??????????????? ????????? ????????????.
		int result =dao.likeCheck(m);
		
		
		RBOARDLIKEDTO dto1= new RBOARDLIKEDTO();
		dto1.setBoardno(boardno);
		dto1.setLikememberid(id);
		
		if(result>0) {
			dao.deleteBoardLike(dto1);
		}else {
			dao.insertBoardLike(dto1);
		}
		
		
		//????????? ?????? ??????
	      //????????????????????? ???????????? ??????????????? count??? ?????? ??????.

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
		
		
	    //????????? ?????? ??????
	      //????????????????????? ???????????? ??????????????? count??? ?????? ??????.

		PrintWriter out = response.getWriter();
			
				int count = dao.likeCount(boardno);

				out.println(count);
				out.close();
		
		return "/listSearch";
	}
	
	
	@RequestMapping("/popup")
	public String popup(@RequestParam("madebyid") String madebyid, HttpServletRequest request, HttpSession session, Model model) {

		 //????????? ?????? ???????????? ?????????.
		System.out.println(madebyid);

		RBOARDDTO dto = new RBOARDDTO();
		
	    //?????? ???????????? ????????? ?????? ????????? ?????????.
		RBOARDDAO dao = sqlSession.getMapper(RBOARDDAO.class);
		
		model.addAttribute("madeby", dao.madeby(madebyid));
		
	
		
		 /*?????? ????????? ??????
	      // ??????????????????????????? setAttribute??? ????????? ????????? login????????? dto??? ????????? ????????? ?????????.
        MEMBERDTO dto1 = (MEMBERDTO) session.getAttribute("login");
		model.addAttribute("dto1", dto1);

		String id = dto1.getId();  // ???????????????????????????.
		System.out.println(id);*/
	

		return "/popup";
	}
	
	
	//?????? ?????????
	
	
	
	
	@RequestMapping(value = "/reviewboard_a", method = RequestMethod.GET)
	public String listSearchsendmailreview(@ModelAttribute("scri") SearchCriteria bs, HttpSession session, HttpServletRequest request, HttpServletResponse response, Model model)
			throws Exception {
		logger.info("rboardreview");
		REVIEWBOARDDAO dao = sqlSession.getMapper(REVIEWBOARDDAO.class);



		List<REVIEWBOARDDTO> searchList = dao.RlistSearch(bs);
		model.addAttribute("searchList", searchList);  //????????????????????? dto?????? ?????????.
		

		
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
		
		return "redirect:reviewboard_a"; // redirect?????? ????????????????????????????????? ?????????.
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
