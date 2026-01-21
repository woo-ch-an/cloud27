package oop;

public class Merchant {
	// 판매자꺼
		int mistorageItem;
		int mifoundation;
		int miitemPrice;
		
		// 아이템을 판다 못팔면 못파는대로 알아서 한다
		// 수익을 저장한다
		// 창고관리를 한다
				
		public void reFreshStore(int iitemCount) {
			mistorageItem -= iitemCount;
			mifoundation += iitemCount * miitemPrice;
		}
		
		public void sellItem(int iproductCount) {
			if(mistorageItem <= 0) {
				System.out.println("품절 되었습니다");
			}
			if(mistorageItem < iproductCount) {
				// 가진거보다 많이 요청하면 가진거만큼만 판매				
				// 판매한 만큼 자본금 추가 + 스토리지 빼기
				reFreshStore(mistorageItem);
				
			}else {
				// 정상적 흐름일때
				reFreshStore(iproductCount);
			}
			System.out.println("판매자의 재고 수 : " + mistorageItem + " 판매자의 자본금 : " + mifoundation);
		}
}