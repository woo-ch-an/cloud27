package com.ktdsuniversity.edu.security.authenticate.oauth;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.security.oauth2.core.user.OAuth2User;

import com.ktdsuniversity.edu.members.vo.MembersVO;
import com.ktdsuniversity.edu.security.user.SecurityUser;

public class NaverOauthUserDetails extends SecurityUser implements OAuth2User {
 
	private static final long serialVersionUID = 1754543900346741129L;
	private Map<String,Object> oauthResult;
	
	public NaverOauthUserDetails(MembersVO membersVO, Map<String, Object> oauthResult) {
		super(membersVO);
		this.oauthResult = (Map<String,Object>) oauthResult.get("response");
		
		membersVO.setEmail(this.oauthResult.get("email").toString());
		membersVO.setName(this.oauthResult.get("name").toString());
		List<String> userRoles = new ArrayList<>();
		userRoles.add("RL-20260414-000003");
		membersVO.setFileGroupId("test");
		membersVO.setRoles(userRoles);
		
	}
	
	public String getEmail() {
		return super.getMembersVO().getEmail();
	}
	
	@Override
	public Map<String, Object> getAttributes() {
		return this.oauthResult;
	}
 
	@Override
	public String getName() {
		return super.getMembersVO().getName();
	}

}
