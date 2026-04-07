package com.ktdsuniversity.edu.config.interceptors;

import org.springframework.web.servlet.HandlerInterceptor;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class IllegalAccessInterceptor implements HandlerInterceptor {

	/**
	 * 엔드포인트접근 전 세션이 있을 경우 컨트롤러 실행하지 않고 게시글 목록 조회 페이지로 이동
	 * 
	 * 페이지 이동 코드 response.sendredirect("URL")
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// 1. 세션 가져오기
		HttpSession session = request.getSession();
		// 2. 세션 있는지 검사하기
		if (session.getAttribute("__LOGIN_DATA__") != null) {
			// 3. 세션 없으면 컨트롤러 실행 안하고 게시글 목록 조회 페잊 ㅣ이동
			// 근데 유알엘은 아바껴야하
			// 융ㄹ엘은 그대론데 페이지는 로그인인것
			 
			
			response.sendRedirect("/");

			return false;
		}

		// 4 세션 있으면 컨트롤러 실행
		return true;
	}
}
