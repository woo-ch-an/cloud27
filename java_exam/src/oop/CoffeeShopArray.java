package oop;

public class CoffeeShopArray {
	// into the unknown ~
	
	Coffee[] drinks; 
	
	public CoffeeShopArray(Coffee hot, Coffee ice, Coffee tea) {
		this.drinks = new Coffee[3];
		this.drinks[0] = hot;
		this.drinks[1] = ice;
		this.drinks[2] = tea;
	}
	
	/**
	 * 커피숍에서 커피를 판매한다
	 * 
	 * @param menu 메뉴들의 번호 , 1:hot 2:ice 3:tea;
	 * @param quantity 메뉴 주문 수량 
	 * @return 주문 가격
	 */
	public int orderCoffee(int menu, int quantity) {
		if(menu < 0 || menu >= this.drinks.length) {
			System.err.println ("This Menu is doesn't exist"); 
			return 0;
		}
		
		Coffee drink = this.drinks[menu];
		System.out.println(drink.name + " 음료를 " + quantity + " 개 주문 하였습니다 ");
		return drink.price * quantity;
		}
}
