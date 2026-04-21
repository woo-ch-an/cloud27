package com.ktdsuniversity.edu.security.authenticate.oauth;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.security.oauth2.core.user.OAuth2User;

import com.ktdsuniversity.edu.members.vo.MembersVO;
import com.ktdsuniversity.edu.security.user.SecurityUser;

public class GoogleOauthUserDetails extends SecurityUser implements OAuth2User {

	private static final long serialVersionUID = -6690546994157629782L;

	private Map<String, Object> oauthResult;
	public GoogleOauthUserDetails(MembersVO membersVO, Map<String, Object> oauthResult) {
		super(membersVO);
		this.oauthResult = oauthResult;
		
		membersVO.setName(this.oauthResult.get("name").toString());
		membersVO.setEmail(this.oauthResult.get("email").toString());
		
		List<String> userRoles = new ArrayList<>();
		userRoles.add("RL-20260414-000003");
		membersVO.setRoles(userRoles);
		
	}
	
	public String getEmail() {
		return super.getMembersVO().getEmail();
	}

	@Override
	public Map<String, Object> getAttributes() {
		return oauthResult;
	}

	@Override
	public String getName() {
		return super.getMembersVO().getName();
	}

}
