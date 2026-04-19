package com.ktdsuniversity.edu.security.user;

import java.util.Collection;

import org.jspecify.annotations.Nullable;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.ktdsuniversity.edu.members.vo.MemberVO;

public class SecurityUser  implements UserDetails {
	 

		private static final long serialVersionUID = 877808216963557013L;

		/**
		 * UserDetails 인터페이스로 사용자의 세부 내용을 알 수 없기 때문에 사용자의 정보를 가지고 있는 membersVO를 멤버변수를 추가해준다
		 * 
		 */
		
		private MemberVO memberVO;
		
		public SecurityUser(MemberVO memberVO) {
			this.memberVO = memberVO;
		}
		
		public MemberVO getMembersVO () {
			return this.memberVO;
		}
		/**
		 * 사용자의 권한 목록을 관리 / 사용자별 권한별 서비스 목록 제공시 이거 씀 
		 */
		@Override
		public Collection<? extends GrantedAuthority> getAuthorities() {
			// 스프링 시쿠리티가 테크하는 권한 2가지 Role(권한) + Action( 생성 조회 뭐 그런거 )
			// Spring Security 가 Role Action 구분방법
			// 권한 => Prefix -> 'ROLE_SUPER_ADMIN' (SuperAdmin -> 어드민 아이디로 )
			// Action 이름으로 작성, CREAT, READ MODIFY DELETE DOWNLOAD UPLOAD 덩덩덩
			
			// 
			return this.memberVO.getRoles()
							     .stream()
							     .map(role -> new SimpleGrantedAuthority("ROLE_" + role))
							     .toList();
		}
		/**
		 * 로그인 한 회원의 비밀번호
		 */

		@Override
		public @Nullable String getPassword() {
			return this.memberVO.getPassword(); 
		}
		
		@Override
		public boolean isAccountNonLocked(){
			return this.memberVO.getBlockYn().equals("N");
		}

		/**
		 * 사용자의 아이디 [식별가능 한 (우린 Email Name이 아니라 식별 가능한 어떤 값]
		 */
		@Override
		public String getUsername() { 
			return this.memberVO.getEmail();
		} 
}
