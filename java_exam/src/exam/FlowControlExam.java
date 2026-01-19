package exam;

public class FlowControlExam {

	public static void main(String[] args) {
		int ikorScore = 90;
		int iengScore = 88;
		int imathScore = 70;
		int iprogScore = 80;
		
		int isum = ikorScore + iengScore + imathScore + iprogScore;
		int iaverage = isum / 4;
		
		// iaverage = 81; 작동확인용 
		if(iaverage >= 95) {
			System.out.println("평균점수 95점 이상: A+");
		}
		else if(iaverage >= 90) {
			System.out.println("평균점수 90점 이상: A");
		}
		else if(iaverage >= 85) {
			System.out.println("평균점수 85점 이상: B+");
		}
		else if(iaverage >= 80) {
			System.out.println("평균점수 80점 이상: B");
		}
		else if(iaverage >= 70) {
			System.out.println("평균점수 70점 이상: C");
		}
		else {
			System.out.println("평균점수 70점 미만: F");
		}
		
		System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
		
		int imoney = 1_000_000;
		
		int ifather = 40; 
		int imother = 36;
		int idaughter = 12;
		
		int[] iary_family = {ifather, imoney, idaughter};
		
		
		int iadultOneWayFlightFare = 300_000;
		int ikidOneWayFlightFare = 120_000;
		
		if(ifather >= 19) {
			imoney -= iadultOneWayFlightFare;
		}
		else {
			imoney -= ikidOneWayFlightFare;
		}
		
		if(imother >= 19) {
			imoney -= iadultOneWayFlightFare;	
		}
		else {
			imoney -= ikidOneWayFlightFare;			
		}
		
		if(idaughter >= 19) {
			imoney -= iadultOneWayFlightFare;	
		}
		else {
			imoney -= ikidOneWayFlightFare;
		}
		
		imoney = 200000;
		for (int i = 0; i<iary_family.length; i++) {
			if (iary_family[i] >= 19) {
				imoney -= iadultOneWayFlightFare;
			}
			else {
				imoney -= ikidOneWayFlightFare;
			}
		}
		
		if(imoney >= 0) {
			System.out.println("여행가자!");
		}
		else {
			System.out.println("다음에 가자");
		}
			
	}

}
