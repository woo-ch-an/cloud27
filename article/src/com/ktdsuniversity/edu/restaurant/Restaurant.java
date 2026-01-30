package com.ktdsuniversity.edu.restaurant;

import com.ktdsuniversity.edu.restaurant.customerr.DrunkenException;
import com.ktdsuniversity.edu.restaurant.customerr.FullException;
import com.ktdsuniversity.edu.restaurant.customerr.NotEnoughMoneyException;
import com.ktdsuniversity.edu.restaurant.customerr.SoldOutException;

public class Restaurant {

	Menu[] foodMenus; 
	Menu[] drinkMenus; 
	private String name;
	private float fillHunger;
	private float fillAlchol;

	public Restaurant(String name, float fillHunger, float fillAlchol, Menu food1, Menu food2, Menu drink1, Menu drink2) {
		this.name = name;
		this.fillAlchol = fillAlchol;
		this.fillHunger = fillHunger;
		
		this.foodMenus = new Menu[2];
		this.drinkMenus = new Menu[2];
		
		this.foodMenus[0] = food1;
		this.foodMenus[1] = food2;
		this.drinkMenus[0] = drink1;
		this.drinkMenus[1] = drink2;		
	}	
	
	public String getName()
	{
		return this.name;
	}
	public float getFillHunger() {
		return this.fillHunger;
	}
	public float getFillAlchol() {
		return this.fillAlchol;
	}
	
	public void setName(String name)
	{
		this.name = name;
	}
	public void setFillHunger(float fillHunger)
	{
		this.fillHunger = fillHunger;
	}
	public void setFillAlchol(float fillAlchol)
	{
		this.fillAlchol = fillAlchol;
	}
	
	public boolean enterRestaurant(Guest guest) {
		float drunken = guest.getDrunken();
		float hunger = guest.getHunger();
		int price = 0; 
		
		
		if(hunger >= this.fillHunger ) {
			// 식당 요구치보다 배부르면 나감
			// 기존 코드 System.out.println("식사 실패 - 배부름"); \n return false;
			throw new FullException("식사 실패 - 배부름");
		}
		if(drunken >= this.fillAlchol){
			// 식당 요구치보다 취함
			// 기존 코드  System.out.println("식사 실패 - 취함 "); \n return false;
			throw new DrunkenException("식사 실패 - 배부름");
			
		}
		
		// 메뉴 정하기 && 재고 있는지 보기
		if (guest.getDrunken() > 0) // 좀 취했으면 음료수 시킴
		{
			// 재고 확인
			if (this.drinkMenus[guest.getGuestsMenu()].getStock() <= 0) {
				throw new SoldOutException("식사 실패 - 품절됨");
			}
			price = this.drinkMenus[guest.getGuestsMenu()].getPrice();
		} else { // 아니면 밥먹음
			// 재고 확인
			if (this.foodMenus[guest.getGuestsMenu()].getStock() <= 0) {
				throw new SoldOutException("식사 실패 - 품절됨");
			}
			price = this.foodMenus[guest.getGuestsMenu()].getPrice();
		}
 
		
		if(price > guest.getPayAccount()) {
			// 기존 코드 System.out.println("식사 실패 - 돈 없음"); \n	return true;
			throw new NotEnoughMoneyException("식사 실패 - 돈 없음");
		}
		
		// 자격 있음
		// 재고관리
		if (guest.getDrunken() > 0) {
			this.drinkMenus[guest.getGuestsMenu()].setStock((this.drinkMenus[guest.getGuestsMenu()].getStock() - 1));
		}
		else {
			this.foodMenus[guest.getGuestsMenu()].setStock((this.foodMenus[guest.getGuestsMenu()].getStock() - 1));
		}
		System.out.println("식사가능");
		return true;
	}
	public void printState() {

		System.out.println("식당 이름 : " + this.name + " 메뉴 ==== ");
		System.out.println("메뉴 1 : " + this.foodMenus[0].getMenuName() + " 가격 : " + this.foodMenus[0].getPrice() + "\t 음식양 : " + this.foodMenus[0].getFillHunger() + "\t알콜량 : " + this.foodMenus[0].getFillAlchol());
		System.out.println("메뉴 2 : " +this.foodMenus[1].getMenuName()+ " 가격 : " + this.foodMenus[1].getPrice() + "\t 음식양 : " + this.foodMenus[1].getFillHunger() + "\t알콜량 : " + this.foodMenus[1].getFillAlchol());
		System.out.println("음료 1 : " + this.drinkMenus[0].getMenuName() + " 가격 : " +this.drinkMenus[0].getPrice() + "\t 음식양 : " + this.drinkMenus[0].getFillHunger() + "\t알콜량 : " + this.drinkMenus[0].getFillAlchol());
		System.out.println("음료 2 : " + this.drinkMenus[1].getMenuName() + " 가격 : " + this.drinkMenus[1].getPrice() + "\t 음식양 : " + this.drinkMenus[1].getFillHunger() + "\t알콜량 : " + this.drinkMenus[1].getFillAlchol());
		
		System.out.println("=========================================================");
	}
}
