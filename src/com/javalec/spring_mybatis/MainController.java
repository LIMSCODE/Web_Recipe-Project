package com.javalec.spring_mybatis;

import java.io.IOException;
import java.net.URLDecoder;
import java.sql.Array;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.codehaus.jackson.JsonParser;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.javalec.spring_mybatis.dao.MAINDAO;
import com.javalec.spring_mybatis.dao.MEMBERDAO;
import com.javalec.spring_mybatis.dao.RBOARDDAO;
import com.javalec.spring_mybatis.dto.Criteria;
import com.javalec.spring_mybatis.dto.MEMBERDTO;
import com.javalec.spring_mybatis.dto.PageMaker;
import com.javalec.spring_mybatis.dto.RBOARDDTO;
import com.javalec.spring_mybatis.dto.SearchCriteria;
import com.javalec.spring_mybatis.dto.SearchCriteria2;

/**
 * Handles requests for the application home page.
 */
@Controller
public class MainController {
	
	private static final Logger logger = LoggerFactory.getLogger(MainController.class);
	
/*	ContentDao dao;*/
	
	@Autowired
	private SqlSession sqlSession;
	
/*	@Autowired
	public void setDao(ContentDao dao) {
		this.dao = dao;
	}*/
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String index(HttpSession session, Model model) {
		
		
		//理쒖떊 �옉�꽦 湲�
		MAINDAO dao = sqlSession.getMapper(MAINDAO.class);
		model.addAttribute("mainlatest0", dao.mainlatest0());
		model.addAttribute("mainlatest1", dao.mainlatest1()); // 留ㅺ컻蹂��닔 �벐�뒗寃�???
		model.addAttribute("mainlatest2", dao.mainlatest2());
		model.addAttribute("mainlatest3", dao.mainlatest3());
		model.addAttribute("mainlatest4", dao.mainlatest4());
		model.addAttribute("mainlatest5", dao.mainlatest5());
		
		
		
		//硫ㅻ쾭 �옲�궧
		model.addAttribute("ranking", dao.ranking()); 
		
		
		
		// 濡쒓렇�씤而⑦듃濡ㅻ윭�뿉�꽌 setAttribute濡� �꽭�뀡�뿉 ���옣�븳 login媛앹껜瑜� dto濡� 遺덈윭�� �솕硫댁뿉 肉뚮━�옄.
		MEMBERDTO dto = (MEMBERDTO) session.getAttribute("login");
		model.addAttribute("dto", dto);
		
		
		
		model.addAttribute("reviews", dao.reviews()); 
		

		return "/index";
	}
	
	

	
	
	
}
