package oop;

public class StudentTest {
	public static void main(String[] args) {
		Student student = new Student(100, 100, 100, 21);		
		
		System.err.println("합계 : " + student.getSumAllScores() );
		System.err.println("평균 : " + student.getAverage());
		System.err.println("학점 : " + student.getCourseCredit());
		System.out.println("등급 : " + student.getABCDE());
	}
}
