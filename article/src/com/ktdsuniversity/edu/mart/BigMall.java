package com.ktdsuniversity.edu.mart;

public class BigMall extends RegularMart {

	public BigMall(String name, Merchandise p1, Merchandise p2, Merchandise p3, Merchandise p4) {
		super(name, p1, p2, p3, p4);

	}
	// 백화점
	// + 포인트 0.5%
	// + 회원제
	// 일반 - 할인 x 0.5% 적립
	// VIP - 3%할인 적립x
	// VVIP - 10%할인 적립3%

	// 할인 먼저 적용 후 계급에 맞게 결제
	// 고객이 원하는 결제금이 있는지 확인 requsetScore : -1 있는거 다 씀, 0 사용안함, 나머진 원하는 만크ㅁ
	public void usingScoreSellItem(CustomerInfo customer, int productNumber, int quantity, int requsetScore) {
		float score = customer.getScore();
		float useScore = 0;
		float scoreWight = 0f; // 스코어 가중치
		float priceWight = 0;

		String customerHierarchy = customer.getHierarchy();

		// 주문 맞는지 먼저 보기
		if (!super.checkOrder(productNumber, quantity)) {
			return;
		}

		if (customerHierarchy.equals("VIP")) {
			// VIP 님
			// 3% 할인 적립금 없음
			scoreWight = 0f;
			priceWight = 0.97f;

		} else if (customerHierarchy.equals("VVIP")) {
			// WIP 고객님
			// VVIP - 10%할인 적립3%
			scoreWight = 0.3f;
			priceWight = 0.9f;
		} else {
			// VIP, VVIP 아니면 다 일반고객 취급
			scoreWight = 0.05f;
			priceWight = 1f;
		}

		if (score > 10000.0 && requsetScore != 0) { // 적립금 사용 10_000원부터 && 사용자가 사용원할 때
			// 현금처럼 사용 + 물품이 더 싸더라도 한번에 사용
			// => 사용자 지갑에 포인트만큼 돈을 추가 + 포인트 0으로 제거
			if (requsetScore > score) {
				// 가진 적립금보다 요청 적립금이 큰 경우
				System.out.println("적립금이 모자랍니다 사용 할 수 있는 만큼 사용합니다");
				// 가진거라도 다 쓰게 하기
				requsetScore = -1;

			}

			if (requsetScore == -1) {
				// 가진거 다 쓰는 경우
				useScore = score;
			} else {
				useScore = requsetScore;
			}
			System.out.println("적립금" + useScore + "만큼 사용하겠습니다. ");

			customer.setMoney(customer.getMoney() + (int) useScore);
			customer.setScore(0f);
		}
		// 포인트 사용 불가능할 땐 그냥 지나가기
		// 정산 시작
		int price = super.sellItems(customer, productNumber, quantity, priceWight);

		// 스코어 일단 계산
		score = (price * scoreWight);

		System.out.println("구매해주셔서 감사합니다 이번 구매로 적립되는 적립금은 " + score + " 점 입니다 ");
		customer.setScore(customer.getScore() + score);

	}

}