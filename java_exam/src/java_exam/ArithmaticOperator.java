package java_exam;

public class ArithmaticOperator {

	public static void main(String[] args) {
		// arithmetic = 산술연산자라는 뜻(a -> e) 
		int n = 0;
		System.out.println("---------");
		System.out.println(n); 
		n++; //n = n + 1; n+=1;
		System.out.println(n);
		
		System.out.println(n++);
		System.out.println(n);
		System.out.println(++n);

		System.out.println(n);
		// syso + space + Enter> println 단축키
		
		n = 0;
		System.out.println(n);
		n--; //n = n - 1; n-=1;
		System.out.println(n);
		
		System.out.println(n--);
		System.out.println(n);
		
		System.out.println(--n);
		
		int m = 10;
		System.out.println(++m); // 예상값 :  11
		System.out.println(m++); // 예상값 : 11
		System.out.println(m); // 예상값 : 12
		
		System.out.println(--m); // 예상값 : 11
		System.out.println(m--); // 예상값 : 11
		System.out.println(m); // 예상값 : 10
		
	}

}
