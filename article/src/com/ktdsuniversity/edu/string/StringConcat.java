package com.ktdsuniversity.edu.string;

public class StringConcat {

	public static void main(String[] args) {
		
		String abcd = "500worldofultram";
		
		for (int i = 0; i< 26 ; i++) {
			abcd += abcd;
		}
		
		
		System.out.println("done");
	}

}
