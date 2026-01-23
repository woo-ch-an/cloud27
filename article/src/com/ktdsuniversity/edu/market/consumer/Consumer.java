package com.ktdsuniversity.edu.market.consumer;

import com.ktdsuniversity.edu.market.seller.Merchant;

public class Consumer {
	// white

	// 구매자측
	// 지갑, 장바구니
	// buyItem
		
	// 공통
	// 판매횟수 
	
	// 구매자꺼
	private int walletAccount;
	private int cartWeight ; //장바구니 영어 = 빠쓰꼤 무게한도임
	private int tradeCounter;
	private int itemWeight;
	
	public Consumer (int walletAccount, int cartWeight) {
		this.walletAccount = walletAccount; // 구매자 지갑 사정
		this.cartWeight  = cartWeight ; // 장바구니 무게 한도  
	}
	public int getWalletAccount() {
		return this.walletAccount;
	}

	public int getJangbaguni() {
		return this.cartWeight ;
	}

	public int getTradeCounter() {
		return this.tradeCounter;
	}

	public int getItemWeight() {
		return this.itemWeight;
	} 
	
	public void setWalletAccount(int walletAccount) {
		this.walletAccount =walletAccount;
	}
	public void setJangbaguni(int cart) {
		this.cartWeight  =cart; 
	}
	public void setTradeCounter(int counter) {
		this.tradeCounter = counter;
	}
	public void setItemWeight(int weight) {
		this.itemWeight = weight;
	}
	
	/**
	 * 구매자가 판매자에게 상품을 구매한다
	 * @param merchant 구매자에게 상품을 판매할 판매자 인스턴스
	 * @param productCount 구매자가 구매할 상품 갯수
	 */
	public void buyFrom(Merchant merchant, int productCount) {
		
		// 1. 두쫀쿠 productCount 만큼 있어요 ?
			 
		
		// 2-1. 판매자 : 있어유 -> 주세요
		if(merchant.isEnoughStock(productCount)) {
		// 3. 얼마에여
		
		// 4. 판매자 1000\.
			int price  = merchant.getPRICE();
		
		// 5. [ 내가 (1000 * 5) 원이 있나 
		// 5-1 있다
			if(this.isEnoughMoney(price * productCount)) {
				
		// 6. 무겁나요
		// 7. 500. g.
				int weight = merchant.getPRODUCT_WEIGHT();
		// 8. [ 내가 (500 * 5) g 들 수 있나
		// 8-1. 있다
				if(this.isEnoughtWeight(weight * productCount)) {
				
		// 9. 5개만 주세여
		// 10. 포장 processing ... -> 판매자 재고--;
					int stock = merchant.getStorageItem();
					stock -= productCount;
					merchant.setStorageItem(stock);
					
		// 11. 구매자 돈--, 무게++; , 판매자 계좌++;  공통 : 구매개수++
					this.walletAccount -= price * productCount;
					this.cartWeight -= weight * productCount;
					merchant.setFoundation(merchant.getFoundation() + (price * productCount));
					this.tradeCounter += productCount;
		// 12. 집으로
				}
				// 8-2. 없다 ( 리턴 
			}
			// 5-2 없다 (  경제활동 x  return
		}
		// 2-2. 판매자 : 없어유 -> 네 ( 경제활동 x) return
	}
	public boolean isEnoughtWeight (int weight) {
		return this.cartWeight >= weight;
	}
	
	public boolean isEnoughMoney(int money) {
		return this.walletAccount >= money;
	}
	
	// 돈이 있고 장바구니 무게 초과가 되지 않았으면 구매 가능
	public void buyItem(int proudctCount, int money,int weight) {
		
		if (this.walletAccount < money)
		{
			System.err.println(" 돈이 부족합니다 ");
		}
		else if(this.cartWeight  < weight) {
			System.err.println(" 더 이상 장바구니를 들 수 없습니다 ");
		}
		else {
			reFreshPoket(proudctCount, money, weight);			
		}
		System.out.println( "구매자의 상품 수 : " + this.tradeCounter + " 장바구니의 남은 무게 : " + cartWeight  + " 남은 돈 : " + walletAccount);
	}
		
	public void reFreshPoket(int proudctCount, int money,int weight) {
		this.tradeCounter += proudctCount; // 거래회수
		this.walletAccount -= money;
		this.cartWeight  -= weight;
	}
}
