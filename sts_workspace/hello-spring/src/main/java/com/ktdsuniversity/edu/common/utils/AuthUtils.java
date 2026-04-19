package com.ktdsuniversity.edu.common.utils;

import java.util.List;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import com.ktdsuniversity.edu.members.vo.MemberVO;

/**
 * Spring Security 인증 및 권한을 편하게 체크할 수 있도록 해주는 유틸리티 클 래 스
 */
public abstract class AuthUtils { // 객체만들기 방지
	private AuthUtils() { // 익명 클래스 방지로 private
		// Authentication is null ??
	}

	public static boolean isAuthenticated() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		return authentication != null;
	}

	// Authentication Token 에서 MembersVO 가져오는 기능
	public static MemberVO getPrincipal() {
		if (isAuthenticated()) {
			Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

			return (MemberVO) authentication.getPrincipal();
		}
		return null;
	}

	// Authentication Token dptj 뜨먀ㅣ rkwudhsms rlsmd
	public static String getUsername() {
		if (isAuthenticated()) {
			return getPrincipal().getEmail();
		}
		return null;
	}

	// Authentication Token have Auth ? zz
	public static boolean hasAnyRole(String... roles) {
		if (isAuthenticated()) {
			List<String> grantedRoles = getPrincipal().getRoles();

			for (String role : roles) {
				if (grantedRoles.contains(role)) {
					return true;
				}
			}
		}

		return false;
	}
}
