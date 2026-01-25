package com.ktdsuniversity.edu.restaurant;

public class RestaurantTest {

	public static void main(String[] args) {
		// 이동네에 존재하는 먹거리들
		Menu food1 = new Menu("제육", 20f, 0f, 5000);
		Menu food2 = new Menu("국밥", 50f, 0f, 6000);
		Menu food3 = new Menu("떡볶", 40f, 0f, 2000);
		Menu food4 = new Menu("순대", 10f, 0f, 3000);
		
		Menu drink1 = new Menu("소주", 10f, 14f , 5000);
		Menu drink2 = new Menu("맥주", 10f, 6f, 4000);
		Menu drink3 = new Menu("막걸", 10f, 10f, 3000);
		Menu drink4 = new Menu("양주", 10f, 40f, 10000);
		
		// 식당 생성
		Restaurant pocha = new Restaurant("포장마차", 90f, 70f, food1, food3, drink2, drink4);
		
		System.out.println("식당 이름 : " +pocha.getName() + " 메뉴 ==== ");
		System.out.println("메뉴 1 : " +food1.getMenuName() + " 가격 : " + food1.getPrice() + "\t 음식양 : " + food1.getFillHunger() + "\t알콜량 : " + food1.getFillAlchol());
		System.out.println("메뉴 2 : " +food3.getMenuName() + " 가격 : " + food3.getPrice() + "\t 음식양 : " + food3.getFillHunger() + "\t알콜량 : " + food3.getFillAlchol());
		System.out.println("음료 1 : " +drink2.getMenuName() + " 가격 : " + drink2.getPrice() + "\t 음식양 : " + drink2.getFillHunger() + "\t알콜량 : " + drink2.getFillAlchol());
		System.out.println("음료 2 : " +drink4.getMenuName() + " 가격 : " + drink4.getPrice() + "\t 음식양 : " + drink4.getFillHunger() + "\t알콜량 : " + drink4.getFillAlchol());
		
		System.out.println("=========================================================");
		// 손님 생성
		Guest guest1 = new Guest("이름", 10f, 100f, 100000);
		
		// 손님이 식당에 들어가기 (Restaurant.)
		if(pocha.enterRestaurant(guest1))
		{
			System.out.println("주문 성공");
		}
		else {
			System.out.println("주문 실패");
		}
	}
}
