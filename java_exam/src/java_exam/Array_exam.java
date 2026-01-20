package java_exam;

public class Array_exam {

	public static void main(String[] args) {
		// int iary_scoreArray2[] = new int[7]; // C언어 스타일
		int[] iary_scoreArray = new int[7]; // Java 스타일

		// 1. 서로 "무조건" 다른 숫자 7개 나오게 만들기
		for (int i = 0; i < iary_scoreArray.length; i++) {
			iary_scoreArray[i] = (int) (Math.random() * 45 + 1);
			for (int j = 0; j < i; j++) {
				while (iary_scoreArray[i] == iary_scoreArray[j]) {
					iary_scoreArray[i] = (int) (Math.random() * 45 + 1);
				}
			}
		}

		// 2. while 먼저 써서 배열 끝까지 다 되면 나오기
		int icount = 0;
		int iranNum = 0;
		boolean isduplicate = false;
		while (icount < iary_scoreArray.length) {
			iranNum = (int) (Math.random() * 45 + 1);
			isduplicate = false;
			for (int i = 0; i < iary_scoreArray.length; i++) {
				if (iary_scoreArray[i] == iranNum) {
					isduplicate = true;
					break;
				}
			}
			if (!isduplicate) {
				iary_scoreArray[icount] = iranNum;
				icount++;
			}
		}

		// 배열 출력
		for (int i = 0; i < iary_scoreArray.length; i++) {
			System.out.println(iary_scoreArray[i]);
		}
	}
}
