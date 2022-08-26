package com.cos.security1.config.oauth;

import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

@Service
public class PrincipalOauth2UserService extends DefaultOAuth2UserService {
	
	// 구글로부터 받은 userRequest 데이터에 대한 후처리되는 함수
	@Override
	public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
		//구글로그인 버튼 클릭 -> 구글로그인창 -> 로그인진행   
		//-> 구글쪽에서 우리쪽으로 code리턴(Oauth-Client라이브러리에서 받아줌)
		//-> Oauth-Client라이브러리가 code를 리턴받으면 AccessToken을 요청
		OAuth2User oAuth2User = super.loadUser(userRequest);
		return oAuth2User;
	}

}
