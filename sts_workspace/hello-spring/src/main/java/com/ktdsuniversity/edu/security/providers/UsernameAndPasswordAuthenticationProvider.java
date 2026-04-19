package com.ktdsuniversity.edu.security.providers;

import org.jspecify.annotations.Nullable;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.ktdsuniversity.edu.members.vo.MemberVO;
import com.ktdsuniversity.edu.security.authenicate.service.SecurityPasswordEncoder;
import com.ktdsuniversity.edu.security.user.SecurityUser;

public class UsernameAndPasswordAuthenticationProvider implements AuthenticationProvider{

	private UserDetailsService userDetailsService;
	private PasswordEncoder passwordEncoder;

	public UsernameAndPasswordAuthenticationProvider(UserDetailsService userDetailsService,
			PasswordEncoder passwordEncoder) { 
		this.userDetailsService = userDetailsService;
		this.passwordEncoder = passwordEncoder;
	}
	
	@Override
	public @Nullable Authentication authenticate(Authentication authentication) throws AuthenticationException {

		String email = authentication.getName();
		// UserDetails => SecurityUser , username = Id; ~ 까지가 아이디 검증 
		UserDetails userDetails = this.userDetailsService.loadUserByUsername(email);
		if(!userDetails.isAccountNonLocked()) {
			throw new LockedException("머 안맞ㅇ믕 ; ");
		}
		
		MemberVO memberVO = ((SecurityUser)userDetails).getMembersVO();
		// 비번검사하기
		String rowPassword = authentication.getCredentials().toString();

		SecurityPasswordEncoder passwordMomparator = (SecurityPasswordEncoder)this.passwordEncoder;
		
		boolean isMatch =  passwordMomparator.matches(rowPassword, memberVO.getSalt(), userDetails.getPassword()); 		
		
		if(!isMatch) {
			throw new BadCredentialsException("아이디나비번이 안ㅁ자음 ");
		}
		
		return new UsernamePasswordAuthenticationToken(memberVO, userDetails.getPassword(), userDetails.getAuthorities()); // SecurityContext에 저장할 인증 토큰
	
	}

	@Override
	public boolean supports(Class<?> authentication) {

		return authentication.equals(UsernamePasswordAuthenticationToken.class);
	}

}
