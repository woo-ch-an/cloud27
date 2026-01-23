package com.ktdsuniversity.edu.restaurant;



public class Guest {
	private String name;
	private float drunken;
	private float hunger;
	private int payAccount;
	private int guestsMenu;

	public Guest(String name, float drunken, float hunger, int payAccount) {
		this.name = name;
		this.drunken = drunken;
		this.hunger = hunger;
		this.payAccount = payAccount;
		this.guestsMenu = (int)Math.random(); // 랜덤으로 원하는 메뉴 선택하기
	}
	
	public String getName() {
		return this.name;
	}
	public float getDrunken() {
		return this.drunken;
	}
	public float getHunger() {
		return this.hunger;
	}
	public int getPayAccount() {
		return this.payAccount;
	}
	public int getGuestsMenu() {
		return this.guestsMenu;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	public void setDrunken(float drunken) {
		this.drunken = drunken; 
	}
	public void setHunger(float hunger) {
		this.hunger = hunger;
	}
	public void getPayAccount(int payAccount) {
		this.payAccount = payAccount;
	}
}
