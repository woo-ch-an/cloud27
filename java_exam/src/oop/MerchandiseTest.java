package oop;

public class MerchandiseTest {
	public static void main(String[] args) {
		Merchant merchant = new Merchant(10, 500, 1000);
		Consumer consumer = new Consumer(500, 10000, 2000, 1000);
		
		
		merchant.sellItem(5);
		merchant.sellItem(2);
		merchant.sellItem(5);
		
		consumer.buyItem(4);
	}
}
