package com.ktdsuniversity.edu.security.authenticate.oauth;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserService;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;

import com.ktdsuniversity.edu.board.vo.request.OAuthMemberVO;
import com.ktdsuniversity.edu.members.dao.MembersDao;
import com.ktdsuniversity.edu.members.vo.MembersVO;
import com.ktdsuniversity.edu.members.vo.request.RegistVO;
												// Oauth 를 통해 회원을 조회하는 인터 페이스
public class HelloSpringOauthService implements OAuth2UserService<OAuth2UserRequest, OAuth2User>{
	private static final Logger logger = LoggerFactory.getLogger(HelloSpringOauthService.class);
	
	private MembersDao membersDao;
	
	public HelloSpringOauthService(MembersDao membersDao) {
		this.membersDao = membersDao;
	}
	
	/**
	 * 
	 * ? /OAuth2 /authorization/naver of goolge 을 통해 로그인을 한 이후 실행되는 메쏘뜨
	 *  즉 네이버나 구글에서 redirect URL 을통해 응답을 보내 줄 때 실행되는 메서드
	 *  @param userRequest Oauth Service Provider 에게 개인정보를 요청하는 객체  지금으로선 네이버님에게 요청하는 객체가 된다
	 *  		1. authorization-uri 호출해서 옷쓰 인증 실행
	 *  		2. 인증 성공 후 토큰 유알이 호출해서 오쓰 토큰 발급
	 *  		3. 발급받은 오쓰 톸느을 이용해 유저인포유알아이 호출 ->사용자 정보 가져오기
	 *  @return OAtuh2User 서비스 제공자로 네이버나구글, 부터 취득한 사용자의 정보를 이용해 Security 인증 정보를 생성한다
	 */
	@Override // 이건 언제 실행되는걸까 ? 
	public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
		// User Request를 통해 개인저옵 취득 하기-> 그냥은 또 못가져옴 -> OAuth2UserService 의 기본 객체를 생성한 후 userRequest 전달
		OAuth2UserService<OAuth2UserRequest, OAuth2User> userService = new DefaultOAuth2UserService();
		
		// ? 이게.. 이게무슨 
		OAuth2User oauthResult = userService.loadUser(userRequest);

		MembersVO oauthMember = null;
		OAuth2User oauth2Principal = null;
		
		String registrationId = userRequest.getClientRegistration().getRegistrationId(); 
		if(registrationId.equals("naver")) { 
		    oauthMember = new MembersVO();  
		    oauth2Principal = new NaverOauthUserDetails(oauthMember,oauthResult.getAttributes());
			 
		}
		else if ( registrationId.equals("google")) {

			oauthMember = new MembersVO(); 
			oauth2Principal = new GoogleOauthUserDetails(oauthMember, oauthResult.getAttributes());
			
		}

		// 오쓰 멤버를 DB에 Insert, 만약 이미 존재한다면 안한다
		if(oauthMember != null) {
			boolean isGuest = this.membersDao.selectMemberByEmail(oauthMember.getEmail()) == null; 
			if(isGuest) {
				RegistVO registVO = new RegistVO();
				registVO.setEmail(oauthMember.getEmail());
				registVO.setName(oauthMember.getName());
				registVO.setPassword("NOEN");
				registVO.setSalt("NOEN");
				
				this.membersDao.insertNewMember(registVO);
			}
			
			OAuthMemberVO oauthmemberVO = new OAuthMemberVO(); 
			oauthmemberVO.setEmail(oauthMember.getEmail());
			oauthmemberVO.setName(oauthMember.getName());
			oauthmemberVO.setRegistrationId(registrationId);
			
			
			OAuthMemberVO newOauth = this.membersDao.selectOauthMemberByEmailAndRegistrationId(oauthmemberVO);
			if(newOauth == null) {
				this.membersDao.insertNewOAuthMember(oauthmemberVO);
			}
		}
		logger.debug(oauthResult.toString());
		
		return oauth2Principal; // 오쓰 ! 움직이면 죽이겠다 소리를 내도 죽이겠다 넨을 써도 죽는다
	} 
}
