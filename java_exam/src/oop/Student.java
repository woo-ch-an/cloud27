package oop;

public class Student {
	// 시험 성적들
	int mijava;
	int mipython;
	int micpp;
	int micsharp;
	
	/**
	 *	기준에 맞춰 학점을 반환
	 *	4.1 ~ 4.5: A+
		3.6 ~ 4.0: A
		3.1 ~ 3.5: B+
		2.6 ~ 3.0: B
		1.6 ~ 2.5: C
		0.6 ~ 1.5: D
		0.1 ~ 0.5: F

	 * @return 학점
	 */
	public String getABCDE() {
		String strrtValue = "";
		Double dcoureseCredit = getCourseCredit();
		
		if(dcoureseCredit >= 4.1) {
			strrtValue = "A+";
		}
		else if(dcoureseCredit >= 3.6){
			strrtValue = "A";
		}
		else if(dcoureseCredit >= 3.1){
			strrtValue = "B+";
		}
		else if(dcoureseCredit >= 2.6){
			strrtValue = "B";
		}
		else if(dcoureseCredit >= 1.6){
			strrtValue = "C";
		}
		else if(dcoureseCredit >= 0.6){
			strrtValue = "D";
		}else{
			strrtValue = "F";
		}

		return strrtValue;
	}
	
	//학점계산기
	public double getCourseCredit() {
		double dcoureseCredit = (getAverage() -55) /10.0;
		// 자릿수맞 추기 
		dcoureseCredit = Math.round(dcoureseCredit * 100) / 100.0;  
						// (int) ((getAverage() - 55) / 10.0 * 100) << 이코드도 됨 마지막에 / 100 
		
		return dcoureseCredit;
	}
	
	// 시험성적총합계산기
	public int getSumAllScores() {
		int isum = mijava+mipython+micpp+micsharp;
		
		return isum;
	}
	
	// 시험성적 평균 계산기
	public double getAverage() {
		double daverage = getSumAllScores() / 4.0;
		
		return daverage;
	}
	

}
