package com.ktdsuniversity.edu.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserService;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.ktdsuniversity.edu.exceptions.handlers.AuthorizationDeniedExceptionHandler;
import com.ktdsuniversity.edu.members.dao.MembersDao;
import com.ktdsuniversity.edu.security.authenticate.filters.JsonWebTokenAuthenticationFilter;
import com.ktdsuniversity.edu.security.authenticate.handlers.LoginFailurHandler;
import com.ktdsuniversity.edu.security.authenticate.handlers.LoginSuccessHandler;
import com.ktdsuniversity.edu.security.authenticate.oauth.HelloSpringOauthService;
import com.ktdsuniversity.edu.security.authenticate.service.SecurityPasswordEncoder;
import com.ktdsuniversity.edu.security.authenticate.service.SecurityUserDetailsService;
import com.ktdsuniversity.edu.security.providers.JsonWebTokenAuthenticationProvider;
import com.ktdsuniversity.edu.security.providers.UsernameAndPasswordAuthenticationProvider;

// application.yml에서 작성할 수 없는 설정들을 적용하기 위한 Annotation
// @Component 의 자식 Annotation
@Configuration
// spring-boot-starter-validation 동작 활성화 시키기
// @EnableWebMvc가 추가되면 application.yml의 mvc 관련 설정들이 모두 무시된다.
//   1. spring.mvc.view.prefix, spring.mvc.view.suffix
//   2. src/main/resources/static 경로 사용 불가능.
@EnableWebMvc 
// 생략 가능
// Spring Security 라이브러리를 활성화 시킨다.
// Spring Security의 필터목록을 확인하기 위해서 작성한다.
@EnableWebSecurity(debug = false)
// Controller or ServiceCode 에서 권한 검사를 위한 에노텡싱셤ㄴㅇ성머ㅜ어수어ㅜㅅㅁ
@EnableMethodSecurity
public class HelloSpringConfiguration implements
		// WebMvc 설정을 위한 Configuration
		// @EnableWebMvc Annotation 에서 적용하는 기본 설정들을 변경하기 위함.
		WebMvcConfigurer {

	@Autowired(required=false) // Null이어도 프로그램은 살려주세요
	@Lazy //필요할떄 찾아주세요 (미리 적재 ㄴㄴ)
	private MembersDao membersDao;
	
	@Value("${app.jwt.secret-key}") // 환경설정정보를 Bean으로 가져오기 환경정보같은거 (운영체제 정보라던지 뭐 )
	private String jwtSecretKey;
	@Value("${app.jwt.issuer}")  // @Annotation (Component 가 적용된 클래스만 적용이 가낭함
	private String jwtIssuer; 
	
	@Bean
	JsonWebTokenAuthenticationProvider createJwtAuthenticationProvider() {
		return new JsonWebTokenAuthenticationProvider(this.jwtSecretKey,this.jwtIssuer);
	}

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
		return new LoginFailurHandler(this.membersDao);
	}
	
	@Bean
	OncePerRequestFilter createJwtAuthFilter() {
		return new JsonWebTokenAuthenticationFilter(this.createJwtAuthenticationProvider(), this.createUserDetailsService());
	}
	
	/**
	 * 특정 URL 에 대하여 Spring ecuri티 의 개입 받지 아니한다
	 * 저 아래에 모든 jsp 파일들은 SS의 간섭을 받지 아니한다라는뜼
	 * Controller에서 해당 페이지를 노출하려 할 떄 저 아래 갸ㅕㅇ로는 인증된 사영자에게 '만' 노출하려는 경우가 종재 
	 * 이때는 SS가 개입하지 않도록 설정한다
	 * @return
	 */
	
	@Bean 
	WebSecurityCustomizer webSecurityCustomizer() {
		return (web) -> web.ignoring().requestMatchers("/WEB-INF/views/**");
	}
	@Bean
	OAuth2UserService<OAuth2UserRequest, OAuth2User> createOAuth2UserService(){
		return new HelloSpringOauthService(this.membersDao);
	}
	
	// TODO Spring Login Filter(BasicAuthenticationFilter) 등록.
	// Spring Security의 기본 로그인 절차를 수정하는 작업.
	@Bean
	SecurityFilterChain configureFilterChain(HttpSecurity httpSecurity) {
		
		httpSecurity.oauth2Login(oauth2 -> oauth2.loginPage("/login")
												  
												  .userInfoEndpoint(endPoint -> 
												  								endPoint.userService(this.createOAuth2UserService())));
		
		//내 서버 접속가능한 URL 등ㄹㅗㄱ 
		// -> 내 서버로 접속 가능한 URL 등록 
		httpSecurity.cors(corsConfigurer -> {
			CorsConfigurationSource source = (httpServletRequest)->{
				// 다른 사이트의 허용할 도메인 rhk url 
				CorsConfiguration config = new CorsConfiguration();
//				config.addAllowedOrigin("http://192.168.211.15:8080"); 
				config.addAllowedOrigin("http://localhost:8080");
				// 허용할 타 사이트 정책 위 url + POST 접근허용하겠다라는뜻
				// 허용할 타 사이트 메소드
				config.addAllowedMethod("POST");
				config.addAllowedMethod("GET");
				// PUT DELETETE <  nono
				
				
				// http dycjd sdjfjsdfnkjaejf Header
				// WELCOME ALL THE HTTP HEADER 
				config.addAllowedHeader("*"); // 통행증은 ?  그런 건 없다.
				// 그날 관우는 5개의 관문을 지나며 6명의 장수를 참했고 훗날 이를 오관참육장 이라 하였다
				return config;
			};
			corsConfigurer.configurationSource(source);
		});
		
		// CSRF 체크 필터 머시기하기  (Invalid CSRF token Found for ...................... 왜살지 진짜 
		// CSRF 체쿠하는 읆ㅇ나하 ㅁ능릉를 무효화
//		httpSecurity.csrf(csrf -> csrf.disable());
		//API 통신은 csrf 없다 그런거 없다. !! 뎅강
		httpSecurity.csrf(csrf -> csrf.ignoringRequestMatchers("/api/**")); 
		
		// FIlter 등록하기 (1회용 토큰 관련) ;/ Custom Filter(JsonWebTokenAuthenticationFilter추가)
		httpSecurity.addFilterAfter(this.createJwtAuthFilter(), UsernamePasswordAuthenticationFilter.class);
		
		//AuthorizationDeniedExcpetioNHandler 에를 추가 COntroller 이하 에서 PreAuthorized() 검증에 실패시 실행
		httpSecurity.exceptionHandling(exceptionHandling -> exceptionHandling.accessDeniedHandler(new AuthorizationDeniedExceptionHandler()));
		
		
		
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
							 .failureHandler(this.createLoginFailurHandler())
		);
		
		// 10시 15분 시작.
		return httpSecurity.build();
	}

	// configureViewResolvers 설정
	// spring.mvc.view.prefix, spring.mvc.view.suffix 재설정
	@Override
	public void configureViewResolvers(ViewResolverRegistry registry) {
		registry.jsp("/WEB-INF/views/", ".jsp");
	}

	// addResourceHandlers
	// src/main/resources/static 경로의 endpoint 재설정
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		// /static/css/ 폴더에 있는 파일들에 대한 Endpoint 설정.
		registry.addResourceHandler("/css/**") // /static/css/ 의 엔드포인트
				.addResourceLocations("classpath:/static/css/"); // /static/css/ 의 물리적인 위치

		// /static/image/ 폴더에 있는 파일들에 대한 Endpoint 설정.
		registry.addResourceHandler("/image/**") // /static/image/ 의 엔드포인트
				.addResourceLocations("classpath:/static/image/"); // /static/image/ 의 물리적인 위치

		// /static/js/ 폴더에 있는 파일들에 대한 Endpoint 설정.
		registry.addResourceHandler("/js/**") // /static/js/ 의 엔드포인트
				.addResourceLocations("classpath:/static/js/"); // /static/js/ 의 물리적인 위치
	}
}