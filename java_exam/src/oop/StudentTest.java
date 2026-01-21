package oop;

public class StudentTest {
	public static void main(String[] args) {
		Student student = new Student();
		student.mijava =100;
		student.mipython = 100; 
		student.micpp = 100;
		student.micsharp = 21;
		
		
		System.err.println("합계 : " + student.getSumAllScores() );
		System.err.println("평균 : " + student.getAverage());
		System.err.println("학점 : " + student.getCourseCredit());
		System.out.println("등급 : " + student.getABCDE());
	}
}
