package com.ktdsuniversity.edu.vendingmachine.machine;

import com.ktdsuniversity.edu.vendingmachine.item.Vending;

public class VendingRefund extends VendingMachine {

	public VendingRefund(Vending backass, Vending monster, Vending hotsix, Vending milkis) {
		super(backass, monster, hotsix, milkis);

	}

	// 환불 버튼 클릭 super클래스에서 남은돈 확인해야함
	public int pressRefundBtn() {
		int money = super.getRemainmoney();

		if (money > 0) {
			System.out.println(money + "원 반환되었습니다");

		} else {
			System.out.println("반환할 돈이 없습니다.");
			money = 0;
		}
		super.setRemainmoney(0); // 돌려줄 돈 없음
		return money;
	}

}
