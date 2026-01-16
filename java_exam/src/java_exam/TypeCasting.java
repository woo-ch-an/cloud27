package java_exam;

public class TypeCasting {

	public static void main(String[] args) {
		// 교재 p.84  묵시적 변환
//		int inum = 10; 
//		float fnum = inum; 
//		double dnum = inum;
//		
//		System.out.println(inum);
//		System.out.println(fnum);
//		System.out.println(dnum);
		
		// 교재 p.85 명시적 변환 (소수점 없어짐)
//		float fnum = 10.9f;
//		int num = (int)fnum;
//		System.out.println(fnum);
//		System.out.println(num);
//		
//		double dnum = 11.15;
//		num = (int)dnum;
//		System.out.println(dnum);
//		System.out.println(num);
		
		// 교재 p.86
//		double dnum = 10.1;
//		dnum = Math.ceil(dnum); // 소수점 올림
//		System.out.println(dnum);
//		
//		dnum = 10.9;
//		dnum = Math.floor(dnum); // 소수점 버림
//		System.out.println(dnum);
//		
//		dnum = 15.18;
//		dnum = Math.round(dnum);
//		System.out.println(dnum); // 소수점 반올림
//		
//		dnum = 10.56;
//		dnum = Math.round(dnum);
//		System.out.println(dnum); // 반올림 2
		
		// 교재 p.87 Java는 소수점 자리 처리가 유연하지 못함
		double dnum = 29.37;
		double dnum2 = dnum * 10;
		System.out.println(dnum2);
		
		dnum2 = Math.round(dnum2);
		System.out.println(dnum2);
		
		double dnum3 = dnum2/ 10;
		System.out.println(dnum3);
		double dnum4 = Math.round(dnum);
		System.out.println(dnum4);
	}

}
