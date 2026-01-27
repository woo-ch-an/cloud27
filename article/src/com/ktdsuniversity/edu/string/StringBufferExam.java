package com.ktdsuniversity.edu.string;
 

public class StringBufferExam {

	public static void main(String[] args) {
		
		StringBuffer sb = new StringBuffer();
		
		sb.append("k sd _ as vnndk sdkfkl ");
		sb.append("k sd _ as vnndk sdkfkl ");
		sb.append("k sd _ as vnndk sdkfkl ");
		
		String str = sb.toString();
		
		System.out.println(str);
		System.out.println(sb);
		
		StringBuffer longString = new StringBuffer();
		
//		for (int i = 0; i < 1000000; i++) {
//			longString.append("asdasdffff");
//		}
		appendString(longString);
		
		String resiult = longString.toString();
		System.out.println(resiult + "<<");
	}
	public static void appendString(StringBuffer buffe)
	{
		buffe.append("123224");
	}
}
