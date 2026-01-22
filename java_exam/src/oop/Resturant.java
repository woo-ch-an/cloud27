package oop;
/**
 * <pre>
 * 키오스크의 입장에서 식당을 바라보기
 * 
 * GUI가 아니니까 console_로 입출력
 * 키오스크 : 주문 대신  받아주고 결제해줌
 * 
 * 1. 대기화면
 * 
 * 2. 사람왔으면(이건모름) 터치로 시작 [터치는 매장식사/포장 구분]
 * 
 * 3. 추천메뉴, 인기메뉴 기타메뉴 등등 표시
 * 
 * 4. 장바구니 담고 빼고 넣고 섞고 돌ㄹ
 * 
 * 5. 결제전 주문내역 확인 
 * 
 * 6. 맞으면 결제 아니면 돌아가기(장바구니 유지)
 * 
 * 7. 암튼 결제
 * 
 * 8. 영수증(주문번호와 함께 끝)
 * 
 * </pre>
 */
public class Resturant {
	/**
	 * <pre>
	 * 		매장식사 	/ 	포장 구분 
	 * 		False		/  	True
	 * </pre>
	 */
	boolean mbtogo;
	/**
	 * <pre>
	 * 		결제 전 정보확인하기 위해 두 번째 요청에 진행할 수 있게 도와줌
	 * 		False : 첫 요청
	 * 		True : 두 번째 요청
	 * 		매 함수마다 해당 값을 False 로 초기화해서 결제 전 두 번 동작할 수 있게끔함
	 * </pre>
	 */
	boolean bdoubleCheck;
	/**
	 * <pre>
	 * 	현재 장바구니에 있는 A 메뉴 개수
	 * </pre>
	 */
	int maCount;
	/**
	 * <pre>
	 * 현재 장바구니에 있는 B 메뉴 개수
	 * </pre>
	 */
	int mbCount;
	/**
	 * <pre>
	 * 현재 장바구니에 있는 C 메뉴 개수
	 * </pre>
	 */
	int mcCount;
	
	/**
	 * 주문번호
	 */
	int imOrderCount;
	
	/**
	 * <pre>
	 * 		2. 대기화면에서 시작버튼을 눌러 메뉴 추천 / 선택 화면으로 이동
	 *             [터치는 매장식사/포장 구분] 파라미터로 받아옴
	 * </pre>
	 * @param true = 매장 식사 , false = 포장 선택
	 */
	public void pressTouchStart(boolean b_heretogo) { 
		bdoubleCheck = false;
		mbtogo = b_heretogo;
		
		if(b_heretogo) {
			System.out.println("매장 식사를 선택하셨습니다 ");
		}else {
			System.out.println("포장을 선택하셨습니다 ");
		}
	}
	
	/**
	 * <pre>
	 * 		3. 메인 메뉴 화면에서 메뉴 표시 메뉴는 3개인걸로
	 * 			추천메뉴 인기메뉴 신메뉴
	 * </pre>
	 */
	public void seeMainMenu() {
		bdoubleCheck = false;
		System.out.println();
		
		System.out.println("추천 메뉴 A - 가격 12000\\");
		System.out.println("인기 메뉴 B - 가격 11000\\");
		System.out.println("  신 메뉴 C - 가격 14000\\");
	}
	
	/**
	 * <pre>
	 * 		4. 장바구니에 담는 중
	 * 			 멤버변수[장바구니] 에 넣어놓기
	 * 
	 * </pre>
	 * @param a A메뉴 갯수
		@param b B메뉴 갯수
 		@param c C메뉴 갯수
	 */
	public void addMenu(int a, int b, int c) {
		bdoubleCheck = false;
		maCount += a;
		mbCount += b;
		mcCount += c;
	}
	
	
	/**
	 * <pre>
	 * 		5. 장바구니에서 빼는 중
	 * 			멤버변수[장바구니] 에서 빼기
	 * 			0보다 작아지지 않게 처리
	 * </pre>
	 * @param a A메뉴 갯수
		@param b B메뉴 갯수
 		@param c C메뉴 갯수
	 */
	public void substMenu(int a, int b, int c) {
		bdoubleCheck = false;
		maCount -= a;
		if(maCount < 0) {
			maCount = 0 ;
		}
		mbCount -= b;
		if(mbCount < 0) {
			mbCount = 0 ;
		}
		mcCount -= c;
		if(mcCount < 0) {
			mcCount = 0 ;
		}
	}
	
	/**
	 * <pre>
	 * 		6. 맞으면 결제 아니면 돌아가기(장바구니 유지)
	 * 			* 장바구니가 비어있으면 나가기
	 * 			True :  확인 된 메뉴 . 결제 진행
	 * 			False : 확인 필요한 메뉴. 돌아가기
	 * </pre>
	 */
	public void pressOrder() {
		if(maCount + mbCount+ mcCount == 0) {
			System.out.println("하나 이상의 메뉴를 선택해주세요 ㅡ");
			return;
		}
		
		if(bdoubleCheck) {
			System.out.println("총 " + calcuMenu() + " 원 결제하겠습니다 ㅡ ");
			System.out.println("주문번호는 "+ imOrderCount++ +"번 입니다");
			
			// 장바구니 초기화
			maCount = 0;
			mbCount = 0;
			mcCount = 0;
						
			bdoubleCheck = false;
		}else {
			System.out.println("결제 전 주문 정보를 확인해 주세요 ㅡ ");
			System.out.println("선택하신 메뉴 A : " + maCount + " 개 B : " + mbCount + " 개 C : " + mcCount + " 개");
			
			bdoubleCheck = true;
		}
	}
	
	public void pressConfirm() {
		if(maCount + mbCount+ mcCount == 0) {
			System.out.println("하나 이상의 메뉴를 선택해주세요 ㅡ");
			return;
		}
		
		if(bdoubleCheck) {
			System.out.println("총 " + calcuMenu() + " 원 결제하겠습니다 ㅡ ");
			System.out.println("주문번호는 "+ imOrderCount++ +"번 입니다");
			
			// 장바구니 초기화
			maCount = 0;
			mbCount = 0;
			mcCount = 0;
			
			bdoubleCheck = false;
		}else {
			System.out.println("결제 전 주문 정보를 확인해 주세요 ㅡ ");
			System.out.println("선택하신 메뉴 A : " + maCount + " 개 B : " + mbCount + " 개 C : " + mcCount + " 개");
			
			bdoubleCheck = true;
		}
	}
	
	/**
	 * 장바구니 출력
	 */
	public void seeSelectedMenu() {
		System.out.println("현재 선택하신 메뉴 A : " + maCount + " 개 B : " + mbCount + " 개 C : " + mcCount + " 개");
	}
	public int calcuMenu() {
		int acoast = 12000;
		int bcoast = 11000;
		int ccoast = 14000;
		
		int icoast= (maCount*acoast) + (mbCount*bcoast) + (mcCount*ccoast);

		return icoast;
	}
}
