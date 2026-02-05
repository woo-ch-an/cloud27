package com.ktdsuniversity.edu.fp.basic.convert;

public class Test {

	public static void main(String[] args) {
		Converter con = new Converter();
		con.printConvertResult("123", str -> Integer.parseInt(str));
		// 기초적 레퍼런스
		con.printConvertResult2("535", Integer::parseInt);
		
		con.printConvertResult2("asdfg", str -> str.length());
		con.printConvertResult2("asdsdsdg", String::length);
		
	}
}
