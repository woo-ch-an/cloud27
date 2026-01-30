package com.ktdsuniversity.edu.restaurant;

import com.ktdsuniversity.edu.restaurant.customerr.DrunkenException;
import com.ktdsuniversity.edu.restaurant.customerr.FullException;
import com.ktdsuniversity.edu.restaurant.customerr.NotEnoughMoneyException;
import com.ktdsuniversity.edu.restaurant.customerr.SoldOutException;

public class RestaurantTest {

	public static void main(String[] args) {
		// 이동네에 존재하는 먹거리들
		// 26.01.30 재고 추가
		Menu food1 = new Menu("제육", 20f, 0f, 5000, 3);
		Menu food2 = new Menu("국밥", 50f, 0f, 6000, 5);
		Menu food3 = new Menu("떡볶", 40f, 0f, 2000, 2);
		Menu food4 = new Menu("순대", 10f, 0f, 3000, 3);
		
		Menu drink1 = new Menu("소주", 10f, 14f , 5000, 10);
		Menu drink2 = new Menu("맥주", 10f, 6f, 4000, 5);
		Menu drink3 = new Menu("막걸", 10f, 10f, 3000, 2);
		Menu drink4 = new Menu("양주", 10f, 40f, 10000, 3);
		
		// 식당 생성
		Restaurant pocha = new Restaurant("포장마차", 90f, 70f, food1, food3, drink2, drink4);
		
		// 식당 상태보기
		pocha.printState();
		
		// 손님 생성
		Guest guest1 = new Guest("이름", 10f, 72f, 100000);
		
		// 26.01.30 과제 
		// 중점 - 예외처리 추가
		// 예외 추가 조건  
		//				1. 배부름이 일정 수치를 초과할 때 "FullException" throw.
		//				2. 취함이 일정 수치를 초과할 때 "DrunkendException" throw.
		//				3. 음료. 음식의 재고 소진 시 관련된 예외 "SoldOutException" throw.
		//				4. 돈이 모자랄 때 관련된 예외 "NotEnoughMoneyException" throw.
		// 
		//	이후 throw 된 예외들 catch 하여 예외에 알맞는 메세지 출력
		
		
		// 손님이 식당에 들어가기 (Restaurant.)
		
		try {
			pocha.enterRestaurant(guest1);
		}catch (DrunkenException de){
			System.out.println(de.getMessage());
		}
		catch (FullException fe){
			System.out.println(fe.getMessage());
		}
		catch (NotEnoughMoneyException neme){
			System.out.println(neme.getMessage());
		}
		catch (SoldOutException soe){
			System.out.println(soe.getMessage());
		}
		
		
	}
}
