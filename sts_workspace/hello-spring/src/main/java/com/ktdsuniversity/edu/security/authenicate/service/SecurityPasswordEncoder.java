package com.ktdsuniversity.edu.security.authenicate.service;

import org.jspecify.annotations.Nullable;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.ktdsuniversity.edu.members.helpers.SHA256Util;

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
