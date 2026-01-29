package com.ktdsuniversity.edu.mart;

public class Merchandise {

	private String name; // 상품명
	private int stock; // 재고
	private int price; // 가격

	public Merchandise(String name, int stock, int price) {
		this.name = name;
		this.stock = stock;
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

}
