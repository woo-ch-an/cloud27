package exam;

public class FlowControlForQuizes {

	public static void main(String[] args) {
		
		Qppt1();
		Qppt2();
		Qppt3(); 
		QBouns();
	}
	
	public static void Qppt1() {
		int isum = 0;
		
		for (int i = 1; i <= 100; i++) {
			isum += i;
		}
		System.out.println("1. 1~100까지의 합 : " +isum);
	}
	
	public static void Qppt2() {
		int iOdd = 0;
		
		for (int i = 1; i <= 100; i++) {
			if(i % 2 == 1) {
				iOdd += i;
			}
		}
		
		System.out.println("2. 1~100까지 홀수의 합 : " + iOdd);
	}
	
	public static void Qppt3() {
		for (int i = 1; i <= 100; i++) {
			if(i % 3 == 0 && i % 5 == 0 && i % 6 == 0 ) { 
				 System.out.println("3. 1~100까지 3, 5, 6의 배수 : " + i);
			}
		}
	}
	
	public static void QBouns() {
		// 1. for 문을 활용해서 1 ~ 5 를 출력하기
		for (int i = 1; i <=5; i++) {
			System.out.println(i);
		}
		
		System.out.println(" ------------ - - - - - - - - - ------------ ");
		
		// 2. 동일하게 5 ~ 1 을 출력하기
		for (int i = 5; i>=1; i--) {
			System.out.println(i);
		}
	}

}
