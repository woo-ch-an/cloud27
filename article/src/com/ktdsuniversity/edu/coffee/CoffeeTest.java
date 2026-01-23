package com.ktdsuniversity.edu.coffee;

public class CoffeeTest {
	
	public static void main(String[] args) {
		
		Coffee hotCoffee = new Coffee("Armericano HOT", 4500, 200); 
		Coffee iceCoffee = new Coffee("IcedTea", 4000, 50);
		
		CoffeeShop starbucks = new CoffeeShop(hotCoffee, iceCoffee);
		
		int price;
		
		price = starbucks.orderCoffee(1, 30);
		System.out.println("price : " + price);
		
		price = starbucks.orderCoffee(2, 400);
		System.out.println("price : " + price);
		
		price = starbucks.orderCoffee(3, 500);
		System.out.println("price : " + price);

		price = starbucks.orderCoffee(1, 150);
		System.out.println("price : " + price);

		price = starbucks.orderCoffee(1, 150);
		System.out.println("price : " + price);
	}
}
