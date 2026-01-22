package oop;

public class Consumer {
	// white

	// 구매자측
	// 지갑, 장바구니
	// buyItem
		
	// 공통
	// 판매횟수 
	
	// 구매자꺼
	int miitemPrice;
	int miwalletAccount;
	int mijangbaguni; //장바구니 영어 = 빠쓰꼤 무게한도임
	int mitradeCounter;
	int miitemWeight;
	
	public Consumer (int miitemWeight, int miwalletAccount, int mijangbaguni, int miitemPrice) {
		this.miitemWeight = miitemWeight; // 상품 무게
		this.miwalletAccount = miwalletAccount; // 구매자 지갑 사정
		this.mijangbaguni = mijangbaguni; // 장바구니 무게 한도   
		this.miitemPrice = miitemPrice; // 상품 가격
	}
	
	// 돈이 있고 장바구니 무게 초과가 되지 않았으면 구매 가능
	public void buyItem(int iitemCount) {
		if (miwalletAccount < miitemPrice * iitemCount)
		{
			System.err.println(" 돈이 부족합니다 ");
		}
		else if(mijangbaguni < iitemCount * miitemWeight) {
			System.err.println(" 더 이상 장바구니를 들 수 없습니다 ");
		}
		else {
			reFreshPoket(iitemCount);			
		}
		System.out.println( "구매자의 상품 수 : " + mitradeCounter + " 장바구니의 남은 무게 : " + mijangbaguni + " 남은 돈 : " + miwalletAccount);
	}
	
	public void reFreshPoket(int iitemCount) {
		mitradeCounter += iitemCount; // 거래회수
		miwalletAccount -= miitemPrice * iitemCount;
		mijangbaguni -= miitemWeight * iitemCount;
	}
}
