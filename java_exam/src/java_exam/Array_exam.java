package java_exam;

public class Array_exam {

	public static void main(String[] args) {
		int[] iary_scoreArray = new int[7]; // Java 스타일
		int iary_scoreArray2[] = new int[7]; // C언어 스타일 
		
		iary_scoreArray = iary_scoreArray2;
		for (int i = 0 ; i < 7; i++) {
			iary_scoreArray[i] = 53;
		}
		System.out.println(iary_scoreArray);
		System.out.println(iary_scoreArray2);
		
	}

}
