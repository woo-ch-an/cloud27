package com.ktdsuniversity.edu.restaurant;

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
			System.out.println("식사 실패 - 배부름");
			return false;
		}
		if(drunken >= this.fillAlchol){
			// 식당 요구치보다 취함
			
			System.out.println("식사 실패 - 취함 ");
			return false;
		}
		
		if(guest.getDrunken() > 0) // 좀 취했으면 음료수 시킴
		{
			price = drinkMenus[guest.getGuestsMenu()].getPrice();
		}else { // 아니면 밥먹음
			price = foodMenus[guest.getGuestsMenu()].getPrice();
		}
		
		if(price <= guest.getPayAccount()) {
			// 자격 있음
			System.out.println("식사가능");
			return true;
		}
		else {
			System.out.println("식사 실패 - 돈 없음");
			return true;
		}
		
	}
}
