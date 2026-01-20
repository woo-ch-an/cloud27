package exam;

public class Method_Exam {
	public static void printSum(int inum) {
		int isum = 0;
		for (int i = 1; i<=inum; i++) {
			isum += i;
		}
		System.out.println("Q1. 1부터 파라미터로 전달된 숫자까지의 합을 구한다 입력값 : " + inum +" 총합 : " + isum);
	}
	
	public static void printPrime(int inum) {
		System.out.print("Q2. 4부터 파라미터로 전달된 숫자 중 소수만 출력한다 : ");
		boolean isPrime = true;
		for (int i = 4; i < inum; i++) {
			isPrime = true;
			for(int j = 2; j< i/2; j++) {
				if(i % j == 0) {
					isPrime = false;
					break;
				}
			}
			
			if(isPrime) {
				System.out.print(i +" ");
			}
		}
		System.out.println();
	}
	
	public static void printMax(int a, int b) {

		System.out.print("Q3. 파라미터로 전달된 숫자 두 개 중 가장 큰 수 하나만 출력한다 큰 수는 : ");
		
		if(a>b) {
			System.out.println(a);
		}
		else {
			System.out.println(b);
		}
	}
	
	public static void printAge(int iage) {
		System.out.print("Q4. 파라미터로 전달된 나이가 성인인지 미성년인지 구분하여 출력한다 이 사람은 ");
		
		if(iage >= 19) {
			System.out.println("성인이다");
		}
		else {
			System.out.println("미성년자다");
		}
	}
	
	public static String getFizzBuzz(int inum) {
		System.out.print("Q5. 랜덤한 숫자를 생성하고 아래 규칙에 따른 결과를 반환한다. num : " + inum + ", 결과 : ");
		String strreturn = "";
		if (inum % 3 == 0) {
			if (inum % 5 == 0) {
				System.out.println("FizzBuzz");
				strreturn = "FizzBuzz";
				return strreturn;
			}
			System.out.println("Fizz");
			strreturn = "Fizz";
			return strreturn;
		}else if( inum % 5 ==0) {
			System.out.println("Buzz");
			strreturn = "Buzz";
			return strreturn;
		}
		else {
			System.out.println(" " + inum);
			return strreturn;
		}
	}
	
	public static int[] getUniqueNumbers() {
		// Q6. 서로 다른 숫자 7개를 배열에 할당하여 반환한다.
		int[] iary_returnValue = new int[7];
		System.out.println("Q6. 서로 다른 숫자 7개를 배열에 할당하여 반환한다. Array blow : ");
		int[] iary_randNumber = new int[7];
		
		for (int i = 0; i < iary_randNumber.length; i++ ) {
			iary_randNumber[i] = (int)(Math.random() * 100);
			for (int j = 0; j< i; j++) {
				if(iary_randNumber[i] == iary_randNumber[j]) {
					iary_randNumber[i] = (int)(Math.random() * 100);
					i--;
					break;
				}
			}
		}
		
		for (int i =0; i< iary_randNumber.length; i++) {
			System.out.print("  " + iary_randNumber[i]);
		}
		System.out.println();
		iary_returnValue = iary_randNumber;
		return iary_returnValue;
	}
	
	public static String getEvenOdd(int a, int b) {
		// Q7. 정수 파라미터 두 개를 전달받아 곱한 결과가 짝수인지 홀수인지 반환한다.
		String strreturn = "";
		System.out.print("Q7. 정수 파라미터 두 개를 전달받아 곱한 결과가 짝수인지 홀수인지 반환한다. 입력값의 곱 : " + (a*b) + " 결과 값 : ");
		if((a*b) % 2 == 0) {
			System.out.println("짝수");
			strreturn = "짝수";
		}
		else {
			System.out.println("홀수");
			strreturn = "홀수";
		}
		return strreturn;
	}
	
	public static int getSumOfFive(int a, int b, int c, int d, int e) {
		// Q8. 전달된 정수 파라미터 5개의 합을 구해 반환한다.
		int isum = (a+b+c+d+e);
		int iretrun = isum;
		System.out.println("Q8. 전달된 정수 파라미터 5개의 합을 구해 반환한다. 합 :" + isum);
	
		return iretrun;
	}
	
	public static double getAverage(int a, int b) {
		// Q9. 합과 점수의 개수를 전달하여 평균을 구해 반환한다. (소수점 둘째 자리까지)
		double daverage = a / (double)b; 
		double breturnval = daverage;
		System.out.println("Q9. 합과 점수의 개수를 전달하여 평균을 구해 반환한다. (소수점 둘째 자리까지) 평균 : " + daverage);
		
		return breturnval;		
	}
	
	public static char getGrade(int iscore) {
		// Q10. 평균 점수를 파라미터로 전달하여 학점을 반환.
		System.out.print("Q10. 평균 점수를 파라미터로 전달하여 학점을 반환. 입력 점수 : " + iscore + " 등급 : ");
		if(iscore > 90) {
			System.out.println("A");
			return 'A';
		}
		else if(iscore > 80) {
			System.out.println("B");		
			return 'B';
		}
		else if(iscore > 70) {
			System.out.println("C");
			return 'C';
		}
		else if(iscore > 60) {
			System.out.println("D");
			return 'D';
		}
		else if(iscore > 50) {
			System.out.println("F");
			return 'F';
		}
		else {
			System.out.println("Out of Value");
			return '-';
		}
	}
	
	public static void nextChar(char cword) {
		// Q11. char 타입의 파라미터 하나를 받아 그 다음의 글자를 문자열로 반환한다.
		System.out.println("Q11. char 타입의 파라미터 하나를 받아 그 다음의 글자를 문자열로 반환한다. 입력값 : " + cword + " 다음 값 : " + (char)(cword+1));
	}
	
	public static String getCharacters(char cfirstword, char csecondword) {
		// Q12. char 타입의 파라미터 두 개를 받아 문자 사이에 있는 모든 글자를 문자열로 반환한다.
		String strValue = "";
		System.out.println("Q12. char 타입의 파라미터 두 개를 받아 문자 사이에 있는 모든 글자를 문자열로 반환한다 -> " +cfirstword+ " 부터 ~ "+ csecondword + " 까지");
		for (int i= (int)cfirstword; i<=(int)csecondword; i++) {
			System.out.print((char)i + " ");
			strValue = strValue + (char)i + " ";
		}		
		System.out.println();
		return strValue;
	}
	
	public static String getLowerCaseAlpha(char cword, int icounter) {
		// Q13. 영소문자는 26개로 구성됨. 'a'에 25를 더하면 'z'. char와 int 파라미터를 전달했을 때 예상되는 문자를 반환.
		String strrtValue = "";
		System.out.print("Q13. char 타입의 파라미터 두 개를 받아 문자 사이에 있는 모든 글자를 문자열로 반환한다. 입력값 : "+ cword + " + " + icounter + " = ");
		
		if(cword + icounter >= 123 || cword + icounter < 97) {
			System.out.println("[E] Out of range");
			return strrtValue;
		}
		System.out.println((char)((int)(cword)+icounter));
		strrtValue += (char)((int)(cword)+icounter);
		return strrtValue;
	}
	
	public static Character convertUpperCase(char cword) {
		// Q14. 영 소문자 글자 하나를 파라미터로 전달하면 대문자로 변환하여 반환.
		Character creValue = ' ';
		System.out.print("Q14. 영 소문자 글자 하나를 파라미터로 전달하면 대문자로 변환하여 반환. 입력 문자 : " + cword + " 문자 변환 : ");

		if((int)cword < 97 || (int)cword >123) {
			System.out.println("[E] Out of range");
			
			return ' ';
		}
		creValue = (char)(cword-32);
		System.out.println((char)(cword-32)); 
		return creValue;
	}
	public static void main(String[] args) {
		// Q1. 1부터 파라미터로 전달된 숫자까지의 합을 구한다(출력)
		printSum(10);
		
		// Q2. 4부터 파라미터로 전달된 숫자 중 소수만 출력한다
		printPrime(20);
		
		// Q3. 파라미터로 전달된 숫자 두 개 중 가장 큰 수 하나만 출력한다
		printMax(10, 20);
		
		// Q4. 파라미터로 전달된 나이가 성인인지 미성년인지 구분하여 출력한다
		printAge(20);
		printAge(15);
		
		// Q5. 랜덤한 숫자를 생성하고 아래 규칙에 따른 결과를 반환한다
		getFizzBuzz(9);
		getFizzBuzz(10);
		getFizzBuzz(15);
		getFizzBuzz(7);
		
		// Q6. 서로 다른 숫자 7개를 배열에 할당하여 반환한다.
		getUniqueNumbers();
		
		// Q7. 정수 파라미터 두 개를 전달받아 곱한 결과가 짝수인지 홀수인지 반환한다.
		getEvenOdd(4, 5);
		getEvenOdd(3, 5);
		
		// Q8. 전달된 정수 파라미터 5개의 합을 구해 반환한다.
		getSumOfFive(1, 2, 3, 4, 5);
		
		// Q9. 합과 점수의 개수를 전달하여 평균을 구해 반환한다. (소수점 둘째 자리까지)
		getAverage(150, 3);
		
		// Q10. 평균 점수를 파라미터로 전달하여 학점을 반환한다.
		getGrade(95);
		getGrade(85);
		getGrade(75);
		getGrade(65);
		getGrade(55);
		
		// Q11. char 타입의 파라미터 하나를 받아 그 다음의 글자를 문자열로 반환한다.
		nextChar('a');
		
		// Q12. char 타입의 파라미터 두 개를 받아 문자 사이에 있는 모든 글자를 문자열로 반환한다.
		getCharacters('a', 'z');
		getCharacters('A', 'Z');
		getCharacters('가', '나');
		
		// Q13. 영소문자는 26개로 구성됨. 'a'에 25를 더하면 'z'. char와 int 파라미터를 전달했을 때 예상되는 문자를 반환.
		getLowerCaseAlpha('a', 25);
		getLowerCaseAlpha('a', 1);
		getLowerCaseAlpha('a', 0);
		getLowerCaseAlpha('a', -1);
		getLowerCaseAlpha('a', 26);
		
		// Q14. 영 소문자 글자 하나를 파라미터로 전달하면 대문자로 변환하여 반환. 
		convertUpperCase('a');
		convertUpperCase('c');
		convertUpperCase('1');
		convertUpperCase('A');
		convertUpperCase('^');
		
		for (int i = 125; i<130; i++) {
			System.out.println((char)i + " = int " + i);
		}
	}

}
