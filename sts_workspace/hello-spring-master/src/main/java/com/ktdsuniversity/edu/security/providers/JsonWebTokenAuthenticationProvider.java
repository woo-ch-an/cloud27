package com.ktdsuniversity.edu.security.providers;

import java.time.Duration;
import java.util.Date;

import javax.crypto.SecretKey;

import org.springframework.context.annotation.Bean;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

/**
 * 사용자의 정보를 이용해 인증 객체를 생성하고 검증하는 객체)클래스 )ㄴ ㅇㅁㄴ Pring Security의 ㅁㅇ ㅁ눠와는 ㅁ무관하다
 * 사용목적 : APi 호출할 떄 인증수단으로 사용하기 위해서
 */
public class JsonWebTokenAuthenticationProvider {
	private String secretKey;
	private String issuer;
 
	public JsonWebTokenAuthenticationProvider(String secretKey, String issuer){
		this.secretKey = secretKey;
		this.issuer = issuer;

	}

	/**
	 * 사용자가 요청할 때 마다 Request Header [Autorization ] 에 전달하는 Json Web Token 가져와서복호화
	 * 한거의 결과에서 사용자의 이메일을(identify) 추출하여 반환
	 * 
	 * @param jsonWebToken 사용자가 전달하는토 큰값
	 * @return JsonWebToken에서 추출하는 사용자의 이메일
	 */
	public String decryptJsonWebToken(String jsonWebToken) {

		SecretKey key = Keys.hmacShaKeyFor(this.secretKey.getBytes());

		Claims claims = Jwts.parser() // JWT 를 분석하기 위한 선언
				.verifyWith(key) // JWT 복호화를 위한 비밀 키 지정
				.requireIssuer(this.issuer) // 사용자의 JWT가 hello-spring에서 만든건지 확인하기 (최소한의 검증) 내껀가 ?이름보기
				.build() // JWT 복호화 ON
				.parseSignedClaims(jsonWebToken) // 사용자가 전달한 JWT 복호화
				.getPayload(); // 복호화된 결과에서 Claim스 만모아서 반환하기 (Map의 형태로 들어있음) 우리경우엔 identify 꺼내오면 되겠죵

		// JWT 복호화 후 아이디 값 추출하기, 를 반환
		String email = claims.get("identify", String.class);

		return email;
	}

	/**
	 * 사용자의 이메일을 이용해 인증용 JWT 를 생성
	 * 
	 * @param email     사용자의 이메일
	 * @param expriedAt JWT 의 유효기간 ( 지금으로부터 ~분 시간ㄴ일월연까지다됨) *기간이 길면 길수록 위험해진다
	 * @return email, expiredAt으로 생성한 JsonWebToken 반환
	 */
	public String makeJsonWebToken(String email, Duration expriedAt) {
		Date issueDate = new Date();

		Date expirationDate = new Date(issueDate.getTime() + expriedAt.toMillis());

		SecretKey key = Keys.hmacShaKeyFor(this.secretKey.getBytes());

		String jsonWebToken = Jwts.builder().issuer("hello-spring").subject(email + "_token").claim("identify", email)
				.issuedAt(issueDate).expiration(expirationDate).signWith(key).compact();

		return jsonWebToken;
	}

	public static void main(String[] args) {
		JsonWebTokenAuthenticationProvider jwtProvide = new JsonWebTokenAuthenticationProvider("sndfjansknfjkajefnjkaelfnaleknfkjanefjkneas", "hello-spring");

		String jwt = jwtProvide.makeJsonWebToken("test@email.com", Duration.ofHours(3)); 

		System.out.println(jwt);

		String email = jwtProvide.decryptJsonWebToken(jwt);
		System.out.print(email);
	}
}
