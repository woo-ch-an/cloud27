package com.ktdsuniversity.edu.market.seller;

public class Merchant {
	// 판매자꺼
		private int storageItem;
		private int foundation;
		final private int PRICE = 1000;
		final private int PRODUCT_WEIGHT = 500;
		
			
		public Merchant (int storageItem) {
			this.storageItem = storageItem; // 상품 갯수
		}
		
		public int getStorageItem() {
			return this.storageItem;
		}
		public int getFoundation() {
			return this.foundation;
		}
		public int getPRICE() {
			return this.PRICE;
		}
		public int getPRODUCT_WEIGHT() {
			return this.PRODUCT_WEIGHT;
		}
		
		public void setStorageItem(int item) {
			this.storageItem = item;
		}
		public void setFoundation(int foundation) {
			this.foundation = foundation; 
		}
		
		// 아이템을 판다 못팔면 못파는대로 알아서 한다
		// 수익을 저장한다
		// 창고관리를 한다
		
		public void reFreshStore(int itemCount) {
			this.storageItem -= itemCount;
			this.foundation += itemCount * this.PRICE;
		}
		
		public boolean isEnoughStock(int itemCount) {
			if(this.storageItem >= itemCount) {
				return true;
			}
			else {
				return false;
			}
		}
		
		public void sellItem(int productCount) {
			if(this.storageItem <= 0) {
				System.out.println("품절 되었습니다");
			}
			else {
			if(this.storageItem < productCount) {
				// 가진거보다 많이 요청하면 가진거만큼만 판매				
				// 판매한 만큼 자본금 추가 + 스토리지 빼기
				reFreshStore(this.storageItem);
				System.out.println("품절 되었습니다");
				
			}else {
				// 정상적 흐름일때
				reFreshStore(productCount);
			}
			System.out.println(	"판매자의 재고 수 : " + this.storageItem + 
								" 판매자의 자본금 : " + this.foundation);
		}
	}
}