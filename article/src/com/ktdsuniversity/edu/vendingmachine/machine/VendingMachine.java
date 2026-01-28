package com.ktdsuniversity.edu.vendingmachine.machine;

import com.ktdsuniversity.edu.vendingmachine.item.Vending;

public class VendingMachine {

	private int remainmoney;
	private Vending[] products;

	public VendingMachine(Vending backass, Vending monster, Vending hotsix, Vending milkis) {
		this.products = new Vending[4];
		this.products[0] = backass;
		this.products[1] = monster;
		this.products[2] = hotsix;
		this.products[3] = milkis;

	}

	public int getRemainmoney() {
		return remainmoney;
	}

	public void setRemainmoney(int remainmoney) {
		this.remainmoney = remainmoney;
	}

	public Vending[] getProducts() {
		return products;
	}

	public void setProducts(Vending[] products) {
		this.products = products;
	}

	/**
	 * 주문하기 (제품 번호 , 주문수량) return = 구매금액 주문을 하면 주문 수량만큼 자판기 음료수 재고가 감소 재고가 없으면 품절
	 * 
	 * 환불받는거 추가 환불 조건 : 1. 돈넣고 다른 메뉴 골랐을 때 환불 2. 돈넣고 메뉴 고르고 남은 돈 3. 환전 버튼으로 구현
	 * orderDrink -> request drink| 지폐;동전; 구분않고 그냥 돈 총액으로 구분
	 */

	public int orderDrinks(int menu, int quantity, int money) {
		int iprice;

		if (menu < 0 || menu >= this.products.length) {
			System.err.println("없는 메뉴 입니다 다시 시도하세요");
			this.remainmoney = money;
			return 0;
		}

		Vending drink = this.products[menu];

		iprice = drink.getPrice() * quantity;
		
		int t = 0; 
		if(money < iprice) {
			// 돈 모자랄 때
			t = money/drink.getPrice();
			if(money / drink.getPrice()  > 0) {
				// 1개라도 살 수 있는 경우
				
				// 검산 
				// 가진돈 >=      가격     *    살 수 있는 개수 
				if (money >= (drink.getPrice() * (money / drink.getPrice()))) {
					quantity = money / drink.getPrice();
					System.out.println("돈이 부족합니다." + quantity + " 개 주문만 처리됩니다.");
				}
			}
		}
		

		if (drink.getStock() == 0) { // || drink.stock < quantity) {
			System.err.println("해당 상품이 품절되었습니다");
			this.remainmoney = money;
			return 0;
		} else if (drink.getStock() < quantity) {
			// 남은 상품보다 많이 주문했을 때
			System.out.println("재고가 부족합니다 " + drink.getStock() + " 개 주문만 처리됩니다.");
			quantity = drink.getStock();
		}
		
		if(money >= iprice) {
			// 가격보다 내 돈이 많거나 딱맞거나
			drink.setStock(drink.getStock() - quantity);
			money -= iprice; 
			this.remainmoney = money;
			System.out.println(drink.getName() + " 음료를 " + quantity + " 개 주문하였습니다 가격은 " + iprice + " 원 입니다");			
		}
		else {
			System.out.println("돈이 부족합니다 ");
		}

		return iprice;
	}

	/**
	 * 입고하기 (제품 번호, 입고수량) return = 없음 입고하면 수량만큼 재고 증가 자판기에 없는 항목은 do nothing
	 */
	public void insertDrink(int menu, int quantity) {
		if (menu < 0 || menu >= this.products.length) {
			return;
		}

		Vending drink = this.products[menu];
		drink.setStock(drink.getStock() + quantity);
	}

	/**
	 * 모든 상품 재고 출력 () return 없음 걍 상품 다 출력하기
	 */
	public void printStock() {
		System.out.println();

		System.out.println("--------- --- ----재고출력--------- --- ----");
		for (int i = 0; i < this.products.length; i++) {
			Vending drink = this.products[i];

			System.out.println("상품명 : " + drink.getName() + " 의 재고는 " + drink.getStock() + " 입니다.");
		}

		System.out.println("--------- --- ----ㅡㅡㅡㅡ--------- --- ----");
	}
}
