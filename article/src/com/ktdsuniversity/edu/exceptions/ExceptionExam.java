package com.ktdsuniversity.edu.exceptions;

public class ExceptionExam {
	public static void nullExam(String str) {
		// str이 비어있지 않으면 내용을 출력한다

		if (str != null && !str.isEmpty()) {
			System.out.println(str);
		}
	}

	public static void arrayIndexExam(String[] arr, int index) {
		if (arr != null && index >= 0 && index < arr.length) {
			System.out.println(arr[index]);
		}
	}

	public static void numberFormatExam(String str) {
		// 숫자를 정수로 변경한다
		// 11자리 . 22억 --> 0 으로 치환한ㄷ ㅏ

		if (str == null) {
			System.out.println(0);
			return;
		}
		int num;
		long temp;

		str = str.replace("_", "");

		if (str.matches("^[0-9]{1,10}$")) {
			temp = Long.parseLong(str);

			if (temp >= Integer.MAX_VALUE) {
				temp = 0;
			}

			num = (int) temp;

			System.out.println(num);
		}

	}

	public static void main(String[] args) {
//		nullExam(null);
//		nullExam("");
//		nullExam("  ");
//		nullExam("asd");

		arrayIndexExam(new String[] { "a", "b" }, 0);
		arrayIndexExam(new String[] { "a", "b" }, 1);
		arrayIndexExam(new String[] { "a", "b" }, 2);
		arrayIndexExam(new String[] { "a", "b" }, -1);
		arrayIndexExam(null, -1);
		arrayIndexExam(null, 0);

		numberFormatExam("2242");
		numberFormatExam("22242");
		numberFormatExam("4_242_300");
		numberFormatExam("12222222222222222222222");
		numberFormatExam("2_242");
	}

}
