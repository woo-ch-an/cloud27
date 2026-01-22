package oop;

public class CoffeeShop {
	/**
	 * 커피숍에서 판매하는 따듯한 아메리카노
	 */
	Coffee hot;
	/**
	 * 커피숍에서 판매하는 차가운 아메리카노
	 */
	Coffee ice;
	
	public CoffeeShop(Coffee hot, Coffee ice) {
		this.hot = hot;
		this.ice = ice;
	}
	
	/**
	 * 커피숍에서 커피를 판매한다
	 * @param menu 메뉴들의 번호 , 1:hot 2:ice
	 * @param quantity 메뉴 주문 수량 
	 * @return 주문 가격
	 */
	public int orderCoffee(int menu, int quantity) {
		if (menu == 1) {
			System.out.println(this.hot.name + " 음료를 " + quantity + " 개 주문 받았습니다. ");
			return this.hot.price * quantity;
		}else if (menu ==2) {
			System.out.println(this.ice.name + " 음료를 " + quantity + " 개 주문 받았습니다. ");
			return this.ice.price * quantity;
		}else {
			System.err.println("존재하지 않는 음료입니다. ");
			return 0;
		}
	}
}
