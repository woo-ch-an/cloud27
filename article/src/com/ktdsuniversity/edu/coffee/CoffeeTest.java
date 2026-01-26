package com.ktdsuniversity.edu.coffee;

public class CoffeeTest {
	
	public static void main(String[] args) {
		
		Coffee hotCoffee = new Coffee("Armericano HOT", 4500, 200); 
		Coffee iceCoffee = new Coffee("IcedTea", 4000, 50);
		
		String str1 = "asd";
		String str2 = "dsa";
		
		// CoffeeShop starbucks = new CoffeeShop(hotCoffee, iceCoffee);
		CoffeeShop starbucks = new CoffeeShop();

		int price;
		
		price = starbucks.orderCoffee();
		System.out.println("price : " + price);
		
		price = starbucks.orderCoffee(2);
		System.out.println("price : " + price);
		
		price = starbucks.orderCoffee(3, 500);
		System.out.println("price : " + price);

		price = starbucks.orderCoffee(1, 150);
		System.out.println("price : " + price);

		price = starbucks.orderCoffee(1, 150);
		System.out.println("price : " + price);
	}
}
