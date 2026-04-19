package com.ktdsuniversity.edu.security.authenicate.handlers;

import java.io.IOException;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import com.ktdsuniversity.edu.common.utils.StringUtils;
import com.ktdsuniversity.edu.members.dao.MembersDao;
import com.ktdsuniversity.edu.members.vo.request.LoginVO;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class LoginSuccessHandler implements AuthenticationSuccessHandler {

	private MembersDao membersDao; 
	
	public LoginSuccessHandler(MembersDao membersDao) {
		this.membersDao = membersDao;
	}
	/**
	 * 로그인 성공시 필요한 작업들
	 */
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
		
		LoginVO loginVO = new LoginVO();
		loginVO.setIp(request.getRemoteAddr());
		loginVO.setEmail(authentication.getName());

		this.membersDao.updateSuccessLogin(loginVO);
		String go = request.getParameter("go");
		
		response.sendRedirect(StringUtils.emptyTo(go, "/"));
	} 
}
