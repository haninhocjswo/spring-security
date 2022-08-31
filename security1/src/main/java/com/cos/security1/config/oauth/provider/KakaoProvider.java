package com.cos.security1.config.oauth.provider;

import java.util.Map;

import org.springframework.security.oauth2.core.user.OAuth2User;

import com.cos.security1.model.User;

public class KakaoProvider implements Oauth2ProviderDiscrimination {
	
	private Map<String, Object> oAuth2User;

	public KakaoProvider(Map<String, Object> oAuth2User) {
		this.oAuth2User = oAuth2User;
	}

	@Override
	public String username() {
		return "kakao_" + oAuth2User.get("id");
	}

	@Override
	public String provider() {
		return "kakao";
	}

	@Override
	public String providerId() {
		return String.valueOf(oAuth2User.get("id"));
	}

	@Override
	public String email() {
		Map<String, Object> kakao_acount = (Map<String, Object>) oAuth2User.get("kakao_account");
		return (String) kakao_acount.get("email");
	}

}
