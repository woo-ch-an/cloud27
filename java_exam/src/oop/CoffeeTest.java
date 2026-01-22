package oop;

public class CoffeeTest {
	
	public static void main(String[] args) {
		
		Coffee hotCoffee = new Coffee("Armericano HOT", 4500); 
		Coffee iceCoffee = new Coffee("IcedTea", 4000);
		
		CoffeeShop starbucks = new CoffeeShop(hotCoffee, iceCoffee);
		
		int price;
		
		price = starbucks.orderCoffee(1, 3);
		System.out.println("price : " + price);
		
		price = starbucks.orderCoffee(2, 4);
		System.out.println("price : " + price);
		

		price = starbucks.orderCoffee(3, 6);
		System.out.println("price : " + price);
	}
}
