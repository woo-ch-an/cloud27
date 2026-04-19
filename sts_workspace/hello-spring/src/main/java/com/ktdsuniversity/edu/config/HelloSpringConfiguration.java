package com.ktdsuniversity.edu.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.ktdsuniversity.edu.members.dao.MembersDao;
import com.ktdsuniversity.edu.security.authenicate.handlers.LoginFailureHandler;
import com.ktdsuniversity.edu.security.authenicate.handlers.LoginSuccessHandler;
import com.ktdsuniversity.edu.security.authenicate.service.SecurityPasswordEncoder;
import com.ktdsuniversity.edu.security.authenicate.service.SecurityUserDetailsService;
import com.ktdsuniversity.edu.security.providers.UsernameAndPasswordAuthenticationProvider;

// Application.yml 에서 작성할 수 없는 설정들을 적용하기위한 @Configuration ,
@Configuration
//Spring-boot-starter-validation 동작 활성화 , @EnableWebMvc 가 추가되면 application.yml의 설정들을 무시 
// spring.mvc.view.prefix, spring.mvc.view.suffix , src/main/resources/static 경로 사용 불가능
@EnableWebMvc
public class HelloSpringConfiguration implements WebMvcConfigurer {

	@Autowired
	private MembersDao membersDao;

	// SecurityPasswordEncoder의 Bean을 생성한다.
	@Bean // 메소드가 실행되어서 반환되는 객체를 Bean Container에 적재한다.
	PasswordEncoder createPasswordEncoder() {
		return new SecurityPasswordEncoder();
	}

	// SecurityUserDetailsService의 Bean을 생성한다.
	// @Bean으로 생성하는 객체(Bean)들은 필요한 의존 객체를 생성자로 주입해 주어야 한다.
	@Bean
	UserDetailsService createUserDetailsService() {
		return new SecurityUserDetailsService(this.membersDao);
	}

	// UsernameAndPasswordAuthenticationProvider의 Bean을 생성한다.
	@Bean
	AuthenticationProvider createAuthenticationProvider() {
		UserDetailsService userDetailsService = this.createUserDetailsService();
		PasswordEncoder passwordEncoder = this.createPasswordEncoder();

		return new UsernameAndPasswordAuthenticationProvider(userDetailsService, passwordEncoder);
	}

	@Bean
	AuthenticationSuccessHandler createLoginSuccessHandler() {
		return new LoginSuccessHandler(this.membersDao);
	}

	@Bean
	AuthenticationFailureHandler createLoginFailurHandler() {
		return new LoginFailureHandler(this.membersDao);
	}

	@Bean
	SecurityFilterChain configureFilterChain(HttpSecurity httpSecurity) {
		// UsernamePasswordAuthenticationFilter 수정.
		httpSecurity.formLogin(formLogin ->
		// Login URL 지정.
		formLogin.loginPage("/login")
				// Login 인증 처리 URL 지정
				// (UsernameAndPasswordAuthenticationProvider가 실행될 Endpoint)
				.loginProcessingUrl("/login-provider")
				// 로그인에 필요한 아이디 파라미터 이름을 "username"에서 "email"로 변경한다.
				.usernameParameter("email")
				// 로그인에 성공하면 뭐할까?
				// this.membersDao.updateSuccessLogin(loginVO); 실행해야 한다.
				.successHandler(this.createLoginSuccessHandler())
				// 로그인에 실패하면 뭐할까?
				// this.membersDao.updateIncreaseLoginFailCount(loginVO.getEmail());
				// this.membersDao.updateBlock(loginVO.getEmail());
				.failureHandler(this.createLoginFailurHandler()));

		// 10시 15분 시작.
		return httpSecurity.build();
	}

	// WebMvc 설정을 위한 Configuration / @EnableWebMvc에 적용하는 기본 설정들을 변경하기 위함

	// ConfigureViewResolver 설정
	// spring.mvc.view.prefix, spring.mvc.view.suffix 사용 setting @Override
	public void configureViewResolvers(ViewResolverRegistry registry) {
		registry.jsp("/WEB-INF/views/", ".jsp");

	}

	// addResourceHandlers Set
	// src/main/resources/static 경로 사용 setting
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		// static/css/ 폴더의 파일들의 Endpoint, 물리적인 위치 적어주기
		registry.addResourceHandler("/css/**").addResourceLocations("classpath:/static/css/");

		// iamge랑 JS도
		registry.addResourceHandler("/image/**").addResourceLocations("classpath:/static/image/");
		registry.addResourceHandler("/js/**").addResourceLocations("classpath:/static/js/");
	}

}
