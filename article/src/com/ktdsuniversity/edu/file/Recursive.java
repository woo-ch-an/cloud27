package com.ktdsuniversity.edu.file;

public class Recursive {
	public void print(int count) {
		System.out.println(count + " 출력합니다");
		if (count < 2000) {
			print(++count);
		}
		System.out.println(count + " done");
	}

	public void printNumber(int a) {
		if (a <= 0) {
			return;
		}
		System.out.println(a--);
		printNumber(a);
	}

	public int sumNumber(int start) {
		if (start == 1) {
			return 1;
		}

		return start + sumNumber(start - 1);
	}

	public static void main(String[] args) {
		Recursive r = new Recursive();
		// r.print(count);
		// r.printNumber(2000);
		System.out.println(r.sumNumber(9));
	}

}
