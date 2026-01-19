package exam;

public class FlowControlQuiz {

	public static void main(String[] args) {
		// 백준 퀴즈 1330
		int a = 1;
		int b = 2;
		
		a = 10;
		b = 2;
		
		a = 5;
		b = 5;
		if (a > b) {
			System.out.println(">");
		}
		else if(a == b) {
			System.out.println("=");
		}
		else {
			System.out.println("<");
		}
		
		System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
		
		// 백준 퀴즈 9498
		int itestScore = 100;
		
		if(itestScore >= 90) {
			System.out.println("A");
		}
		else if(itestScore >= 80) {
			System.out.println("B");
		}
		else if (itestScore >= 70){
			System.out.println("C");
		}
		else if(itestScore >= 60) {
			System.out.println("D");
		}
		else {
			System.out.println("F");
		}

		System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
		
		// 백준 퀴즈 2753
		int iisAnYear = 1900; // 2012년은 윤년, 1900년은 윤년 아님, 2000년은 윤년
		
		if(iisAnYear % 4 == 0 && (iisAnYear % 100 != 0 || iisAnYear % 400 == 0 )) {
			System.out.println("1 (윤년이다)");
		}
		else {
			System.out.println("0 (윤년이 아니다)");
		}
		
		System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
		
		// 백준 퀴즈 14681 
		int iquadranx = -2;
		int iquadrany = 13;
		// x,y 는 0이 아님
		if(iquadranx > 0) {
			if(iquadrany > 0) {
				// x, y 둘 다 양수일 때 1사분면
				System.out.println("1 사분면");
			}else {
				// x는 양수, y는 음수일 때 4사분면
				System.out.println("4 사분면");
			}
		}else {
			if(iquadrany > 0) {
				// x는 음수, y는 양수일 때 2사분면
				System.out.println("2 사분면");
			}else {
				// x,y 음수일 때 3사분면
				System.out.println("3 사분면");
			}
		}
		System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
		// 백준 퀴즈 2884
		
		int isetHour = 23;
		int isetMinet = 40;
		
		if(isetHour == 0) {
			isetHour = 24;
		}
		int isettime = isetHour * 60 + isetMinet - 45;
		
		System.out.println((isettime / 60) + " H " + (isettime%60) + " M");
		
		System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
		
		// 백준 퀴즈 2525
		int inowHTime = 23;
		int inowMTime = 00;
		int icookeTime = 2470;
		
		int istemptime = inowHTime * 60 + inowMTime + icookeTime;
		if(istemptime >= 1440) {
			istemptime %= 1440;
		}
		System.out.println(istemptime / 60 + " 시 " + istemptime % 60 + " 분");
		
		System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
		// 백준 퀴즈 2480 
		
		int idice1 = 1;
		int idice2 = 1;
		int idice3 = 6;
		
		int ibigDice = 0;
		int iresult = 0;

		if(idice1 > idice2) {
			// 1번 주사위 > 2번 주사위
			ibigDice = idice1;
			
			if(idice1 < idice3) {
				// 1번 주사위 < 3번 주사위
				// 3개 모두 다름
				ibigDice = idice3;
			
				iresult = ibigDice * 100;
			}
			else if (idice1 == idice3) {
				// 2개 같은 경우
				
				iresult = idice1 * 100 + 1000;
			}
			else {
				if(idice2 == idice3) {
					// 2개가 같을 경우
					
					iresult = idice2 * 100 + 1000;
				}
				else {
					// 1 > 2 < 3
					// 다 다르니까 큰거 주기
					if(idice3 > idice1) {
						ibigDice = idice3;
					}
					
					iresult = ibigDice * 100;
				}
			}
		}
		else if (idice1 == idice2) {
			
			if(idice1 == idice3 ) {
				// 잭파t 
				iresult = 10_000 + (idice1 * 1000);
			}
			else {
				// 2개만 같은 경우
				iresult = idice1 * 100 + 1000;
			}
		}
		else
		{
			ibigDice = idice2;
			
			if(idice2 < idice3) {
				// 1번 주사위 < 3번 주사위
				// 3개 모두 다름
				ibigDice = idice3;
			
				iresult = ibigDice * 100;
			}
			else if (idice2 == idice3) {
				// 2개 같은 경우
				
				iresult = idice2 * 100 + 1000;
			}
			else {
				if(idice1 == idice3) {
					// 2개가 같을 경우
					
					iresult = idice1 * 100 + 1000;
				}
				else {
					// 1 > 2 < 3
					// 다 다르니까 큰거 주기
					if(idice3 > idice2) {
						ibigDice = idice3;
					}
					
					iresult = ibigDice * 100;
				}
			}
		} 
		
		System.out.println("상금 : " + iresult);
	}
}
