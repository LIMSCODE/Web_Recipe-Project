package com.javalec.spring_mybatis;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.javalec.spring_mybatis.dto.MEMBERDTO;

//로그인체크 인터셉터. 적용할화면은 xml에서 설정

public class LoginInterceptor extends HandlerInterceptorAdapter {
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object Handler)
			throws IOException {

		// 세션이 존재하지 않을경우 로그인화면으로 이동
		HttpSession session = request.getSession(false);  //false이면 세션없을때 null됨,  true는 새로생성
		if (session == null) {
			response.sendRedirect("loginform"); // 경로 맞나?
			return false;
		}

		// 로그인컨트롤러에서 지정한 세션
		MEMBERDTO login = (MEMBERDTO) session.getAttribute("login");
		// 사용자 정보가 세션이 없을때.
		if (login == null) {
			response.sendRedirect("loginform"); // 경로??
			return false; // 더이상 컨트롤러로 가지않도록
		}

		return true; // 컨트롤러로 가도록

	}

}
