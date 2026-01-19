package java_exam;

public class ComapreExam {
	public static void main(String[] args) {
		int iage = 29 ; 
		
		// age 의 값이 10대인지 확인해보기
		// age 가 20대인지 확인해보기
		
		boolean bisteen = 10 <= iage && iage < 20;
		
		System.out.println("10대 : " + bisteen);
		
		boolean bistwen = 20 <= iage && iage < 30;
		
		System.out.println("20대 : " + bistwen);		
		System.out.println((iage/10) + "0대");
		
		// 고객나이
		int icustomerAge = 12;
		// 고객돈
		int icustomerWallet = 2500;
		
		// A 가게는 19세 이상의 고객만이 방문 가능하며 모든 제품은 1500원이다
		// 고객이 가게에서 제품을 구매할 수 있는 경우를 빠른 연산을 사용하여 출력
		System.out.println(icustomerAge >= 19 && icustomerWallet >= 1500);
		
		// B 가게는 19세 이상의 고객만 방문할 수 있고 모든 제품은 2000원이다
		// B 가게는 특별 할인으로 고객의 나이가 3의 배수면 돈이 모자라도 구매가능하다
		// 고객이 가게에서 제품을 구매할 수 있는 경우를 빠른 연산을 사용하여 출력
		System.out.println(icustomerAge >= 19 && (icustomerAge % 3 == 0 || icustomerWallet >= 2000));
		
		// 분리한다면 성인체크 && 지불방법 체크 -> 빠른 연산이 안됨
		
		boolean isAdult = icustomerAge >= 19;
		boolean isPayable = icustomerAge % 3 == 0 || icustomerWallet >= 2000;
		
		System.out.println(isAdult && isPayable); // <isAdult &= isPayable; 빠른연산 가능	;
		

		
		
	}
}
