package com.ktdsuniversity.edu.mart;

public class ConvenienceStore extends RegularMart {

	public ConvenienceStore(String name, Merchandise p1, Merchandise p2, Merchandise p3, Merchandise p4) {
		super(name, p1, p2, p3, p4);

	}

	// 포인트 적립 결제
	public void usingPointSellItem(CustomerInfo customer, int productNum, int qauntity) {
		float point = customer.getPoint();
		if (point > 100.0) { // 포인트를 사용
			// 현금처럼 사용 + 물품이 더 싸더라도 한번에 사용
			// => 사용자 지갑에 포인트만큼 돈을 추가 + 포인트 0으로 제거
			System.out.println("현재 포인트" + point + "를 사용하겠습니다. ");
			customer.setMoney(customer.getMoney() + (int) point);
			customer.setPoint(0f);
		}
		// 포인트 사용 불가능할 땐 그냥 지나가기

		int price = super.sellItems(customer, productNum, qauntity);

		// 포인트 쓰던 안쓰던 적립
		point = (price * 0.01f);

		System.out.println("구매해주셔서 감사합니다 이번 구매로 적립되는 포인트는 " + point + " 포인트 입니다 ");
		customer.setPoint(customer.getPoint() + point);

	}
}
