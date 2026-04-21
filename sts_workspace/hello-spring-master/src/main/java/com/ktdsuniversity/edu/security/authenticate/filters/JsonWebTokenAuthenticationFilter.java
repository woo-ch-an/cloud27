package com.ktdsuniversity.edu.security.authenticate.filters;

import java.io.IOException;
import java.io.PrintWriter;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.filter.OncePerRequestFilter;

import com.ktdsuniversity.edu.common.utils.StringUtils;
import com.ktdsuniversity.edu.security.providers.JsonWebTokenAuthenticationProvider;
import com.ktdsuniversity.edu.security.user.SecurityUser;

import io.jsonwebtoken.JwtException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * 이 클래스의 객체가 Security Filter Chain에 등록되어 인증이 필요한 모든 EndPoint가 실행되기 전에
 * JsonWebTokenAuthenticationFilter (UsernamePasswordAuthenticationToken)을 생성하도록
 * 함 O
 * 
 * HttpServletRequest의 헤더로 전달된 Authorization에 들어있는 JWT 를 분석하고 분석된 결고ㅏ를
 * Authentication 토큰으로 생성시ㅣㄴ긴단ㄹ
 */
public class JsonWebTokenAuthenticationFilter extends OncePerRequestFilter {
// 이거 상속받으면 FilterChain에 등록됨  원래 이용도 > 인가 ? 

	private JsonWebTokenAuthenticationProvider jsonWebTokenAuthenticationProvider;

	private UserDetailsService userDetailsService;

	public JsonWebTokenAuthenticationFilter(JsonWebTokenAuthenticationProvider jsonWebTokenAuthenticationProvider,
			UserDetailsService userDetailsService) {
		this.jsonWebTokenAuthenticationProvider = jsonWebTokenAuthenticationProvider;
		this.userDetailsService = userDetailsService;
	}

	/**
	 * 내부 필터 동작하기 란 뜻
	 * 
	 */
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		// 다음 필터 동작 이전에 이 필터가 해야할 일이 ?있다면 wirte.. down .. . . .
		// 인터셉터에서의 PreHandler JWT토큰만들기 로 인증만들기

		// 뭐할려는걸까 ? : Authorization이 존재하는가 를 보고싶당
		// 요청 URL이 /api ~인 경우에만 실행함 + 요청 URL가져오기 * 정확함을 요구하기위해 /api/로찾기
		String requestUrl = request.getServletPath();
		// http://asfkjsdkf:29028/api/aruticles?asd=asf
		// -> 여기서 앞에 뒤에(쿼리스트링 다 빼고 URI만 가져온다

		if (requestUrl.startsWith("/api/")) {
			// Request에서 header의 Authorization 끍어오기
			String jsonWebToken = request.getHeader("Authorization");
			if (!StringUtils.isEmpty(jsonWebToken)) {

				/**
				 * 이전 1회용토큰 발급하기 ~
				 */
//				// JWT 를 복호화 시켜서 email을 갖꼬온다
//				String email = this.jsonWebTokenAuthenticationProvider.decryptJsonWebToken(jsonWebToken);
//				
//				// 이메일을 이용해 사용자 정보/권한조회 
//				UserDetails userDetails = this.userDetailsService.loadUserByUsername(email);
//				SecurityUser securityUser = (SecurityUser) userDetails;
//				
//				// 사용자 정보를이용해 토큰 발행 시작 
//				Authentication authToken = new UsernamePasswordAuthenticationToken(securityUser.getMembersVO(),userDetails.getPassword(),userDetails.getAuthorities());
//				
//				// 일회용 토큰 적재하기
//				SecurityContextHolder.getContext().setAuthentication(authToken);
				/**
				 * ~ 이전 1회용 토큰 발급
				 */

				/**
				 * 옛날옛적 Exception쓰던 시절 ~
				 */
//				// Json Web Token이 전달안되면이익
//				String errorMessage = "{ \"error\" : \"인증이 필요합니다\"}";
//				
//				response.setCharacterEncoding("UTF-8");
//				response.setContentType("application/json");
//				// 전얘
//				PrintWriter write = response.getWriter();
//				write.append(errorMessage);
//				write.flush();
//				return;
				/**
				 * ~ 옛날옛적 Exception쓰던 시절
				 */

				String email = null;
				try {
					email = this.jsonWebTokenAuthenticationProvider.decryptJsonWebToken(jsonWebToken);
				} catch (JwtException je) {
					response.setCharacterEncoding("UTF-8");
					response.setContentType("application/json");

					PrintWriter writer;
					writer = response.getWriter();
					writer.append("{ \"error\": \"인증이 필요하거나 잘못된 권한입니다.\" }");
					writer.flush();
					return;
				}

				// email을 이용해 사용자의 정보와 권한을 조회한다.
				UserDetails userDetails = this.userDetailsService.loadUserByUsername(email);
				SecurityUser securityUser = (SecurityUser) userDetails;

				// 사용자의 정보를 이용해 AuthenticationToken(UsernamePasswordAuthenticationToken)을 발행한다.
				Authentication authToken = new UsernamePasswordAuthenticationToken(securityUser.getMembersVO(),
						userDetails.getPassword(), userDetails.getAuthorities());

				// 발행한 AuthenticationToken을 SecurityContext에 적재시킨다. (일회용 토큰)
				SecurityContextHolder.getContext().setAuthentication(authToken);
			}

		}

		filterChain.doFilter(request, response); // 이 다음 필터가 있다면 그 필터를 동작시킨다.

	}

// 모든 필터가 동작이 완료되고 Filter Chain의 역순으로 응답이 돌아 올 때
// 이 필터가 해야할 일 작성.
// postHandle

}
