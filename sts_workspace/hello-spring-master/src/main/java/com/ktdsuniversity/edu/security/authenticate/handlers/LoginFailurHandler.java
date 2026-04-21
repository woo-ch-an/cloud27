package com.ktdsuniversity.edu.security.authenticate.handlers;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

import com.ktdsuniversity.edu.members.dao.MembersDao;
import com.ktdsuniversity.edu.members.vo.request.LoginVO;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class LoginFailurHandler implements AuthenticationFailureHandler {

	private static final Logger logger = LoggerFactory.getLogger(LoginFailurHandler.class);
	private MembersDao membersDao;

	public LoginFailurHandler(MembersDao membersDao) {
		this.membersDao = membersDao;
	}

	@Override
	public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException exception) throws IOException, ServletException {

		logger.error("onAuthenticationFailure Active");
		logger.error(exception.getMessage(), exception);
		String email = request.getParameter("email");

		// Password 가 틀렸을 때 만 시 ㄹ 해 ㅇ
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
