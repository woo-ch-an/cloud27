package com.ktdsuniversity.edu.security.providers;

import org.jspecify.annotations.Nullable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.ktdsuniversity.edu.members.vo.MembersVO;
import com.ktdsuniversity.edu.security.authenticate.service.SecurityPasswordEncoder;
import com.ktdsuniversity.edu.security.user.SecurityUser;

/**
 * Spring Security 인증 공급자 [ ID , password Pair check ]. 맞으면 token 발급 후 securityContext에 저장함
 */
public class UsernameAndPasswordAuthenticationProvider implements AuthenticationProvider{

	private static final Logger logger = LoggerFactory.getLogger(UsernameAndPasswordAuthenticationProvider.class);
	/**
	 * 사용자가 로긍니할 때 전송한 아이디로 회원 정보기능 조회
	 */
	private UserDetailsService userDetailsService;

	/**
	 * 사용자가 로그인 할 때 전송한비밀번호 + 회원 비밀번호 비교 기능
	 */
	private PasswordEncoder passwordEncoder;
	
	public UsernameAndPasswordAuthenticationProvider(UserDetailsService userDetailsService,
			PasswordEncoder passwordEncoder) { 
		this.userDetailsService = userDetailsService;
		this.passwordEncoder = passwordEncoder;
	}

	/**
	 * 사용자로부터 Spring Security 로그 인 요청이 있을 때 마다 실행
	 * 
	 * 사용자가 보내준 ID?PW로 인증 수행 -> UserDetailsServiceinterface 이용해서 정보 조회 -> PasswordEncoder Interface로 사용자pw 검증 -> 일치하면 Token 발행
	 * 
	 * @param authentication : 사용자가 로그인 요청한정보 ( 아이디 / 비번 )
	 * @return UsernamePasswordAuthenticationToken
	 */
	@Override
	public @Nullable Authentication authenticate(Authentication authentication) throws AuthenticationException {
		
		String email = authentication.getName();
		// UserDetails => SecurityUser , username = Id; ~ 까지가 아이디 검증 
		UserDetails userDetails = this.userDetailsService.loadUserByUsername(email);
		if(!userDetails.isAccountNonLocked()) {
			throw new LockedException("머 안맞ㅇ믕 ; ");
		}
		
		MembersVO membersVO = ((SecurityUser)userDetails).getMembersVO();
		// 비번검사하기
		String rowPassword = authentication.getCredentials().toString();

		SecurityPasswordEncoder passwordMomparator = (SecurityPasswordEncoder)this.passwordEncoder;
		
		boolean isMatch =  passwordMomparator.matches(rowPassword, membersVO.getSalt(), userDetails.getPassword()); 		
		
		if(!isMatch) {
			throw new BadCredentialsException("아이디나비번이 안ㅁ자음 ");
		}
		
		return new UsernamePasswordAuthenticationToken(membersVO, userDetails.getPassword(), userDetails.getAuthorities()); // SecurityContext에 저장할 인증 토큰
	}

	/**
	 * 이 인증 공급자가 발급하는 토큰의 종류 설정 한 다 람 쥐 헌 쳇 바 퀴 에 타 고 파
	 * @param Authenticate() 가 발급한 클래스 정보가 들어온다 (요 위에있는거)
	 * @return 위에 얘가 발급한 토큰의 적절한 토큰인지 에 대한 여부
	 */
	@Override
	public boolean supports(Class<?> authentication) {
		
		return authentication.equals(UsernamePasswordAuthenticationToken.class);
	}

}
