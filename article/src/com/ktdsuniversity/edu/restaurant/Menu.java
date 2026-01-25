package com.ktdsuniversity.edu.restaurant;

public class Menu {

	private String menuName;
	private float fillHunger;
	private float fillAlchol;
	private int price;
	
	public Menu(String menuName, float fillHunger, float fillAlchol, int price) {
		this.menuName = menuName;
		this.fillAlchol = fillAlchol;
		this.fillHunger = fillHunger;
		this.price = price;
	}
	public int getPrice() {
		return this.price;
	}
	public float getFillHunger() {
		return this.fillHunger;
	}
	public float getFillAlchol() {
		return this.fillAlchol;
	}
	public String getMenuName() {
		return this.menuName;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	public void setFillHunger(float fillHunger) {
		this.fillHunger = fillHunger;
	}
	public void setFillAlchol(float fillAlchol) {
		this.fillAlchol = fillAlchol;
	}
	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}
	
	// 
}
