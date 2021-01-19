package com.javalec.spring_mybatis;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.github.scribejava.core.model.OAuth2AccessToken;
import com.javalec.spring_mybatis.dao.MEMBERDAO;
import com.javalec.spring_mybatis.dto.MEMBERDTO;
import com.javalec.spring_mybatis.dto.MEMBERNAVERDTO;
import com.javalec.spring_mybatis.dto.NaverLoginBO;
import com.kubg.utils.UploadFileUtils;

/**
 * Handles requests for the application home page.
 */
@Controller
public class LoginController {

	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);

	/* ContentDao dao; */

	@Autowired
	private SqlSession sqlSession;
	
	@Autowired
	BCryptPasswordEncoder passEncoder;
	
	@Resource(name = "uploadPath")
	private String uploadPath;
	

	/*
	 * @Autowired public void setDao(ContentDao dao) { this.dao = dao; }
	 */

	/**
	 * Simply selects the home view to render by returning its name.
	 * @throws Exception 
	 * @throws IOException 
	 */
	

	// id check
	@ResponseBody
	@RequestMapping(value = "/idCheck", method = RequestMethod.POST)
	public int postIdCheck(HttpServletRequest request) throws Exception {
	 logger.info("post idCheck");
	 MEMBERDAO dao = sqlSession.getMapper(MEMBERDAO.class);
	 
	 String id = request.getParameter("id");
	 System.out.println(id);
	 MEMBERDTO idCheck = dao.idCheck(id);
	 
	 int result = 0;
	 System.out.println(result);
	//MEMBERDTO를 반환.  있으면 1으로 반환
	 if(idCheck != null) {
	  result = 1;
	 } 
	 
	 return result;
	}
	
	

	// �쉶�썝媛��엯
	@RequestMapping("/registuser")
	public String registuser(HttpServletRequest request, Model model,  MultipartFile file ) throws IOException, Exception {
		MEMBERDAO dao = sqlSession.getMapper(MEMBERDAO.class);
		
		
		//鍮꾨�踰덊샇 �븫�샇�솕 --> db�뿉 �븫�샇�솕�릺�뼱 ���옣�맂�떎.
		MEMBERDTO dto = new MEMBERDTO();
		String inputPass = request.getParameter("pw");
		String pass = passEncoder.encode(inputPass);
		

		
		String imgUploadPath = uploadPath + File.separator + "imgUpload";
		String ymdPath = UploadFileUtils.calcPath(imgUploadPath);
		String fileName = null;
		
		//蹂듬텤�뻽�뜑�땲 �뿉�윭�굹�꽌 �넀�닔爾먯빞�븿
		
		if(file!=null) {
			fileName= UploadFileUtils.fileUpload(imgUploadPath, file.getOriginalFilename(), file.getBytes(), ymdPath);
			
		}else {
			fileName = uploadPath + File.separator + "images" + File.separator + "none.png";
		}


		dto.setId(request.getParameter("id"));
		dto.setPw(pass);
		dto.setName(request.getParameter("name"));
		dto.setEmail(request.getParameter("email"));
		dto.setPhone(request.getParameter("phone"));
		
		dto.setMemberImg(File.separator + "imgUpload" + ymdPath + File.separator + fileName);
		dto.setMemberThumbImg(File.separator + "imgUpload" + ymdPath + File.separator + "s" + File.separator + "s_" + fileName);
			
		
		
		
		dao.insertuser(dto);
		

		return "redirect:index";
	}
	
	

	// 濡쒓렇�씤 泥섎━�븯�뒗 遺�遺�
	@RequestMapping("/originallogin")
	public String loginCheck(RedirectAttributes rttr, HttpServletRequest request, HttpSession session) {
		MEMBERDAO dao = sqlSession.getMapper(MEMBERDAO.class);

		String returnURL = "";
		
		MEMBERDTO dto = new MEMBERDTO();
		
		// dao.loginCheck(id,pw)�뒗 selectAll�븳 寃곌낵. 
		MEMBERDTO login = dao.loginCheck(request.getParameter("id"));

		//�븫�샇�솕�븳 鍮꾨�踰덊샇媛� �엯�젰�븳媛믨낵 留욌뒗吏� 鍮꾧탳
		boolean passMatch= passEncoder.matches(request.getParameter("pw"), login.getPw());

		if (session.getAttribute("login") != null) {
			// 湲곗〈�뿉 login�씠�� �꽭�뀡 媛믪씠 議댁옱�븳�떎硫�
			session.removeAttribute("login"); // 湲곗〈媛믪쓣 �젣嫄고빐 以��떎.
		}

		
		if (login != null && passMatch) { // 濡쒓렇�씤 �꽦怨듭떆
			session.setAttribute("login", login); // �꽭�뀡�뿉 login�씤�씠�� �씠由꾩쑝濡� login媛앹껜瑜� ���옣�빐 �냸.
			session.setMaxInactiveInterval(1000 * 1000);
			returnURL = "redirect:index"; // 濡쒓렇�씤 �꽦怨듭떆 硫붿씤�럹�씠吏�濡� �씠�룞�븯怨�
		} else { // 濡쒓렇�씤�뿉 �떎�뙣�븳 寃쎌슦

			//硫붿꽭吏� 異쒕젰�떆�궎湲�. ?????
			rttr.addFlashAttribute("msg", false);
			returnURL = "redirect:loginform"; // 濡쒓렇�씤 �뤌�쑝濡� �떎�떆 媛��룄濡� �븿
		}

		return returnURL; // �쐞�뿉�꽌 �꽕�젙�븳 returnURL �쓣 諛섑솚�빐�꽌 �씠�룞�떆�궡
	}

	// �꽭�뀡�씠 �떎瑜멸납�뿉�꽌�룄 �쑀吏��릺�룄濡�.
	// HttpSession session = request.getSession(true); �븞�뜥�룄�맖??

	// 濡쒓렇�븘�썐 �븯�뒗 遺�遺�
	@RequestMapping("/originallogout")
	public String originallogout(HttpSession session) {
		session.invalidate(); // �꽭�뀡 珥덇린�솕
		return "redirect:loginform"; // 濡쒓렇�븘�썐 �썑 濡쒓렇�씤�솕硫댁쑝濡� �씠�룞
	}

	
	
	
	
	/* NaverLoginBO */
	private NaverLoginBO naverLoginBO;
	private String apiResult = null;

	@Autowired
	private void setNaverLoginBO(NaverLoginBO naverLoginBO) {
		this.naverLoginBO = naverLoginBO;
	}

	// 濡쒓렇�씤 泥� �솕硫� �슂泥� 硫붿냼�뱶
	@RequestMapping(value = "/loginform", method = { RequestMethod.GET, RequestMethod.POST })
	public String login(Model model, HttpSession session) {

		/* �꽕�씠踰꾩븘�씠�뵒濡� �씤利� URL�쓣 �깮�꽦�븯湲� �쐞�븯�뿬 naverLoginBO�겢�옒�뒪�쓽 getAuthorizationUrl硫붿냼�뱶 �샇異� */
		String naverAuthUrl = naverLoginBO.getAuthorizationUrl(session);
		// https://nid.naver.com/oauth2.0/authorize?response_type=code&client_id=sE***************&
		// redirect_uri=http%3A%2F%2F211.63.89.90%3A8090%2Flogin_project%2Fcallback&state=e68c269c-5ba9-4c31-85da-54c16c658125
		System.out.println("�꽕�씠踰�:" + naverAuthUrl);
		// �꽕�씠踰�
		model.addAttribute("url", naverAuthUrl);
		return "loginform";
	}

	// �꽕�씠踰� 濡쒓렇�씤 �꽦怨듭떆 callback�샇異� 硫붿냼�뱶
	@RequestMapping(value = "/callback", method = { RequestMethod.GET, RequestMethod.POST })
	public String callback(HttpServletRequest request, Model model, @RequestParam String code, @RequestParam String state, HttpSession session)
			throws IOException, ParseException {

		System.out.println("�뿬湲곕뒗 callback");
		OAuth2AccessToken oauthToken;
		oauthToken = naverLoginBO.getAccessToken(session, code, state);

		// 1. 濡쒓렇�씤 �궗�슜�옄 �젙蹂대�� �씫�뼱�삩�떎.
		apiResult = naverLoginBO.getUserProfile(oauthToken); // String�삎�떇�쓽 json�뜲�씠�꽣
		/**
		 * apiResult json 援ъ“ {"resultcode":"00", "message":"success",
		 * "response":{"id":"33666449","nickname":"shinn****","age":"20-29","gender":"M","email":"sh@naver.com","name":"\uc2e0\ubc94\ud638"}}
		 **/
		// 2. String�삎�떇�씤 apiResult瑜� json�삎�깭濡� 諛붽퓞
		JSONParser parser = new JSONParser();
		Object obj = parser.parse(apiResult);
		JSONObject jsonObj = (JSONObject) obj;
		// 3. �뜲�씠�꽣 �뙆�떛
		// Top�젅踰� �떒怨� _response �뙆�떛
		JSONObject response_obj = (JSONObject) jsonObj.get("response");
		
		

		// response�쓽 nickname媛� �뙆�떛
		String name = (String) response_obj.get("id");
		String email = (String) response_obj.get("email");
		String id = (String) response_obj.get("nickname");
		String memberImg = (String) response_obj.get("profile_image");
		
		System.out.println(id);
		System.out.println(email);
		System.out.println(name);
		System.out.println(memberImg);
		

		
		
		MEMBERDTO memberdto = new MEMBERDTO();
		MEMBERDAO dao = sqlSession.getMapper(MEMBERDAO.class);
		

		//1. MEMBERNAVER �뀒�씠釉붿뿉 �젙蹂� ���옣�떆�궓�떎. (以묐났諛⑹� 荑쇰━臾�)
		dao.insertnaveruser(id,  name, email, memberImg);
				
		
		String returnURL = "";

		if (session.getAttribute("login") != null) {
			// 湲곗〈�뿉 login�씠�� �꽭�뀡 媛믪씠 議댁옱�븳�떎硫�
			session.removeAttribute("login"); // 湲곗〈媛믪쓣 �젣嫄고빐 以��떎.
		}

		//2. dao.loginCheck(id,pw)�뒗 selectAll�븳 寃곌낵瑜� session�뿉 ���옣�떆耳� �떎瑜명럹�씠吏�濡� 肉뚮┛�떎.
		memberdto = dao.loginChecknaver(id, email);



		if (memberdto != null) { // 濡쒓렇�씤 �꽦怨듭떆
			session.setAttribute("login", memberdto); // �꽭�뀡�뿉 login�씤�씠�� �씠由꾩쑝濡� login媛앹껜瑜� ���옣�빐 �냸.
			session.setMaxInactiveInterval(1000 * 1000);
			
			
			returnURL = "redirect:index"; // 濡쒓렇�씤 �꽦怨듭떆 硫붿씤�럹�씠吏�濡� �씠�룞�븯怨�
			
		} else { // 濡쒓렇�씤�뿉 �떎�뙣�븳 寃쎌슦
			
			
			//硫붿꽭吏� 異쒕젰�떆�궎湲�. ?????
			returnURL = "redirect:loginform"; // 濡쒓렇�씤 �뤌�쑝濡� �떎�떆 媛��룄濡� �븿
		}

		return returnURL; // �쐞�뿉�꽌 �꽕�젙�븳 returnURL �쓣 諛섑솚�빐�꽌 �씠�룞�떆�궡
	}


		
		
		
		
		

	// 濡쒓렇�븘�썐
	// - �꽕�씠踰� API�뒗 濡쒓렇�씤�� 吏��썝�븯�뒗�뜲, 濡쒓렇�븘�썐�� 吏��썝�쓣 �븯吏��븡�뒗�떎.
	// - �씠寃� �븣臾몄뿉 �굹�뒗 �굹留뚯쓽 �꽭�뀡�쓣 留뚮뱾�뼱�꽌 濡쒓렇�븘�썐 �슂泥��씠 �뱾�뼱�삱 �븣 洹몃깷 �궡 �꽭�뀡�쓣 invalidate �떆�궎怨� index.jsp濡�
	// 由щ떎�씠�젆�듃 �떆耳곕떎.
	// - �셿踰쏀븳 濡쒓렇�븘�썐�쓣 �븯�젮硫� �꽕�씠踰� �솃�럹�씠吏�濡� �젒�냽�빐�꽌 濡쒓렇�븘�썐 踰꾪듉�쓣 �닃�윭�빞�븳�떎!

	@RequestMapping(value = "/logout", method = { RequestMethod.GET, RequestMethod.POST })
	public String logout(HttpSession session) throws IOException {
		System.out.println("�뿬湲곕뒗 logout");
		session.invalidate();
		
		
		return "redirect:index";
	}


}
