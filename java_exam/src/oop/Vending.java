package oop;

/**
 * 음료수 종류를 나타내는 데이터 클래스
 */
public class Vending {
	
	String name;
	int price;
	int stock;
	
	public Vending(String name, int price, int stock)
	{
		this.name = name;
		this.price = price;
		this.stock = stock;
	}

}
