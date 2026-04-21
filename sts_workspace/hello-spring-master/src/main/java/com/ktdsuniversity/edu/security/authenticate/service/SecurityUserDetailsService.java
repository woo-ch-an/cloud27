package com.ktdsuniversity.edu.security.authenticate.service;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.ktdsuniversity.edu.members.dao.MembersDao;
import com.ktdsuniversity.edu.members.vo.MembersVO;
import com.ktdsuniversity.edu.security.user.SecurityUser;

/**
 * 로그인 인증 실행 시 로그인 요청 정보 중 아이디로 회원의 정보 조회
 */
public class SecurityUserDetailsService implements UserDetailsService{
	
	private MembersDao membersDao;
	
	public SecurityUserDetailsService(MembersDao membersDao) {
		this.membersDao = membersDao;
	}
	/**
	 * 아이디로 디비에서 회원정보조회
	 * @param username : Id (email ) 
	 * @return  Db 조회한 회원정보 (SecurityUser)
	 * @throws : UsernameNotFoundException : DB에 회워정보없을때 던지는거
	 */
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		MembersVO loadedUser = this.membersDao.selectMemberByEmail(username); 
		
		if(loadedUser == null) {
			throw new UsernameNotFoundException("뭐기 또 틀림");
		}
		
		List<String> userRole = this.membersDao.selectMemberRolesByEmail(loadedUser.getEmail());
		loadedUser.setRoles(userRole);
		
		return new SecurityUser(loadedUser);
	} 
}
