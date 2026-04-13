package com.ktdsuniversity.edu.config.interceptors;

import java.io.PrintWriter;

import org.jspecify.annotations.Nullable;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * 
 * 로그인이 필요힌 머ㅜ
 */
public class SessionInterceptor implements HandlerInterceptor {

	// 컨트롤러가 실행되기 이전 수행할 공통 코드를 작성하는 영역
	//
	// Request -> 클라이언트(브라우저) 가 요청하는 내용 Header Parameter file session
	// Response -> 컨트롤러가 실행되기 이전에 브라우저로 응답을 보내는 역할(필요하면)
	// Handler 실행할 컨트롤러
	// Boolean 반환 [컨트롤러를 실행할지 여부 반환 True -> 컨트롤러 실행, false 실행안함

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// 1. 세션 가져오기
		HttpSession session = request.getSession();
		// 2. 세션 있는지 검사하기
		if (session.getAttribute("__LOGIN_DATA__") == null) {

			String pathName = request.getRequestURI();
			if (pathName.startsWith("/api/")) {

				String jsonResult = "{	“status” : 403,	“error” : ”권한이 부족합니다”}";
				
				response.setCharacterEncoding("UTF-8");
				response.setContentType("application/json");
				
				PrintWriter write = response.getWriter();
				write.write(jsonResult);
				write.flush();
				return false;
			}

			// 3. 세션 없으면 컨트롤러 실행 안하고 로그인 페이지 보여주기
			// 근데 유알엘은 아바껴야하
			// 융ㄹ엘은 그대론데 페이지는 로그인인것
			String loginPagePath = "/WEB-INF/views/members/login.jsp";
			RequestDispatcher dispatcher = request.getRequestDispatcher(loginPagePath);

			// UR 은 안바뀌고 서블릿드등을 볼 수 있다
			dispatcher.forward(request, response);

			return false;
		}

		// 4 세션 있으면 컨트롤러 실행
		return true;
	}

	// 컨트롤러가 실행된 이후 수행할 공통 코드 작성
	// 이엑스) 모델 데이터 추가 모델 데이터 삭제 쑤정
	// Request -> 클라이언트(브라우저) 가 요청하는 내용 Header Parameter file session
	// Response -> 컨트롤러가 실행되기 이후 에 브라우저로 응답을 보내는 역할(필요하면)
//	    * @param handler 실행된 컨트롤러
//	    * @param modelAndView 컨트롤러가 반환시킨 view(template)와 model

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			@Nullable ModelAndView modelAndView) throws Exception {
		HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
	}

	// JSP 를 HTML 로 변환시켜 브라우저로 변환시키기 직전에 수행하는 공통 영ㅇ뭐시기
	// 리스폰에 내용 첨부 혹은 제거 파일이나 뭐 텍스트나 너ㄱ
	// 처리되지 않고 던져진 예외 핸들링
	// 이엑스 캐치되지 않는 예외 객체 --> 예외의종류를 통해 알맞은 예외 처리등을 수행

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler,
			@Nullable Exception ex) throws Exception {
		HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
	}

}
