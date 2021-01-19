package com.javalec.spring_mybatis;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.json.JSONArray;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.javalec.spring_mybatis.dao.RESTAUDAO;
import com.javalec.spring_mybatis.dto.Criteria;
import com.javalec.spring_mybatis.dto.PageMaker;
import com.javalec.spring_mybatis.dto.RBOARDDTO;
import com.javalec.spring_mybatis.dto.RESTAUDTO;
import com.javalec.spring_mybatis.dto.RESTAUSEARCHDTO;


@Controller
public class RestauController {


	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);
	
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
	
	@RequestMapping("/restau2")
	public String r2(@ModelAttribute("cri") Criteria cri, Model model, HttpServletRequest request
			, HttpSession session) {
	

		String admdng = request.getParameter("sel2");
		String restaukind = request.getParameter("restaukind");
	
		System.out.println(admdng);
		System.out.println(restaukind);
		
		RESTAUSEARCHDTO dto = new RESTAUSEARCHDTO();
		dto.setAdmdng(admdng);
		dto.setRestaukind(restaukind);

		
		
		RESTAUDAO dao = sqlSession.getMapper(RESTAUDAO.class);

		
		
		int a= cri.getRowStart();
		int b = cri.getRowEnd();
		System.out.println(a);
		System.out.println(b);
		
		Map map = new HashMap<String,String>();
		map.put("admdng",admdng);
		map.put("restaukind",restaukind);
		map.put("rowStart", a);
		map.put("rowEnd", b);

		//�떆�옉
		List list0 = new ArrayList();
		list0 = dao.restauselect_0( map);
		
		List<JSONObject> list_0 = new ArrayList();
		
				for (int i = 0; i < list0.size(); i++) {
					JSONObject obj = new JSONObject();
					
					
					obj.put("address", ((RESTAUDTO) list0.get(i)).getSite_addr());
					obj.put("upso_nm", ((RESTAUDTO) list0.get(i)).getUpso_nm());
					obj.put("site_addr_rd", ((RESTAUDTO) list0.get(i)).getSite_addr_rd());
					obj.put("telno", ((RESTAUDTO) list0.get(i)).getUpso_site_telno());
					obj.put("uptae", ((RESTAUDTO) list0.get(i)).getSnt_uptae_nm());
			
					System.out.println(obj);
					list_0.add(obj);
					
				}
		model.addAttribute("list_0",list_0);
				
		model.addAttribute("admdng",admdng);
		model.addAttribute("restaukind",restaukind);
		
		
		

		//�떆�옉
				List list1 = new ArrayList();
				list1 = dao.restauselect_1( map);
				
				List<JSONObject> list_1 = new ArrayList();
				
						for (int i = 0; i < list1.size(); i++) {
							JSONObject obj = new JSONObject();
							
							
							obj.put("address", ((RESTAUDTO) list0.get(i)).getSite_addr());
							obj.put("upso_nm", ((RESTAUDTO) list0.get(i)).getUpso_nm());
							obj.put("site_addr_rd", ((RESTAUDTO) list0.get(i)).getSite_addr_rd());
							obj.put("telno", ((RESTAUDTO) list0.get(i)).getUpso_site_telno());
							obj.put("uptae", ((RESTAUDTO) list0.get(i)).getSnt_uptae_nm());
					
							System.out.println(obj);
							list_1.add(obj);
							
						}
				model.addAttribute("list_1",list_1);
				System.out.println(list_1);
				
		
				
				session.setAttribute("admdng", admdng);
				session.setAttribute("restaukind", restaukind);

				

		//�럹�씠吏�
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(dao.restauCount(dto));
		model.addAttribute("pageMaker", pageMaker);
		
		model.addAttribute("cri", cri);

		System.out.println(dao.restauCount(dto));
		
		
		
		return "/restau2";
	}
	
	
	
	
	@RequestMapping("/restausearch")
	public String restausearch(@ModelAttribute("cri") Criteria cri, Model model, HttpServletRequest request
			, HttpSession session) {
		
		String admdng = request.getParameter("sel2");
		String restaukind = request.getParameter("restaukind");
	
		System.out.println(admdng);
		System.out.println(restaukind);
		
		RESTAUSEARCHDTO dto = new RESTAUSEARCHDTO();
		dto.setAdmdng(admdng);
		dto.setRestaukind(restaukind);

		
		
		RESTAUDAO dao = sqlSession.getMapper(RESTAUDAO.class);

		
		
		int a= cri.getRowStart();
		int b = cri.getRowEnd();
		System.out.println(a);
		System.out.println(b);
		
		Map map = new HashMap<String,String>();
		map.put("admdng",admdng);
		map.put("restaukind",restaukind);
		map.put("rowStart", a);
		map.put("rowEnd", b);

		//�떆�옉
		List list0 = new ArrayList();
		list0 = dao.restauselect_0( map);
		
		List<JSONObject> list_0 = new ArrayList();
		
				for (int i = 0; i < list0.size(); i++) {
					JSONObject obj = new JSONObject();
					
					
					obj.put("address", ((RESTAUDTO) list0.get(i)).getSite_addr());
					obj.put("upso_nm", ((RESTAUDTO) list0.get(i)).getUpso_nm());
					obj.put("site_addr_rd", ((RESTAUDTO) list0.get(i)).getSite_addr_rd());
					obj.put("telno", ((RESTAUDTO) list0.get(i)).getUpso_site_telno());
					obj.put("uptae", ((RESTAUDTO) list0.get(i)).getSnt_uptae_nm());
			
					System.out.println(obj);
					list_0.add(obj);
					
				}
		model.addAttribute("list_0",list_0);
				
		model.addAttribute("admdng",admdng);
		model.addAttribute("restaukind",restaukind);
		
		
		
		//�떆�옉
				List list1 = new ArrayList();
				list1 = dao.restauselect_1( map);
				
				List<JSONObject> list_1 = new ArrayList();
				
						for (int i = 0; i < list1.size(); i++) {
							JSONObject obj = new JSONObject();
							
							
							obj.put("address", ((RESTAUDTO) list0.get(i)).getSite_addr());
							obj.put("upso_nm", ((RESTAUDTO) list0.get(i)).getUpso_nm());
							obj.put("site_addr_rd", ((RESTAUDTO) list0.get(i)).getSite_addr_rd());
							obj.put("telno", ((RESTAUDTO) list0.get(i)).getUpso_site_telno());
							obj.put("uptae", ((RESTAUDTO) list0.get(i)).getSnt_uptae_nm());
					
							System.out.println(obj);
							list_1.add(obj);
							
						}
				model.addAttribute("list_1",list_1);
				System.out.println(list_1);
				
		
				
				session.setAttribute("admdng", admdng);
				session.setAttribute("restaukind", restaukind);

				

		//�럹�씠吏�
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(dao.restauCount(dto));
		model.addAttribute("pageMaker", pageMaker);
		
		model.addAttribute("cri", cri);

		System.out.println(dao.restauCount(dto));
		
		return "/restau2";
		
	}
	
	

	@RequestMapping("/restausearch1")
	public String restausearch1(@ModelAttribute("cri") Criteria cri, Model model, HttpServletRequest request, 
			 HttpSession session, @RequestParam("page") String page, @RequestParam("perPageNum") String perPageNum) {
		
		String admdng = (String) session.getAttribute("admdng");
		String restaukind = (String)session.getAttribute("restaukind");
		
		
	
		System.out.println(admdng);
		System.out.println(restaukind);
		
		RESTAUSEARCHDTO dto = new RESTAUSEARCHDTO();
		dto.setAdmdng(admdng);
		dto.setRestaukind(restaukind);

		
		
		RESTAUDAO dao = sqlSession.getMapper(RESTAUDAO.class);

		
		
		int a= Integer.parseInt(page);
		int b = Integer.parseInt(perPageNum);
	
		int a1 = (a-1)*b+1;
		int b1 = a*b;
		System.out.println(a1);
		System.out.println(b1);
		
		Map map = new HashMap();
		map.put("admdng",admdng);
		map.put("restaukind",restaukind);
		map.put("rowStart", a1);
		map.put("rowEnd", b1);

		//�떆�옉
		List list0 = new ArrayList();
		list0 = dao.restauselect_0( map);
		
		List<JSONObject> list_0 = new ArrayList();
		
				for (int i = 0; i < list0.size(); i++) {
					JSONObject obj = new JSONObject();
					
					
					obj.put("address", ((RESTAUDTO) list0.get(i)).getSite_addr());
					obj.put("upso_nm", ((RESTAUDTO) list0.get(i)).getUpso_nm());
					obj.put("site_addr_rd", ((RESTAUDTO) list0.get(i)).getSite_addr_rd());
					obj.put("telno", ((RESTAUDTO) list0.get(i)).getUpso_site_telno());
					obj.put("uptae", ((RESTAUDTO) list0.get(i)).getSnt_uptae_nm());
			
					System.out.println(obj);
					list_0.add(obj);
					
				}
		model.addAttribute("list_0",list_0);
				
		model.addAttribute("admdng",admdng);
		model.addAttribute("restaukind",restaukind);
		
		
		
		//�떆�옉
				List list1 = new ArrayList();
				list1 = dao.restauselect_1( map);
				
				List<JSONObject> list_1 = new ArrayList();
				
						for (int i = 0; i < list1.size(); i++) {
							JSONObject obj = new JSONObject();
							
							
							obj.put("address", ((RESTAUDTO) list0.get(i)).getSite_addr());
							obj.put("upso_nm", ((RESTAUDTO) list0.get(i)).getUpso_nm());
							obj.put("site_addr_rd", ((RESTAUDTO) list0.get(i)).getSite_addr_rd());
							obj.put("telno", ((RESTAUDTO) list0.get(i)).getUpso_site_telno());
							obj.put("uptae", ((RESTAUDTO) list0.get(i)).getSnt_uptae_nm());
					
							System.out.println(obj);
							list_1.add(obj);
							
						}
				model.addAttribute("list_1",list_1);
				System.out.println(list_1);
				


		//�럹�씠吏�
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(dao.restauCount(dto));
		model.addAttribute("pageMaker", pageMaker);
		
		model.addAttribute("cri", cri);

		System.out.println(dao.restauCount(dto));
		
		return "/restau2";
		
	}
		
		

	
	
	@RequestMapping("/restau4")
	public String r() {

		return "/restau4";
	}

	@RequestMapping("/restau3")
	public String restau(Model model) {


			return "/restau3";
	}

	@RequestMapping("/restaudb")
	public String restau1(HttpServletRequest request) {

		RESTAUDAO dao = sqlSession.getMapper(RESTAUDAO.class);

		String[] bikeList = request.getParameterValues("restau");
		// bike01.js�뿉�꽌
		// 諛몃쪟媛믪쓣 hidden �씤�뭼�깭洹몃줈 �닲寃⑥꽌 �쟾�넚�븿. name='bike'

		for (int i = 0; i < bikeList.length; i++) {
			String[] tmp = bikeList[i].split("/");

			// bikeList 諛곗뿴�쓣 �굹�늿�썑 tmp諛곗뿴�뿉 ���옣.
			// tmp瑜� dto�뿉 ���옣
			RESTAUDTO dto = new RESTAUDTO(tmp[0], tmp[1], tmp[2], tmp[3], tmp[4], tmp[5], tmp[6]);
			dao.restauinsert(dto);

		}

		return "/restau3";

	}
	
}
