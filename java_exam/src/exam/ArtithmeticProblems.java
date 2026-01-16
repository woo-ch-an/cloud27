package exam;

public class ArtithmeticProblems {

	public static void main(String[] args) {
		// 문제 1
		int iminutes =5;
		int iseconds =50;
		
		// 5분 50초는 몇초일까 ?
		int itime = iminutes * 60 + iseconds;
		System.out.println(iminutes + " 분 " + iseconds + " 초는 총 " + itime + "초 입니다");
		
		// 문제 2
		int iprocessTime = 145;
		int iminutes2 = iprocessTime / 60;
		int iseconds2 = iprocessTime % 60;
		
		System.out.println(iprocessTime + " 초 는 " + iminutes2 + " 분 " + iseconds2 + " 초 입니다 ");
		System.out.println(iprocessTime + " 초 는 " + (iprocessTime / 60)+ " 분 " + (iprocessTime % 60) + " 초 입니다 ");
		
		// 문제 3
		int icelsius = 30; // 섭씨온도
		int ifahrenheit = (icelsius * 9/5) + 32; // 화씨온도
		
		System.out.println(icelsius +" 'C = "+ ifahrenheit+ " 'F ");
		System.out.println(icelsius + " 'C = " + (icelsius * 9/5 + 32) + " 'F ");
		
		//추가문제
		int isubjectA = 100;
		int isubjectB = 80;
		int isubjectC = 95;
		int isubjectD = 68;
		
		int itotalScore = isubjectA + isubjectB + isubjectC + isubjectD;
		double davarage = itotalScore / 4d;
		double dscore = Math.round((davarage - 55) * 10) / 100.0 ; 	
		// 4.5 만점 기준 학점 계산. 소수점 이하 두자리 까지 + (평균점수 - 55점)에서 소수점 계산
		
		System.out.println("점수 총합 : " + itotalScore);
		System.out.println("점수 평균 : " + davarage);
		System.out.println("학점 결과 : " + dscore);
	}
}
