package oop;

public class ResturantTest {
	public static void main(String[] args) {
		Resturant Rest = new Resturant();
		
		// 1. 식당에 들어와서 키오스크를 봄
		// Eye.Watch(Front);
		
		
		// 2. 키오스크에서 매장식사를 선택
		Rest.pressTouchStart(true); 
		
		// 3. 키오스크의 메뉴판 보기
		Rest.seeMainMenu();
		
		// 4. 장바구니에 먹을 거 담기
		Rest.addMenu(2, 10, 3);
		
		// * 장바구니 확인
		Rest.seeSelectedMenu();
		
		// 5. 장바구니에서 빼기
		Rest.substMenu(0, 5, 0);
		
		// * 장바구니 확인
		Rest.seeSelectedMenu();
		
		// 6-1. 장바구니 내용물 주문하기
		Rest.pressOrder();
		
		// *B 다 빼보기
		Rest.substMenu(0, 10, 0);
		
		// 6-1. 진짜 주문
		Rest.pressOrder();
		
		// 6-2. 내용물 확인 후 Order 버튼이나 확인버튼 아무거나 눌러도 동작하게
		// Rest.pressOrder(); 
		Rest.pressConfirm();
		
	}
}
