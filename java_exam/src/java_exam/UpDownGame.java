package java_exam;

import java.util.Scanner;

public class UpDownGame {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		double drandomNumber = Math.random();
		int ianswer = (int) (drandomNumber * 100);
		int ivalue = 0;
//
//		int inputNumber = 0; // 사용자 입력값 저장
//
//		// 사용자의 입력값이 100 이하일 때 반복동작
//		while(inputNumber <= 100) {
//			
//			// 사용자로 부터 정수를 입력받는다
//			inputNumber = keyboard.nextInt();
//			System.out.println("입력 : "+ inputNumber);
//		}
//		
//		System.out.println("Application 종료");
		while(true) {
			System.out.println("숫자를 입력하세요 ");
			ivalue = keyboard.nextInt();
			if(ianswer == ivalue) {
				System.out.println("정답입니다 ");
				break;
			}
			else if(ianswer > ivalue) {
				System.out.println("Up !");
			}
			else {
				System.out.println("Down !");
			}
			
		}
	
	}
}
