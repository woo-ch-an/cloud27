package exam;

public class FlowControlWhileQuizs {

	public static void main(String[] args) {
		
		// Q2739. 구구단
		int in = 2;
		int i = 0;
		while (i < 9) {
			System.out.println(in + " * " + ++i + " = " + (in * i));
		}
		
		System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
		
		// Q8393. 합
		int insum = 10;
		int j=1 ;
		int iresult=0;
		while (j <= insum) {
			iresult += j;
			j++;
		}
		System.out.println(iresult);
		
		System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
		
		// Q25314.코딩은 체육과목 입니다
		
		int ilongint = 16;
		int k = 1;
		while(k <= (ilongint / 4)) {
			System.out.print("long ");
			k++;
		}
		System.out.println("int");
		
		System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
		
		// Q.2438. 별 찍기 - 1
		int iCountingstar = 5;
		int l = 0;
		int m = 0;
		while (l < iCountingstar) {
			while (m <= l) {
				System.out.print("*");
				m++;
			}
			System.out.println("");
			m =0;
			l++;
		}
		
		System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
		
		// Q.2439
		int ireversStar = 10; // Number
		int n = 0; // Line
		int o = 0; // Space 
		int p = 0; // * Count
		
		while (n < ireversStar) {
			
			while(o < (ireversStar - n - 1)) { // -1 머임 ? 
				System.out.print(" ");
				o++;
			}

			while(p <= n) {
				System.out.print("*");
				p++;
			}
			
			System.out.println("");
			o = 0;
			p = 0; 
			n++;
		}
		System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
		
	}

}
