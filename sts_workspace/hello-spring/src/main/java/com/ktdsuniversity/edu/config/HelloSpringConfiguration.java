package com.ktdsuniversity.edu.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.ktdsuniversity.edu.config.interceptors.IllegalAccessInterceptor;
import com.ktdsuniversity.edu.config.interceptors.SessionInterceptor;

// Application.yml 에서 작성할 수 없는 설정들을 적용하기위한 @Configuration ,
@Configuration
//Spring-boot-starter-validation 동작 활성화 , @EnableWebMvc 가 추가되면 application.yml의 설정들을 무시 
// spring.mvc.view.prefix, spring.mvc.view.suffix , src/main/resources/static 경로 사용 불가능
@EnableWebMvc
public class HelloSpringConfiguration implements WebMvcConfigurer {
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
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		SessionInterceptor sessioninterceptor = new SessionInterceptor();
		
		registry.addInterceptor(sessioninterceptor).addPathPatterns("/**").excludePathPatterns(
				"/regist/check/duplicate/**", // 회원가입 이메일 중복 검사.
				"/regist", // 회원가입 페이지 & 처리
				"/login", // 로그인 페이지 & 처리
				"/js/**", // static resources
				"/css/**", // static resources
				"/image/**", // static resources
				"/", // 게시글 목록 조회
				"/view/**", // 게시글 내용 조회
				"/file/**" // 첨부파일 다운로드
				); // sessionInterceptor가 적용되지 않을 URL 명시.
		
		IllegalAccessInterceptor illegalAccessInterceptor = new IllegalAccessInterceptor();
		registry.addInterceptor(illegalAccessInterceptor).addPathPatterns(
				"/regist/check/duplicate/**", // 회원가입 이메일 중복 검사.
				"/regist", // 회원가입 페이지 & 처리
				"/login" // 로그인 페이지 & 처리
				);
		
	} 

}
