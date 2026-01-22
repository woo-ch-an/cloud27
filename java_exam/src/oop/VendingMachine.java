package oop;

public class VendingMachine {

	Vending[] products;
	
	public VendingMachine(Vending backass, Vending monster, Vending hotsix, Vending milkis) {
		this.products = new Vending[4];
		this.products[0] = backass;
		this.products[1] = monster;
		this.products[2] = hotsix;
		this.products[3] = milkis;
		
	}
	/** 
	 * 주문하기 (제품 번호 , 주문수량)
	 * return = 구매금액
	 * 주문을 하면 주문 수량만큼 자판기 음료수 재고가 감소
	 * 재고가 없으면 품절
	 */
	public int orderDrinks(int menu, int quantity) {
		int iprice;
		
		if(menu < 0 || menu >= this.products.length) {
			System.err.println("없는 메뉴 입니다");
			return 0;
		}

		Vending drink = this.products[menu];
		
		if(drink.stock == 0 ) { // || drink.stock < quantity) {
			System.err.println("해당 상품이 품절되었습니다");
			return 0;
		}
		else if(drink.stock < quantity) {
			// 남은 상품보다 많이 주문했을 때
			System.out.println("재고가 부족합니다 " + drink.stock + " 개 주문만 처리됩니다.");
			quantity = drink.stock;
		}


		iprice = drink.price * quantity;	
		drink.stock -= quantity;	
		System.out.println(drink.name + " 음료를 "
		                   + quantity + " 개 주문하였습니다 가격은 "
		                   + iprice+" 원 입니다");
		
		return iprice;		
	}
	
	/** 
	 * 입고하기 (제품 번호, 입고수량) 
	 * return = 없음
	 * 입고하면 수량만큼 재고 증가
	 * 자판기에 없는 항목은 do nothing
	 */
	public void insertDrink(int menu, int quantity) {
		if(menu < 0 || menu >= this.products.length) {
			return;
		}
		
		Vending drink = this.products[menu];
		drink.stock += quantity;
	}
	
	/**
	 * 모든 상품 재고 출력 () 
	 * return 없음
	 * 걍 상품 다 출력하기
	 */
	public void printStock() {
		System.out.println();
		
		System.out.println("--------- --- ----재고출력--------- --- ----");
		for (int i = 0; i<this.products.length; i++)
		{
			Vending drink = this.products[i];
			
			System.out.println("상품명 : " + drink.name + " 의 재고는 " + drink.stock + " 입니다.");
		}

		System.out.println("--------- --- ----ㅡㅡㅡㅡ--------- --- ----");
	}
}
