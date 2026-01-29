package com.ktdsuniversity.edu.mart;

public class CustomerInfo {
	private String name; // 고객이름
	private String hierarchy; // 고객백화점 등급 // VIP VVIP 아니면 다 일반
	private float point; // 편의점 포인트
	private float score; // 백화점 포인트(점수로구분)
	private int money; // 현재가진돈

	public CustomerInfo(String name, String hierarchy, float point, float score, int money) {
		this.name = name;
		this.hierarchy = hierarchy;
		this.point = point;
		this.score = score;
		this.money = money;
	}

	public String getHierarchy() {
		return hierarchy;
	}

	public void setHierarchy(String hierarchy) {
		this.hierarchy = hierarchy;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getPoint() {
		return point;
	}

	public void setPoint(float point) {
		this.point = point;
	}

	public float getScore() {
		return score;
	}

	public void setScore(float score) {
		this.score = score;
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}
}
