package com.ktdsuniversity.edu.abstracts;

public class DepartmentStore extends AbstractMart {

	public DepartmentStore(int productPrice) {
		super(productPrice);
	}
	
	@Override
	public int usePoit(Guest guest) {
		return 0;
	}
	
	// guest의 instance type으로 구분해서 차등적용
	@Override
	public void givePoint(Guest guest, int amount) {
		
		int point = 0;
		
		if ( guest instanceof VVIP vvip) {
			// 3% 적립
			point = (int) (amount * 0.3f);
			
		}else if( guest instanceof VIP vip) {
			// 적립 없음
			point = (int) (amount * 0f);
		}
		else {			
			// 0.5% 적립
			point = (int) (amount * 0.05f);
		}

		guest.addPoint(point);
	}
	@Override
	public int discount(Guest guest, int amount) {
		int discount = 0;
			
		if ( guest instanceof VVIP vvip) {
			// 10% 할인
			discount = (int) (amount * 0.9f);
			
		}else if( guest instanceof VIP vip) {
			// 3% 할인
			discount = (int) (amount * 0.97f);
		}
		else {			
			// 할인없음
			discount = (int) (amount * 1f);
		}
		return discount;
	}
}
