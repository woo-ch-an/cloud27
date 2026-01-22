package oop;

public class CoffeeArrayTest {
	
	public static void main(String[] args) {
		
		Coffee hotCoffee = new Coffee("Armericano HOT", 4500); 
		Coffee iceCoffee = new Coffee("IcedTea", 4000);
		Coffee tea = new Coffee("Caemomile Tea", 5000);
		
		CoffeeShopArray starbucks = new CoffeeShopArray(hotCoffee, iceCoffee, tea);
		
		int price;
		price = starbucks.orderCoffee(0, 4);
		System.out.println("price : " + price);
		
		price = starbucks.orderCoffee(1, 3);
		System.out.println("price : " + price);
		
		price = starbucks.orderCoffee(2, 3);
		System.out.println("price : " + price);

		price = starbucks.orderCoffee(3, 5);
		System.out.println("price : " + price);
	}
}
