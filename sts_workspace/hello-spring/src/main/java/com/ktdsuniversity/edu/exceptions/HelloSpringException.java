package com.ktdsuniversity.edu.exceptions;

public class HelloSpringException extends RuntimeException {

	private static final long serialVersionUID = 5344517791626726005L;

	// 예외 발생시 사용자에게 보여주고싶은 페이지 (템플릿 또는 뷰) 이름
	private String errorPage;

	// 사용자에게 보여주고 싶은 페이지 (템플릿 or 뷰 ) 에 보내줄 모델 데이터
	private Object object;
 
	public HelloSpringException(String errorPage, String message) {
		super(message);
		this.errorPage = errorPage;
	}

	public HelloSpringException(String errorPage, String message, Object object) {
		super(message);
		this.errorPage = errorPage;
		this.object = object;
	}

	public String getErrorPage() {
		return this.errorPage;
	}

	public Object getObject() {
		return this.object;
	}
 
}
