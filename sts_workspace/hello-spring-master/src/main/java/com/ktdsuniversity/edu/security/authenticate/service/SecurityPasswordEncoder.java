package com.ktdsuniversity.edu.security.authenticate.service;

import org.jspecify.annotations.Nullable;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.ktdsuniversity.edu.members.helpers.SHA256Util;

/**
 * 디비에 있는 비밀번호와 로그인 요청 정보의 비밀번호가 일치하는지 검사
 * 
 *필요한 데이터 : 1. 디비 회원 비번
 * 2; 로그인 요청 정보 중 비번 ( 암호화 안된거
 * 			보기힘들다 					어쩌라고용
 * 						3. 암호화하기위한 정보 (로그인 요청에 있음 SALT
 */
public class SecurityPasswordEncoder implements PasswordEncoder{

	/**
	 * 로그인 요청 정보 중 비밀번호 암호화하기 
	 * @param 평문 비비ㅓㄴ
	 * @return 암호화된 비ㅓㄴ
	 */
	@Override
	public @Nullable String encode(@Nullable CharSequence rawPassword) {
		return null;
	}

	/**
	 * 로그인 요청 정보 중 평 무 ㄴ 비 밀 번 호 와 데 이 베 ㅇ ㅣ 암호화된비 밀번 호가 일치하는 지 
	 *  평문 + 암호화 == 디비 암호 >> 
	 */
	@Override
	public boolean matches(@Nullable CharSequence rawPassword, @Nullable String encodedPassword) {
		return false;
	}
	
	public String encode(String rawPassword, String salt){
		return SHA256Util.getEncrypt(rawPassword, salt);
	}
	
	public boolean matches(String rawPassword, String salt ,String encodedPassword) {
		return this.encode(rawPassword, salt).equals(encodedPassword);
		
	}
	

}
