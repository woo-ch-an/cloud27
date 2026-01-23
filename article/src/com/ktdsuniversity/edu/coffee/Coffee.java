package com.ktdsuniversity.edu.coffee;

/**
 * <pre>
 * 
 *  커피 메뉴를 나타내는 데이터 클래스
 * 
 * </pre>
 */
public class Coffee {
	/** 
	 * 커피 메뉴 이름
	 */
	private String name;
	
	/**
	 * 커피 메뉴 가격
	 */
	private int price;
	
	/** 
	 * 하루동안 판매할 수 있는 커피의 양
	 */
	private int stock; 
	
	public Coffee(String name, int price, int stock) {
		this.name = name;
		this.price = price;
		this.stock = stock;
		// 생성자의 this -> 생성자의 자체 인스턴스
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
	
	public void setName(String name)
	{
		this.name = name;
	}
	public void setPrice(int price)
	{
		this.price = price;
	}
	public void setStock(int stock)
	{
		this.stock = stock;	
	}
	
	
}
