package com.ktdsuniversity.edu.security.authenicate.handlers;

import java.io.IOException;

import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

import com.ktdsuniversity.edu.members.dao.MembersDao;
import com.ktdsuniversity.edu.members.vo.request.LoginVO;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class LoginFailureHandler implements AuthenticationFailureHandler {
	private MembersDao membersDao;

	public LoginFailureHandler(MembersDao membersDao) {
		this.membersDao = membersDao;
	}

	/**
	 * 로그인 실패시 필요한 작업들
	 */

	@Override
	public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException exception) throws IOException, ServletException {
		
		// 로그인 실패 정보를 기록할 이메일 가져오깅
		String email = request.getParameter("email");

		// Password 가 틀렸을 때 실행되도록 함
		if (exception instanceof BadCredentialsException) {
			this.membersDao.updateIncreaseLoginFailCount(email);
			this.membersDao.updateBlock(email);
		}

		// 루그인 페이지 보여주기
		String loginPagePath = "/WEB-INF/views/members/login.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(loginPagePath);
		LoginVO loginVO = new LoginVO();
		loginVO.setEmail(email);

		request.setAttribute("inputData", loginVO);
		request.setAttribute("errorMessage", exception.getMessage());
		dispatcher.forward(request, response);

	}

}
