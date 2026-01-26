package com.ktdsuniversity.edu.coffee;

public class CoffeeShop {
	/**
	 * 커피숍에서 판매하는 따듯한 아메리카노
	 */
	private Coffee hot;
	/**
	 * 커피숍에서 판매하는 차가운 아메리카노
	 */
	private Coffee ice;
	
	/** 
	 * 생성자 오버로딩
	 */
	public CoffeeShop() {
		//this.hot = new Coffee("ESPRESSO", 4500, 200); 
		//this.ice = new Coffee("ICEDTEA", 4000, 50);
		
		this(new Coffee("ESPRESSO", 4500, 200), new Coffee("ICEDTEA", 4000, 50));		
	}
	
	public CoffeeShop(Coffee hot, Coffee ice) {
		this.hot = hot;
		this.ice = ice;
	}
	
	/**
	 * order 1 of first menu 
	 */
	public int orderCoffee() {
		int price;
		price = this.orderCoffee(1);

		return price;
	}
	
	/**
	 * order 1  Coffee
	 * @param menu 
	 * @return
	 */
	public int orderCoffee(int menu) {
		int price;
		price = this.orderCoffee(menu, 1);
	
		return price;
	}
	/**
	 * 커피숍에서 커피를 판매한다
	 * @param menu 메뉴들의 번호 , 1:hot 2:ice
	 * @param quantity 메뉴 주문 수량 
	 * @return 주문 가격
	 */
	public int orderCoffee(int menu, int quantity) {
		
		String name;
		int price = 0;
		int stock;

		if (menu == 1) {
			stock = this.hot.getStock();
			name = this.hot.getName();
			
			if(stock >= quantity) {
				this.hot.setStock(stock - quantity);
				System.out.println(name + " 음료를 " + quantity + " 개 주문 받았습니다. 남은 재고 : " +stock);
				return this.hot.getPrice() * quantity;				
			}else {
				if(stock != 0) {
					System.out.println(name + " 음료가 모자랍니다 재고 :" + stock);
					System.out.println(stock + " 개의 음료 주문만 받습니다.");
					price = this.hot.getPrice() * stock;
					this.hot.setStock(0);
				}

				System.err.println("품절되었습니다.");
				return price;
			}
			
		}else if (menu ==2) {
			stock = this.ice.getStock();
			name = this.ice.getName();
			
			if(stock >= quantity) {
				this.ice.setStock(stock - quantity);
				System.out.println(name + " 음료를 " + quantity + " 개 주문 받았습니다. 남은 재고 : " +stock);
				return this.ice.getPrice() * quantity;				
			}else {
				if(stock != 0) {
					System.out.println(name + " 음료가 모자랍니다 재고 :" + stock);
					System.out.println(stock + " 개의 음료 주문만 받습니다.");
					price = this.ice.getPrice() * stock;
					this.ice.setStock(0);
				}

				System.err.println("품절되었습니다.");
				return price;
			}
			
			
		}else {
			System.err.println("존재하지 않는 음료입니다. ");
			return 0;
		}

	}
}
