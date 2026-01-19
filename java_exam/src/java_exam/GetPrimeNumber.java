package java_exam;

public class GetPrimeNumber {

	public static void main(String[] args) {
		boolean isprimeNumber = false;
		
		int icount = 0;

		for (int i =2; i< 100000; i++) 
		{
			isprimeNumber = true;
			for (int j = 2; j<= i/2; j++) 
			{
				if(i % j == 0) {
					// 소수 아님
					isprimeNumber = false;
				}				
			}
			
			if(isprimeNumber == true) {
				System.out.println("소수 발견 : " + i);	
				icount++;
			}
		}
		System.out.println("총 " + icount + "개 의 소수 발견");
	}

}
