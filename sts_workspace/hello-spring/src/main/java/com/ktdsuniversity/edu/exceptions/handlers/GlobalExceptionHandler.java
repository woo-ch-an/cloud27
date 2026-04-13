package com.ktdsuniversity.edu.exceptions.handlers;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ktdsuniversity.edu.exceptions.HelloSpringApiException;
import com.ktdsuniversity.edu.exceptions.HelloSpringException;


/**
 * Spring Application 에서 던져진 catch 되지 않은 예외들을 처리
 * 
 * @Controller 와 유사한 형태
 * URL 이 엔드포인트 ) 
 * 
 * @ControllerAdvice 
 * Exception이 엔드포인트 )
 */
@ControllerAdvice
public class GlobalExceptionHandler {
	
	private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);
	/**
	 * Hello스프링예외가 던져지면 viewErrorPage가 실행, 실행된 결과는 ModelAndView가 됨
	 * @return
	 */

	@ExceptionHandler(HelloSpringException.class)
	public String viewErrorPage(HelloSpringException hse, Model model) {
		logger.error(hse.getMessage(), hse);
		
		String message = hse.getMessage();
		model.addAttribute("errorMessage",message);
		String errorPage = hse.getErrorPage();
		Object modelData = hse.getObject();
		if(modelData != null) {
			model.addAttribute("errorData", modelData);
		}
		
		return errorPage;
	}
	
	@ResponseBody
	@ExceptionHandler(HelloSpringApiException.class)
	public Map<String, Object> returnErrorJson(HelloSpringApiException hsae, Model model){
		logger.error(hsae.getMessage(), hsae);
		
		int status = hsae.getErrorStatus();
		Object errorObject = hsae.getError();
		Map<String, Object> returnResponseData = new HashMap<>();
		returnResponseData.put("status", status);
		returnResponseData.put("error", errorObject);
		
		return returnResponseData;
	}
	
	@ExceptionHandler(RuntimeException.class)
	public String viewSystemErrorPage(RuntimeException re) {
		logger.error(re.getMessage(), re);
		return "errors/500";
	}

}