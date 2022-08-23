package com.cos.security1.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity	//스프링 시큐리티 필터가 스프링 필터 체인에 등록됨.
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Bean
	public BCryptPasswordEncoder encodePwd() {
		return new BCryptPasswordEncoder();
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable();	
		http.authorizeRequests()
			// /user/** 의 종류의 url을 요청 시 인증(로그인)을 해야한다.
			.antMatchers("/user/**").authenticated()	
			// /manager/** 의 종류의 url을 요청 시 인증(로그인)과 ROLE_ADMIN 혹은 ROLE_MANAGER의 자격을 갖춰야한다.
			.antMatchers("/manager/**").access("hasRole('ROLE_ADMIN') or hasRole('ROLE_MANAGER')")
			// /admin/** 의 종류의 url을 요청 시 인증(로그인)과 ROLE_ADMIN의 자격을 갖춰야한다.			
			.antMatchers("/admin/**").access("hasRole('ROLE_ADMIN')")
			// 나머지 url 요청은 허용한다.
			.anyRequest().permitAll()
			.and()
			// 로그인을 했을 시 login화면으로 이동
			.formLogin()
			// 로그인 페이지 주소
			.loginPage("/loginForm");

	}
}
