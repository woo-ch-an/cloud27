package com.ktdsuniversity.edu.fp.basic.convert;

import java.util.function.Function;

public class Converter {

	public void printConvertResult(String str, Changer changer) {
		int result = changer.changerToInt(str);
		System.out.println(result);
	}

	public void printConvertResult2(String str, Function<String, Integer> function) {
		int a = function.apply(str);
		System.out.println(a);
	}
}
