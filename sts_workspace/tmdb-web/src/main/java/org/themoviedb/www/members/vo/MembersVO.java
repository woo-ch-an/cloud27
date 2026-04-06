package org.themoviedb.www.members.vo;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class MembersVO {
	@NotEmpty(message = "이메일을 입력해주세yo")
	@Email(message="이메일을 형식에 맞게 입력해주seyo")
	private String email; 
	@NotEmpty(message = "이름을 입력해주세yo")	
	@Size(min = 2, max = 10, message = "2 ~ 10글자 사이로 입력해 주seyo")
	private String name; 
	@Pattern(regexp = "^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[a-zA-Z]).{8,}$", 
			message = "특수문자,대문자,소문자,숫자를 하나이상 포함하세yo")
	private String password;
	private String salt;
	
	public String getSalt() {
		return this.salt;
	}
	public void setSalt(String salt) {
		this.salt = salt;
	}
	public String getEmail() {
		return this.email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getName() {
		return this.name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return this.password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "MemberVO [email=" + email + ", name=" + name + ", password=" + password + "]";
	}  
}
