package com.ktdsuniversity.edu.article.management;

import com.ktdsuniversity.edu.member.management.Member;

public class Article {
	
	String title;
	String content;
	Member 작성자;
	// String authorName;
	// String authorId;
	
	public Article(String title, Member 작성자, String content) {
		this.title = title;
		this.작성자 = 작성자;
		this.content = content;
	}
	
	public void viewArticleDescription() {
		// 변수 모두 출력
		System.out.println("제목 : "  + this.title);
		System.out.println("내용 : " + this.content);
		
		System.out.println("작성자 ID : " + this.작성자.getId());
		System.out.println("작성자 이름 : " + this.작성자.getName());
	}
	
	public static void main(String[] args) {
		Member 작성자 = new Member("super","관리자");
		
		Article article = new Article("제곧", 작성자, "내용");
		article.viewArticleDescription(); 
	}
}
