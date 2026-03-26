package com.ktdsuniversity.edu;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * End point 를 생성하는 역할
 */

@Controller
public class TestEndPointController {
	public TestEndPointController() {
		System.out.println("TestEndPointControlllererl " + this);
	}

	/**
	 * "/jsp" 엔드포인트 hellojsp.jsp 파읽 읽고 HTML로변환 후 반환
	 */
	@GetMapping("/jsp")
	public String viewHelloJspPage(Model model) {
		// Model model parameter ==> Transper data to Template Engine
		System.out.println(model);
		// myname 이라는 키("변수명")로 이름을 할당해 템플릿에게 주고싶당
		model.addAttribute("myname", "식케이");
		model.addAttribute("age", "30");
		System.out.println(model);
		return "hellojsp";
	}

	// "/hello" 엔드포인트 생성
	@GetMapping("/hello")
	// 사용자가 /hello 요청시 사용자에게 보여줄 html 페이지 생성
	public ResponseEntity<String> ViewHelloHtml() {
		// 사용자에게 보여줄 HTML 반환
		return new ResponseEntity<>("<h1>Hellow</h1>", HttpStatus.OK);
	}

	// 사용자가 /root 엔드포인트 접근시 첫 페이지임 화녕ㅇ요 를 브라우저 에 보내준다

	@GetMapping("/root")
	public ResponseEntity<String> ViewFirstHelloHtml() {

		return new ResponseEntity<>("gd this is your fist page, greetings ~", HttpStatus.OK);
	}

}
