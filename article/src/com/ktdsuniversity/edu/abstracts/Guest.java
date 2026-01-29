package com.ktdsuniversity.edu.abstracts;

public class Guest {

	private int money;
	private int point;

	public Guest(int money, int point) {
		this.money = money;
		this.point = point;
	}

	public int getPoint() {
		return this.point;
	}

	public int getMoney() {
		return this.money;
	}

	public void usePoint(int point) {
		this.point -= point;
	}

	public void addPoint(int point) {
		this.point += point;
	}

	public void giveMoney(int remainmoney) {
		this.money += remainmoney;
	}

	public void pay(int amount) {
		this.money -= amount;
	}

	@Override
	public String toString() {
		return "고객에게 남은 돈" + this.money;
	}
}
