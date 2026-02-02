package com.ktdsuniversity.edu.generics;

import java.util.Arrays;

public class ScoreListTest {
	public static void main(String[] args) {

		ScoreList<Integer, Integer> list = new ScoreList<>();

		list.add(24442);
		list.add(2442);
		list.add(244);
		list.add(242);
		list.add(2042);
		list.add(442);

		Reducer<Integer, Integer> listReducer = new Reducer<>() {

			@Override
			public Integer reduce(Integer input, Integer output) {

				output += input;
				return output;
			}
		};

		int sum = list.reultsum(listReducer, 0);
		System.out.println("답  :  29854  -> " + sum);

		ScoreList<String, String> strList = new ScoreList<>();

		strList.add("asdf");
		strList.add("aefg");
		strList.add("vhdf");

		Reducer<String, String> strListReducer = new Reducer<>() {

			@Override
			public String reduce(String input, String output) {

				output += input;
				return output;
			}
		};

		String arrayTest = strList.reultsum(strListReducer, "");

		System.out.println(arrayTest);

		ScoreList<String[], String> arrayList = new ScoreList<>();
		arrayList.add(new String[] { "asd", "===" });
		arrayList.add(new String[] { "ffgd", "a=dh" });
		arrayList.add(new String[] { "pgp", "b=dh" });

		Reducer<String[], String> arrayReducer = new Reducer<>() {

			@Override
			public String reduce(String[] input, String output) {
				for (int i = 0; i < input.length; i++) {
					output += input[i];
				}

				return output;
			}
		};

		String arrayResult = arrayList.reultsum(arrayReducer, "");
		System.out.println(arrayResult);
	}

}
