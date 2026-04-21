package com.ktdsuniversity.edu.security.authenticate.web;

import java.time.Duration;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ktdsuniversity.edu.common.utils.ServletUtils;
import com.ktdsuniversity.edu.exceptions.HelloSpringApiException;
import com.ktdsuniversity.edu.members.dao.MembersDao;
import com.ktdsuniversity.edu.members.vo.MembersVO;
import com.ktdsuniversity.edu.members.vo.request.LoginVO;
import com.ktdsuniversity.edu.security.authenticate.service.SecurityPasswordEncoder;
import com.ktdsuniversity.edu.security.providers.JsonWebTokenAuthenticationProvider;
import com.ktdsuniversity.edu.security.user.SecurityUser;

import jakarta.validation.Valid;

@Controller
public class JwtLoginContoller {
	
	@Autowired
	private MembersDao membersDao;

	@Autowired
	private UserDetailsService userDetailsService;
	
	@Autowired
	private PasswordEncoder passwordEncoder; 
	
	@Autowired
	private JsonWebTokenAuthenticationProvider jwtAuthenticationProvider;
	
	
	
	@ResponseBody
	@PostMapping("/api/authorization")
	public Map<String, String> doJwtLogin(@Valid @RequestBody LoginVO loginVO, BindingResult bindingResult) {
		
		if(bindingResult.hasErrors()) {
			throw new HelloSpringApiException("Login Fail 1", HttpStatus.BAD_REQUEST.value(), bindingResult.getFieldErrors());
		}
		UserDetails userDetails = null;
		// 이메일을 통해 회원 정보 조회
		try {
			userDetails = this.userDetailsService.loadUserByUsername(loginVO.getEmail());
		}
		catch(UsernameNotFoundException unfe) {
			throw new HelloSpringApiException("Login Fail 2", HttpStatus.BAD_REQUEST.value(), "ill chi X");
		}

		if(!userDetails.isAccountNonLocked()) {
			throw new HelloSpringApiException("Login Fail 3", HttpStatus.BAD_REQUEST.value(), "ill chi X");
		}
		
		String password = loginVO.getPassword();
		
		SecurityPasswordEncoder securityPasswordEncoder = (SecurityPasswordEncoder) this.passwordEncoder;
		
		SecurityUser securityUser = (SecurityUser)userDetails; 
		MembersVO membersVO = securityUser.getMembersVO();
		if(!securityPasswordEncoder.matches(password, membersVO.getSalt(), membersVO.getPassword()))
		{
			this.membersDao.updateIncreaseLoginFailCount(loginVO.getEmail());
			this.membersDao.updateBlock(loginVO.getEmail());
			throw new HelloSpringApiException("Login Fail 4", HttpStatus.BAD_REQUEST.value(), "ill chi X");
		}
		// 비번 일 치 검 사 수 행
		
		loginVO.setIp(ServletUtils.getIp());
		this.membersDao.updateSuccessLogin(loginVO);
		
		
		String jwt = this.jwtAuthenticationProvider.makeJsonWebToken(loginVO.getEmail(), Duration.ofHours(9));
		return Map.of("token", jwt);
	}
}
