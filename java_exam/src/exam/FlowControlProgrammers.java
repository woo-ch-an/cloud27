package exam;

public class FlowControlProgrammers {

	public static void main(String[] args) {
		// 120829 번 문제
		
		int iangle = 90;
		// 예각 1 
		// 직각 2
		// 둔각 3
		// 평각 4
		
		if (iangle == 180) {
			System.out.println("4");
		}
		else if (90 < iangle && iangle <180) {
			System.out.println("3");
		}
		else if (iangle == 90) {
			System.out.println("2");
		}
		else if(iangle <90) {
			System.out.println("1");
		}
		else {
			System.out.println("에러");
		}
		
		System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
		
		// 120830 번 문제
		int isheepK = 64;
		int idrink = 6; 

		int ipayMoney = isheepK * 12000 + idrink * 2000 - (isheepK / 10 * 2000);
		
		System.out.println(ipayMoney);
		
		//? 
		
		
	}

}
