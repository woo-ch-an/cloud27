package com.ktdsuniversity.edu.abstracts;

/**
 * public class Name : 인스턴스로 생성할수 있는 일반 클래스 정의 public abstract class Name :
 * 인스턴스로 생성할 수 없는 추상 클래스 정의
 */
public abstract class AbstractMart {

	private int safe;
	private int productPrice;
	// 고객에게 거슬러 줄 돈
	private int remainMoney;

	public AbstractMart(int productPrice) {
		this.productPrice = productPrice;
	}

	// 추상
	public void sell(Guest guest, int sellCount) {
		int amount = sellCount * this.productPrice;
		int money = guest.getMoney();
		amount -= this.discount(guest, amount);

		int guestPoint = this.usePoit(guest);
		this.remainMoney = money;

		if (sellCount < 0) {
			return;
		}

		if (money + guestPoint < amount) {
			System.out.println("돈 모자랍니다 가격 : " + amount + " 낸 돈 : " + money);
			return;
		}

		// 손님의 지불
		guest.pay(money);

		this.givePoint(guest, amount);
		
		if(amount > guestPoint) {
			this.remainMoney -= amount - guestPoint;
		}
		
		this.safe += money - this.remainMoney;
		System.out.println("거슬러 줄 돈 " + this.remainMoney);

		// 마트의 지불
		guest.giveMoney(this.remainMoney);
		this.remainMoney = 0;

		System.out.println("매출액 " + this.safe);
	}

	// 사상
	public abstract int usePoit(Guest guest);

	public abstract void givePoint(Guest guest, int amount);

	public abstract int discount(Guest guest, int amount);
}
