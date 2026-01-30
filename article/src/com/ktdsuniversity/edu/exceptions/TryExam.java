package com.ktdsuniversity.edu.exceptions;

public class TryExam {

	public static void hnadleException() {

		try {
			Class.forName("com.ktdsuniversity.edu.exceptions");
		} catch (ClassNotFoundException ex) {
			ex.printStackTrace();
		}
	}

	public static void numberFormatExam(String str) {
		int value = 0;
		if (str != null) {
			try {

				System.out.println(1);
				value = Integer.parseInt(str);
				System.out.println(2);

			} catch (Exception e) {
				e.printStackTrace(); // print all cause of the error
				System.out.println(e.getMessage());
			}
		}
	}

	public static void main(String[] args) {
		numberFormatExam("10000");
		numberFormatExam("1a000");
		numberFormatExam("20000000000000000");
	}
	
}
