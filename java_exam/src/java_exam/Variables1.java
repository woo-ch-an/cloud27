package java_exam;

public class Variables1 {

	public static void main(String[] args) {
		// favorite Variables blow ~ 
		// 나이가 몇 살인지 구해보는 나이 계산기		
		// 현재 연도 - 나의 생년
		
		System.out.println(2026 - 1998 + 1);
		
		// 변수 이름 규칙
	
		{
			int inowYear = 2026;
			int imyBirthYear = 1998;
			int imyAge = inowYear - imyBirthYear;
	
			System.out.println(inowYear - imyBirthYear + 1);
			System.out.println(imyAge - 1);
		}

		System.out.println("계산 끝");		
		try {
			
			long inum = Integer.MAX_VALUE; 
			inum = Integer.parseInt("Error");
			inum = inum + 1;
			
			byte bNumber = 127;

			bNumber = (byte)(bNumber + 1); 

			System.out.println(bNumber);
			
		}catch(Exception ex) {

			System.out.println(ex);
		}
		
//		final long lprice = 1000;
//		long lbuildPrice = 10_000_000_000L;
//		float fration = 5.111f;
//		double dreturn = 5.222233333334444444444455555555;
//		int inumber = (int)1L;

		System.out.println("3+7의 결과는 " + 3 + 7); // 묵시적 형변환 3, 7이 문자열로 취급됨
		System.out.println(1000000L + 3.6f);
		System.out.println(3.2 * 3.125);
		
		
	}
}
