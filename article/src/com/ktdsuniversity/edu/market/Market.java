package com.ktdsuniversity.edu.market;

import com.ktdsuniversity.edu.market.consumer.Consumer;
import com.ktdsuniversity.edu.market.seller.Merchant;

public class Market {
	
	public static void main(String[] args) {
		Merchant merchant = new Merchant(100);
		Consumer consumer = new Consumer(100000, 6000);
		
		// 구매자가 판매자에게 물품을 5개 구매한다
		consumer.buyFrom(merchant, 8); 
		
		System.out.println("구매개수 : " + consumer.getTradeCounter());
		System.out.println("중량 : " + consumer.getJangbaguni());
		System.out.println("지갑 : " + consumer.getWalletAccount());
		
		System.out.println("재고 : " + merchant.getStorageItem());
		System.out.println("자금 : " + merchant.getFoundation());
		
		// 구매자가 상품을 구매하려면 판매자가 판매를 먼저 해야 한다
		
//		int stock = merchant.getStorageItem();
//		int price = merchant.getPRICE();
//		int weight = merchant.getPRODUCT_WEIGHT();
//		
//		if(stock >= 5 &&
//				(price * 5) <= consumer.getWalletAccount() &&
//				(weight * 5) <= consumer.getJangbaguni()
//				) {
//		
//		merchant.sellItem(5);
//		consumer.buyItem(5, price * 5,  weight * 5);
//		}
	}
}
