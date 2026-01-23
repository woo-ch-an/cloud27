package com.ktdsuniversity.edu.vendingmachine.item;

/**
 * 음료수 종류를 나타내는 데이터 클래스
 */
public class Vending {
	
	private String name;
	private int price;
	private int stock;
	
	public Vending(String name, int price, int stock)
	{
		this.name = name;
		this.price = price;
		this.stock = stock;
	}
	
	public String getName() {
		return this.name;
	}
	public int getPrice() {
		return this.price;
	}
	public int getStock() {
		return this.stock;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
}
