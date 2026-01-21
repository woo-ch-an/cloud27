package oop;

public class MerchandiseTest {
	public static void main(String[] args) {
		Merchant merchant = new Merchant();
		Consumer consumer = new Consumer();

		// 지정해줘야 하는 값
		// 판매자쪽 
		merchant.mistorageItem = 10; // 상품 갯수
		merchant.mifoundation = 500; // 초기자본
		merchant.miitemPrice = 1000; // 상품 가격
		
		// 구매자쪽
		consumer.miitemWeight = 500; // 상품 무게
		consumer.miwalletAccount = 20000; // 구매자 지갑 사정
		consumer.mijangbaguni = 2000; // 장바구니 무게 한도   
		consumer.miitemPrice = 1000; // 상품 가격
		
		merchant.sellItem(5);
		
		consumer.buyItem(4);
	}
}
