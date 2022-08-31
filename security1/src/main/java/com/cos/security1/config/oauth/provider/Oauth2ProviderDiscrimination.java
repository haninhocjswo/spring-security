package com.cos.security1.config.oauth.provider;

public interface Oauth2ProviderDiscrimination {

	public String username();
	public String provider();
	public String providerId();
	public String email();
}
