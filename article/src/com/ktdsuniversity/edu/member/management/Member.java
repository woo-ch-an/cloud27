package com.ktdsuniversity.edu.member.management;

public class Member {
	private String id;
	private String name;
	
	public Member(String id, String name) {
		this.id = id;
		this.name = name;
	}
	public String getId() {
		return this.id;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	public void printInfo() {
		System.out.println("작성자 ID : " + this.id);
		System.out.println("작성자 이름 : " + this.name);
	}
	
}
