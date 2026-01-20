package java_exam;

public class ScoreCalculator {
	public static String computeGrade(int subjA, int subjB,int subjC,int subjD,int subjE)
	{
		String strrtValue = "";
	
		int iamount = subjA + subjB + subjC + subjD + subjE;
		double davarage = calcAverage(iamount, 5);
		String strgrade  = calcGrade(davarage);
		
		strrtValue = strgrade;
		return strrtValue;
	}
	
	public static double calcAverage(int amount, int subjectCount) {
		// 평균 구하기
		double drtValue = amount / (double)subjectCount;

		return drtValue;
	}
	
	public static String calcGrade(double average) {
		// 등급 구하기
		String strrtValue; 
		
		if(average >= 90) {
			return strrtValue ="A";
		}
		else if(average >= 80) {
			return strrtValue ="B";
			
		}
		else if(average >= 70) {
			return strrtValue ="C";
					
		}
		else if(average >= 60) {
			return strrtValue ="D";
			
		}
		else {
			return strrtValue ="F";
		}
	}
	
	public static void main(String[] args) {
		String strgrade = computeGrade(100, 95, 95,100,100); 
		
		System.out.println(strgrade); // 예시 문제 답 : "A"
	}
}
