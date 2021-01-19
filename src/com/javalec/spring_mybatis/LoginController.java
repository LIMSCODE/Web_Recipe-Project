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
	
	

	  // 회원가입
	@RequestMapping("/registuser")
	public String registuser(HttpServletRequest request, Model model,  MultipartFile file ) throws IOException, Exception {
		MEMBERDAO dao = sqlSession.getMapper(MEMBERDAO.class);
		
		
		//비밀번호 암호화 --> db에 암호화되어 저장된다.

		MEMBERDTO dto = new MEMBERDTO();
		String inputPass = request.getParameter("pw");
		String pass = passEncoder.encode(inputPass);
		

		
		String imgUploadPath = uploadPath + File.separator + "imgUpload";
		String ymdPath = UploadFileUtils.calcPath(imgUploadPath);
		String fileName = null;
		
	
		
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
	
	

	   // 로그인 처리하는 부분
	@RequestMapping("/originallogin")
	public String loginCheck(RedirectAttributes rttr, HttpServletRequest request, HttpSession session) {
		MEMBERDAO dao = sqlSession.getMapper(MEMBERDAO.class);

		String returnURL = "";
		
		MEMBERDTO dto = new MEMBERDTO();
		
		 // dao.loginCheck(id,pw)는 selectAll한 결과. 
		MEMBERDTO login = dao.loginCheck(request.getParameter("id"));

		 //암호화한 비밀번호가 입력한값과 맞는지 비교
		boolean passMatch= passEncoder.matches(request.getParameter("pw"), login.getPw());

		if (session.getAttribute("login") != null) {
			  // 기존에 login이란 세션 값이 존재한다면
			session.removeAttribute("login");// 기존값을 제거해 준다.
		}

		
		if (login != null && passMatch) { // 로그인 성공시
			session.setAttribute("login", login); // 세션에 login인이란 이름으로 login객체를 저장해 놈.

			session.setMaxInactiveInterval(1000 * 1000);
			returnURL = "redirect:index"; // 로그인 성공시 메인페이지로 이동하고

		} else { // 로그인에 실패한 경우


			 //메세지 출력시키기. ?????

			rttr.addFlashAttribute("msg", false);
			returnURL = "redirect:loginform"; // 로그인 폼으로 다시 가도록 함

		}

		return returnURL; // 위에서 설정한 returnURL 을 반환해서 이동시킴
	}

	 // 세션이 다른곳에서도 유지되도록.
	// HttpSession session = request.getSession(true); �븞�뜥�룄�맖??

	 // 로그아웃 하는 부분
	@RequestMapping("/originallogout")
	public String originallogout(HttpSession session) {
		session.invalidate();  // 세션 초기화
		return "redirect:loginform"; // 로그아웃 후 로그인화면으로 이동
	}

	
	
	
	
	/* NaverLoginBO */
	private NaverLoginBO naverLoginBO;
	private String apiResult = null;

	@Autowired
	private void setNaverLoginBO(NaverLoginBO naverLoginBO) {
		this.naverLoginBO = naverLoginBO;
	}

	// 로그인 첫 화면 요청 메소드
	@RequestMapping(value = "/loginform", method = { RequestMethod.GET, RequestMethod.POST })
	public String login(Model model, HttpSession session) {

		 /* 네이버아이디로 인증 URL을 생성하기 위하여 naverLoginBO클래스의 getAuthorizationUrl메소드 호출 */
         String naverAuthUrl = naverLoginBO.getAuthorizationUrl(session);
		// https://nid.naver.com/oauth2.0/authorize?response_type=code&client_id=sE***************&
		// redirect_uri=http%3A%2F%2F211.63.89.90%3A8090%2Flogin_project%2Fcallback&state=e68c269c-5ba9-4c31-85da-54c16c658125
		System.out.println("네이버:" + naverAuthUrl);
		   // 네이버

		model.addAttribute("url", naverAuthUrl);
		return "loginform";
	}

	  // 네이버 로그인 성공시 callback호출 메소드
	@RequestMapping(value = "/callback", method = { RequestMethod.GET, RequestMethod.POST })
	public String callback(HttpServletRequest request, Model model, @RequestParam String code, @RequestParam String state, HttpSession session)
			throws IOException, ParseException {

		System.out.println("�뿬湲곕뒗 callback");
		OAuth2AccessToken oauthToken;
		oauthToken = naverLoginBO.getAccessToken(session, code, state);

		// 1. 로그인 사용자 정보를 읽어온다.
		apiResult = naverLoginBO.getUserProfile(oauthToken); // String�삎�떇�쓽 json�뜲�씠�꽣
		/**
		 * apiResult json 援ъ“ {"resultcode":"00", "message":"success",
		 * "response":{"id":"33666449","nickname":"shinn****","age":"20-29","gender":"M","email":"sh@naver.com","name":"\uc2e0\ubc94\ud638"}}
		 **/
	      // 2. String형식인 apiResult를 json형태로 바꿈
		JSONParser parser = new JSONParser();
		Object obj = parser.parse(apiResult);
		JSONObject jsonObj = (JSONObject) obj;
		 // 3. 데이터 파싱
		  // Top레벨 단계 _response 파싱
		JSONObject response_obj = (JSONObject) jsonObj.get("response");
		
		

	     // response의 nickname값 파싱
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
		

		  //1. MEMBERNAVER 테이블에 정보 저장시킨다. (중복방지 쿼리문)

		dao.insertnaveruser(id,  name, email, memberImg);
				
		
		String returnURL = "";

		if (session.getAttribute("login") != null) {
			 // 기존에 login이란 세션 값이 존재한다면
			session.removeAttribute("login"); // 기존값을 제거해 준다.

		}

		 //2. dao.loginCheck(id,pw)는 selectAll한 결과를 session에 저장시켜 다른페이지로 뿌린다.
        memberdto = dao.loginChecknaver(id, email);



		if (memberdto != null) {// 로그인 성공시
			session.setAttribute("login", memberdto); // 세션에 login인이란 이름으로 login객체를 저장해 놈.

			session.setMaxInactiveInterval(1000 * 1000);
			
			
			returnURL = "redirect:index"; // 로그인 성공시 메인페이지로 이동하고

		} else { // 로그인에 실패한 경우

			
			returnURL = "redirect:loginform"; // 로그인 폼으로 다시 가도록 함

		}

		return returnURL; // 위에서 설정한 returnURL 을 반환해서 이동시킴
	}


		
		
		
		
		

	   // 로그아웃
	   // - 네이버 API는 로그인은 지원하는데, 로그아웃은 지원을 하지않는다.
	   // - 이것 때문에 나는 나만의 세션을 만들어서 로그아웃 요청이 들어올 때 그냥 내 세션을 invalidate 시키고 index.jsp로
	   // 리다이렉트 시켰다.
	   // - 완벽한 로그아웃을 하려면 네이버 홈페이지로 접속해서 로그아웃 버튼을 눌러야한다!

	@RequestMapping(value = "/logout", method = { RequestMethod.GET, RequestMethod.POST })
	public String logout(HttpSession session) throws IOException {
		System.out.println("logout");
		session.invalidate();
		
		
		return "redirect:index";
	}


}
